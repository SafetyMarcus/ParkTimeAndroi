package au.com.parktime;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Marcus Hooper
 */
public class ParkingAvailableActivity extends BaseActivity
{
	LinearLayout questionLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_available_activity);
		setUpToolbar("Available", true);

		questionLayout = (LinearLayout) findViewById(R.id.question_layout);

		for(int i = 0; i < questionLayout.getChildCount(); i++)
			questionLayout.getChildAt(i).animate().alpha(1).start();
	}

	@Override
	public void onBackPressed()
	{
		for(int i = 0; i < questionLayout.getChildCount(); i++)
		{
			if(i == 2)
			{
				((TextView) questionLayout.getChildAt(i)).setText("YES");
				continue;
			}

			questionLayout.getChildAt(i).setVisibility(View.GONE);
		}
		super.onBackPressed();
	}
}
