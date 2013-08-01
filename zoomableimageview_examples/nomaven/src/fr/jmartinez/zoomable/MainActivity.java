package fr.jmartinez.zoomable;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements Runnable {

    ImageView imageView;
    TextView textView;
    int countdown = 8;
    Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.view);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(Integer.toString(countdown));
        // Simulate a slow load from the web, using a countdown timer.
        handler = new Handler();
        handler.postDelayed(this, 1000);
	}

    @Override
    public void run() {
        countdown--;
        textView.setText(Integer.toString(countdown));
        if(countdown > 0) {
            handler.postDelayed(this, 1000);
        } else {
            // Finally the image arrived!
            imageView.setImageResource(R.drawable.screenshot);
        }
    }
}
