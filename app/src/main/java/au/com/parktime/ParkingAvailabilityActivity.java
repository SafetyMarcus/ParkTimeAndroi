package au.com.parktime;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Marcus Hooper
 */
public class ParkingAvailabilityActivity extends BaseActivity
{
	public static final String LOCATION = "location";
	private Button parkingAvailable;
	private Button parkingUnavailable;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.parking_availability_activity);
		String location = getIntent().getExtras().getString(LOCATION);
		((TextView) findViewById(R.id.location)).setText(location);
		setUpToolbar("Availability", true);

		parkingAvailable = (Button) findViewById(R.id.parking_available);
		parkingAvailable.setOnClickListener(new ParkingAvailableListener());
		parkingUnavailable = (Button) findViewById(R.id.parking_unavailable);
		parkingUnavailable.setOnClickListener(new ParkingUnavailableListener());
	}

	public class ParkingAvailableListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			Bundle options = ActivityOptions.makeSceneTransitionAnimation(ParkingAvailabilityActivity.this, parkingAvailable,
					getString(R.string.parking_available_transition)).toBundle();
			Intent intent = new Intent(ParkingAvailabilityActivity.this, ParkingAvailableActivity.class);
			startActivity(intent, options);
		}
	}

	public class ParkingUnavailableListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			Bundle options = ActivityOptions.makeSceneTransitionAnimation(ParkingAvailabilityActivity.this, parkingUnavailable,
					getString(R.string.parking_unavailable_transition)).toBundle();
			Intent intent = new Intent(ParkingAvailabilityActivity.this, ParkingUnavailableActivity.class);
			startActivity(intent, options);
		}
	}
}
