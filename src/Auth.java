import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Auth {
    static PreparedStatement pstmt = null;
    ResultSet rs = null;
    public static void loginMethod() {
        System.out.println("Please input login or register to continue.");
        boolean validInput = false;
        while (!validInput) {
            String userFlag = Tools.stringValidate();
            if (userFlag.equalsIgnoreCase("Login")) {
                login();
            }
        }
    }
    public static void login() {
        String username = Tools.stringValidate();
        String password = Tools.stringValidate();
        Connection conn = Database.getConn();

        try {
            pstmt = conn.prepareStatement("SELECT username, pass, isAdmin FROM db_access WHERE username = ? AND pass = ?");
        } catch (java.sql.SQLException e) {
            ErrorHandling.logError(e, "e0x91");
        }
    }
}
