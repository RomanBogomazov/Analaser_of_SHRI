package Controllers.ButtonControllers;

import Controllers.DAO.SQLDAO;
import StaticModels.StructureOfTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by User on 11.10.2017.
 */
public final class DeleteButtonController implements EditButtonController, ActionListener {
    @Override
    public void get(StructureOfTable tableModel, JComboBox comboBox, JTextField[] texts) throws SQLException {
        SQLDAO.get().remove(tableModel, (String) comboBox.getSelectedItem());
        comboBox.removeItemAt(comboBox.getSelectedIndex());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}