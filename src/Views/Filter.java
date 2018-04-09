package Views;

import Settings.Settings;

import javax.swing.*;

/**
 * Created by User on 02.05.2017.
 */
public class Filter extends JPanel {
  private JCheckBox[] checkBox;
  private JTextField[] text1;
  private JTextField[] text2;
  private JSlider[] slider;
  private JButton[] button;
  private int labelCount;
  private String[] dataFields = {"Key", "X center", "Y center", "X FWHM", "Y FWHM", "Gauss level", "Background level", "Chi square", "Ml lambda"};
  private String[] nameLabel = {"X center: ", "Y center: ", "X FWHM: ", "Y FWHM: ", "Gauss level: ", "Background level: ", "Chi square: ", "Ml lambda: "};


  public Filter(int x, int y, int width, int height) {
    setLayout(null);
    this.setBounds(x, y, width, height);
    labelCount = nameLabel.length;
    checkBox = new JCheckBox[nameLabel.length];
    text1 = new JTextField[nameLabel.length];
    text2 = new JTextField[nameLabel.length];
    slider = new JSlider[nameLabel.length];
    button = new JButton[nameLabel.length];

    for(int i = 0; i < nameLabel.length; i++) {
      checkBox[i] = new JCheckBox(nameLabel[i]);
      checkBox[i].setFont(Settings.font);
      checkBox[i].setBounds(0, i*height/nameLabel.length, (int) (3.5*width/10), height/nameLabel.length);
      add(checkBox[i]);

      text1[i] = new JTextField("0");
      text1[i].setEnabled(false);
      text1[i].setFont(Settings.font);
      text1[i].setBounds((int) (3.5*width/10), i*height/nameLabel.length, width*2/10, height/nameLabel.length);
      add(text1[i]);

      text2[i] = new JTextField("2000");
      text2[i].setEnabled(false);
      text2[i].setFont(Settings.font);
      text2[i].setBounds((int) (5.5*width/10), i*height/nameLabel.length, width*2/10, height/nameLabel.length);
      add(text2[i]);

      slider[i] = new JSlider();
      slider[i].setVisible(false);
      slider[i].setEnabled(false);
      slider[i].setFont(Settings.font);
      slider[i].setBounds((int) (3.5*width/10), i*height/nameLabel.length, width*4/10, height/nameLabel.length);
      add(slider[i]);

      button[i] = new JButton("Slider");
      button[i].setFont(Settings.font);
      button[i].setEnabled(false);
      button[i].setBounds((int) (7.5*width/10), i*height/nameLabel.length, 2*width/10, height/nameLabel.length);
      add(button[i]);

      int finalI = i;
      checkBox[i].addActionListener(e -> {
        if(text1[finalI].isEnabled() == false) {
          slider[finalI].setEnabled(true);
          text1[finalI].setEnabled(true);
          text2[finalI].setEnabled(true);
          button[finalI].setEnabled(true);
        }
        else {
          slider[finalI].setEnabled(false);
          text1[finalI].setEnabled(false);
          text2[finalI].setEnabled(false);
          button[finalI].setEnabled(false);
        }
      });

      button[i].addActionListener(e -> {
        if(button[finalI].getText().equals("Slider")) {
          text1[finalI].setVisible(false);
          text2[finalI].setVisible(false);
          slider[finalI].setVisible(true);
          button[finalI].setText("Edit");
        }
        else {
          text1[finalI].setVisible(true);
          text2[finalI].setVisible(true);
          slider[finalI].setVisible(false);
          button[finalI].setText("Slider");
        }
      });
    }
  }

  public void setVisible(boolean set){
    super.setVisible(set);
    for (int i=0; i<labelCount; i++){
      checkBox[i].setVisible(set);
      text1[i].setVisible(set);
      text2[i].setVisible(set);
      button[i].setVisible(set);
    }
  }

  public boolean isChecked(int i){
    if (checkBox[i].isSelected()){
      return true;
    }
    else {
      return false;
    }
  }

  public float getMinValue(int i){
    if (text1[i].getText().isEmpty()){
      text1[i].setText("0");
      return 0;
    }
    else {
      return Float.parseFloat(text1[i].getText());
    }
  }

  public float getMaxValue(int i){
    if (text2[i].getText().isEmpty()){
      text2[i].setText("2000");
      return 2000;
    }
    else {
      return Float.parseFloat(text2[i].getText());
    }
  }
}