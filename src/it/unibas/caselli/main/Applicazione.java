package it.unibas.caselli.main;

import it.unibas.caselli.controllo.ControlloMenu;
import it.unibas.caselli.controllo.ControlloPrincipale;
import it.unibas.caselli.modello.Modello;
import it.unibas.caselli.persistenza.DAOArchivio;
import it.unibas.caselli.persistenza.IDAOArchivio;
import it.unibas.caselli.vista.Frame;
import it.unibas.caselli.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private IDAOArchivio daoArchivio;
    private Modello modello;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;

    public void inizializza() {
        this.daoArchivio = new DAOArchivio();
        this.modello = new Modello();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();

        this.vistaPrincipale.inizializza();
        this.frame.inizializza();

    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public Modello getModello() {
        return modello;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getInstance().inizializza();
        });
    }
}
