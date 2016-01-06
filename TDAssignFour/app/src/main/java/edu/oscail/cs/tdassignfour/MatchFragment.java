package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MatchFragment extends Fragment {
    // Variables declared and some set
    Button penBtnA, conBtnA, tryBtnA;
    TextView scoreTextA;
    EditText teamNameTextA;
    int counterA = 0, noOfPenA = 0, noOfConA = 0, noOfTryA = 0;

    Button penBtnB, conBtnB, tryBtnB;
    TextView scoreTextB;
    EditText teamNameTextB;
    int counterB = 0, noOfPenB = 0, noOfConB = 0, noOfTryB = 0;

    /**
     * Public method which take no parameters but returns a global variable which can be used
     * within the entire RugbyMatchActivity class
     * @return a string statement populated by multiple getMethods
     */
    public String getMatchStats() {
        return "SCORE:\n"
                // TeamNames are temporarily hardcoded until solution can be found
                + teamNameTextA.getText() + ":" + counterA + "\n"
                + teamNameTextB.getText() + ":" + counterB + "\n"
                + "\n"
                + "***MATCH STATISTICS***\n"
                + "\n"
                + getTeamAStats().toUpperCase() + "\n"
                + getTeamBStats().toUpperCase();
    }

    protected String getTeamAStats() {
        return teamNameTextA.getText() + ": PENALITIES- " + noOfPenA + ", CONVERSION- " + noOfConA + ", TRIES- " + noOfTryA;
    }
    protected String getTeamBStats() {
        return teamNameTextB.getText() + ": PENALITIES- " + noOfPenB + ", CONVERSION- " + noOfConB + ", TRIES- " + noOfTryB;
    }




    // To prevent NullPointerException error
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saedInstanceState) {

        //super.onCreateView(savedInstanceState);
        View rootView = inflater.inflate(R.layout.match_fragment, container, false);
        //Team A first
        penBtnA = (Button) rootView.findViewById(R.id.penaltyButtonA);
        conBtnA = (Button) rootView.findViewById(R.id.conversionButtonA);
        tryBtnA = (Button) rootView.findViewById(R.id.tryButtonA);
        scoreTextA = (TextView) rootView.findViewById(R.id.scoreTextViewA);
        teamNameTextA = (EditText) rootView.findViewById(R.id.editTextA);

        // Consider using the alternative switch/case to check which button is clicked
        // When +3 Penalty button is clicked, 3 points are added to current score
        penBtnA.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           noOfPenA++;
                                           counterA = counterA + 3;
                                           scoreTextA.setText(Integer.toString(counterA));
                                       }
                                   }
        );

        // Tag marker for this activity
        //Log.i(TAG, "The view has been inflated following +3Penalty Button clicked.");

        // When +2 Conversion button is clicked, 2 points are added to current score
        conBtnA.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           noOfConA++;
                                           counterA = counterA + 2;
                                           scoreTextA.setText(Integer.toString(counterA));
                                       }
                                   }
        );

        // Tag marker for this activity
        //Log.i(TAG, "The view has been inflated following +2Conversion Button clicked.");

        // When +5 Try button is clicked, 5 points are added to current score
        tryBtnA.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           noOfTryA++;
                                           counterA = counterA + 5;
                                           scoreTextA.setText(Integer.toString(counterA));
                                       }
                                   }
        );

        // Team B second
        penBtnB = (Button) rootView.findViewById(R.id.penaltyButtonB);
        conBtnB = (Button) rootView.findViewById(R.id.conversionButtonB);
        tryBtnB = (Button) rootView.findViewById(R.id.tryButtonB);
        scoreTextB = (TextView) rootView.findViewById(R.id.scoreTextViewB);
        teamNameTextB = (EditText) rootView.findViewById(R.id.editTextB);

        // Consider using the alternative switch/case to check which button is clicked
        // When +3 Penalty button is clicked, 3 points are added to current score
        penBtnB.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           noOfPenB++;
                                           counterB = counterB + 3;
                                           scoreTextB.setText(Integer.toString(counterB));
                                       }
                                   }
        );

        // Tag marker for this activity
        //Log.i(TAG, "The view has been inflated following +3Penalty Button clicked.");

        // When +2 Conversion button is clicked, 2 points are added to current score
        conBtnB.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           noOfConB++;
                                           counterB = counterB + 2;
                                           scoreTextB.setText(Integer.toString(counterB));
                                       }
                                   }
        );

        // Tag marker for this activity
       // Log.i(TAG, "The view has been inflated following +2Conversion Button clicked.");

        // When +5 Try button is clicked, 5 points are added to current score
        tryBtnB.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           noOfTryB++;
                                           counterB = counterB + 5;
                                           scoreTextB.setText(Integer.toString(counterB));
                                       }
                                   }
        );


        // buttonReset is defined in the layout file
        Button buttonReset = (Button) rootView.findViewById(R.id.resetButton);

        // sets the onClick listener for buttonReset to reset the scoreTextA field
        buttonReset.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the resetText method within a fragment upon a button click
             * @param view with a scoreTextA value of null set by the resetText method
             */
            public void onClick(View view) {
                counterA = 0; counterB = 0;
                noOfPenA = 0; noOfPenB = 0;
                noOfConA = 0; noOfConB = 0;
                noOfTryA = 0; noOfTryB = 0;
                scoreTextA.setText(Integer.toString(counterA));
                scoreTextB.setText(Integer.toString(counterB));

                // teamNameTextA set to null following a failed manual test, refer to Test Schedule
                teamNameTextA.setText(null);
                teamNameTextB.setText(null);


            }
        });

        // Tag marker for this activity
        //Log.i(TAG, "The score has been reset following Reset Button clicked.");

        // buttonSummary is defined in the layout file
        Button buttonSummary = (Button) rootView.findViewById(R.id.summaryButton);

        // sets the onClick listener for buttonSummary to produce matchStats
        buttonSummary.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the getMatchStats method to initiate the summaryStats
             * variable and passes its value into a toast message upon a button click
             * @param view of a toast message with summaryStats as its text
             */
            public void onClick(View view) {
                String summaryStats = getMatchStats();
                Toast.makeText(getActivity(), summaryStats, Toast.LENGTH_LONG).show();
                //getApplicationContext
            }
        });

        // Tag marker for this activity
        // Log.i(TAG, "The toast message is visible following Summary Button clicked.");

        // buttonEmail is defined in the layout file
        Button buttonEmail = (Button) rootView.findViewById(R.id.emailButton);

        // sets the onClick listener for buttonEmail to produce a email message
        buttonEmail.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the getMatchStats method to initiate the summaryStats
             * variable and passes its value into a toast message upon a button click
             * @param view if email message from users account with Match Results as subject and
             *             summaryStats as message text
             */
            public void onClick(View view) {

                // gets matchStats and uses its value to initiate summaryStats
                String summaryStats = getMatchStats();

                // Declares an implicit intent to create an email
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                // Provides parameters for the email
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Match Results");
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, summaryStats);

                // Start the ArtActivity
                startActivity(emailIntent);
            }
        });

        // Tag marker for this activity
        //Log.i(TAG, "The email has been created following Email Button clicked.");
        return rootView;
    }
}

