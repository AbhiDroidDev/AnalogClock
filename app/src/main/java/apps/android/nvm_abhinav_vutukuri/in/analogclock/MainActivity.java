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
    @BindView(R.id.dial_ImageView)
    ImageView dial_ImageView;
    @BindView(R.id.minuteHand_ImageView)
    ImageView minuteHand_ImageView;
    @BindView(R.id.hourHand_ImageView)
    ImageView hourHand_ImageView;
    @BindView(R.id.secondHand_ImageView)
    ImageView secondHand_ImageView;

    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        utils = new Utils();
        rotateAllClockHands();
        secondHand_ImageView.post(rotateSecondHandRunnable);
    }

    @Override
    protected void onResume()
    {
        registerReceiver(timeTickReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        if (timeTickReceiver != null)
        {
            unregisterReceiver(timeTickReceiver);
        }
        super.onPause();
    }

    void rotateAllClockHands()
    {
        //rotate all clock hands to show current time
        secondHand_ImageView.setRotation(utils.getSecondHandDegrees());
        minuteHand_ImageView.setRotation(utils.getMinuteHandDegrees());
        hourHand_ImageView.setRotation(utils.getHourHandDegrees());
    }

    void rotateMinuteAndHourHands()
    {
        //rotate minute & hour hands to show current time
        minuteHand_ImageView.setRotation(utils.getMinuteHandDegrees());
        hourHand_ImageView.setRotation(utils.getHourHandDegrees());
    }

    final Runnable rotateSecondHandRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            secondHand_ImageView.setRotation(utils.getSecondHandDegrees());
            secondHand_ImageView.post(rotateSecondHandRunnable);
        }
    };

    BroadcastReceiver timeTickReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals(Intent.ACTION_TIME_TICK))
            {
                rotateMinuteAndHourHands();
            }
        }
    };
}
