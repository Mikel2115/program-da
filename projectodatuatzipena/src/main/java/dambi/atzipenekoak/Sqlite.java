package dambi.atzipenekoak;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sqlite {
    private Connection connect() {
        System.out.println(new File("").getAbsolutePath());
        String url = "jdbc:sqlite:Bidojokoak.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void insert(int id, int rangoak, String tituloa, double bentak, String series, String plataformak, String fecha, String desarrollador, String publikatzailea) {
        String sql = "INSERT INTO BestSeller(Id, Rangoak, Tituloa, Bentak, Series, Plataformak, Kanporaketa_data, Desarrolladorea, Publikatzailea) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.setInt(2, rangoak);
                pstmt.setString(3, tituloa);
                pstmt.setDouble(4, bentak);
                pstmt.setString(5, series);
                pstmt.setString(6, plataformak);
                pstmt.setString(7, fecha);
                pstmt.setString(8, desarrollador);
                pstmt.setString(9, publikatzailea);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
