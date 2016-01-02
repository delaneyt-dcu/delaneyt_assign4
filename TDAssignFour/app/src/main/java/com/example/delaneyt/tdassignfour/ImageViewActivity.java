package com.example.delaneyt.tdassignfour;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by delaneyt on 31/12/2015.
 */
public class ImageViewActivity extends AppCompatActivity {

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
//        getSupportFragmentManager().addOnBackStackChangedListener(this);
        //Handle when activity is recreated like on orientation Change
//        shouldDisplayHomeUp();
        /*
        Debug Tag for use logging debug output to LogCat
        */
        String TAG = "ImageViewActivity";

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


//    @Override
//    public void onBackStackChanged() {
//        shouldDisplayHomeUp();
//    }

//    public void shouldDisplayHomeUp() {
        //Enable Up button only  if there are entries in the back stack
//        boolean canback = getSupportFragmentManager().getBackStackEntryCount() > 0;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
//    }

//    @Override
//    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
//        getSupportFragmentManager().popBackStack();
//        return true;
//    }


}






