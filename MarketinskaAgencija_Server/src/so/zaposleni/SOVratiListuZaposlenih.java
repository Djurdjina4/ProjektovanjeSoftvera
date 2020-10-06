/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zaposleni;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author djurd
 */
public class SOVratiListuZaposlenih extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        lista = db.DBBroker.getInstance().vratiBezUslova(odo);
    }

}
