package com.example.felix.tp1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Felix on 2017-01-16.
 */

//BEN_REVIEW : Était-il nécessaire de séparer FindMeColor (d'ailleurs, drôle de nom, mais j'en tiendrais pas rigueur) et Chooser ? Overdesign. Pas de points
//             enlevés, mais je pose la question tout de même. Me voir.
//
//             EDIT : OH! Je viens de voir que FindMeColor était ton activité!!!! Nommage!!!!

//BEN_CORRECTION : Chooser de quoi ? Nommage.
//BEN_REVIEW :  Suggestion : FindColorGame
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
        // BEN_CORRECTION : Chiffre magique : 4. À recevoir à la construction ou à mettre en constante.
        for (int i = 0; i < 4; i++) {
            listToReturn.add(colorsInGame.get(i));
        }

        return listToReturn;
    }
}