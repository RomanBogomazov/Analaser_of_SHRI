package Controllers.DAO;

import Controllers.ControllerGetKeyByValueFromMap;
import Controllers.Converter;
import StaticModels.StructureOfTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 02.05.2017.
 */
public class SQLDAO implements IDAO {
  private static SQLDAO instance = new SQLDAO();;
  private Connection connect;
  private Statement statement;
  private ResultSet result;
  private PreparedStatement preparedStatement;
  private static final String dataBaseName = "jdbc:mysql://localhost:3306/shri";
  private static final String username = "root";
  private static final String password = "2740RomAN0087";
  private String answerSymbols;

  private SQLDAO(){
    try {
      connect = DriverManager.getConnection(dataBaseName, username, password);
      statement = connect.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static SQLDAO get() {
    return instance;
  }

  @Override
  public ArrayList<String[]> selectAll(String[] dataFields, String nameTable, String query) {
    ArrayList<String[]> table = new ArrayList<>();
    ArrayList<String> cashList = new ArrayList<>();
    try {
      result = statement.executeQuery("Select * From " + nameTable + " " + query);
      while(result.next()) {
        for (String dataField : dataFields) {
          cashList.add(result.getString(dataField));
        }
        table.add(Converter.get().convertListOnArray(cashList));
        cashList = new ArrayList<>();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return table;
  }

  @Override
  public Map<String, String> getPrimaryValues(StructureOfTable tableModel) {
    Map<String, String> primaryValues = new HashMap<>();
    try {
      result = statement.executeQuery("Select * From " + tableModel.getNameOfTable());
      while(result.next()) {
        primaryValues.put(result.getString("Key"), result.getString(tableModel.getTextOfColumns()[0]));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return primaryValues;
  }

  @Override
  public String[] select(StructureOfTable tableModel, int key) {
    ArrayList<String> note = new ArrayList<>();
    try {
      result = statement.executeQuery("Select * From " + tableModel.getNameOfTable() + " Where `key` = " + key);
      result.next();
      for (String dataField : tableModel.getTextOfColumns()) {
        note.add(result.getString(dataField));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    note.remove(0);

    return Converter.get().convertListOnArray(note);
  }

  @Override
  public void insert(StructureOfTable tableModel) {
    answerSymbols = "(?";
    for (int i=0; i<tableModel.getValues().length-1; i++){
      answerSymbols += ",?";
    }
    answerSymbols += ")";

    try {
      preparedStatement = connect.prepareStatement("call Insert" + tableModel.getNameOfTable() + answerSymbols);
      for (int i=0; i<tableModel.getValues().length; i++) {
        preparedStatement.setString(i+1, tableModel.getValues()[i]);
      }
      result = preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(StructureOfTable tableModel, String primaryValue) {
    String[] dates = new String[tableModel.getValues().length+1];
    dates[0] = ControllerGetKeyByValueFromMap.get().getKey(SQLDAO.get().getPrimaryValues(tableModel), primaryValue);
    System.arraycopy(tableModel.getValues(), 0, dates, 1, tableModel.getValues().length);

    answerSymbols = "(?";
    for (int i=0; i<dates.length-1; i++){
      answerSymbols += ",?";
    }
    answerSymbols += ")";

    try {
      preparedStatement = connect.prepareStatement("call Update" + tableModel.getNameOfTable() + answerSymbols);
      for (int i=0; i<dates.length; i++) {
        preparedStatement.setString(i+1, dates[i]);
      }
      result = preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remove(StructureOfTable tableModel, String primaryValue) throws SQLException {
    answerSymbols = "(?)";
      preparedStatement = connect.prepareStatement("call Delete" + tableModel.getNameOfTable() + answerSymbols);
      preparedStatement.setString(1, ControllerGetKeyByValueFromMap.get().getKey(SQLDAO.get().getPrimaryValues(tableModel), primaryValue));
      result = preparedStatement.executeQuery();
  }
}