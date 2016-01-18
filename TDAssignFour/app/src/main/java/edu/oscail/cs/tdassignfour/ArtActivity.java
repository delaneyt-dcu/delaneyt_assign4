package edu.oscail.cs.tdassignfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;


/**
 *
 * Created by delaneyt on 31/12/2015.
 */
public class ArtActivity extends AppCompatActivity
        {

    /**
     * Public void method that overrides the onCreate method of the AppCompatActivity class and saves
     * the state of the application in a bundle based on the value of the savedInstance State and
     * carries out button intent actions.
     *
     * @param savedInstanceState can be passed back to onCreate if the activity needs to be created
     *                           (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Listen for changes in the back stack
        //getSupportFragmentManager().addOnBackStackChangedListener(this);
        //Handle when activity is recreated like on orientation Change
        //shouldDisplayHomeUp();
        /*
        Debug Tag for use logging debug output to LogCat
        */
        String TAG = "ArtActivity";

        // Calls the onCreate constructor of the AppCompatActivity superclass
        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(GalleryFragment.EXTRA_RES_ID, 0));

        // Passes the imageView as an argument into the setContentView method
        setContentView(imageView);

        // Tag marker for this activity
        Log.i(TAG, "The activity is visible and has been created.");

    }


            // Ensures the single up arrow action returns to previous screen
            // (similar to back arrow in this case)
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    // Respond to the action bar's Up/Home button
                    case android.R.id.home:
                        finish();
                        return true;
                }
                return super.onOptionsItemSelected(item);
            }




 /**   @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp() {
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount() > 0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
        getSupportFragmentManager().popBackStack();
        return true;
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }*/

}