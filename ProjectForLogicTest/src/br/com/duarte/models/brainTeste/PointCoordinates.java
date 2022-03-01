package br.com.duarte.models.brainTeste;

import java.util.HashMap;

public class PointCoordinates {

    private HashMap<Integer, Coordinates> pointCoordinates;

    public HashMap<Integer, Coordinates> getPointCoordinates() {
        return pointCoordinates;
    }

    public void setCoordinates(HashMap<Integer, Coordinates> pointCoordinates) {
        this.pointCoordinates = pointCoordinates;
    }
}
