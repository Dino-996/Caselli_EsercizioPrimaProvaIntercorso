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
    // ---- INIZIO PUNTO 3 ----
    /**
     * Verifica se il casello selezionato è sulla stessa autostrada e se ci sono caselli 
     * successivi.
     * 
     * @param nomeAutostrada
     * @param posizioneKm
     * @return 
     */
    private Casello filtraCaselli(String nomeAutostrada, double posizioneKm) {
        Casello altroCasello = null;
        for (Casello caselloSuccessivo : listaCaselli) {
            if (altroCasello == null || caselloSuccessivo.getNomeAutostrada().equals(nomeAutostrada)) {
                if (caselloSuccessivo.getPosizioneKm() > posizioneKm) {
                    altroCasello = caselloSuccessivo;
                }
            }
        }
        return altroCasello;
    }
    
    /**
     * Verifica se il casello selezionato dall'utente ha almeno lo stesso numero
     * di accessi dei caselli successivi.
     * 
     * @param caselloSelezionato
     * @return 
     */
    public boolean verificaAccessi(Casello caselloSelezionato) {
        Casello caselloSuccessivo = filtraCaselli(caselloSelezionato.getNomeAutostrada(), caselloSelezionato.getPosizioneKm());
        if (caselloSuccessivo != null && caselloSuccessivo.contaAccessi() >= caselloSelezionato.contaAccessi()) {
            //logger.debug("Casello selezionato - Posizione: {} - Lista Accessi: {}", caselloSelezionato.getPosizioneKm(), caselloSelezionato.getListaAccessi().size());
            //logger.debug("Casello successivo - Posizione: {} - Lista Accessi: {}", caselloSuccessivo.getPosizioneKm(), caselloSuccessivo.getListaAccessi().size());
            return true;
        }

        return false;
    }
    // ---- FINE PUNTO 3 ----
    
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
