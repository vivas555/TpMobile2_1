package com.example.felix.tp1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Felix on 2017-01-16.
 */

public class Chooser {
    private ArrayList<ColorForGame> colorsInGame;

    public Chooser(ArrayList<ColorForGame> colorsInGame) {
        this.colorsInGame = colorsInGame;
    }


    //region Getter/Setter

    public ArrayList<ColorForGame> getColorsInGame() {
        return colorsInGame;
    }

    public void setColorsInGame(ArrayList<ColorForGame> colorsInGame) {
        this.colorsInGame = colorsInGame;
    }
    //endregion


    public ArrayList<ColorForGame> generateRound(){

        ArrayList<ColorForGame> listToReturn = new ArrayList<>();
        Collections.shuffle(colorsInGame);
        for (int i = 0; i < 4; i++) {
            listToReturn.add(colorsInGame.get(i));
        }

        return listToReturn;
    }
}