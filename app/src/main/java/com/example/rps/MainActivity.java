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

    TextView scoreTextView,
            wonLostTextView,
            userSelectionTextView,
            compSelectionTextView;

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

        wonLostTextView.setText("");
        compSelectionTextView.setText("");
        userSelectionTextView.setText("");
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

        /*
        The method call returns a random int value between 0 (inclusive) and high (exclusive).
        That's why we are adding low (to include the low value also).
         */

        int compSelection = random.nextInt(high) + low;

        /* Can find the attached logic sheet inside the drawable folder
        Name: Logic For Rock Paper Scissor.png */

        if (userSelection == compSelection) {
            wonLostTextView.setText("It's a Tie !");
        } else if ( (userSelection - compSelection) % 3 == 1 ) {
            wonLostTextView.setText("Yay, you Won !");
            userScore++;
        } else {
            wonLostTextView.setText("Oops, you Lost !");
            compScore++;
        }
        setScoreTextView(userScore, compScore);

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
            default:
                compSelectionTextView.setText("");
        }

        switch (userSelection) {
            case 1:
                userSelectionTextView.setText("Rock");
                break;
            case 2:
                userSelectionTextView.setText("Paper");
                break;
            case 3:
                userSelectionTextView.setText("Scissor");
                break;
            default:
                userSelectionTextView.setText("");
        }
        setScoreTextView(userScore, compScore);
    }

    public void resetGame(View view) {
        userScore = 0;
        compScore = 0;
        wonLostTextView.setText("");
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
