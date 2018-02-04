package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declare key values for saving state Bundle

    public static final String GOALS_A = "goalsA";
    public static final String GOALS_B = "goalsB";
    public static final String OFFSIDES_A = "offsidesA";
    public static final String OFFSIDES_B = "offsidesB";
    public static final String FOULS_A = "foulsA";
    public static final String FOULS_B = "foulsB";

    //declare and initialize values for score and statistics integers
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulTeamA = 0;
    int foulTeamB = 0;
    int offsideTeamA = 0;
    int offsideTeamB = 0;

    //
    @Override
    public void onSaveInstanceState(Bundle savedData) {
        super.onSaveInstanceState(savedData);
        // Save the user's current game state...
        // Without this, the score and other values are lost when we rotate screen or other configuration change event.
        //A Bundle object saves the values and pass them to the new activity when requested.

        savedData.putInt(GOALS_A, scoreTeamA);
        savedData.putInt(GOALS_B, scoreTeamB);
        savedData.putInt(FOULS_A, foulTeamA);
        savedData.putInt(FOULS_B, foulTeamB);
        savedData.putInt(OFFSIDES_A, offsideTeamA);
        savedData.putInt(OFFSIDES_B, offsideTeamB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checking for previous saved data and if there are, restore them

        if (savedInstanceState != null) {
            // Restore value of members from saved state

            scoreTeamA = savedInstanceState.getInt(GOALS_A);
            scoreTeamB = savedInstanceState.getInt(GOALS_B);
            foulTeamA = savedInstanceState.getInt(FOULS_A);
            foulTeamB = savedInstanceState.getInt(FOULS_B);
            offsideTeamA = savedInstanceState.getInt(OFFSIDES_A);
            offsideTeamB = savedInstanceState.getInt(OFFSIDES_B);
        }

        //displaying the saved data

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsForTeamA(foulTeamA);
        displayFoulsForTeamB(foulTeamB);
        displayOffsidesForTeamA(offsideTeamA);
        displayOffsidesForTeamB(offsideTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the number of fouls for Team A by 1.
     */
    public void addFoulTeamA(View v) {
        foulTeamA = foulTeamA + 1;
        displayFoulsForTeamA(foulTeamA);
    }

    /**
     * Increase the number of offsides for Team A by 1.
     */
    public void addOffsideForTeamA(View v) {
        offsideTeamA = offsideTeamA + 1;
        displayOffsidesForTeamA(offsideTeamA);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulsForTeamA(int fouls) {
        TextView foulsView = (TextView) findViewById(R.id.foul_A);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Displays the given offsides for Team A.
     */
    public void displayOffsidesForTeamA(int offsides) {
        TextView offsidesView = (TextView) findViewById(R.id.offside_A);
        offsidesView.setText(String.valueOf(offsides));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the number of fouls for Team B by 1.
     */
    public void addFoulTeamB(View v) {
        foulTeamB = foulTeamB + 1;
        displayFoulsForTeamB(foulTeamB);
    }

    /**
     * Increase the number of offsides for Team B by 1.
     */
    public void addOffsideForTeamB(View v) {
        offsideTeamB = offsideTeamB + 1;
        displayOffsidesForTeamB(offsideTeamB);

    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulsForTeamB(int fouls) {
        TextView foulsView = (TextView) findViewById(R.id.foul_B);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Displays the given offsides for Team B.
     */
    public void displayOffsidesForTeamB(int offsides) {
        TextView offsidesView = (TextView) findViewById(R.id.offside_B);
        offsidesView.setText(String.valueOf(offsides));
    }

    public void Reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        offsideTeamA = 0;
        offsideTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsForTeamA(foulTeamA);
        displayFoulsForTeamB(foulTeamB);
        displayOffsidesForTeamA(offsideTeamA);
        displayOffsidesForTeamB(offsideTeamB);
    }
}