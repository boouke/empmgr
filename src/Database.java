import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    protected static Connection conn = null;
    public static boolean isConnected = false;
    public static String URL = "";
    public static String username = "";
    public Connection connect(){
        URL = "jdbc:mysql://localhost:4431/hospital";
        username = "root";
        String password = "";
        System.out.println("Custom options? Y for yes, anything else for no.)");
        String userFlag = ErrorHandling.stringValidate();
        if (userFlag.equalsIgnoreCase("Y")) {
            URL = ErrorHandling.stringValidate();
            username = ErrorHandling.stringValidate();
            password = ErrorHandling.stringValidate();
        }
        try {
            conn = DriverManager.getConnection(URL, username, password);
            System.out.println("Connection successful.");
            isConnected = true;
        } catch (java.sql.SQLException e){
            ErrorHandling.logError(e, "e0x91");
        }
        return conn;
    }
    public static boolean getConnectionStatus(){
        return isConnected;
    }
    public static String getURL(){
        return URL;
    }
    public static String getUsername(){
        return username;
    }
}
