package apps.android.nvm_abhinav_vutukuri.in.analogclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import java.util.Calendar;

import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.HOUR_HAND_ROTATION_DEGREES_PER_HOUR;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.HOUR_HAND_ROTATION_DEGREES_PER_MINUTE;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.MINUTE_HAND_ROTATION_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.OFFSET_HOUR_HAND_IN_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.OFFSET_MINUTE_HAND_IN_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.OFFSET_SECOND_HAND_IN_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.SECOND_HAND_ROTATION_DEGREES;

/**
 * Created by Admin on 12/15/16.
 */

class Clock
{
    private ImageView secondHand_ImageView;
    private ImageView minuteHand_ImageView;
    private ImageView hourHand_ImageView;

    Clock(ImageView secondHand_ImageView, ImageView minuteHand_ImageView, ImageView hourHand_ImageView)
    {
        this.secondHand_ImageView = secondHand_ImageView;
        this.minuteHand_ImageView = minuteHand_ImageView;
        this.hourHand_ImageView = hourHand_ImageView;
    }
    
    void start()
    {
        rotateAllClockHands();
        secondHand_ImageView.post(rotateSecondHandRunnable);
    }

    private final Runnable rotateSecondHandRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            secondHand_ImageView.setRotation(getSecondHandDegrees());
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

    private void rotateAllClockHands()
    {
        //rotate all clock hands to show current time
         secondHand_ImageView.setRotation(getSecondHandDegrees());
         minuteHand_ImageView.setRotation(getMinuteHandDegrees());
         hourHand_ImageView.setRotation(getHourHandDegrees());
    }

    private void rotateMinuteAndHourHands()
    {
        //rotate minute & hour hands to show current time
         minuteHand_ImageView.setRotation(getMinuteHandDegrees());
         hourHand_ImageView.setRotation(getHourHandDegrees());
    }
    
    private int getCurrentHour()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR);
    }

    private int getCurrentMinute()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    private int getCurrentSeconds()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.SECOND);
    }

    private float getHourHandDegrees()
    {
        return ((getCurrentHour() * HOUR_HAND_ROTATION_DEGREES_PER_HOUR) +
                (getCurrentMinute() * HOUR_HAND_ROTATION_DEGREES_PER_MINUTE) -
                OFFSET_HOUR_HAND_IN_DEGREES);
    }

    private float getMinuteHandDegrees()
    {
        return ((getCurrentMinute() * MINUTE_HAND_ROTATION_DEGREES) - OFFSET_MINUTE_HAND_IN_DEGREES);
    }

    private float getSecondHandDegrees()
    {
        return ((getCurrentSeconds() * SECOND_HAND_ROTATION_DEGREES) - OFFSET_SECOND_HAND_IN_DEGREES);
    }
}
