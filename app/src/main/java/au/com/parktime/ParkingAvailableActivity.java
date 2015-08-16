package au.com.parktime;

import android.os.Bundle;

/**
 * @author Marcus Hooper
 */
public class ParkingAvailableActivity extends BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_available_activity);
		setUpToolbar("Available", true);
	}
}
