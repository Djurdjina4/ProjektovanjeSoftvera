/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djurd
 */
public class Zahtev implements OpstiDomenskiObjekat {

    private int zahtevID;
    private Date datumOD;
    private Date datumDO;
    private double ukupnaCena;
    private Klijent klijent;
    private ArrayList<StavkaZahteva> stavke;
    private ArrayList<Izvrsava> izvrsava;

    private String kriterijumPretrage;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Zahtev() {
        stavke = new ArrayList<>();
    }

    public Zahtev(int zahtevID, Date datumOD, Date datumDO, double ukupnaCena, Klijent klijent, ArrayList<StavkaZahteva> stavke, ArrayList<Izvrsava> izvrsava) {
        this.zahtevID = zahtevID;
        this.datumOD = datumOD;
        this.datumDO = datumDO;
        this.ukupnaCena = ukupnaCena;
        this.klijent = klijent;
        this.stavke = stavke;
        this.izvrsava = izvrsava;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public int getZahtevID() {
        return zahtevID;
    }

    public void setZahtevID(int zahtevID) {
        this.zahtevID = zahtevID;
    }

    public Date getDatumOD() {
        return datumOD;
    }

    public void setDatumOD(Date datumOD) {
        this.datumOD = datumOD;
    }

    public Date getDatumDO() {
        return datumDO;
    }

    public void setDatumDO(Date datumDO) {
        this.datumDO = datumDO;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public ArrayList<StavkaZahteva> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaZahteva> stavke) {
        this.stavke = stavke;
    }

    public ArrayList<Izvrsava> getIzvrsava() {
        return izvrsava;
    }

    public void setIzvrsava(ArrayList<Izvrsava> izvrsava) {
        this.izvrsava = izvrsava;
    }

    @Override
    public String vratiNazivTabele() {
        return "zahtev";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> listaZahteva = new ArrayList<>();
        try {
            while (rs.next()) {
                Zahtev z = new Zahtev();

                z.setZahtevID(rs.getInt("zahtevID"));
                z.setDatumOD(new java.sql.Date(rs.getDate("datumOD").getTime()));
                z.setDatumDO(new java.sql.Date(rs.getDate("datumDO").getTime()));
                z.setUkupnaCena(rs.getDouble("ukupnaCena"));

                Klijent klijent1 = new Klijent(rs.getInt("klijentID"), rs.getString("kompanija"), rs.getString("osoba"), rs.getString("grad"), rs.getString("email"), rs.getString("brojTelefona"));

                z.setKlijent(klijent1);

                z.setStavke(null);
                z.setIzvrsava(null);
                listaZahteva.add(z);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return listaZahteva;
    }

    @Override
    public String vratiUslovZaPretragu() {
        String uslov = "zahtev.klijentID = '" + klijent.getKlijentID() + "'";
        if (kriterijumPretrage.equals("")) {
            return uslov;
        } else {
            return uslov += " AND zahtev.ukupnaCena LIKE '%" + kriterijumPretrage + "%'";
        }

    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + new java.sql.Date(datumOD.getTime()) + "','" + new java.sql.Date(datumDO.getTime()) + "','" + klijent.getKlijentID() + "', '" + ukupnaCena + "'";

    }

    @Override
    public String uzmiID() {
        return "zahtevID";
    }

    @Override
    public int vratiSlobodanID(ResultSet rs) {
        int slobodanID = 0;
        List<Integer> listaID = new ArrayList<>();

        try {
            while (rs.next()) {
                int id = rs.getInt("zahtevID");
                listaID.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Zahtev.class.getName()).log(Level.SEVERE, null, ex);
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
        return "zahtevID= '" + zahtevID + "'";
    }

    @Override
    public String vratiVrednostiZaOperacijuUpdate() {
        System.out.println(sdf.format(datumOD));
        return "datumOD='" + sdf.format(datumOD) + "',datumDO='" + sdf.format(datumDO) + "',klijentID='" + klijent.getKlijentID() + "',ukupnaCena='" + ukupnaCena + "'";
    }

    @Override
    public String vratiUslovZaOperacijuUpdate() {
        return "zahtevID='" + zahtevID + "'";
    }

    @Override
    public String vratiJoinTabelu() {
        return "klijent";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "zahtev.klijentID=klijent.klijentID";
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
