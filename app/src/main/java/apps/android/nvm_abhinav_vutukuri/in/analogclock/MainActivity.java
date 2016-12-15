
package apps.android.nvm_abhinav_vutukuri.in.analogclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    ImageView dial_ImageView;
    ImageView minuteHand_ImageView;
    ImageView hourHand_ImageView;
    ImageView secondHand_ImageView;

    Clock clock;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dial_ImageView = (ImageView)findViewById(R.id.dial_ImageView);
        minuteHand_ImageView = (ImageView)findViewById(R.id.minuteHand_ImageView);
        hourHand_ImageView = (ImageView)findViewById(R.id.hourHand_ImageView);
        secondHand_ImageView = (ImageView)findViewById(R.id.secondHand_ImageView);

        clock = new Clock(secondHand_ImageView, minuteHand_ImageView, hourHand_ImageView);
        clock.start();
    }

    @Override
    protected void onResume()
    {
        registerReceiver(clock.timeTickReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        if (clock.timeTickReceiver != null)
        {
            unregisterReceiver(clock.timeTickReceiver);
        }
        super.onPause();
    }

}
