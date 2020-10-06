/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zahtev;

import domen.Izvrsava;
import domen.OpstiDomenskiObjekat;
import domen.Zahtev;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author djurd
 */
public class SOIzmeniZahtev extends OpstaSistemskaOperacija {

    /* int id;

    public int getId() {
        return id;
    }*/
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        db.DBBroker.getInstance().izmeni(odo);
        Zahtev z = (Zahtev) odo;

        for (Izvrsava iz : z.getIzvrsava()) {
            db.DBBroker.getInstance().izmeni(iz.getStavka());
            db.DBBroker.getInstance().izmeni(iz);

           
        }

    }

}
