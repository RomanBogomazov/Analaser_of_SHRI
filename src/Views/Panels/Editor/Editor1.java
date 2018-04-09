package Views.Panels.Editor;

import StaticModels.Researcher;
import StaticModels.Sample;
import StaticModels.System;
import Views.*;
import Views.List;

import java.awt.*;

/**
 * Created by User on 02.05.2017.
 */
public class Editor1 extends Editor {
  private TableEditor researcher;
  private TableEditor sample;
  private TableEditor system;

  public Editor1(Rectangle bounds) {
    super(bounds);

    buttonNext.setText("Next");
    researcher = new List(new Rectangle(0, 0, 15*getWidth()/32, getHeight()), Researcher.get());
    sample = new List(new Rectangle(17*getWidth()/32, 0, 15*getWidth()/32, getHeight()/4), Sample.get());
    system = new List(new Rectangle(17*getWidth()/32, 10*getHeight()/32, 15*getWidth()/32, getHeight()/8), System.get());

    add(researcher);
    add(sample);
    add(system);
    setVisible(false);
  }

  public void setVisible(boolean set) {
    super.setVisible(set);
    researcher.setVisible(set);
    sample.setVisible(set);
    system.setVisible(set);
  }
}