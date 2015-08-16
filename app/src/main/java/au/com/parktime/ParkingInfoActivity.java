package au.com.parktime;

import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Marcus Hooper
 */
public class ParkingInfoActivity extends BaseActivity
{
	public static final String COLOUR = "colour";
	public static final String INFO = "info";

	private TextView info;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		postponeEnterTransition();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_unavailable_activity);
		setUpToolbar("Thanks", true);

		Bundle extras = getIntent().getExtras();
		findViewById(R.id.info_layout).setBackgroundColor(extras.getInt(COLOUR));
		startPostponedEnterTransition();

		info = (TextView) findViewById(R.id.info_text);
		info.setText(extras.getString(INFO));
		info.animate().alpha(1).start();
	}

	@Override
	public void onBackPressed()
	{
		info.animate().alpha(0).start();
		super.onBackPressed();
	}
}
