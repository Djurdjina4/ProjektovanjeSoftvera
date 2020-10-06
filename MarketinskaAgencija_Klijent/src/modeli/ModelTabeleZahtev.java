/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Zahtev;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author djurd
 */
public class ModelTabeleZahtev extends AbstractTableModel {
    
    ArrayList<Zahtev> lista;
    String[] kolone= new String[]{"Zahtev ID", "Datum od", "Datum do", "Ukupna cena"};

    public ModelTabeleZahtev(ArrayList<Zahtev> lista) {
        this.lista = lista;
    }

    public ArrayList<Zahtev> getLista() {
        return lista;
    }
    
    
    @Override
    public int getRowCount() {
        if(lista==null) return 0;
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zahtev z= lista.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getZahtevID();
            case 1: return z.getDatumOD();
            case 2: return z.getDatumDO();
            case 3: return z.getUkupnaCena();
            default:return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
}
