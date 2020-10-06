/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author djurd
 */
public class SOPronadjiZaposlenog extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> lista;

    public Object getLista() {
        return lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = DBBroker.getInstance().vratiSaUslovom(odo);
    }

}
