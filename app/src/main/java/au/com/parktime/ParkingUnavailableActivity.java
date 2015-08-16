package au.com.parktime;

import android.os.Bundle;

/**
 * @author Marcus Hooper
 */
public class ParkingUnavailableActivity extends BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_unavailable_activity);

		setUpToolbar("Unavailable", true);
	}
}
