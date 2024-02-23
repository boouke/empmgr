import java.io.Console;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Tools {
    Console cnsl = null;
    private long startTime;

    public void stopwatchStart() {
        startTime = System.nanoTime();
    }

    public String stopwatchStop() {
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        double seconds = (double) elapsedTime / 1_000_000_000.0;
        double milliseconds = (double) elapsedTime / 1_000_000.0;

        return String.format("%.3f", seconds) + " s (" + String.format("%.3f", milliseconds) + " ms)";
    }
    public static String stringValidate() {
        boolean validInput = false;
        String errorCode;
        String stringToValidate = "";
        Scanner scan = new Scanner(System.in);
        while (!validInput) {
            try {
                stringToValidate = scan.nextLine();
                validInput = true;
            } catch (NoSuchElementException e) {
                errorCode = "e0x01";
                System.out.println(TechnicalErrorCodes.e0x01);
                ErrorHandling.logError(e, errorCode);
                System.exit(1);
            } catch (IllegalStateException e) {
                errorCode = "e0x11";
                System.out.println(TechnicalErrorCodes.e0x11);
                ErrorHandling.logError(e, errorCode);
                System.exit(1);
            }
        }
        return stringToValidate;
    }
    public String passRead(){
        String pass = "";
        char[] temp = null;
        try{
            cnsl = System.console();
            if (cnsl != null) {
                temp = cnsl.readPassword("Please input password:");
            } else {
                System.out.println("null");
            }
        } catch (Exception e){
            ErrorHandling.logError(e, "e0x81");
        }
        if (temp!=null){
            pass = String.valueOf(temp);
        } else {
            ErrorHandling.logErrorNoException("e0x81");
        }
        System.out.println(pass);
        return pass;
    }
}