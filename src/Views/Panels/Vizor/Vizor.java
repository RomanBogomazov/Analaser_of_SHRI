package Views.Panels.Vizor;

import StaticModels.Result;
import Views.Filter;
import Views.List;
import Views.SHRIModul.SHRIPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 02.05.2017.
 */
public class Vizor extends JPanel {
  private Filter filter;
  private List result;
  private SHRIPanel shri;
  private JButton refresh;

  public Vizor(JFrame frame, Rectangle bounds) {
    setBounds(bounds);
    setLayout(null);
    filter = new Filter(getWidth()/2, 0, getWidth()/2, getHeight());
    result = new List(new Rectangle(0, 0, getWidth()/2, getHeight(), Result.get());
    shri = new SHRIPanel(frame, filter);

    add(filter);
    add(result);
    add(shri);
    setVisible(false);
  }

  public void setVisible(boolean set){
    super.setVisible(set);
    filter.setVisible(set);
    result.setVisible(set);
    shri.setVisible(set);
  }
}