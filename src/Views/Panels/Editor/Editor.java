package Views.Panels.Editor;

import Controllers.ButtonControllers.InsertButtonController;
import Settings.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 02.05.2017.
 */
public abstract class Editor extends JPanel {
  protected JButton buttonNext = new JButton();

  protected Editor(Rectangle bounds) {
    setBounds(bounds);
    setLayout(null);

    buttonNext.setBounds(3*getWidth()/4, 15*getHeight()/16, getWidth()/4, getHeight()/16);
    buttonNext.setFont(Settings.font);
    add(buttonNext);
    //buttonNext.addActionListener(new InsertButtonController());
  }

  public void setVisible(boolean set){
    super.setVisible(set);
    buttonNext.setVisible(set);
  }

  public void addActionListener(Editor editor){
    buttonNext.addActionListener(e->{
      this.setVisible(false);
      editor.setVisible(true);
    });
  }
}