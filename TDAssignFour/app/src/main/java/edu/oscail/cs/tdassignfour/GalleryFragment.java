package edu.oscail.cs.tdassignfour;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * This is a child activity of the MainActivity class, launched by explicit intent with the
 * @+id/home_gallery_button. It loads layout resources from the activity_photo_gallery.xml file
 * which include an actionbar containing a clickable back action arrow with the activity name and a
 * gridView of clickable image thumbprints which lunch a ArtActivity. The origins of the code
 * used in this class is accredited to Dr Adam Porter (ref project: UIGrdLayout.java)
 * Created by delaneyt on 11/12/2015.
 */
public class GalleryFragment extends Fragment {

    /**
     * Debug Tag for use logging debug output to LogCat
     */
    //private final String TAG = "PhotoGalleryActivity";

    // Declares a protected string variable EXTRA_RES_ID and initiates its value as POS
    protected static final String EXTRA_RES_ID = "POS";

    // Creates an array of resource image files which is a private instance to this class
    private ArrayList<Integer> mThumbIdsCars = new ArrayList<>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8,
                    R.drawable.image9, R.drawable.image10, R.drawable.image11,
                    R.drawable.image12));

    /**
     * Public void method that overrides the onCreate method of the AppCompatActivity class and
     * saves the state of the application in a bundle based on the value of the savedInstance State
     * and carries out button intent actions.
     //* @param savedInstanceState is the argument passed back to onCreate if the activity needs to be
     *                           created (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    //@Override
    //public void onCreate(Bundle savedInstanceState) {

    // Calls the onCreate constructor of the AppCompatActivity superclass
    //   super.onCreate(savedInstanceState);}

    // Tag marker for this activity
    //Log.i(TAG, "The activity is visible and about to be created.");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saedInstanceState) {
        //super.onCreateView(savedInstanceState);
        View rootView = inflater.inflate(R.layout.gallery_fragment, container, false);
        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity(), mThumbIdsCars));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ArtActivity
                //Intent intent = new Intent(GalleryFragment.this, ArtActivity.class);
                // change follows stackoverflow
                Intent intent = new Intent(getActivity(), ArtActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int) id);

                // Start the ArtActivity
                startActivity(intent);

                // Tag marker for this activity
                // Log.i(TAG, "The activity is visible has been started.");
            }
        });
        return rootView;
    }
}

