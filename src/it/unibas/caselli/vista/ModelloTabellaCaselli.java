package it.unibas.caselli.vista;

import it.unibas.caselli.modello.Casello;
import java.util.ArrayList;
import java.util.List;

public class ModelloTabellaCaselli extends AbstractTableModel {

    private List<Casello> listaCaselli = new ArrayList<>();

    public List<Casello> getListaCaselli() {
        return listaCaselli;
    }

    public void setListaCaselli(List<Casello> listaCaselli) {
        this.listaCaselli = listaCaselli;
    }

    @Override
    public int getRowCount() {
        return this.listaCaselli.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Casello casello = this.listaCaselli.get(rowIndex);
        if (columnIndex == 0) {
            return casello.getCodiceUnivoco();
        }
        if (columnIndex == 1) {
            return casello.getNomeAutostrada();
        }
        if (columnIndex == 2) {
            return casello.getPosizioneKm();
        }
        if (columnIndex == 3) {
            return casello.contaAccessi();
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2 || columnIndex == 3) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice univoco";
        }
        if (column == 1) {
            return "Autostrada";
        }
        if (column == 2) {
            return "Posizione in Km";
        }
        if (column == 3) {
            return "Numero accessi";
        }
        return "";
    }
}
