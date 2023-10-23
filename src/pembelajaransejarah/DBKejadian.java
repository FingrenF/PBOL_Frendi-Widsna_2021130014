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
public class DBKejadian {
    private KejadianModel dt=new KejadianModel();    
    public KejadianModel getKejadianModel(){ return(dt);}
    public void setKejadianModel(KejadianModel s){ dt=s;}
    
    public ObservableList<KejadianModel>  Load() {
        try {
            ObservableList<KejadianModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodeKejadian, namaKejadian, tahunAwal, tahunAkhir, deskripsi from kejadian");
            
            int i = 1;
            while (rs.next()) {
                KejadianModel d=new KejadianModel();
                d.setKodeKejadian(rs.getString("kodeKejadian"));
                d.setNamaKejadian(rs.getString("namaKejadian"));
                d.setTahunAwal(rs.getString("tahunAwal"));
                d.setTahunAkhir(rs.getString("tahunAkhir"));
                d.setDeskripsi(rs.getString("deskripsi"));
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
      public ObservableList<KejadianModel>  CariBrg(String kode, String nama) {
        try {    
            ObservableList<KejadianModel> tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from kejadian WHERE kodeKejadian LIKE '" + kode + "%' OR namaKejadian LIKE '" + nama + "%'");
            int i = 1;
            while(rs.next()){
            KejadianModel d = new KejadianModel();
             d.setKodeKejadian(rs.getString("kodeKejadian"));
                d.setNamaKejadian(rs.getString("namaKejadian"));
                d.setTahunAwal(rs.getString("tahunAwal"));
                d.setTahunAkhir(rs.getString("tahunAkhir"));
                d.setDeskripsi(rs.getString("deskripsi"));
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from kejadian where kodeKejadian = ? ");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update kejadian set namaKejadian = ?, tahunAwal = ?, tahunAkhir = ? , deskripsi = ?  where  kodeKejadian = ? ");
            con.preparedStatement.setString(1, getKejadianModel().getNamaKejadian());
            con.preparedStatement.setString(2, getKejadianModel().getTahunAwal());
            con.preparedStatement.setString(3, getKejadianModel().getTahunAkhir());
            con.preparedStatement.setString(4, getKejadianModel().getDeskripsi());
            con.preparedStatement.setString(5, getKejadianModel().getKodeKejadian());
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from kejadian where kodeKejadian= '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into kejadian (kodeKejadian,namaKejadian, tahunAwal, tahunAkhir, deskripsi) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getKejadianModel().getKodeKejadian());  
            con.preparedStatement.setString(2, getKejadianModel().getNamaKejadian());
            con.preparedStatement.setString(3, getKejadianModel().getTahunAwal());
            con.preparedStatement.setString(4, getKejadianModel().getTahunAkhir());
            con.preparedStatement.setString(5, getKejadianModel().getDeskripsi());
                         
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
}
