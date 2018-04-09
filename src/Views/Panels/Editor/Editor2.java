package Views.Panels.Editor;

import StaticModels.Measurement;
import StaticModels.Param;
import Views.*;
import Views.List;
import Settings.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 02.05.2017.
 */
public class Editor2 extends Editor {
  private JButton buttonBack;
  private TableEditor param;
  private TableEditor measurement;

  public Editor2(Rectangle bounds){
    super(bounds);

    buttonNext.setText("Finish");

    buttonBack = new JButton("Back");
    buttonBack.setBounds(0, 15*getHeight()/16, getWidth()/4, getHeight()/16);
    buttonBack.setFont(Settings.font);
    buttonBack.addActionListener(e->{
      setVisible(false);
    });
    add(buttonBack);

    param = new List(new Rectangle(getWidth()/4, getHeight()/8, getWidth()/2, getHeight()/4), Param.get());
    measurement = new Download(new Rectangle(getWidth()/4, 4*getHeight()/8, getWidth()/2, getHeight()/4), Measurement.get());

    add(param);
    add(measurement);
    setVisible(false);
  }

  public void setVisible(boolean set){
    super.setVisible(set);
    buttonNext.setVisible(set);
    buttonBack.setVisible(set);
    param.setVisible(set);
    measurement.setVisible(set);
  }

  public void addActionListener(Editor editor){
    buttonNext.addActionListener(e->{
      this.setVisible(false);
      editor.setVisible(true);
    });
    buttonBack.addActionListener(e->{
      this.setVisible(false);
      editor.setVisible(true);
    });
  }
}