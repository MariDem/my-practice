package by.marina.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/my_customer";
    static final String USER = "root";
    static final String PASSWORD = "23393225111042001s)";

    private final List<DemoEntity> entities = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    Connection connection;
    Statement statement;
    String sql;

    private static DemoEntity demoList;


    public DataProvider() {
        {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                statement = connection.createStatement();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public List<DemoEntity> getAllEntities() throws SQLException {
        try {
            sql = "SELECT * FROM customer";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            entities.clear();
            while (resultSet.next()) {
                demoList = new DemoEntity();
                demoList.setId(resultSet.getInt("id"));
                demoList.setName(resultSet.getString("name"));
                demoList.setAddress(resultSet.getString("address"));
                entities.add(demoList);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }


    public void addEntity(String name, String address) {
        String sql = "INSERT INTO customer (name, address) Values (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            demoList.setName(name);
            demoList.setAddress(address);
            entities.add(demoList);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        statement.close();
        connection.close();
    }
}
