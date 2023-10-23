package pembelajaransejarah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

class Koneksi {
    public Connection dbKoneksi;
    public Statement statement;
    public PreparedStatement preparedStatement;
    public Koneksi() {
        this.dbKoneksi = null;    
    }
    
    public void bukaKoneksi() {
        try {    Class.forName("com.mysql.jdbc.Driver");
            dbKoneksi = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/db_sejarah?user=root&password=");
        } catch (Exception e) {
            e.printStackTrace();}
    }
    
    public void tutupKoneksi() {
        try { if (statement != null) {    
            statement.close();           
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (dbKoneksi != null) {
            dbKoneksi.close();
        }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());        }    
    }
}
