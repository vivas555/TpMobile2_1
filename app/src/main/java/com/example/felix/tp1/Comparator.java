package com.example.felix.tp1;


import java.util.ArrayList;

//BEN_CORRECTION : Cette classe ne devrait même pas exister...
public  class Comparator {

    //BEN_CORRECTION : Inversion d'un attribut de visibilité, ici "public", avec "static".
    static public boolean checkIfListHaveOneInCommon(ArrayList<ColorForGame> colors, ArrayList<ColorForGame> texts) {

        for (int i = 0; i < 4; i++) {
            if (colors.get(0).equals(texts.get(0))) {
                return true;
            }
        }
        return false;
    }
}
