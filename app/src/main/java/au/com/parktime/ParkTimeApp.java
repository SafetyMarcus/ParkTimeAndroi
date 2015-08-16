package au.com.parktime;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * @author Marcus Hooper
 */
public class ParkTimeApp extends Application
{
	private static ParkTimeApp app;

	@Override
	public void onCreate()
	{
		super.onCreate();
		app = this;

		// Enable Local Datastore.
		Parse.enableLocalDatastore(this);
		Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
		ParseInstallation.getCurrentInstallation().saveInBackground();
	}

	public static ParkTimeApp getInstance()
	{
		return app;
	}
}
