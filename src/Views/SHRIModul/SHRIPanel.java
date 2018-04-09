package Views.SHRIModul;

import Views.Filter;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;

/**
 * Created by User on 02.05.2017.
 */
public class SHRIPanel extends GLJPanel {
  private final GLProfile profile;
  private GLCapabilities capabilities;
  private final GLCanvas glcanvas;
  private Dots dots;
//  private final FPSAnimator animator;

  public SHRIPanel(JFrame mainFrame, Filter filter){
    super();
    setBounds(mainFrame.getBounds());

    profile = GLProfile.get(GLProfile.GL2);
    capabilities = new GLCapabilities(profile);
//    dots = new Dots(filter);

    glcanvas = new GLCanvas(capabilities);
    //glcanvas.addGLEventListener(dots);
    glcanvas.setBounds(getWidth()/32, getHeight()/4, 13*getWidth()/32, 11*getHeight()/16);
    mainFrame.getContentPane().add(glcanvas);

/*    animator = new FPSAnimator(glcanvas, 300,true);
    animator.start();*/
  }

  public void setVisible(boolean set) {
    glcanvas.setVisible(set);
  }
}