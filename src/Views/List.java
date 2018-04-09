package Views;

import Controllers.ButtonControllers.DeleteButtonController;
import Controllers.ButtonControllers.EditButtonController;
import Controllers.ButtonControllers.InsertButtonController;
import Controllers.ButtonControllers.UpdateButtonController;
import Controllers.ControllerGetKeyByValueFromMap;
import Controllers.Converter;
import Controllers.DAO.SQLDAO;
import StaticModels.StructureOfTable;
import Settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by User on 02.05.2017.
 */
public class List extends TableEditor {
  private JComboBox comboBox;
  private final EditButtonController[] buttonControllers = {new InsertButtonController(), new UpdateButtonController(), new DeleteButtonController()};
  private final String[] editButtonControllerErrorMessages = {
          "Field cannot be inserted because!",
          "Field cannot be updated because!",
          "Field cannot be deleted because has foreign fields!"
  };

  public List(Rectangle bounds, StructureOfTable tableModel){
    super(tableModel.getTextOfLabels());
    setBounds(bounds);
    setLayout(null);

    comboBox = new JComboBox(Converter.get().getValuesFromMap(SQLDAO.get().getPrimaryValues(tableModel)));
    comboBox.setBounds(getWidth()/2, 0, getWidth()/2, bounds.height/(tableModel.getTextOfLabels().length+1));
    comboBox.setEditable(false);
    comboBox.setFont(Settings.font);
    comboBox.addActionListener(e->{
      String key = ControllerGetKeyByValueFromMap.get().getKey(SQLDAO.get().getPrimaryValues(tableModel), comboBox.getSelectedItem().toString());
      if (key!=null){
        tableModel.setValues(SQLDAO.get().select(tableModel, Integer.parseInt(key)));
        for (int i=0; i<texts.length; i++){
          texts[i].setText(tableModel.getValues()[i]);
        }
      }
    });
    add(comboBox);

    for (int i=0; i<labels.length; i++){
      labels[i].setBounds(0, i*(getHeight()/(tableModel.getTextOfLabels().length+1)), getWidth()/2, getHeight()/(tableModel.getTextOfLabels().length+1));
    }

    for (int i=0; i<buttons.length; i++){
      buttons[i].setBounds(i*getWidth()/3, getHeight()-getHeight()/(tableModel.getTextOfLabels().length+1), getWidth()/3, getHeight()/(tableModel.getTextOfLabels().length+1));
      int finalI = i;
      buttons[i].addActionListener(e->{
        try {
          buttonControllers[finalI].get(tableModel, comboBox, texts);
        } catch (SQLException e1) {
          JOptionPane.showMessageDialog(null,editButtonControllerErrorMessages[finalI]);
        }
      });
    }

    for (int i=0; i<texts.length; i++){
      texts[i].setBounds(getWidth()/2, (i+1)*getHeight()/(tableModel.getTextOfLabels().length+1), getWidth()/2, getHeight()/(tableModel.getTextOfLabels().length+1));
      comboBox.setSelectedIndex(0);
    }
  }

  public void setVisible(boolean set){
    super.setVisible(set);
    if (comboBox!=null){
      comboBox.setVisible(set);
    }
  }
}