package it.unibas.caselli.controllo;

import it.unibas.caselli.main.Applicazione;
import it.unibas.caselli.modello.Archivio;
import it.unibas.caselli.modello.Casello;
import it.unibas.caselli.modello.Costanti;
import it.unibas.caselli.persistenza.DAOException;
import it.unibas.caselli.persistenza.IDAOArchivio;
import it.unibas.caselli.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();
    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica archivio");
            this.putValue(SHORT_DESCRIPTION, "Verifica se l'accesso piu costoso e il meno costoso hanno usato lo stesso metodo di pagamento");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
            int riga = vista.getRigaSelezionata();
            if (riga == -1) {
                Applicazione.getInstance().getFrame().getErrore("Selezionare prima un casello");
                return;
            }
            List<Casello> listaFiltrata = (List<Casello>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getInstance().getFrame().getMessaggio("Non esistono caselli successivi in quell'autostrada");
                return;
            }
            Casello caselloSelezionato = listaFiltrata.get(riga);
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            if (archivio.verificaAccessoCostoso(caselloSelezionato)) {
                Applicazione.getInstance().getFrame().getMessaggio("L'accesso piu costoso e quello meno costoso hanno usato lo stesso metodo di pagamento");
            } else {
                Applicazione.getInstance().getFrame().getErrore("L'accesso piu costoso e quello meno costoso NON hanno usato lo stesso metodo di pagamento");
            }
        }

    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaCaselli().size() + " caselli");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
                getAzioneVerifica().setEnabled(true);
            } catch (DAOException ex) {
                Logger.getLogger(ControlloMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}
