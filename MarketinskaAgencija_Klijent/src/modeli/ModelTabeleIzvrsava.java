/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Izvrsava;
import domen.StavkaZahteva;
import domen.Usluga;
import domen.Zaposleni;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author djurd
 */
public class ModelTabeleIzvrsava extends AbstractTableModel {
    
    ArrayList<Izvrsava> lista;
    String[] kolone = new String[]{"Redni broj", "Naziv", "Usluga", "Ucestalost", "Zaposleni"};
    
    public ModelTabeleIzvrsava() {
        lista = new ArrayList<>();
    }
    
    public ModelTabeleIzvrsava(ArrayList<Izvrsava> lista) {
        this.lista = lista;
    }
    
    public ArrayList<Izvrsava> getLista() {
        return lista;
    }
    
    public void setLista(ArrayList<Izvrsava> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }
    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Izvrsava i = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getStavka().getRbStavke();
            case 1:
                return i.getStavka().getNaziv();
            case 2:
                return i.getStavka().getUsluga();
            case 3:
                return (int) i.getStavka().getUcestalost();
            case 4:
                return i.getZaposleni();
            
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0) return false;
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Izvrsava i = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                i.getStavka().setRbStavke(Integer.parseInt((String) aValue));
                break;
            case 1:
                i.getStavka().setNaziv((String) aValue);
                break;
            case 2:
                i.getStavka().setUsluga((Usluga) aValue);
                break;
            case 3:
                i.getStavka().setUcestalost(Integer.parseInt((String) aValue));
                break;
            case 4:
                i.setZaposleni((Zaposleni) aValue);
                break;
        }
        fireTableDataChanged();
    }
    
    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }
    
    public void dodaj() {
        lista.add(new Izvrsava());
        fireTableDataChanged();
    }
    
    public void dodaj(int rb) {
       // lista.add(new StavkaZahteva(rb, 0, "", null, null));
        lista.add(new Izvrsava(null, new StavkaZahteva(rb, 0, null, null, "")));
        fireTableDataChanged();
    }
    
}
