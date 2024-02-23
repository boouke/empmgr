import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Query extends Database{
    ResultSet rs = null;
    Statement stmt = null;
    public void prepareQuery(){
        String query = Tools.stringValidate();
        if (query.contains("SELECT")){
            selectQuery(query);
        }
    }
    public void selectQuery(String query){
        try {
            stmt = conn.createStatement();
            System.out.println("Executing query: " + query);
            rs = stmt.executeQuery(query);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String nationality = rs.getString("nationality");
                String number = rs.getString("number");
                String position = rs.getString("position");
                int salary = rs.getInt("salary");
                Date hireDate = rs.getDate("hire_date");
                String additionalInfo = rs.getString("additional_info");
                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname +
                        ", Age: " + age + ", Nationality: " + nationality +
                        ", Number: " + number + ", Position: " + position +
                        ", Salary: " + salary + ", Hire Date: " + hireDate +
                        ", Additional Info: " + additionalInfo);

            }
        } catch (SQLException e){
            ErrorHandling.logError(e, "e0x91");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }catch(java.sql.SQLException e){
                    ErrorHandling.logError(e, "e0x91");
            }
        }
    }
    public void managerialQuery(boolean isAdmin, String query){
        try {
            stmt = conn.createStatement();
            if (query.contains("DROP") || query.contains("TRUNCATE") || query.contains("COMMIT") || query.contains("ROLLBACK") || query.contains("SAVEPOINT") || query.contains("GRANT") || query.contains("REVOKE"))
            stmt.executeUpdate(query);
        } catch(java.sql.SQLException e){
            ErrorHandling.logError(e, "e0x91");
        }
    }
}
