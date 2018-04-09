package Controllers.ButtonControllers;

import Controllers.Converter;
import Controllers.DAO.SQLDAO;
import StaticModels.StructureOfTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 11.10.2017.
 */
public final class InsertButtonController implements ActionListener, EditButtonController {
    @Override
    public void get(StructureOfTable tableModel, JComboBox comboBox, JTextField[] texts){
        comboBox.setEditable(!comboBox.isEditable());
        for (JTextField textField : texts){
            textField.setEditable(!textField.isEditable());
        }

        if (comboBox.isEditable()){
            comboBox.addItem("");
            comboBox.setSelectedIndex(comboBox.getItemCount()-1);
            for (JTextField textField : texts){
                textField.setText("");
            }
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(String.valueOf(comboBox.getSelectedItem()));
            for (JTextField textField : texts){
                values.add(textField.getText());
            }
            tableModel.setValues(Converter.get().convertListOnArray(values));
            SQLDAO.get().insert(tableModel);
            comboBox.removeItemAt(comboBox.getItemCount()-1);
            comboBox.addItem(tableModel.getValues()[0]);
            comboBox.setSelectedIndex(comboBox.getItemCount()-1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}