package au.com.parktime;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author Marcus Hooper
 */
public class ParkingUnavailableActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_unavailable_activity);
	}
}
