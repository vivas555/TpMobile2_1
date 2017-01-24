package com.example.felix.tp1;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

/**
 * Created by Felix on 2017-01-16.
 */
//BEN_REVIEW :  Suggestion : GameColor
public class ColorForGame {
    public int name;
    public int colorCode;

    public ColorForGame(int name, @ColorRes int colorCode) {
        this.name = name;
        this.colorCode = colorCode;
    }

    //BEN_REVIEW : À mettre avant l'autre constructeur.
    public ColorForGame() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorForGame that = (ColorForGame) o;

        if (colorCode != that.colorCode) return false;
        return name == that.name;

    }

}
