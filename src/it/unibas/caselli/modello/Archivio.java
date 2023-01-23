package it.unibas.caselli.modello;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Casello> listaCaselli = new ArrayList<>();

    public List<Casello> getListaCaselli() {
        return listaCaselli;
    }

    public void addCasello(Casello casello) {
        this.listaCaselli.add(casello);
    }

    //PUNTO2
    public List<Casello> getCasello(String nome) {
        List<Casello> listaFiltrata = new ArrayList<>();
        for (Casello casello : this.listaCaselli) {
            if (casello.getNomeAutostrada().trim().contains(nome)) {
                listaFiltrata.add(casello);
            }
        }
        return listaFiltrata;
    }

    public Casello verificaAccessi(Casello caselloSelezionato) {
        Casello altroCasello = null;
        for (Casello caselloSuccessivo : listaCaselli) {
            if (caselloSuccessivo.getNomeAutostrada().equals(caselloSelezionato.getNomeAutostrada())) {
                if (caselloSuccessivo.getPosizioneKm() > caselloSelezionato.getPosizioneKm()) {
                    if (caselloSuccessivo.getListaAccessi().size() >= caselloSelezionato.getListaAccessi().size()) {
                        altroCasello = caselloSuccessivo;
                        logger.debug("Casello selezionato - Posizione: {} - Lista Accessi: {}", caselloSelezionato.getPosizioneKm(), caselloSelezionato.getListaAccessi().size());
                        logger.debug("Casello successivo - Posizione: {} - Lista Accessi: {}", caselloSuccessivo.getPosizioneKm(), caselloSuccessivo.getListaAccessi().size());
                        logger.debug("Altro casello: {}", altroCasello);
                    }
                }
            }
        }
        logger.debug("Altro casello: {}", altroCasello);
        return altroCasello;
    }

    public boolean verificaAccessoCostoso(Casello caselloSelezionato) {
        for (Accesso accesso : caselloSelezionato.getListaAccessi()) {
            Accesso accessoPiuCostoso = caselloSelezionato.accessoCostoso(accesso);
            Accesso accessoMenoCostoso = caselloSelezionato.accessoMenoCostoso(accesso);
            if (accessoPiuCostoso.getTipoPagamento().equals(accessoMenoCostoso.getTipoPagamento())) {
                return true;
            }
        }
        return false;
    }
}
