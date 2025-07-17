import java.sql.*;

// Here we Will See Another Method or Way to How to connect from your Database

public class JDBC1 {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/DatabaseName?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String QUERY = "SELECT * FROM TableName";
        // Add this before getting connection
        System.out.println("Connecting to: " + URL);
        System.out.println("Using credentials: " + USERNAME + "/" + PASSWORD.replaceAll(".", "*"));

        try (
                // Auto-closeable resources (Java 7+ feature)
                Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            // Get metadata to dynamically print columns
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println("\n----------------------------------");

            // Iterate through result rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}