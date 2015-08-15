package au.com.parktime;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * @author Marcus Hooper
 */
public class ParkingAvailabilityActivity extends FragmentActivity
{
	public static final String LOCATION = "location";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_availability_activity);
		String location = getIntent().getExtras().getString(LOCATION);
		((TextView) findViewById(R.id.location)).setText(location);
	}
}
