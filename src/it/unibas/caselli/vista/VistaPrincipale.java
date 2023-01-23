package it.unibas.caselli.vista;

import it.unibas.caselli.main.Applicazione;
import it.unibas.caselli.modello.Casello;
import it.unibas.caselli.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaAzioni();
        this.aggiornaComponenti();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.campoTesto.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneVerifica.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneVerifica());
    }

    private void aggiornaComponenti() {
        ModelloTabellaCaselli modello = new ModelloTabellaCaselli();
        this.tabellaCaselli.setModel(modello);
    }

    public void aggiornaTabella() {
        List<Casello> listaFiltrata = (List<Casello>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaCaselli modello = (ModelloTabellaCaselli) this.tabellaCaselli.getModel();
        modello.setListaCaselli(listaFiltrata);
        modello.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoTesto = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaCaselli = new javax.swing.JTable();
        bottoneVerifica = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca autostrada"));

        jLabel1.setText("Nome autostrada:");

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(campoTesto)
                .addGap(18, 18, 18)
                .addComponent(bottoneCerca)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaCaselli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabellaCaselli);

        bottoneVerifica.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottoneVerifica)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneVerifica)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getNomeAutostrada() {
        return this.campoTesto.getText();
    }

    public int getRigaSelezionata() {
        return this.tabellaCaselli.getSelectedRow();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneVerifica;
    private javax.swing.JTextField campoTesto;
    private javax.swing.JTable tabellaCaselli;
    // End of variables declaration//GEN-END:variables
}
