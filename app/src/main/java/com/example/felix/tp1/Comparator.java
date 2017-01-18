package com.example.felix.tp1;


import java.util.ArrayList;

public  class Comparator {

    static public boolean checkIfListHaveOneInCommon(ArrayList<ColorForGame> colors, ArrayList<ColorForGame> texts) {

        for (int i = 0; i < 4; i++) {
            if (colors.get(0).equals(texts.get(0))) {
                return true;
            }
        }
        return false;
    }
}
