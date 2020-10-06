/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import com.sun.xml.internal.ws.wsdl.writer.document.OpenAtts;
import domen.Izvrsava;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.StavkaZahteva;
import domen.Usluga;
import domen.Zahtev;
import domen.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author djurd
 */
public class ObradaZahteva extends Thread {

    Socket s;
    List<ObradaZahteva> zaposleniLista;
    Zaposleni zaposleni;

    public ObradaZahteva(List<ObradaZahteva> zaposleniLista, Socket s) {
        this.zaposleniLista = zaposleniLista;
        this.s = s;
        zaposleni = new Zaposleni();
    }

    @Override
    public void run() {
        while (true) {

            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();

            switch (kz.getOperacija()) {
                case Operacije.LOG_IN:

                    try {
                        zaposleni = (Zaposleni) kz.getParametar();
                        List<Zaposleni> listaZaposlenih = (List<Zaposleni>) Kontroler.getInstanca().pronadjiZaposlenog(zaposleni);
                        if (listaZaposlenih.isEmpty()) {
                            so.setOdgovor(null);
                            so.setUspesnost(true);
                        } else {
                            zaposleni = listaZaposlenih.get(0);
                            so.setOdgovor(zaposleni);
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    break;
                case Operacije.ZAPAMTI_KLIJENTA:

                    try {
                        Klijent zaUnos = (Klijent) kz.getParametar();
                        int klijentID = Kontroler.getInstanca().zapamtiKlijenta(zaUnos);
                        so.setOdgovor(klijentID - 1);
                        so.setPoruka("Sistem je zapamtio klijenta.");

                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        JOptionPane.showMessageDialog(null, "Sistem ne može da kreira klijenta!");
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case Operacije.VRATI_USLUGE:

                    try {
                        List<OpstiDomenskiObjekat> usluge = Kontroler.getInstanca().vratiListuUsluga(new Usluga());
                        if (usluge.isEmpty()) {
                            so.setOdgovor(null);
                            so.setPoruka("Sistem ne moze da ucita listu usluga.");
                            so.setUspesnost(false);
                        } else {
                            so.setOdgovor(usluge);
                            so.setPoruka("Sistem je ucitao listu usluga.");
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case Operacije.VRATI_KLIJENTE:
                    try {
                        List<OpstiDomenskiObjekat> klijenti = Kontroler.getInstanca().vratiListuKlijenata(new Klijent());
                        if (klijenti.isEmpty()) {
                            so.setOdgovor(null);
                            so.setPoruka("Sistem ne moze da ucita listu klijenata.");
                            so.setUspesnost(false);
                        } else {
                            so.setOdgovor(klijenti);
                            so.setPoruka("Sistem je ucitao listu klijenata.");
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.ZAPAMTI_ZAHTEV:
                    Zahtev zahtev = (Zahtev) kz.getParametar();
                    try {
                        Kontroler.getInstanca().zapamtiZahtev(zahtev);
                        so.setPoruka("Sistem je zapamtio zahtev.");
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setPoruka("Sistem je ne može da zapamti zahtev.");
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case Operacije.PRETRAZI_KLIJENTE:
                    try {
                        List<OpstiDomenskiObjekat> pretragaKlijenata = Kontroler.getInstanca().pretraziKlijente((OpstiDomenskiObjekat) kz.getParametar());
                        so.setOdgovor(pretragaKlijenata);
                        if (((List<OpstiDomenskiObjekat>) so.getOdgovor()).isEmpty()) {
                            so.setPoruka("Sistem ne moze da pronadje klijente po zadatoj vrednosti.");
                            so.setUspesnost(false);
                        }
                        so.setPoruka("Sistem je našao klijente po zadatoj vrednosti.");
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.OBRISI_KLIJENTA:
                    try {
                        Klijent zaBrisanje = (Klijent) kz.getParametar();
                        Kontroler.getInstanca().obrisiKlijenta(zaBrisanje);
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.IZMENI_KLIJENTA:
                    try {
                        Klijent zaIzmenu = (Klijent) kz.getParametar();
                        Kontroler.getInstanca().izmeniKlijenta(zaIzmenu);
                        so.setPoruka("Sistem je izmenio klijenta.");
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.VRATI_ZAHTEVE_KLIJENTA:
                    try {
                        List<OpstiDomenskiObjekat> zahteviKlijenta = Kontroler.getInstanca().vratiZahteveKlijenta((OpstiDomenskiObjekat) kz.getParametar());
                        if (zahteviKlijenta.isEmpty()) {
                            so.setOdgovor(null);
                            so.setPoruka("Sistem ne moze da ucita listu zahteva klijenata.");
                            so.setUspesnost(false);
                        } else {
                            so.setOdgovor(zahteviKlijenta);
                            so.setPoruka("Sistem je ucitao listu zahteva klijenata.");
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.VRATI_STAVKE_ZAHTEVA:
                    try {
                        List<OpstiDomenskiObjekat> stavkeZahteva = Kontroler.getInstanca().vratiStavkeZahteva((OpstiDomenskiObjekat) kz.getParametar());
                        if (stavkeZahteva.isEmpty()) {
                            so.setOdgovor(null);
                            so.setPoruka("Sistem ne moze da ucita listu stavki zahteva .");
                            so.setUspesnost(false);
                        } else {
                            so.setOdgovor(stavkeZahteva);
                            so.setPoruka("Sistem je ucitao listu stavki zahteva .");
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.OBRISI_ZAHTEV:
                    try {
                        Zahtev zahtevBrisanje = (Zahtev) kz.getParametar();
                        Kontroler.getInstanca().obrisiZahtev(zahtevBrisanje);
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case Operacije.IZMENI_ZAHTEV:
                    Zahtev zahtevZaIzmenu = (Zahtev) kz.getParametar();
                    try {
                        Kontroler.getInstanca().izmeniZahtev(zahtevZaIzmenu);
                        so.setPoruka("Sistem je zapamtio zahtev.");
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setPoruka("Sistem je ne može da zapamti zahtev.");
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case Operacije.VRATI_ZAPOSLENE:

                    try {
                        List<OpstiDomenskiObjekat> listaZap = Kontroler.getInstanca().vratiListuZaposlenih(new Zaposleni());
                        if (listaZap.isEmpty()) {
                            so.setOdgovor(null);
                            so.setPoruka("Sistem ne moze da ucita listu zaposlenih.");
                            so.setUspesnost(false);
                        } else {
                            so.setOdgovor(listaZap);
                            so.setPoruka("Sistem je ucitao listu zaposlenih.");
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case Operacije.VRATI_IZVRSAVA:
                    try {
                        // List<OpstiDomenskiObjekat> lista = Kontroler.getInstanca().vratiIzvrsavaZaZahtev((OpstiDomenskiObjekat) kz.getParametar());
                        StavkaZahteva sz = new StavkaZahteva(-1, -1, null, (Zahtev) kz.getParametar(), "");
                        List<OpstiDomenskiObjekat> lista = Kontroler.getInstanca().vratiIzvrsavaZaZahtev(new Izvrsava(new Zaposleni(), sz));

                        if (lista.isEmpty()) {
                            so.setOdgovor(null);
                            so.setPoruka("Sistem ne moze da ucita listu.");
                            so.setUspesnost(false);
                        } else {
                            so.setOdgovor(lista);
                            so.setPoruka("Sistem je ucitao listu.");
                            so.setUspesnost(true);
                        }
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case Operacije.OBRISI_STAVKU:
                    try {
                        Izvrsava izvrsavaZaBrisanje = (Izvrsava) kz.getParametar();
                        Kontroler.getInstanca().obrisiStavku(izvrsavaZaBrisanje);
                        so.setUspesnost(true);
                    } catch (Exception ex) {
                        so.setOdgovor(null);
                        so.setUspesnost(true);
                        Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

            }

            posaljiOdgovor(so);

        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();

        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaZahteva.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return kz;

    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);

        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
