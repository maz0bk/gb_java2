import java.sql.*;

public class MainClass {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect();
            dropTableEx();
            createTableEx();
            prepareStatements();
            rollbackEx();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void rollbackEx() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10);");
        Savepoint sp1 = connection.setSavepoint();
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20);");
        connection.rollback(sp1);
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30);");
        connection.setAutoCommit(true);
    }

    private static void trasactionEx() throws SQLException {
        long t = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 10000; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, i * 10 % 100);
            psInsert.executeUpdate();
        }
        connection.setAutoCommit(true);
        System.out.println("time: " + (System.currentTimeMillis() - t));
    }

    private static void batchEx() throws SQLException {
        for (int i = 1; i <= 10; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, i * 10 % 100);
            psInsert.addBatch();
        }
        psInsert.executeBatch();
    }

    private static void addDataPreparedStatementEx() throws SQLException {
        for (int i = 1; i <= 10; i++) {
            psInsert.setString(1, "Bob" + i);
            psInsert.setInt(2, i * 10 % 100);
            psInsert.executeUpdate();
        }
    }

    private static void createTableEx() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (\n" +
                "        id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "        name  TEXT,\n" +
                "        score INTEGER\n" +
                "    );");
    }

    private static void dropTableEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    private static void readEx() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id > 2;");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt(3));
        }
    }

    private static void clearTableEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students;");
    }

    private static void deleteEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE name = 'Bob1';");
    }

    private static void updateEx() throws SQLException {
        stmt.executeUpdate("UPDATE students SET score = 100 WHERE name = 'Bob4';");
    }

    private static void insertEx() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob4', 60);");
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void prepareStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psInsert.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
