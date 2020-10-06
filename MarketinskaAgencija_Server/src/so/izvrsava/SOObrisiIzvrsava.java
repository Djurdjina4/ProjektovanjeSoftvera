/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.izvrsava;

import domen.Izvrsava;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZahteva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author djurd
 */
public class SOObrisiIzvrsava extends OpstaSistemskaOperacija {

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Izvrsava i=(Izvrsava)odo;
        StavkaZahteva s=i.getStavka();
        db.DBBroker.getInstance().obrisi((OpstiDomenskiObjekat)s);

    }

}
