package it.unibas.caselli.modello;

import java.util.ArrayList;
import java.util.List;

public class Casello {
    
    private final String codiceUnivoco;
    private final String nomeAutostrada;
    private final double posizioneKm;
    
    private final List<Accesso> listaAccessi = new ArrayList<>();

    public Casello(String codiceUnivoco, String nomeAutostrada, double posizioneKm) {
        this.codiceUnivoco = codiceUnivoco;
        this.nomeAutostrada = nomeAutostrada;
        this.posizioneKm = posizioneKm;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public String getNomeAutostrada() {
        return nomeAutostrada;
    }

    public double getPosizioneKm() {
        return posizioneKm;
    }

    public List<Accesso> getListaAccessi() {
        return listaAccessi;
    }
    
    public void addAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }
    
    public Accesso accessoCostoso (Accesso altroAccesso) {
        for (Accesso accesso : listaAccessi) {
            if (accesso.getCostoPedaggio() > altroAccesso.getCostoPedaggio()) {
                altroAccesso = accesso;
            }
        }
        return altroAccesso;
    }
    
    public Accesso accessoMenoCostoso(Accesso altroAccesso) {
        for (Accesso accesso : listaAccessi) {
            if (accesso.getCostoPedaggio() < altroAccesso.getCostoPedaggio()) {
                altroAccesso = accesso;
            }
        }
        return altroAccesso;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice univoco: ").append(codiceUnivoco).append("\n");
        sb.append("Autostrada: ").append(nomeAutostrada).append("\n");
        sb.append("Posizione in Km:").append(posizioneKm).append("\n");
        return sb.toString().trim();
    }
}
