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
public class Izvrsava implements OpstiDomenskiObjekat {

    private Zaposleni zaposleni;
    private StavkaZahteva stavka;

    public Izvrsava() {
    }

    public Izvrsava(Zaposleni zaposleni, StavkaZahteva stavka) {
        this.zaposleni = zaposleni;
        this.stavka = stavka;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public StavkaZahteva getStavka() {
        return stavka;
    }

    public void setStavka(StavkaZahteva stavka) {
        this.stavka = stavka;
    }

    @Override
    public String vratiNazivTabele() {
        return "izvrsava";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Zaposleni zap = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("imeZaposlenog"),
                    rs.getString("prezimeZaposlenog"), new Date(rs.getDate("datumRodjenja").getTime()),
                    new Date(rs.getDate("datumZaposlenja").getTime()),
                    rs.getString("username"), rs.getString("password"), rs.getDouble("plata"));

            Zahtev z = new Zahtev(rs.getInt("zahtevID"), new java.sql.Date(rs.getDate("datumOD").getTime()),
                    new java.sql.Date(rs.getDate("datumDO").getTime()), rs.getDouble("ukupnaCena"), null, null, null);

            Usluga u = new Usluga(rs.getInt("uslugaID"), rs.getString("nazivUsluge"), rs.getDouble("cena"));

            StavkaZahteva sz = new StavkaZahteva(rs.getInt("rbStavke"), rs.getInt("ucestalost"),
                    u, z, rs.getString("naziv"));

            Izvrsava izvrsava = new Izvrsava(zap, sz);

            lista.add(izvrsava);
        }
        return lista;
    }

    @Override
    public String vratiUslovZaPretragu() {
        return "izvrsava.zahtevID='" + stavka.getZahtev().getZahtevID() + "'";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + stavka.getZahtev().getZahtevID() + "','" + stavka.getRbStavke() + "','" + zaposleni.getZaposleniID() + "'";
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
        return "rbStavke= '" + stavka.getRbStavke() + "'";
    }

    @Override
    public String vratiVrednostiZaOperacijuUpdate() {
        return "zaposleniID='" + zaposleni.getZaposleniID() + "'";
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        return "rbStavke='" + stavka.getRbStavke()+ "'";
    }

    @Override
    public String vratiJoinTabelu() {
        return "zahtev";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "izvrsava.zahtevID=zahtev.zahtevID";
    }

    @Override
    public String vratiJoinTabelu2() {
        return "stavkazahteva";
    }

    @Override
    public String vratiUslovZaJoin2() {
        return "izvrsava.rbStavke=stavkazahteva.rbStavke";
    }

    @Override
    public String vratiJoinTabelu3() {
        return "zaposleni";
    }

    @Override
    public String vratiUslovZaJoin3() {
        return "izvrsava.zaposleniID=zaposleni.zaposleniID";
    }

    @Override
    public String vratiJoinTabelu4() {
        return "usluga";
    }

    @Override
    public String vratiUslovZaJoin4() {
        return "stavkazahteva.uslugaID=usluga.uslugaID";
    }

    @Override
    public String vratiUslovZaPretraguDveTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
