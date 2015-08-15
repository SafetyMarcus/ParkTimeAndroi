package au.com.parktime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends FragmentActivity
{
	private static final int PICKER_CODE = 1234;

	private Button parkingButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		parkingButton = (Button) findViewById(R.id.parking_button);
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
			Intent intent = new Intent(this, ParkingAvailabilityActivity.class);
			intent.putExtra(ParkingAvailabilityActivity.LOCATION, name);
			startActivity(intent);
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
