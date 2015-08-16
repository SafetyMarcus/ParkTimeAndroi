package au.com.parktime;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * @author Marcus Hooper
 */
public abstract class BaseActivity extends AppCompatActivity
{
	public Toolbar toolbar;

	public void setUpToolbar(String title, boolean displayBack)
	{
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		setTitle(title);

		if(displayBack)
		{
			ActionBar actionBar = getSupportActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case android.R.id.home:
				onBackPressed();
				return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
