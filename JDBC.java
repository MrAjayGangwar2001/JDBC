import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws Exception {

        // There are Seven Steps to connect to a database using JDBC
        // 1. Import the necessary packages
        // 2. Register the driver
        // 3. create a connection
        // 4. Create a statement
        // 5. Execute the query
        // 6. Process the result
        // 7. Close the connection

        String url = "jdbc:mysql://localhost:3306/Database-Name?useSSL=false&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";
        String query = "select * from Table_Name";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Connecting to: " + url);
            System.out.println("Using credentials: " + username + "/" + password.replaceAll(".", "*"));
            System.out.println("Query: " + query);
            System.out.println("---------------Connected Successfully-------------------");

            rs.next();
           // String data = rs.getString("name");
            System.out.println(rs.getString(2)); // Fetch first column data

            // while (rs.next()) {
            // String data = rs.getString("name"); // Fetch first column data
            // System.out.println(data);
            // }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

