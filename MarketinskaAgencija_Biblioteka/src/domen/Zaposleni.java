/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author djurd
 */
public class Zaposleni implements OpstiDomenskiObjekat {

    private int zaposleniID;
    private String imeZaposlenog;
    private String prezimeZaposlenog;
    private Date datumRodjenja;
    private Date datumZaposlenja;
    private String username;
    private String password;
    private double plata;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniID, String imeZaposlenog, String prezimeZaposlenog, Date datumRodjenja, Date datumZaposlenja, String username, String password, double plata) {
        this.zaposleniID = zaposleniID;
        this.imeZaposlenog = imeZaposlenog;
        this.prezimeZaposlenog = prezimeZaposlenog;
        this.datumRodjenja = datumRodjenja;
        this.datumZaposlenja = datumZaposlenja;
        this.username = username;
        this.password = password;
        this.plata = plata;
    }

    @Override
    public String toString() {
        return imeZaposlenog + " " + prezimeZaposlenog;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getImeZaposlenog() {
        return imeZaposlenog;
    }

    public void setImeZaposlenog(String imeZaposlenog) {
        this.imeZaposlenog = imeZaposlenog;
    }

    public String getPrezimeZaposlenog() {
        return prezimeZaposlenog;
    }

    public void setPrezimeZaposlenog(String prezimeZaposlenog) {
        this.prezimeZaposlenog = prezimeZaposlenog;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Zaposleni zaposleni = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("imeZaposlenog"),
                    rs.getString("prezimeZaposlenog"), new Date(rs.getDate("datumRodjenja").getTime()),
                    new Date(rs.getDate("datumZaposlenja").getTime()),
                    rs.getString("username"), rs.getString("password"), rs.getDouble("plata"));
            lista.add(zaposleni);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "username = '" + username + "' AND password='" + password + "'";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String uzmiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiSlobodanID(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaOperacijuUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
