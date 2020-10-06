/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zahtev;

import domen.Izvrsava;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZahteva;
import domen.Zahtev;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author djurd
 */
public class SOZapamtiZahtev extends OpstaSistemskaOperacija {

    int id;

    public int getId() {
        return id;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
     
        id = db.DBBroker.getInstance().sacuvaj(odo);
        Zahtev z = (Zahtev) odo;
        z.setZahtevID(id - 1);

        for (Izvrsava iz : z.getIzvrsava()) {
            iz.getStavka().setZahtev(z);
            int rbs = db.DBBroker.getInstance().sacuvaj(iz.getStavka());
            iz.getStavka().setRbStavke(rbs - 1);
            db.DBBroker.getInstance().sacuvaj2(iz);

        }

    }

}
