package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class MatchFragment extends Fragment {

    // memberVariables declared and some set
    Button m_PenBtnA, m_ConBtnA, m_TryBtnA;
    TextView m_ScoreTextA;
    EditText m_TeamNameTextA;
    int m_CounterA = 0, m_NoOfPenA = 0, m_NoOfConA = 0, m_NoOfTryA = 0;

    Button m_PenBtnB, m_ConBtnB, m_TryBtnB;
    TextView m_ScoreTextB;
    EditText m_TeamNameTextB;
    int m_CounterB = 0, m_NoOfPenB = 0, m_NoOfConB = 0, m_NoOfTryB = 0;

    /**
     * Public method which take no parameters but returns a global variable which can be used
     * within the entire RugbyMatchActivity class
     * @return a string statement populated by multiple getMethods
     */
    public String getMatchStats() {
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

    protected String getTeamAStats() {
        return m_TeamNameTextA.getText() + ": PENALITIES- " + m_NoOfPenA + ", CONVERSION- " + m_NoOfConA + ", TRIES- " + m_NoOfTryA;
    }
    protected String getTeamBStats() {
        return m_TeamNameTextB.getText() + ": PENALITIES- " + m_NoOfPenB + ", CONVERSION- " + m_NoOfConB + ", TRIES- " + m_NoOfTryB;
    }

    // To prevent NullPointerException error
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //tells Android to explicitly call method to display additional menu item within this frags actionBar
        setHasOptionsMenu(true);

        //super.onCreateView(savedInstanceState);
        View rootView = inflater.inflate(R.layout.match_fragment, container, false);
        //Team A first
        m_PenBtnA = (Button) rootView.findViewById(R.id.penaltyButtonA);
        m_ConBtnA = (Button) rootView.findViewById(R.id.conversionButtonA);
        m_TryBtnA = (Button) rootView.findViewById(R.id.tryButtonA);
        m_ScoreTextA = (TextView) rootView.findViewById(R.id.scoreTextViewA);
        m_TeamNameTextA = (EditText) rootView.findViewById(R.id.editTextA);

            // Consider using the alternative switch/case to check which button is clicked
            // When +3 Penalty button is clicked, 3 points are added to current score
            m_PenBtnA.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               m_NoOfPenA++;
                                               m_CounterA = m_CounterA + 3;
                                               m_ScoreTextA.setText(Integer.toString(m_CounterA));
                                           }
                                       });

            // Tag marker for this activity
            //Log.i(TAG, "The view has been inflated following +3Penalty Button clicked.");

            // When +2 Conversion button is clicked, 2 points are added to current score
            m_ConBtnA.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               m_NoOfConA++;
                                               m_CounterA = m_CounterA + 2;
                                               m_ScoreTextA.setText(Integer.toString(m_CounterA));
                                           }
                                       });

            // Tag marker for this activity
            //Log.i(TAG, "The view has been inflated following +2Conversion Button clicked.");

            // When +5 Try button is clicked, 5 points are added to current score
            m_TryBtnA.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               m_NoOfTryA++;
                                               m_CounterA = m_CounterA + 5;
                                               m_ScoreTextA.setText(Integer.toString(m_CounterA));
                                           }
                                       });

            // Team B second
            m_PenBtnB = (Button) rootView.findViewById(R.id.penaltyButtonB);
            m_ConBtnB = (Button) rootView.findViewById(R.id.conversionButtonB);
            m_TryBtnB = (Button) rootView.findViewById(R.id.tryButtonB);
            m_ScoreTextB = (TextView) rootView.findViewById(R.id.scoreTextViewB);
            m_TeamNameTextB = (EditText) rootView.findViewById(R.id.editTextB);

            // Consider using the alternative switch/case to check which button is clicked
            // When +3 Penalty button is clicked, 3 points are added to current score
            m_PenBtnB.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               m_NoOfPenB++;
                                               m_CounterB = m_CounterB + 3;
                                               m_ScoreTextB.setText(Integer.toString(m_CounterB));
                                           }
                                       });

            // Tag marker for this activity
            //Log.i(TAG, "The view has been inflated following +3Penalty Button clicked.");

            // When +2 Conversion button is clicked, 2 points are added to current score
            m_ConBtnB.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               m_NoOfConB++;
                                               m_CounterB = m_CounterB + 2;
                                               m_ScoreTextB.setText(Integer.toString(m_CounterB));
                                           }
                                       });

            // Tag marker for this activity
            // Log.i(TAG, "The view has been inflated following +2Conversion Button clicked.");

            // When +5 Try button is clicked, 5 points are added to current score
            m_TryBtnB.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               m_NoOfTryB++;
                                               m_CounterB = m_CounterB + 5;
                                               m_ScoreTextB.setText(Integer.toString(m_CounterB));
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
                    m_CounterA = 0;
                    m_CounterB = 0;
                    m_NoOfPenA = 0;
                    m_NoOfPenB = 0;
                    m_NoOfConA = 0;
                    m_NoOfConB = 0;
                    m_NoOfTryA = 0;
                    m_NoOfTryB = 0;
                    m_ScoreTextA.setText(Integer.toString(m_CounterA));
                    m_ScoreTextB.setText(Integer.toString(m_CounterB));

                    // m_TeamNameTextA set to null following a failed manual test, refer to Test Schedule
                    m_TeamNameTextA.setText(null);
                    m_TeamNameTextB.setText(null);
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
                 *
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
        return rootView;
    }

    // Adds an additional 'share' menu item for Match Frag ONLY onto the main activity items
    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.match, menu);
    }

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Restore last state for checked position.
        //Restore UI state from the savedInstanceState.
        //This bundle has also been passed to onCreate.
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

