package Controllers.ButtonControllers;

import Controllers.Converter;
import Controllers.DAO.SQLDAO;
import StaticModels.StructureOfTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 11.10.2017.
 */
public final class UpdateButtonController implements EditButtonController, ActionListener {
    private String previousName;

    @Override
    public void get(StructureOfTable tableModel, JComboBox comboBox, JTextField[] texts){
        comboBox.setEditable(!comboBox.isEditable());
        for (JTextField textField : texts){
            textField.setEditable(!textField.isEditable());
        }

        if (comboBox.isEditable()) {
            previousName = comboBox.getSelectedItem().toString();
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(String.valueOf(comboBox.getSelectedItem()));
            for (JTextField textField : texts){
                values.add(textField.getText());
            }
            tableModel.setValues(Converter.get().convertListOnArray(values));
            SQLDAO.get().update(tableModel, previousName);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}