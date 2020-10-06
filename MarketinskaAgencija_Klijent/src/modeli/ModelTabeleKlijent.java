/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klijent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author djurd
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    ArrayList<Klijent> lista;
    String[] kolone = new String[]{"ID", "Kompanija", "Osoba", "Grad", "Email", "Broj telefona"};

    public ModelTabeleKlijent(ArrayList<Klijent> lista) {
        this.lista = lista;
    }

    public ArrayList<Klijent> getLista() {
        return lista;
    }
    

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent klijent = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return klijent.getKlijentID();
            case 1:
                return klijent.getKompanija();
            case 2:
                return klijent.getOsoba();
            case 3:
                return klijent.getGrad();
            case 4:
                return klijent.getEmail();
            case 5:
                return klijent.getBrojTelefona();
            default:
                return "";
        }
    }

}
