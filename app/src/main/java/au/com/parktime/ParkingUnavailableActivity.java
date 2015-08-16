package au.com.parktime;

import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Marcus Hooper
 */
public class ParkingUnavailableActivity extends BaseActivity
{
	private TextView info;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_unavailable_activity);

		setUpToolbar("Unavailable", true);

		info = (TextView) findViewById(R.id.info_text);
		info.animate().alpha(1).start();
	}

	@Override
	public void onBackPressed()
	{
		info.animate().alpha(0).start();
		super.onBackPressed();
	}
}
