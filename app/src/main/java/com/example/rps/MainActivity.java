package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView scoreTextView, wonLostTextView, userSelectionTextView, compSelectionTextView;

    int userScore = 0;
    int compScore = 0;

    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        wonLostTextView = findViewById(R.id.wonLostTextView);
        compSelectionTextView = findViewById(R.id.compSelectionTextView);
        userSelectionTextView = findViewById(R.id.userSelectionTextView);
    }

    public void rpsButtonSelected(View view) {
        Log.i(TAG, "rpsButtonSelected: " + view.getTag());

        int userSelection = Integer.parseInt(view.getTag().toString());
        match(userSelection);
    }

    /*
    1 is Rock
    2 is Paper
    3 is Scissor
    */

    private void match(int userSelection) {

        int low = 1;
        int high = 3;
        int compSelection = random.nextInt(high) + low;

        switch (compSelection) {
            case 1:
                compSelectionTextView.setText("Rock");
                break;
            case 2:
                compSelectionTextView.setText("Paper");
                break;
            case 3:
                compSelectionTextView.setText("Scissor");
                break;
        }

        /*The method call returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and n (exclusive).*/

        Log.i(TAG, "matchWithComp: userSelection: " + String.valueOf(userSelection));
        Log.e(TAG, "matchWithComp: compSelection: " + String.valueOf(compSelection));

        switch (userSelection) {
            case 1:
                userSelectionTextView.setText("Rock");
                switch (compSelection) {
                    case 1:
                        wonLostTextView.setText("It's a Tie !");
                        break;
                    case 2:
                        wonLostTextView.setText("Oops, you Lost !");
                        compScore++;
                        break;
                    case 3:
                        wonLostTextView.setText("Yay, you Won !");
                        userScore++;
                        break;
                }
                break;

            case 2:
                userSelectionTextView.setText("Paper");
                switch (compSelection) {
                    case 1:
                        wonLostTextView.setText("Yay, you Won !");
                        userScore++;
                        break;
                    case 2:
                        wonLostTextView.setText("It's a Tie!");
                        break;
                    case 3:
                        wonLostTextView.setText("Oops, you Lost !");
                        compScore++;
                        break;
                }
                break;

            case 3:
                userSelectionTextView.setText("Scissor");
                switch (compSelection) {
                    case 1:
                        wonLostTextView.setText("Oops, you Lost !");
                        compScore++;
                        break;
                    case 2:
                        wonLostTextView.setText("Yay, you Won !");
                        userScore++;
                        break;
                    case 3:
                        wonLostTextView.setText("It's a Tie!");
                        break;
                }
                break;
        }

        setScoreTextView(userScore, compScore);

    }



    public void resetGame(View view) {
        userScore = 0;
        compScore = 0;
        wonLostTextView.setText("Play...");
        compSelectionTextView.setText("");
        setScoreTextView(userScore, compScore);
        userSelectionTextView.setText("");
        compSelectionTextView.setText("");

    }

    private void setScoreTextView(int userScore, int compScore) {
        String scoreString = String.valueOf(userScore) + " : " + String.valueOf(compScore);
        scoreTextView.setText(scoreString);
    }


}
