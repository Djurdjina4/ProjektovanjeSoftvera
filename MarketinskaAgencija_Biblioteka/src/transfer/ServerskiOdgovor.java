/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author djurd
 */
public class ServerskiOdgovor implements Serializable{
    private int operacija;
    private Object odgovor;
    private String poruka;
    private boolean uspesnost;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(int operacija, Object odgovor, String poruka, boolean uspesnost) {
        this.operacija = operacija;
        this.odgovor = odgovor;
        this.poruka = poruka;
        this.uspesnost = uspesnost;
    }


    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }


    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(boolean uspesnost) {
        this.uspesnost = uspesnost;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }


}
