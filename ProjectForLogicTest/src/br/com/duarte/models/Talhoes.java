package br.com.duarte.models;

import java.util.HashMap;

public class Talhoes {
    private HashMap<Integer, PointCoordinates> talhoes;

    public HashMap<Integer, PointCoordinates> getTalhoes() {
        return talhoes;
    }

    public void setTalhoes(HashMap<Integer, PointCoordinates> talhoes) {
        this.talhoes = talhoes;
    }
}
