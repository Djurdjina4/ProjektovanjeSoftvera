/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author djurd
 */
public class DBProperties {

    Properties properties;

    public DBProperties() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("db.config.properties"));

    }

    public String vratiDBURL() {
        return properties.getProperty(DBKonstante.URL);
    }

    public String vratiDBKorisnik() {
        return properties.getProperty(DBKonstante.USERNAME);
    }

    public String vratiDBSifra() {
        return properties.getProperty(DBKonstante.PASSWORD);
    }

    public String vratiDBPort() {
        return properties.getProperty(DBKonstante.PORT);
    }
}
