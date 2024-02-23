import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Auth {
    static boolean isLoggedIn = false;
    static PreparedStatement pstmt = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static boolean isAdmin = false;
    public static void loginMethod() {
        System.out.println("Please input login or register to continue.");
        boolean validInput = false;
        while (!validInput) {
            String userFlag = Tools.stringValidate();
            if (userFlag.equalsIgnoreCase("Login")) {
                login();
                validInput = true;
            } else if (userFlag.equalsIgnoreCase("Register")) {
                register();
                validInput = true;
            } else {
                System.out.println("Select one of the options.");
            }
        }
    }
    public static void login() {
        Database database = new Database();
        database.autoConnect();
        System.out.println("Please insert username.");
        String username = Tools.stringValidate();
        System.out.println("Please insert password.w");
        String password = Tools.stringValidate();
        Connection conn = Database.getConn();

        try {
            pstmt = conn.prepareStatement("SELECT username, pass, admin FROM db_access WHERE username = ? AND pass = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            System.out.println("Logging in...");
            while(!isLoggedIn) {
                if (rs.next()) {
                    isAdmin = rs.getBoolean("admin");
                    System.out.println("Success!\nYou are now logged in as " + username);
                    isLoggedIn = true;
                } else {
                    System.out.println("Credentials do not match, try again!");
                }
            }
            conn.close();
            rs.close();
            pstmt.close();
        } catch (java.sql.SQLException e) {
            ErrorHandling.logError(e, "e0x91");
        }
    }
    public static void register(){
        Database database = new Database();
        database.autoConnect();
        String username = Tools.stringValidate();
        String password = Tools.stringValidate();
        Connection conn = Database.getConn();

        try{
            pstmt = conn.prepareStatement("INSERT INTO db_access(username, pass, admin) VALUES (?, ?, false)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            loginMethod();
        } catch (java.sql.SQLException e){
            ErrorHandling.logError(e, "e0x91");
        }
    }
    public static boolean getLoginStatus(){
        return isLoggedIn;
    }
    public static boolean getAdminStatus(){
        return isAdmin;
    }
}
