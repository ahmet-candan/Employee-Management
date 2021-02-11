package calisanlarprojesi;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalisanIslmeleri {
    
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement prepareStatement = null;
    
    public ArrayList<Calisan> calisanlariGetir(){
        
        ArrayList<Calisan> cikti = new ArrayList<Calisan>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * from calisanlar";
            ResultSet rm = statement.executeQuery(sorgu);
            
            while ( rm.next()){
            
            int id = rm.getInt("id");
            String ad = rm.getString("ad");
            String soyad = rm.getString("soyad");
            String dep = rm.getString("departman");
            String maas = rm.getString("maas");
            
            cikti.add(new Calisan(id, ad, soyad, dep, maas));
            }
            return cikti;

        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslmeleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public void calisanGuncelle(int id,String yad,String ysoyad,String ydepartman,String ymaas){
    
        String sorgu = "UPDATE calisanlar set ad = ? , soyad=? , departman=? , maas=? where id=?";
        
        try {
            prepareStatement = con.prepareStatement(sorgu);
            
            prepareStatement.setString(1, yad);
            prepareStatement.setString(2, ysoyad);
            prepareStatement.setString(3, ydepartman);
            prepareStatement.setString(4, ymaas);
            prepareStatement.setInt(5, id);
            
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslmeleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calisanSil(int id){
        
            String sorgu = "Delete from calisanlar where id = ?";
        try {
            prepareStatement = con.prepareCall(sorgu);
            prepareStatement.setInt(1,id);
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslmeleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            
    }
    
    public void calisanEkle(String ad,String soyad,String departman,String maas){
    
        String sorgu = "Insert Into calisanlar (ad,soyad,departman,maas) VALUES (?, ?, ?, ?)";
        
        try {
            prepareStatement = con.prepareStatement(sorgu);
            
            prepareStatement.setString(1, ad);
            prepareStatement.setString(2, soyad);
            prepareStatement.setString(3, departman);
            prepareStatement.setString(4, maas);
            
            prepareStatement.executeUpdate();
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(CalisanIslmeleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean girisYap(String kullanici,String parola) throws SQLException{
    String sorgu = "Select * from adminler where username= ? and password = ?";
    
    
        try {
            prepareStatement = con.prepareStatement(sorgu);
            prepareStatement.setString(1, kullanici);
        prepareStatement.setString(2, parola);
        
        ResultSet rs = prepareStatement.executeQuery();
        
        return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslmeleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }

    public CalisanIslmeleri() {
        
        String url = "jdbc:mysql://localhost:3306/demo";
        
        try {
            con = DriverManager.getConnection(url,"root","");
            System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslmeleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
