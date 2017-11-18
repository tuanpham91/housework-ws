import java.sql.*;
import java.util.Calendar;
import java.util.logging.Logger;

import org.json.JSONObject;
public class SqlProcessor {
    private static String url = "jdbc:mysql://localhost/housework";
    private static String user = "root";
    private static String password = "Tuan1991apha";
    private static Connection conn ;
    private static int userID = 0;
    public static void addUser(JSONObject userJson ) {
        userID++;
        String query = "INSERT INTO user (id, name,password, realname) VALUES (?,?,?,?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs ;
            statement.setInt(1,userID);
            statement.setString(2,(String) userJson.get("name"));
            statement.setString(3,(String) userJson.get("password"));
            statement.setString(4,(String) userJson.get("realname"));
            statement.executeUpdate();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static User getUser(int id) {
        String query = "SELECT * FROM user u WHERE  u.id = ?" ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs ;
            statement.setInt(1,id);
            rs = statement.executeQuery();
            conn.close();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void plusPoint(int id, int points, int jobId) {
        String query = "INSERT INTO pointlist (userId,month,week,year, points, jobId) VALUES (?,?,?,?,?,?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            Calendar cal = Calendar.getInstance();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1,id);
            statement.setInt(2, cal.get(Calendar.MONTH));
            statement.setInt(3, cal.get(Calendar.WEEK_OF_YEAR));
            statement.setInt(4, cal.get(Calendar.YEAR));
            statement.setInt(5,points);
            statement.setInt(6, jobId);
            statement.executeUpdate();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
