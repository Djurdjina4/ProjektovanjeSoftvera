/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author djurd
 */
public class Komunikacija {

    private boolean zauzetPrijem = false;
    private static Komunikacija instanca;
    Socket s;

    private Komunikacija() {
        try {
            s = new Socket("localhost", 9999);
        } catch (IOException ex) {
            System.out.println("Greška prilikom povezivanja sa serverom");
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    public ServerskiOdgovor primiOdgovor() {
        zauzetPrijem = true;
        ServerskiOdgovor so = new ServerskiOdgovor();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(s.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
            zauzetPrijem = false;
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;

    }

    public void posaljiZahtev(KlijentskiZahtev kz)throws InterruptedException {
        try {
            if (zauzetPrijem) {
                sleep(1000);
            }
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isZauzetPrijem() {
        return zauzetPrijem;
    }

    public void setZauzetPrijem(boolean zauzetPrijem) {
        this.zauzetPrijem = zauzetPrijem;
    }

}
