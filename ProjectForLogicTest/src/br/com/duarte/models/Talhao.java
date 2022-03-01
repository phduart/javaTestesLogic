package br.com.duarte.models;

import java.util.List;

public class Talhao {
    int talhao;
    List<CoordenadasBrain> coordenadas;

    public int getTalhao() {
        return talhao;
    }

    public void setTalhao(int talhao) {
        this.talhao = talhao;
    }

    public List<CoordenadasBrain> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<CoordenadasBrain> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
