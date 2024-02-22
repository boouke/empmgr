import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ErrorHandling {
    public static String stringValidate() {
        boolean validInput = false;
        String errorCode;
        boolean corePanicState = false;
        String stringToValidate = "";
        Scanner scan = new Scanner(System.in);
        while (!validInput) {
            try {
                //System.in.close();
                stringToValidate = scan.nextLine();
                validInput = true;
            } catch (NoSuchElementException e) {
                errorCode = "e0x01";
                System.out.println(TechnicalErrorCodes.e0x01);
                logError(e, errorCode);
                System.exit(1);
            } catch (IllegalStateException e) {
                errorCode = "e0x11";
                System.out.println(TechnicalErrorCodes.e0x11);
                logError(e, errorCode);
                System.exit(1);
            }
        }
        return stringToValidate;
    }
    public static void logError(Exception e, String errorCode) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd___HH-mm-ss").format(new Date());
        String filename = "logs/err" + timestamp + ".dmp";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.write("\n" + "[" + timestamp + "] - " + errorCode);
            e.printStackTrace(writer);
            System.out.println("Error logged in external file.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void logErrorNoException(String errorCode) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd___HH-mm-ss").format(new Date());
        String filename = "../logs/err" + timestamp + ".dmp";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
                writer.write("\n" + "[" + timestamp + "] - " + errorCode);
            System.out.println("Error logged in external file.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
