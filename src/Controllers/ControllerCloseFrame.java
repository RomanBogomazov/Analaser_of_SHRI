package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 11.09.2017.
 */
public class ControllerCloseFrame implements ActionListener {
    private static ControllerCloseFrame instance;

    public static ControllerCloseFrame getInstance(JFrame frame) {
        if (instance == null) {
            instance = new ControllerCloseFrame();
        }
        frame.dispose();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}