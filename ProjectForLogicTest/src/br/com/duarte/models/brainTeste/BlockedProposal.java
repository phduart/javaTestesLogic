package br.com.duarte.models.brainTeste;

public class BlockedProposal {
    private Integer poliza;
    private Integer operacion;
    private String cpfCnpj;
    private Integer endosso;
    private Talhoes talhoes;

    public Integer getPoliza() {
        return poliza;
    }

    public void setPoliza(Integer poliza) {
        this.poliza = poliza;
    }

    public Integer getOperacion() {
        return operacion;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Integer getEndosso() {
        return endosso;
    }

    public void setEndosso(Integer endosso) {
        this.endosso = endosso;
    }

    public void setOperacion(Integer operacion) {
        this.operacion = operacion;
    }

    public Talhoes getTalhoes() {
        return talhoes;
    }

    public void setTalhoes(Talhoes talhoes) {
        this.talhoes = talhoes;
    }
}
