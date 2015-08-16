package au.com.parktime;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Marcus Hooper
 */
public class ParkingAvailableActivity extends BaseActivity
{
	LinearLayout questionLayout;
	Button heaps;
	Button few;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parking_available_activity);
		setUpToolbar("Available", true);

		questionLayout = (LinearLayout) findViewById(R.id.question_layout);
		heaps = (Button) findViewById(R.id.heaps);
		few = (Button) findViewById(R.id.few);

		heaps.setOnClickListener(new ReportListener());
		few.setOnClickListener(new ReportListener());

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

	public class ReportListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v)
		{
			Bundle options = ActivityOptions.makeSceneTransitionAnimation(ParkingAvailableActivity.this, questionLayout,
				getString(R.string.parking_available_transition)).toBundle();
			Intent intent = new Intent(ParkingAvailableActivity.this, ParkingInfoActivity.class);
			intent.putExtra(ParkingInfoActivity.COLOUR, getResources().getColor(R.color.green));

			StringBuilder info = new StringBuilder();
			if(v.getId() == R.id.heaps)
				info.append("Sweet!\n");
			else
				info.append("Better Hurry\n");
			info.append("Thanks for reporting");
			intent.putExtra(ParkingInfoActivity.INFO, info.toString());
			startActivity(intent, options);
		}
	}
}
