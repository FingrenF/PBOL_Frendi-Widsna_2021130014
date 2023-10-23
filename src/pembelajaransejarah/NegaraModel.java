/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pembelajaransejarah;

/**
 *
 * @author Lenovo
 */
public class NegaraModel {
    private String kodeNegara, namaNegara, tahunDitemukan, bendera, masehi, masa;
    private boolean ditemukanSesudahMasehi;

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
        switch (masa) {
            case "true":
                setDitemukanSesudahMasehi(true);
                break;
            case "false":
                setDitemukanSesudahMasehi(false);
            default:
                throw new AssertionError();
        }
    }
    

    public String getMasehi() {
        return masehi;
    }

    public void setMasehi(String masehi) {
        this.masehi = masehi;
    }
    
    public String getKodeNegara() {
        return kodeNegara;
    }

    public void setKodeNegara(String kodeNegara) {
        this.kodeNegara = kodeNegara;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }

    public String getTahunDitemukan() {
        return tahunDitemukan;
    }

    public void setTahunDitemukan(String tahunDitemukan) {
        this.tahunDitemukan = tahunDitemukan;
    }

    public String getBendera() {
        return bendera;
    }

    public void setBendera(String bendera) {
        this.bendera = bendera;
    }

    public boolean isDitemukanSesudahMasehi() {
        return ditemukanSesudahMasehi;
    }

    public void setDitemukanSesudahMasehi(boolean ditemukanSesudahMasehi) {
        this.ditemukanSesudahMasehi = ditemukanSesudahMasehi;
    }
    
}
