package ma.nabil.android.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class TestDialog extends Activity {
	/** Called when the activity is first created. */
	protected ProgressDialog mBusy;
	final Handler mHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button test = (Button) findViewById(R.id.Button01);
		test.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				testDialog();
			}
		});
	}

	private void testDialog() {
		mBusy = ProgressDialog.show(TestDialog.this, "Téléchargement",
				"En cours...", true, false);

		Thread t = new Thread() {
			public void run() {
				try {
					sleep(6000);
					mHandler.post(new Runnable() {

						@Override
						public void run() {
							mBusy.dismiss();

						}
					});
				} catch (Exception e) {
					mHandler.post(new Runnable() {

						@Override
						public void run() {
							mBusy.dismiss();

						}
					});
				}

			}
		};
	}
}