There are some/seven Steps to Create Connection with SQL Database.

1. import Package  ==>  java.sql

2. Load and Register the Driver   ==> com.mysql.jdbc.Driver

3. Establish a Connection     ==> Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name"),

4. Create a Statement    ==> Statement stmt = con.createStatement();

5. Execute the Query     ==> ResultSet rs = stmt.executeQuery("SELECT * FROM your_table_name");

6. Process the Results  ==> while (rs.next()) {...}

7. Close the Connection