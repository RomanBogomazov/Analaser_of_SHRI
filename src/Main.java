import Controllers.ControllerCheckPanels;
import Controllers.ControllerCloseFrame;
import Views.Panels.Editor.Editor;
import Views.Panels.Editor.Editor1;
import Views.Panels.Editor.Editor2;
import Views.Panels.Vizor.Vizor;
import Settings.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 08.09.2017.
 */
public class Main extends JFrame implements Runnable {
    private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private int sizeY = (int) size.getHeight();
    private int sizeX = (int) size.getWidth();

    private String[] styles = {UIManager.getSystemLookAndFeelClassName(), "com.sun.java.swing.plaf.windows.WindowsLookAndFeel", "com.sun.java.swing.plaf.motif.MotifLookAndFeel"};

    private JButton exit = new JButton("Exit");
    private JRadioButton frameChecker = new JRadioButton("  Editor");
    private Editor editor1;
    private Editor editor2;
    private Vizor vizor;

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(styles[0]);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setFrame();
        setExitButton();
        setEditor1();
        setVizor();
        setFrameChecker();
        setVisible(true);
    }

    private void setFrame(){
        setBounds(sizeX/4, sizeY/4, sizeX/2, sizeY/2);
        setUndecorated(true);
        setLayout(null);
        setFont(Settings.font);
    }

    private void setExitButton() {
        exit.setBounds(this.getWidth() - this.getWidth()/8, 0, sizeX/16, sizeY/32);
        exit.addActionListener(e -> ControllerCloseFrame.getInstance(this));
        exit.setFont(Settings.font);
        add(exit);
    }

    private void setFrameChecker() {
        frameChecker.setBounds(this.getWidth()/64, 0, sizeX/12, sizeY/32);
        frameChecker.addActionListener(e -> ControllerCheckPanels.getInstance(frameChecker, vizor, editor1, editor2));
        frameChecker.setFont(Settings.font);
        add(frameChecker);
        frameChecker.updateUI();
    }

    private void setEditor1() {
        editor1 = new Editor1(new Rectangle(getWidth()/32, getHeight()/16, 15*getWidth()/16, 7*getHeight()/8));
        editor2 = new Editor2(new Rectangle(getWidth()/32, getHeight()/16, 15*getWidth()/16, 7*getHeight()/8));
        editor1.addActionListener(editor2);
        editor2.addActionListener(editor1);
        add(editor1);
        add(editor2);
    }

    private void setVizor() {
        vizor = new Vizor(this, new Rectangle(getWidth()/32, getHeight()/16, 15*getWidth()/16, 7*getHeight()/8));
        add(vizor);
        vizor.setVisible(true);
    }

    public static void main(String[] args) {
        new Thread(new Main()).run();
    }
}