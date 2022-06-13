package sample;

import java.sql.*;
import java.util.Objects;

public class Mapper {
    private static final String url = "jdbc:mysql://localhost:3306/limingyu?" +
            "user=root&password=1234&" +
            "useSSL=false&" +
            "serverTimezone=GMT%2B8&" +
            "characterEncoding=utf8";
    private Connection con;
    private Statement sql;

    public Mapper() throws Exception {
        con = DriverManager.getConnection(url);
        sql = con.createStatement();
    }

    public Boolean login(String userName, String password) throws SQLException {
        ResultSet rs = sql.executeQuery("select * from student where account='" + userName + "'");
        try {
            rs.next();
            return Objects.equals(rs.getString("password"), password);
        } catch (SQLException throwable) {
            return null;
        }
    }

    public void close() throws SQLException {
        sql.close();
        con.close();
    }
}
