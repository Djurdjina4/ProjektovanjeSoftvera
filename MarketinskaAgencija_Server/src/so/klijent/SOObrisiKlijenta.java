/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author djurd
 */
public class SOObrisiKlijenta extends OpstaSistemskaOperacija{

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        db.DBBroker.getInstance().obrisi(odo);
    }
    
}
