package by.marina.DB;


import javax.security.auth.login.LoginException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserProvider {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/my_customer";
    static final String USER = "root";
    static final String PASSWORD = "23393225111042001s)";

    private static Connection connection = null;
    private static Statement statement = null;

    public UserProvider() {
        {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean loginProcess(String userName, String password) throws LoginException {
        try {
            String sql = "SELECT * FROM user";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                if(resultSet.getString("userName").equals(userName) && resultSet.getString("password").equals(password))
                    return true;
            }
        } catch (SQLException e) {
            throw new LoginException();
        }
        return false;
    }

    @Override
    protected void finalize() throws Throwable {
        statement.close();
        connection.close();
    }
}
