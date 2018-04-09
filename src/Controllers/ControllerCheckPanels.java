package Controllers;

import Views.Panels.Editor.Editor;
import Views.Panels.Vizor.Vizor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 11.09.2017.
 */
public class ControllerCheckPanels implements ActionListener {
    private static ControllerCheckPanels instance;

    public static ControllerCheckPanels getInstance(JRadioButton frameChecker, Vizor vizor, Editor editor1, Editor editor2){
        if (instance == null){
            instance = new ControllerCheckPanels();
        }
        if (frameChecker.isSelected()) {
            vizor.setVisible(false);
            editor1.setVisible(true);
        } else {
            editor1.setVisible(false);
            editor2.setVisible(false);
            vizor.setVisible(true);
        }

        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}