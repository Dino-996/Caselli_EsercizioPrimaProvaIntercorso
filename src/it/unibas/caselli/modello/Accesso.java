package it.unibas.caselli.modello;

public class Accesso {
    private final String targa;
    private final String marca;
    private final double costoPedaggio;
    private final String tipoPagamento;

    public Accesso(String targa, String marca, double costoPedaggio, String tipoPagamento) {
        this.targa = targa;
        this.marca = marca;
        this.costoPedaggio = costoPedaggio;
        this.tipoPagamento = tipoPagamento;
    }

    public String getTarga() {
        return targa;
    }

    public String getMarca() {
        return marca;
    }

    public double getCostoPedaggio() {
        return costoPedaggio;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Targa: ").append(targa).append("\n");
        sb.append("Marca: ").append(marca).append("\n");
        sb.append("Costo del pedaggio: ").append(costoPedaggio).append("\n");
        sb.append("Tipo di pagamento: ").append(tipoPagamento).append("\n");
        return sb.toString().trim();
    }
}
