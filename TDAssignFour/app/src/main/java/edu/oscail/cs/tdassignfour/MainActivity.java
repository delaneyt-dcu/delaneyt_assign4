package edu.oscail.cs.tdassignfour;

import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;

import edu.oscail.cs.tdassignfour.view.*;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends android.support.v7.app.ActionBarActivity {
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private ActionTabsViewPagerAdapter myViewPageAdapter;
	private android.support.v4.app.Fragment counterA;
	private android.support.v4.app.Fragment counterB;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			//Restore the fragment's instance
			counterA = getSupportFragmentManager().getFragment(
					savedInstanceState, "Team_A");
			counterB = getSupportFragmentManager().getFragment(
					savedInstanceState, "Team_B");
		}
		setContentView(R.layout.main);
		//setRetainInstance(true);
        // Define SlidingTabLayout (shown at top)
        // and ViewPager (shown at bottom) in the layout.
        // Get their instances.
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        // create a fragment list in order.
        fragments = new ArrayList<Fragment>();
		fragments.add(new EventFragment());
        fragments.add(new GalleryFragment());
        fragments.add(new MatchFragment());
        fragments.add(new SettingsFragment());

        // use FragmentPagerAdapter to bind the slidingTabLayout (tabs with different titles)
        // and ViewPager (different pages of fragment) together.
        myViewPageAdapter =new ActionTabsViewPagerAdapter(getFragmentManager(),
                fragments);
        viewPager.setAdapter(myViewPageAdapter);

        // make sure the tabs are equally spaced.
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

			// toasts were not in brief but handy when testing so decided to keep!

			 case R.id.menuitem_notify:

				 // NOTIF_ID can be any 'unique' integer
				 final int NOTIF_ID = 9876;
				 Context context = getApplicationContext();

				 // Set date and time, (YYYY, M, D, H, Min)
				 // Note: Jan = 0, Feb = 1, etc
				 Calendar beginTime = Calendar.getInstance();
				 beginTime.set(2016, 1, 19, 7, 30);
				 Calendar endTime = Calendar.getInstance();
				 endTime.set(2016, 1, 19, 8, 30);

				 //Implicit intent to open system's calendar
				 Intent mCalendarIntent = new Intent(Intent.ACTION_INSERT)
						 .setData(CalendarContract.Events.CONTENT_URI)
						 .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
						 .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
						 .putExtra(CalendarContract.Events.TITLE, context.getString(R.string.events_title))
						 .putExtra(CalendarContract.Events.EVENT_LOCATION, context.getString(R.string.event_location));
				 //mCalendarIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
				 PendingIntent intent = PendingIntent.getActivity(context, 0, mCalendarIntent, 0);

				 // Set the notification parameters
				 NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
						 .setSmallIcon(R.drawable.ic_event_white_24dp)
						 .setContentTitle(context.getString(R.string.notification_title))
						 .setContentIntent(intent)
						// .setPriority(PRIORITY_HIGH) //private static final PRIORITY_HIGH = 5;
						 .setContentText(context.getString(R.string.notification_text))
						 .setAutoCancel(true)

						 // giving it the bells and whistles
						 .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS);
				 NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

				 // mId allows you to update the notification later on.
				 mNotificationManager.notify(NOTIF_ID, mBuilder.build());
				 // mNotificationManager.cancel(NOTIF_ID);

				 return true;

			case R.id.menuitem_event:
				Context mycontext = getApplicationContext();

				// Set date and time, (YYYY, M, D, H, Min)
				// Note: Jan = 0, Feb = 1, etc
				Calendar mybeginTime = Calendar.getInstance();
				mybeginTime.set(2016, 1, 19, 7, 30);
				Calendar myendTime = Calendar.getInstance();
				myendTime.set(2016, 1, 19, 8, 30);

				//Implicit intent to open system's calendar
				Intent myCalendarIntent = new Intent(Intent.ACTION_INSERT)
						.setData(CalendarContract.Events.CONTENT_URI)
						.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, mybeginTime.getTimeInMillis())
						.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, myendTime.getTimeInMillis())
						.putExtra(CalendarContract.Events.TITLE, mycontext.getString(R.string.events_title))
						.putExtra(CalendarContract.Events.EVENT_LOCATION, mycontext.getString(R.string.event_location));
				startActivity(myCalendarIntent);
				return true;
		}
		return false;
	}
}
