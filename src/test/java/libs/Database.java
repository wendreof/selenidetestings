package libs;

import java.sql.*;

public class Database {
    private final String URL = "jdbc:postgresql://pgdb/ninjaplus";
    private final String USER = "postgres";
    private final String PWD = "qaninja";


    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

    public void deleteMovie(String title) throws SQLException {
        String query = "DELETE FROM public.movies where title = ?;";

        PreparedStatement stm = this.connect().prepareStatement(query);

        stm.setString(1, title);
        stm.executeQuery();

    }
}
