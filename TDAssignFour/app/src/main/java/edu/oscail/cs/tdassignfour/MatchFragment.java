package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class provides a rugby match score counter tool
 *
 * <p>
 * User edits both team names and increments the starting zero default score by clicking one
 * of three buttons, ie +3penalty, +2conversion or +5try. User may display or email match stats
 * or reset the inputs to their default values to start again.</p>
 *
 * @author Tim Delaney
 * @version 2.0
 * @since 2016-01-20
 */
public class MatchFragment extends Fragment {

    //Debug Tag for use logging debug output to LogCat
    private final String TAG = "MatchFragment";

    // Team A memberVariables declared and some initiated
    Button m_PenBtnA, m_ConBtnA, m_TryBtnA;
    TextView m_ScoreTextA;
    EditText m_TeamNameTextA;
    int m_CounterA = 0, m_NoOfPenA = 0, m_NoOfConA = 0, m_NoOfTryA = 0;

    // Team B memberVariables declared and some initiated
    Button m_PenBtnB, m_ConBtnB, m_TryBtnB;
    TextView m_ScoreTextB;
    EditText m_TeamNameTextB;
    int m_CounterB = 0, m_NoOfPenB = 0, m_NoOfConB = 0, m_NoOfTryB = 0;

    /**
     * Returns global Match Stats variables which can be used within the entire App
     *
     * @return a string statement populated by multiple getMethods
     */
    public String getMatchStats() {

        //Tag marker for this activity
        Log.i(TAG, "matchStats called and about to be returned");
        return "SCORE:\n"
                // TeamNames are temporarily hardcoded until solution can be found
                + m_TeamNameTextA.getText() + ":" + m_CounterA + "\n"
                + m_TeamNameTextB.getText() + ":" + m_CounterB + "\n"
                + "\n"
                + "***MATCH STATISTICS***\n"
                + "\n"
                + getTeamAStats().toUpperCase() + "\n"
                + getTeamBStats().toUpperCase();
    }

    /**
     * Returns global Team A Stats variables which can be used within the entire App
     *
     * @return a string statement populated by multiple getMethods
     */
    protected String getTeamAStats() {

        //Tag marker for this activity
        Log.i(TAG, "TeamAStats called and about to be returned");
        return m_TeamNameTextA.getText() + ": PENALITIES- " + m_NoOfPenA + ", CONVERSION- " + m_NoOfConA + ", TRIES- " + m_NoOfTryA;
    }

    /**
     * Returns global Team B Stats variables which can be used within the entire App
     *
     * @return a string statement populated by multiple getMethods
     */
    protected String getTeamBStats() {

        //Tag marker for this activity
        Log.i(TAG, "TeamBStats called and about to be returned");
        return m_TeamNameTextB.getText() + ": PENALITIES- " + m_NoOfPenB + ", CONVERSION- " + m_NoOfConB + ", TRIES- " + m_NoOfTryB;
    }

    /**
     * Receives and adds the relevant points scored and updates Team A's score. No return.
     * Use the {@link public void onClick(View v)} method
     *
     * @param pointsScored related to the score increment
     */
    public void addPointsScoredA(int pointsScored) {
        m_CounterA = m_CounterA + pointsScored;
        m_ScoreTextA.setText(Integer.toString(m_CounterA));
    }

    /**
     * Receives and adds the relevant points scored and updates Team B's score. No return.
     * Use the {@link public void onClick(View v)} method
     *
     * @param pointsScored related to the score increment
     */
    public void addPointsScoredB(int pointsScored) {
        m_CounterB = m_CounterB + pointsScored;
        m_ScoreTextB.setText(Integer.toString(m_CounterB));
    }

