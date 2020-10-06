/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djurd
 */

public class Klijent implements OpstiDomenskiObjekat {

    private int klijentID;
    private String kompanija;
    private String osoba;
    private String grad;
    private String email;
    private String brojTelefona;
    private String kriterijumPretrage;

    public Klijent() {

    }

    public Klijent(int klijentID, String kompanija, String osoba, String grad, String email, String brojTelefona) {
        this.klijentID = klijentID;
        this.kompanija = kompanija;
        this.osoba = osoba;
        this.grad = grad;
        this.email = email;
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return kompanija + " - " + osoba;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public String getOsoba() {
        return osoba;
    }

    public void setOsoba(String osoba) {
        this.osoba = osoba;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaKlijenata = new ArrayList<>();
        try {
            while (rs.next()) {
                Klijent k = new Klijent();
                k.setKlijentID(rs.getInt("klijentID"));
                k.setKompanija(rs.getString("kompanija"));
                k.setOsoba(rs.getString("osoba"));
                k.setGrad(rs.getString("grad"));
                k.setEmail(rs.getString("email"));
                k.setBrojTelefona(rs.getString("brojTelefona"));

                listaKlijenata.add(k);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return listaKlijenata;
    }

    @Override
    public String vratiUslovZaPretragu() {
       
       return "kompanija LIKE '%" + kriterijumPretrage + "%' OR osoba LIKE '%" + kriterijumPretrage + "%' OR grad LIKE '%"+kriterijumPretrage+"%'";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + kompanija + "','" + osoba + "','" + grad + "','" + email + "','" + brojTelefona + "'";
    }

    @Override
    public String uzmiID() {
        return "klijentID";
    }

    @Override
    public int vratiSlobodanID(ResultSet rs) {
        int slobodanID = 0;
        List<Integer> listaID = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("klijentID");
                listaID.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listaID.isEmpty()) {
            return 1;
        }
        for (int i = 0; i < listaID.size(); i++) {
            if ((i + 1) == listaID.size()) {
                return listaID.get(i) + 1;
            } else if ((listaID.get(i) + 1) < listaID.get(i + 1)) {
                return listaID.get(i) + 1;
            }
        }
        return slobodanID;
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return "klijentID= '"+klijentID+"'";
    }

    @Override
    public String vratiVrednostiZaOperacijuUpdate() {
        return "kompanija='" +kompanija + "',osoba='" + osoba + "',grad='" + grad + "', email='"+email+"', brojTelefona='"+brojTelefona+"'";
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        return "klijentID='"+klijentID+"'";
    }

    @Override
    public String vratiJoinTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiJoinTabelu4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJoin4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPretraguDveTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
