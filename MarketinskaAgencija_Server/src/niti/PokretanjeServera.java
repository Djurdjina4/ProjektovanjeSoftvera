/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import db.DBProperties;
import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author djurd
 */
public class PokretanjeServera extends Thread {

    ServerSocket ss;

    @Override
    public void run() {
        List<ObradaZahteva> zaposleniLista = new ArrayList<>();

        try {
            DBProperties properties = new DBProperties();
            int port = Integer.parseInt(properties.vratiDBPort());

            ss = new ServerSocket(port);
            
            System.out.println("Server je pokrenut");
            while (!isInterrupted()) {
                Socket s = ss.accept();
                System.out.println("Klijent je povezan");
                Kontroler.getInstanca().dodajZaposlenog(s);
                ObradaZahteva oz = new ObradaZahteva(zaposleniLista, s);
                zaposleniLista.add(oz);
                oz.start();
            }

        } catch (IOException ex) {
            System.out.println("Server nije pokrenut");
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void stopServerThread() throws IOException {
        ss.close();
    }

    public ServerSocket getServerSocket() {
        return ss;
    }

}
