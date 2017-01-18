package com.example.felix.tp1;

import android.media.MediaPlayer;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.felix.tp1.Comparator.checkIfListHaveOneInCommon;

public class FindMeColor extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ImageView circle;
    private ColorForGame currentColor;
    private Chooser chooser;
    private MediaPlayer mediaPlayerGood;
    private MediaPlayer mediaPlayerBad;
    private Boolean isResuming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_me_color);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        circle = (ImageView) findViewById(R.id.circle);

        currentColor = new ColorForGame();

        mediaPlayerBad = MediaPlayer.create(this, R.raw.wrong_ping);
        mediaPlayerGood = MediaPlayer.create(this, R.raw.good_ping);

        chooser = new Chooser(null);
        isResuming = false;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (chooser.getColorsInGame() == null) {
            chooser = createChooser();
        }

        if (isResuming == false) {
            startRound();
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("FristButtonText", (String) btn1.getText());
        outState.putString("SecondButtonText", (String) btn2.getText());
        outState.putString("ThirdButtonText", (String) btn3.getText());
        outState.putString("FourthButtonText", (String) btn4.getText());
        outState.putInt("CurrentColorColorName", currentColor.name);
        outState.putInt("FristButtonColor", btn1.getCurrentTextColor());
        outState.putInt("SecondButtonColor", btn2.getCurrentTextColor());
        outState.putInt("ThirdButtonColor", btn3.getCurrentTextColor());
        outState.putInt("FourthButtonColor", btn4.getCurrentTextColor());
        outState.putInt("CurrentColorColorCode", currentColor.colorCode);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        btn1.setText(savedInstanceState.getString("FristButtonText"));
        btn2.setText(savedInstanceState.getString("SecondButtonText"));
        btn3.setText(savedInstanceState.getString("ThirdButtonText"));
        btn4.setText(savedInstanceState.getString("FourthButtonText"));

        currentColor.colorCode = (savedInstanceState.getInt("CurrentColorColorCode"));
        currentColor.name = (savedInstanceState.getInt("CurrentColorColorName"));

        btn1.setTextColor(savedInstanceState.getInt("FristButtonColor"));
        btn2.setTextColor(savedInstanceState.getInt("SecondButtonColor"));
        btn3.setTextColor(savedInstanceState.getInt("ThirdButtonColor"));
        btn4.setTextColor(savedInstanceState.getInt("FourthButtonColor"));


       changeCircleColor(currentColor.colorCode);


        isResuming = true;
    }

    public void OnUserAnswer(View view) {
        playSound(verifyAnswer((String) ((Button) view).getText()));
    }

    private boolean verifyAnswer(String buttonText) {

        return buttonText.equals(getString(currentColor.name));
    }

    private void playSound(boolean isGoodAnswer) {

        if (isGoodAnswer) {

            mediaPlayerGood.start();

        } else {

            mediaPlayerBad.start();
        }
        startRound();
    }

    private void startRound() {

        ArrayList<ColorForGame> colorsPresentInThisRound = chooser.generateRound();

        currentColor = colorsPresentInThisRound.get(0);

        changeCircleColor(colorsPresentInThisRound.get(0).colorCode);


        ArrayList<ColorForGame> colorsPresentForText = new ArrayList<ColorForGame>(colorsPresentInThisRound);
        Collections.shuffle(colorsPresentForText);


        ArrayList<ColorForGame> colorsPresentForColor = new ArrayList<ColorForGame>(colorsPresentInThisRound);
        Collections.shuffle(colorsPresentForColor);
        Collections.copy(colorsPresentForColor, colorsPresentInThisRound);

        while (checkIfListHaveOneInCommon(colorsPresentForColor, colorsPresentForText)) {
            Collections.shuffle(colorsPresentForColor);
        }

        changeButtonsText(colorsPresentForText);
        changeButtonsColor(colorsPresentForColor);
    }

    private void changeCircleColor(@ColorRes int color) {
        circle.setBackgroundTintList(ContextCompat.getColorStateList(this, color));
    }

    private void changeButtonsText(ArrayList<ColorForGame> colors) {
        btn1.setText(colors.get(0).name);
        btn2.setText(colors.get(1).name);
        btn3.setText(colors.get(2).name);
        btn4.setText(colors.get(3).name);

    }

    private void changeButtonsColor(ArrayList<ColorForGame> colors) {
        btn1.setTextColor(ContextCompat.getColorStateList(this, colors.get(0).colorCode));
        btn2.setTextColor(ContextCompat.getColorStateList(this, colors.get(1).colorCode));
        btn3.setTextColor(ContextCompat.getColorStateList(this, colors.get(2).colorCode));
        btn4.setTextColor(ContextCompat.getColorStateList(this, colors.get(3).colorCode));
    }

    private Chooser createChooser() {

        ArrayList<ColorForGame> colorForGameArrayList = new ArrayList<>();
        ColorForGame colorRed = new ColorForGame(R.string.red, R.color.red);
        colorForGameArrayList.add(colorRed);
        ColorForGame colorPink = new ColorForGame(R.string.pink, R.color.pink);
        colorForGameArrayList.add(colorPink);
        ColorForGame colorBlue = new ColorForGame(R.string.blue, R.color.blue);
        colorForGameArrayList.add(colorBlue);
        ColorForGame colorViolet = new ColorForGame(R.string.violet, R.color.violet);
        colorForGameArrayList.add(colorViolet);
        ColorForGame colorGreen = new ColorForGame(R.string.green, R.color.green);
        colorForGameArrayList.add(colorGreen);
        ColorForGame colorBrown = new ColorForGame(R.string.brown, R.color.brown);
        colorForGameArrayList.add(colorBrown);
        ColorForGame colorOrange = new ColorForGame(R.string.orange, R.color.orange);
        colorForGameArrayList.add(colorOrange);

        Chooser chooserToCreat = new Chooser(colorForGameArrayList);

        return chooserToCreat;
    }
}