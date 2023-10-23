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
public class DBNegara {
    private NegaraModel dt=new NegaraModel();    
    public NegaraModel getNegaraModel(){ return(dt);}
    public void setNegaraModel(NegaraModel s){ dt=s;}
    
    public ObservableList<NegaraModel>  Load() {
        try {
            ObservableList<NegaraModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodeNegara, namaNegara, tahunDitemukan, ditemukanSesudahMasehi, bendera from negara");
            
            int i = 1;
            while (rs.next()) {
                NegaraModel d=new NegaraModel();
                d.setKodeNegara(rs.getString("kodeNegara"));
                d.setNamaNegara(rs.getString("namaNegara"));
                d.setTahunDitemukan(rs.getString("tahunDitemukan"));
                boolean ditemukanSesudahMasehi = rs.getBoolean("ditemukanSesudahMasehi");
                String masehi;
                if (ditemukanSesudahMasehi) {
                    masehi = "Masehi";
                } else masehi = "Sebelum Masehi";
                d.setMasehi(masehi);
                d.setBendera(rs.getString("bendera"));
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
      public ObservableList<NegaraModel>  CariBrg(String kode, String nama) {
        try {    
            ObservableList<NegaraModel> tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from negara WHERE kodeNegara LIKE '" + kode + "%' OR namaNegara LIKE '" + nama + "%'");
            int i = 1;
            while(rs.next()){
            NegaraModel d = new NegaraModel();
             d.setKodeNegara(rs.getString("kodeNegara"));
                d.setNamaNegara(rs.getString("namaNegara"));
                d.setTahunDitemukan(rs.getString("tahunDitemukan"));
                boolean ditemukanSesudahMasehi = rs.getBoolean("ditemukanSesudahMasehi");
                String masehi;
                if (ditemukanSesudahMasehi) {
                    masehi = "Masehi";
                } else masehi = "Sebelum Masehi";
                d.setMasehi(masehi);
                d.setBendera(rs.getString("bendera"));
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from negara where kodeNegara  = ? ");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update negara set namaNegara = ?, tahunDitemukan = ?, ditemukanSesudahMasehi = ? , bendera = ?  where  kodeNegara = ? ");
            con.preparedStatement.setString(1, getNegaraModel().getNamaNegara());
            con.preparedStatement.setString(2, getNegaraModel().getTahunDitemukan());
            con.preparedStatement.setString(3, getNegaraModel().getMasa());
            con.preparedStatement.setString(4, getNegaraModel().getBendera());
            con.preparedStatement.setString(5, getNegaraModel().getKodeNegara());
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from negara where kodeNegara = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into negara (kodeNegara,namaNegara, tahunDitemukan, ditemukanSesudahMasehi, Bendera) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getNegaraModel().getKodeNegara());
            con.preparedStatement.setString(2, getNegaraModel().getNamaNegara());
            con.preparedStatement.setString(3, getNegaraModel().getTahunDitemukan());
            con.preparedStatement.setString(4, getNegaraModel().getMasa());
            con.preparedStatement.setString(5, getNegaraModel().getBendera());                
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
