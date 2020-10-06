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
public class StavkaZahteva implements OpstiDomenskiObjekat {

    private int rbStavke;
    private int ucestalost;
    private Usluga usluga;
    private Zahtev zahtev;
    private String naziv;

    public StavkaZahteva() {
    }

    public StavkaZahteva(int rbStavke, int ucestalost, Usluga usluga, Zahtev zahtev, String naziv) {
        this.rbStavke = rbStavke;
        this.ucestalost = ucestalost;
        this.naziv = naziv;
        this.usluga = usluga;
        this.zahtev = zahtev;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public double getUcestalost() {
        return ucestalost;
    }

    public void setUcestalost(int ucestalost) {
        this.ucestalost = ucestalost;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkazahteva";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaStavki = new ArrayList<>();
        try {
            while (rs.next()) {

                //Klijent k = new Klijent(rs.getInt("klijentID"), rs.getString("kompanija"), rs.getString("osoba"), rs.getString("grad"), rs.getString("email"), rs.getString("brojTelefona"));
                Usluga u = new Usluga(rs.getInt("uslugaID"), rs.getString("nazivUsluge"), rs.getDouble("cena"));
                Zahtev z = new Zahtev(rs.getInt("zahtevID"), new java.sql.Date(rs.getDate("datumOD").getTime()), new java.sql.Date(rs.getDate("datumDO").getTime()), rs.getDouble("ukupnaCena"), null, null, null);

                StavkaZahteva s = new StavkaZahteva(rs.getInt("rbStavke"), rs.getInt("ucestalost"),
                        u, z, rs.getString("naziv"));
                listaStavki.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return listaStavki;
    }

    @Override
    public String vratiUslovZaPretragu() {
        // return "stavkazahteva.zahtevID='" + zahtev.getZahtevID() + "'";
        return "stavkazahteva.zahtevID = '" + zahtev.getZahtevID() + "' AND stavkazahteva.uslugaID = '" + usluga.getUslugaID() + "'";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + ucestalost + "','" + usluga.getUslugaID() + "','" + zahtev.getZahtevID() + "', '" + naziv + "'";
    }

    @Override
    public String uzmiID() {
        return "rbStavke";
    }

    @Override
    public int vratiSlobodanID(ResultSet rs) {
        int slobodanID = 0;
        List<Integer> listaID = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("rbStavke");
                listaID.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StavkaZahteva.class.getName()).log(Level.SEVERE, null, ex);
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

    public Zahtev getZahtev() {
        return zahtev;
    }

    public void setZahtev(Zahtev zahtev) {
        this.zahtev = zahtev;
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return "rbStavke= '" +rbStavke + "'";

    }

    @Override
    public String vratiVrednostiZaOperacijuUpdate() {
        return "ucestalost='" + ucestalost + "', uslugaID='" + usluga.getUslugaID()
                + "', naziv='" + naziv + "'";

    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        return "rbStavke='" + rbStavke + "'";
    }

    @Override
    public String vratiJoinTabelu() {
        return "zahtev";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "stavkazahteva.zahtevID=zahtev.zahtevID";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "usluga";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "stavkazahteva.uslugaID=usluga.uslugaID";
    }

    @Override
    public String vratiJoinTabelu3() {
        return "";
    }

    @Override
    public String vratiUslovZaJoin3() {
        return "";
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
