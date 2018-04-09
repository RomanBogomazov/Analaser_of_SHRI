package Views;

import Settings.Settings;

import javax.swing.*;

/**
 * Created by User on 04.05.2017.
 */
public abstract class TableEditor extends JPanel {
  protected JTextField[] texts;
  protected JLabel[] labels;
  protected JButton[] buttons;
  protected static final String[] namesOfButtons = {"Insert", "Update", "Delete"};

  TableEditor(String[] textOfLabels) {
    labels = new JLabel[textOfLabels.length];
    for (int i=0; i<textOfLabels.length; i++) {
      labels[i] = new JLabel(textOfLabels[i]);
      labels[i].setFont(Settings.font);
      add(labels[i]);
    }

    texts = new JTextField[textOfLabels.length - 1];
    for (int i=0; i<texts.length; i++) {
      texts[i] = new JTextField();
      texts[i].setEditable(false);
      texts[i].setFont(Settings.font);
      add(texts[i]);
    }

    buttons = new JButton[namesOfButtons.length];
    for (int i=0; i<buttons.length; i++) {
      buttons[i] = new JButton(namesOfButtons[i]);
      buttons[i].setFont(Settings.font);
      add(buttons[i]);
    }
  }

  public void setVisible(boolean set){
    for (JLabel label : labels) {
      label.setVisible(set);
    }
    for (JTextField text : texts) {
      text.setVisible(set);
    }
    for (JButton button : buttons) {
      button.setVisible(set);
    }
  }
}