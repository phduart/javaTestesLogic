package br.com.duarte.models;

import java.util.List;

public class BlockedProposalBrain {
    int proposta;
    String cpfcnpj;
    int endosso;
    List<Talhao> talhoes;

    public int getProposta() {
        return proposta;
    }

    public void setProposta(int proposta) {
        this.proposta = proposta;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public int getEndosso() {
        return endosso;
    }

    public void setEndosso(int endosso) {
        this.endosso = endosso;
    }

    public List<Talhao> getTalhoes() {
        return talhoes;
    }

    public void setTalhoes(List<Talhao> talhoes) {
        this.talhoes = talhoes;
    }
}
