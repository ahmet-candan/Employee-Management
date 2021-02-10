
package calisanlarprojesi;

public class Calisan {
    
    private int id;
    private String ad;
    private String soyad;
    private String maas;
    private String departman;

    public Calisan(int id, String ad, String soyad, String maas, String departman) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.maas = maas;
        this.departman = departman;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }
  
}
