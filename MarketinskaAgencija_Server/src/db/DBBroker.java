/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djurd
 */
public class DBBroker {

    Connection konekcija;
    private static DBBroker instance;

    public DBBroker() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/seminarski";
        String username = "root";
        String password = "";

        try {
            konekcija = DriverManager.getConnection(url, username, password);
            konekcija.setAutoCommit(false);
            System.out.println("Uspesno uspostavljanje konekcije!");

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Konekcija na bazu nije uspela!");
        }
    }

    public static DBBroker getInstance() throws IOException, SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OpstiDomenskiObjekat> vratiSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public int sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES ('" + vratiSlobodanID(odo) + "'," + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement sqlStatement = konekcija.prepareStatement(upit);
        sqlStatement.executeUpdate(upit);
        return vratiSlobodanID(odo);
    }

    private int vratiSlobodanID(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "SELECT " + odo.uzmiID() + " FROM " + odo.vratiNazivTabele() + "  ORDER BY " + odo.uzmiID() + " ASC";
        Statement sqlStatement = konekcija.createStatement();
        ResultSet rs = sqlStatement.executeQuery(sql);

        return odo.vratiSlobodanID(rs);
    }

    public List<OpstiDomenskiObjekat> vratiBezUslova(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaBrisanje();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaOperacijuUpdate()
                + " WHERE " + odo.vratiUslovZaOperacijuUpdate();
        System.out.println(sql);
        Statement stat = konekcija.createStatement();
        stat.executeUpdate(sql);
        stat.close();
    }

    public List<OpstiDomenskiObjekat> vratiDveTabeleSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public List<OpstiDomenskiObjekat> vratiTriTabeleSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " JOIN "
                + odo.vratiJoinTabelu2() + " ON " + odo.vratiUslovZaJoin2()
                + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public List<OpstiDomenskiObjekat> vratiCetiriTabeleSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " JOIN "
                + odo.vratiJoinTabelu2() + " ON " + odo.vratiUslovZaJoin2()
                + " JOIN "
                + odo.vratiJoinTabelu3() + " ON " + odo.vratiUslovZaJoin3() + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public List<OpstiDomenskiObjekat> vratiTriTabeleBezUslova(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " JOIN "
                + odo.vratiJoinTabelu2() + " ON " + odo.vratiUslovZaJoin2();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

    public void sacuvaj2(OpstiDomenskiObjekat odo) throws Exception {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        Statement stat = konekcija.createStatement();
        stat.executeUpdate(upit);
        stat.close();
    }

    public List<OpstiDomenskiObjekat> vratiPetTabelaSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " JOIN "
                + odo.vratiJoinTabelu() + " ON " + odo.vratiUslovZaJoin() + " JOIN "
                + odo.vratiJoinTabelu2() + " ON " + odo.vratiUslovZaJoin2()
                + " JOIN "
                + odo.vratiJoinTabelu3() + " ON " + odo.vratiUslovZaJoin3()
                + " JOIN "
                + odo.vratiJoinTabelu4() + " ON " + odo.vratiUslovZaJoin4()
                + " WHERE " + odo.vratiUslovZaPretragu();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.ucitajListu(rs);
    }

   

}
