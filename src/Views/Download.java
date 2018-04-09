package Views;

import StaticModels.StructureOfTable;
import Settings.Settings;

import java.awt.*;
import java.io.File;
import javax.swing.*;

/**
 * Created by User on 02.05.2017.
 */
public class Download extends TableEditor {
  private JTextField text;
  private JButton button;
  private JFileChooser fileOpen;
  private File file;

  public Download(Rectangle bounds, StructureOfTable tableModel) {
    super(tableModel.getTextOfLabels());
    setBounds(bounds);
    setLayout(null);

    for (int i=0; i<tableModel.getTextOfLabels().length; i++) {
      labels[i].setText(tableModel.getTextOfLabels()[i]);
      labels[i].setBounds(0, i*getHeight()/tableModel.getTextOfLabels().length, getWidth()/4, getHeight()/tableModel.getTextOfLabels().length);
      add(labels[i]);
    }
    for (int i=0; i<texts.length; i++){
      texts[i].setBounds(getWidth()/4, (i+1)*getHeight()/tableModel.getTextOfLabels().length, 3*getWidth()/4, getHeight()/tableModel.getTextOfLabels().length);
      add(texts[i]);
    }

    text = new JTextField();
    text.setEditable(false);
    text.setBounds(getWidth()/4, 0, getWidth()/2, getHeight()/tableModel.getTextOfLabels().length);
    text.setFont(Settings.font);
    add(text);

    button = new JButton("Download");
    button.setBounds(3*getWidth()/4, 0, getWidth()/4, getHeight()/tableModel.getTextOfLabels().length);
    button.setFont(Settings.font);
    button.addActionListener(e->{
      fileOpen = new JFileChooser();
      int ret = fileOpen.showDialog(null, "Download measurement");
      if (ret == JFileChooser.APPROVE_OPTION) {
        file = fileOpen.getSelectedFile();
        text.setText(file.getName());
      }
    });
    add(button);
  }

  public void setVisible(boolean set){
    super.setVisible(set);
    if (text!=null){
      text.setVisible(set);
    }
    if (button!=null) {
      button.setVisible(set);
    }
  }
}