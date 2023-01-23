package it.unibas.caselli.controllo;

import it.unibas.caselli.main.Applicazione;
import it.unibas.caselli.modello.Archivio;
import it.unibas.caselli.modello.Casello;
import it.unibas.caselli.modello.Costanti;
import it.unibas.caselli.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica casello");
            this.putValue(SHORT_DESCRIPTION, "Verifica se tutti i caselli successivi a quello selezionato hanno almeno lo stesso numero di accessi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
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
            if (archivio.verificaAccessi(caselloSelezionato) != null) {
                Applicazione.getInstance().getFrame().getMessaggio("Tutti i caselli successivi in quell'autostrada hanno almeno lo stesso numero di accessi");
            } else {
                Applicazione.getInstance().getFrame().getErrore("NON tutti i caselli successivi in quell'autostrada hanno almeno lo stesso numero di accessi");
            }
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca caselli in archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
            String autostrada = vista.getNomeAutostrada();
            if (autostrada.isEmpty()) {
                Applicazione.getInstance().getFrame().getErrore("Inserire un autostrada prima di continuare");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Casello> listaFiltrata = archivio.getCasello(autostrada);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getInstance().getFrame().getMessaggio("Nessun accesso per il casello selezionato");
                return;
            }
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

    }
}
