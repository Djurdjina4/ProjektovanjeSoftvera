/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Izvrsava;
import domen.Klijent;
import domen.StavkaZahteva;
import domen.Zahtev;
import domen.Zaposleni;
import java.util.ArrayList;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author djurd
 */
public class Kontroler {

    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ServerskiOdgovor pronadjiZaposlenog(Zaposleni z) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(z);
        kz.setOperacija(Operacije.LOG_IN);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor unesiKlijenta(Klijent klijent) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_KLIJENTA);
        kz.setParametar(klijent);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor ucitajUsluge() throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_USLUGE);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor unesiZahtev(Zahtev zahtev) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_ZAHTEV);
        kz.setParametar(zahtev);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor ucitajKlijente() throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_KLIJENTE);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor pretraziKlijente(Klijent klijent) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_KLIJENTE);
        kz.setParametar(klijent);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiKlijenta(Klijent k) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_KLIJENTA);
        kz.setParametar(k);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniKlijenta(Klijent klijent) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(klijent);
        kz.setOperacija(Operacije.IZMENI_KLIJENTA);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor ucitajZahteve(Zahtev zahtev) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(zahtev);
        kz.setOperacija(Operacije.VRATI_ZAHTEVE_KLIJENTA);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor ucitajStavkeZahteva(StavkaZahteva stavkaZahteva) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setParametar(stavkaZahteva);
        kz.setOperacija(Operacije.VRATI_STAVKE_ZAHTEVA);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();

        return so;
    }

    public ServerskiOdgovor obrisiZahtev(Zahtev z) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_ZAHTEV);
        kz.setParametar(z);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniZahtev(Zahtev zahtev) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_ZAHTEV);
        kz.setParametar(zahtev);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();

        return so;
    }

    public ServerskiOdgovor ucitajZaposlene() throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_ZAPOSLENE);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor ucitajIzvrsavaZaZahtev(Zahtev z) throws InterruptedException {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_IZVRSAVA);
        kz.setParametar(z);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiStavku(Izvrsava izvrsava) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_STAVKU);
        kz.setParametar(izvrsava);
        Komunikacija.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiOdgovor();
        return so;
    }

   
}