    /**
     * Returns inflated view of match_fragment.xml layout and performs actions depending on button
     * selection such as score update, reset, summary, or specific email menu option
     *
     * @param inflater is a reference what to inflate on the screen
     * @param container is a reference to a special view that can contain other views (ie children)
     * @param savedInstanceState is a reference to a Bundle object
     * @return rootView depending on user selection
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //tells Android to explicitly call method to display additional menu item within this frags actionBar
        setHasOptionsMenu(true);

        //super.onCreateView(savedInstanceState);
        View rootView = inflater.inflate(R.layout.match_fragment, container, false);

        //Team A scores
        m_PenBtnA = (Button) rootView.findViewById(R.id.penaltyButtonA);
        m_ConBtnA = (Button) rootView.findViewById(R.id.conversionButtonA);
        m_TryBtnA = (Button) rootView.findViewById(R.id.tryButtonA);
        m_ScoreTextA = (TextView) rootView.findViewById(R.id.scoreTextViewA);
        m_TeamNameTextA = (EditText) rootView.findViewById(R.id.editTextA);

        // When +3 Penalty button is clicked, 3 points are added to current score
        m_PenBtnA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfPenA++;
                addPointsScoredA(3);
            }
        });

        //Tag marker for this activity
        Log.i(TAG, "The view has been inflated following +3Penalty Button clicked.");

        // When +2 Conversion button is clicked, 2 points are added to current score
        m_ConBtnA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfConA++;
                addPointsScoredA(2);
            }
        });

        // Tag marker for this activity
        Log.i(TAG, "The view has been inflated following +2Conversion Button clicked.");

        // When +5 Try button is clicked, 5 points are added to current score
        m_TryBtnA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfTryA++;
                addPointsScoredA(5);
            }
        });

        // Tag marker for this activity
        Log.i(TAG, "The view has been inflated following +5Try Button clicked.");

        // Team B scores (Team A comments apply here also. Debug Log TAGs removed)
        m_PenBtnB = (Button) rootView.findViewById(R.id.penaltyButtonB);
        m_ConBtnB = (Button) rootView.findViewById(R.id.conversionButtonB);
        m_TryBtnB = (Button) rootView.findViewById(R.id.tryButtonB);
        m_ScoreTextB = (TextView) rootView.findViewById(R.id.scoreTextViewB);
        m_TeamNameTextB = (EditText) rootView.findViewById(R.id.editTextB);
        m_PenBtnB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfPenB++;
                addPointsScoredB(3);
            }
        });
        m_ConBtnB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfConB++;
                addPointsScoredB(2);
            }
        });
        m_TryBtnB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_NoOfTryB++;
                addPointsScoredB(5);
            }
        });

        // buttonReset is defined in the layout file
        Button buttonReset = (Button) rootView.findViewById(R.id.resetButton);

        // sets the onClick listener for buttonReset to reset the m_ScoreTextA field
        buttonReset.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the resetText method
             * within a fragment upon a button click
             * @param view with a m_ScoreTextA value of null set by the resetText method
             */
            public void onClick(View view) {
                m_CounterA=m_CounterB=m_NoOfPenA=m_NoOfPenB=m_NoOfConA=m_NoOfConB=m_NoOfTryA=m_NoOfTryB=0;
                m_ScoreTextA.setText(Integer.toString(m_CounterA));
                m_ScoreTextB.setText(Integer.toString(m_CounterB));

                // m_TeamNameTextA set to null following a failed manual test, refer to Test Schedule
                m_TeamNameTextA.setText(null);
                m_TeamNameTextB.setText(null);
            }
        });

            // Tag marker for this activity
            Log.i(TAG, "The score has been reset following Reset Button clicked.");

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
            Log.i(TAG, "The toast message is visible following Summary Button clicked.");
        return rootView;
    }

    /**
     * Inflates the special menu tab view for the MatchFragment which include the unique share option.
     *
     * @param menu options are passed into the method
     * @param inflater is a reference what menu items to inflate on the screen
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.match, menu);
    }

    /**
     * Returns the devices calender app by intent complete with event details upon the share menu click
     *
     * @param item refers to email item clicked by user
     * @return boolean true if item clicked or false otherwise
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_share:

                // gets matchStats and uses its value to initiate summaryStats
                String summaryStats = getMatchStats();

                // Declares an implicit intent to create an email
                // it's not ACTION_SEND
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

                // Provides parameters for the email
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Match Results");
                emailIntent.putExtra(Intent.EXTRA_TEXT, summaryStats);

                // "mailto:" for blank or use "mailto:default@recipient.com"
                emailIntent.setData(Uri.parse("mailto:"));

                // this will make sure that when user returns to the app,
                // the app is displayed, instead of the email app.
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Start the ArtActivity
                startActivity(emailIntent);
                return true;
        }
        return false;
    }

    /**
     * Saves the value of member variables. No return.
     *
     * @param outState refers to the state of member variables
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {

        // Save the user's current game state
        outState.putInt("Team_A", m_CounterA);
        outState.putInt("Team_B", m_CounterB);
        outState.putInt("Pen_A", m_NoOfPenA);
        outState.putInt("Pen_B", m_NoOfPenB);
        outState.putInt("Con_A", m_NoOfConA);
        outState.putInt("Con_B", m_NoOfConB);
        outState.putInt("Try_A", m_NoOfTryA);
        outState.putInt("Try_B", m_NoOfTryB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }

    /**
     * gets the value of member variables when activity is created. No return.
     *
     * @param savedInstanceState is a reference to a Bundle object
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Restores last state for checked position.
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        if (savedInstanceState != null) {
            m_CounterA = savedInstanceState.getInt("Team_A");
            m_CounterB = savedInstanceState.getInt("Team_B");
            m_NoOfPenA = savedInstanceState.getInt("Pen_A");
            m_NoOfPenB = savedInstanceState.getInt("Pen_B");
            m_NoOfConA = savedInstanceState.getInt("Con_A");
            m_NoOfConB = savedInstanceState.getInt("Con_B");
            m_NoOfTryA = savedInstanceState.getInt("Try_A");
            m_NoOfTryB = savedInstanceState.getInt("Try_B");
        }
    }
}

