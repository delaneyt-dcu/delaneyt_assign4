package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *  Displays an event image with associated event info
 *
 *  <p> This fragment class is automatically loaded by the MainActivity upon app launch.
 *  It is primarily for notice purposes but some UI in the form of action and menu tabs</p>
 *
 *  <p><b>Maintenance: </b>Event details can be amended within the R.values.strings.xml file</p>
 *
 *  @author Tim Delaney
 *  @version 2.0
 *  @since 2016-01-20
 */
public class EventFragment extends Fragment {

    /**
     * Returns a jpeg image + textView view to inflate contained within the event fragment layout
     *
     * @param inflater instantiates a layout XML file into its corresponding View objects
     * @param container is a reference to a special view that can contain other views (ie children)
     * @param savedInstanceState is a reference to a Bundle object that is passed into the onCreate
     *                           or onCreateView method of every Android Activity/Frag
     * @return inflated view of R.Layout.event_fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_fragment, container, false);
    }
}

