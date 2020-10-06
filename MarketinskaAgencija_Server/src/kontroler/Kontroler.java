/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.Izvrsava;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZahteva;
import domen.Usluga;
import domen.Zahtev;
import domen.Zaposleni;
import forme.ServerskaForma;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;
import so.izvrsava.SOObrisiIzvrsava;
import so.izvrsava.SOVratiIzvrsavaZaZahtev;
import so.klijent.SOIzmeniKlijenta;
import so.klijent.SOObrisiKlijenta;
import so.klijent.SOPretragaKlijenata;
import so.klijent.SOVratiListuKlijenata;
import so.klijent.SOZapamtiKlijenta;
import so.stavkaZahteva.SOVratiListuStavkiZahteva;
import so.usluga.SOVratiListuUsluga;
import so.zahtev.SOObrisiZahtev;
import so.zahtev.SOIzmeniZahtev;
import so.zahtev.SOZapamtiZahtev;
import so.zahtev.SoVratiListuZahtevaKlijenta;
import so.zaposleni.SOPronadjiZaposlenog;
import so.zaposleni.SOVratiListuZaposlenih;

/**
 *
 * @author djurd
 */
public class Kontroler {

    private static Kontroler instanca;
    private ServerskaForma forma;
    ArrayList<Socket> listaZaposlenih = new ArrayList<>();

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ServerskaForma getForma() {
        return forma;
    }

    public void setForma(ServerskaForma forma) {
        this.forma = forma;
    }

    public ArrayList<Socket> getListaZaposlenih() {
        return listaZaposlenih;
    }

    public void setListaZaposlenih(ArrayList<Socket> listaZaposlenih) {
        this.listaZaposlenih = listaZaposlenih;
    }

    public void dodajZaposlenog(Socket s) {
        listaZaposlenih.add(s);
    }

    public Object pronadjiZaposlenog(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPronadjiZaposlenog();
        oso.izvrsi(odo);
        return ((SOPronadjiZaposlenog) oso).getLista();
    }

    public int zapamtiKlijenta(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOZapamtiKlijenta();
        oso.izvrsi(odo);
        return ((SOZapamtiKlijenta) oso).getId();

    }

    public List<OpstiDomenskiObjekat> vratiListuUsluga(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuUsluga();
        oso.izvrsi(odo);
        return ((SOVratiListuUsluga) oso).getLista();

    }

    public List<OpstiDomenskiObjekat> vratiListuKlijenata(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuKlijenata();
        oso.izvrsi(odo);
        return ((SOVratiListuKlijenata) oso).getLista();
    }

    public void zapamtiZahtev(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOZapamtiZahtev();
        oso.izvrsi(odo);
    }

    

    public List<OpstiDomenskiObjekat> pretraziKlijente(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOPretragaKlijenata();
        oso.izvrsi(odo);

        return ((SOPretragaKlijenata) oso).getLista();
    }

    public void obrisiKlijenta(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOObrisiKlijenta();
        oso.izvrsi(odo);
    }

    public void izmeniKlijenta(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniKlijenta();
        oso.izvrsi(odo);
    }

    public List<OpstiDomenskiObjekat> vratiZahteveKlijenta(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SoVratiListuZahtevaKlijenta();
        oso.izvrsi(odo);
        return ((SoVratiListuZahtevaKlijenta) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiStavkeZahteva(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuStavkiZahteva();
        oso.izvrsi(odo);
        return ((SOVratiListuStavkiZahteva) oso).getLista();
    }

    public void obrisiZahtev(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOObrisiZahtev();
        oso.izvrsi(odo);
    }

    public void izmeniZahtev(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOIzmeniZahtev();
        oso.izvrsi(odo);
    }

  
    public List<OpstiDomenskiObjekat> vratiListuZaposlenih(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuZaposlenih();
        oso.izvrsi(odo);
        return ((SOVratiListuZaposlenih) oso).getLista();
    }

    public List<OpstiDomenskiObjekat> vratiIzvrsavaZaZahtev(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiIzvrsavaZaZahtev();
        oso.izvrsi(odo);
        return ((SOVratiIzvrsavaZaZahtev) oso).getLista();
    }

    public void obrisiStavku(OpstiDomenskiObjekat odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOObrisiIzvrsava();
        oso.izvrsi(odo);
    }

}
