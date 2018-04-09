package Controllers.DAO;

import StaticModels.StructureOfTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by User on 02.05.2017.
 */
public interface IDAO {
  void insert(StructureOfTable tableModel);
  void update(StructureOfTable tableModel, String primaryValue);
  void remove(StructureOfTable tableModel, String primaryValue) throws SQLException;

  String[] select(StructureOfTable tableModel, int key);
  ArrayList<String[]> selectAll(String[] dataFields, String nameTable, String query);
  Map<String, String> getPrimaryValues(StructureOfTable tableModel);
}