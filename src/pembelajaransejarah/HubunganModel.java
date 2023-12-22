/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pembelajaransejarah;

/**
 *
 * @author Lenovo
 */
public class HubunganModel {
    private String kodeHubungan, kodeKejadian, kodeNegara, deskripsiHubungan;
    private KejadianModel kejadianModel;

    public KejadianModel getKejadianModel() {
        return kejadianModel;
    }

    public void setKejadianModel(KejadianModel kejadianModel) {
        this.kejadianModel = kejadianModel;
    }

    public String getKodeHubungan() {
        return kodeHubungan;
    }

    public void setKodeHubungan(String kodeHubungan) {
        this.kodeHubungan = kodeHubungan;
    }

    public String getKodeKejadian() {
        return kodeKejadian;
    }

    public void setKodeKejadian(String kodeKejadian) {
        this.kodeKejadian = kodeKejadian;
    }

    public String getKodeNegara() {
        return kodeNegara;
    }

    public void setKodeNegara(String kodeNegara) {
        this.kodeNegara = kodeNegara;
    }

    public String getDeskripsiHubungan() {
        return deskripsiHubungan;
    }

    public void setDeskripsiHubungan(String deskripsiHubungan) {
        this.deskripsiHubungan = deskripsiHubungan;
    }
}
