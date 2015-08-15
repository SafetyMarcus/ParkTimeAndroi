package au.com.parktime;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends FragmentActivity
{
	private static final int PICKER_CODE = 1234;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

		Transition transition = new Fade();
		transition.excludeTarget(android.R.id.statusBarBackground, true);
		transition.excludeTarget(android.R.id.navigationBarBackground, true);
		getWindow().setEnterTransition(transition);
		getWindow().setExitTransition(transition);

		setContentView(R.layout.main_activity);
		Button parkingButton = (Button) findViewById(R.id.parking_button);
		parkingButton.setOnClickListener(new ParkingClickListener());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(resultCode == Activity.RESULT_OK && requestCode == PICKER_CODE)
		{
			// The user has selected a place. Extract the name and address.
			final Place place = PlacePicker.getPlace(data, this);

			final CharSequence name = place.getName();

			Pair<View, String> pair = new Pair<>(findViewById(R.id.parking_button), "location");
			ActivityOptions.makeSceneTransitionAnimation(this, pair);

			new Handler().postDelayed(new Runnable()
			{
				@Override
				public void run()
				{
					Intent intent = new Intent(MainActivity.this, ParkingAvailabilityActivity.class);
					intent.putExtra(ParkingAvailabilityActivity.LOCATION, name);
					startActivity(intent);
					overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
				}
			}, 2000);
		}
		else
			super.onActivityResult(requestCode, resultCode, data);
	}

	private class ParkingClickListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			// Construct an intent for the place picker
			try
			{
				PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
				Intent intent = intentBuilder.build(MainActivity.this);
				// Start the intent by requesting a result,
				// identified by a request code.
				startActivityForResult(intent, PICKER_CODE);
			}
			catch(GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e)
			{
				//...
			}
		}
	}
}
