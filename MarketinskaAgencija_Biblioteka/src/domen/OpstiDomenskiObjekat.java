/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author djurd
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;

    public String vratiUslovZaPretragu();

    public String vratiVrednostiZaInsert();

    public String uzmiID();

    public int vratiSlobodanID(ResultSet rs);

    public String vratiUslovZaBrisanje();

    public String vratiVrednostiZaOperacijuUpdate();

    public String vratiUslovZaOperacijuUpdate();

    public String vratiJoinTabelu();

    public String vratiUslovZaJoin();

    public String vratiJoinTabelu2();

    public String vratiUslovZaJoin2();

    public String vratiJoinTabelu3();

    public String vratiUslovZaJoin3();

    public String vratiJoinTabelu4();

    public String vratiUslovZaJoin4();

    public String vratiUslovZaPretraguDveTabele();

}
