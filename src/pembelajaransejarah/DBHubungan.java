/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pembelajaransejarah;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class DBHubungan {
    private HubunganModel dt=new HubunganModel();    
    public HubunganModel getHubunganModel(){ return(dt);}
    public void setHubunganModel(HubunganModel s){ dt=s;}
    
    public ObservableList<HubunganModel>  Load() {
        try {
            ObservableList<HubunganModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodeHubungan, kodeKejadian, kodeNegara, deskripsiHubungan from hubungan");
            
            int i = 1;
            while (rs.next()) {
                HubunganModel d=new HubunganModel();
                d.setKodeHubungan(rs.getString("kodeHubungan"));
                d.setKodeNegara(rs.getString("kodeNegara"));
                d.setKodeKejadian(rs.getString("kodeKejadian"));
                d.setDeskripsiHubungan(rs.getString("deskripsiHubungan"));
                tableData.add(d);                
                i++;            
            }
            con.tutupKoneksi();            
            return tableData;
        } catch (Exception e) {            
            e.printStackTrace();            
            return null;        
        }
    }
      public ObservableList<HubunganModel>  CariHubungan(String kode) {
        try {    
            ObservableList<HubunganModel> tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from hubungan WHERE kodeHubungan LIKE '" + kode + "%'");
            int i = 1;
            while(rs.next()){
            HubunganModel d = new HubunganModel();
            d.setKodeHubungan(rs.getString("kodeHubungan"));
            d.setKodeNegara(rs.getString("kodeNegara"));
            d.setKodeKejadian(rs.getString("kodeKejadian"));
            d.setDeskripsiHubungan(rs.getString("deskripsiHubungan"));
            tableData.add(d);
            i++;
            }
            con.tutupKoneksi();
            return tableData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
      public boolean delete(String nomor) {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from hubungan where kodeHubungan = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }
      public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update hubungan set kodeNegara = ?, kodeKejadian = ? , deskripsiHubungan = ?  where  kodeHubungan = ? ");
            con.preparedStatement.setString(1, getHubunganModel().getKodeNegara());
            con.preparedStatement.setString(2, getHubunganModel().getKodeKejadian());
            con.preparedStatement.setString(3, getHubunganModel().getDeskripsiHubungan());
            con.preparedStatement.setString(4, getHubunganModel().getKodeHubungan());
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }    
    }
    public int validasi(String nomor) {
        int val = 0;
        try {         
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from hubungan where kodeHubungan = '" + nomor + "'");
            while (rs.next()) {                
                val = rs.getInt("jml");            
            }            
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }
    
    public boolean insert() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {       
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into hubungan (kodeHubungan, kodeNegara, kodeKejadian, deskripsiHubungan) values (?,?,?,?)");
            con.preparedStatement.setString(1, getHubunganModel().getKodeHubungan());  
            con.preparedStatement.setString(2, getHubunganModel().getKodeNegara());
            con.preparedStatement.setString(3, getHubunganModel().getKodeKejadian());
            con.preparedStatement.setString(4, getHubunganModel().getDeskripsiHubungan());            
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }    
     }
    
   public ObservableList<HubunganModel> getDescriptionsByNegara(NegaraModel negara) {
    ObservableList<HubunganModel> descriptions = FXCollections.observableArrayList();

    try {
        Koneksi con = new Koneksi();
        con.bukaKoneksi();
        con.statement = con.dbKoneksi.createStatement();

        String query = "SELECT h.kodeHubungan, h.kodeKejadian, h.kodeNegara, h.deskripsiHubungan, " +
                       "k.kodeKejadian AS kejadianKode, k.namaKejadian " +
                       "FROM hubungan h " +
                       "JOIN negara n ON h.kodeNegara = n.kodeNegara " +
                       "JOIN kejadian k ON h.kodeKejadian = k.kodeKejadian " +
                       "WHERE n.kodeNegara = '" + negara.getKodeNegara() + "'";

        ResultSet rs = con.statement.executeQuery(query);

        while (rs.next()) {
            HubunganModel description = new HubunganModel();
            description.setKodeHubungan(rs.getString("kodeHubungan"));
            description.setKodeNegara(rs.getString("kodeNegara"));
            description.setKodeKejadian(rs.getString("kodeKejadian"));
            description.setDeskripsiHubungan(rs.getString("deskripsiHubungan"));

            KejadianModel kejadianModel = new KejadianModel();
            kejadianModel.setNamaKejadian(rs.getString("namaKejadian"));

            description.setKejadianModel(kejadianModel);

            descriptions.add(description);
        }

        con.tutupKoneksi();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return descriptions;
}

     private static DBHubungan instance = new DBHubungan();

    public static DBHubungan getInstance() {
        return instance;
    }
}
