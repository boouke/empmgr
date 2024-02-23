public class Choice {
    public static void choice() {
        Database database = new Database();
        Query query = new Query();
        Auth.loginMethod();
        boolean isLoggedIn = Auth.getLoginStatus();
        for (;;) {
            boolean isConnected = Database.getConnectionStatus();
            System.out.println("\nWhat do you want to do? (Query, Connect, Status)");
            String userFlag = Tools.stringValidate();
            if (userFlag.equalsIgnoreCase("query")) {
                query.prepareQuery();
            } else if (userFlag.equalsIgnoreCase("connect")) {
                if (isConnected) {
                    System.out.println("\nThe connection is established. If you want to inspect the details, enquire \"Status\" ");
                } else {
                    database.connect();
                }
            } else if (userFlag.equalsIgnoreCase("status")) {
                String URL = Database.getURL();
                String username = Database.getUsername();
                System.out.println("\nConnection: [Establisthed, stable]\nURL: [" + URL + "]\nUsername: [" + username + "]");
            }
        }
    }
}
