package Controllers.ButtonControllers;

import StaticModels.StructureOfTable;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by User on 11.10.2017.
 */
public interface EditButtonController {
    public void get(StructureOfTable tableModel, JComboBox comboBox, JTextField[] texts) throws SQLException;
}