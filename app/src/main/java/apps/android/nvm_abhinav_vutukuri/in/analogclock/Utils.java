package apps.android.nvm_abhinav_vutukuri.in.analogclock;

import java.util.Calendar;

import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.HOUR_HAND_ROTATION_DEGREES_PER_HOUR;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.HOUR_HAND_ROTATION_DEGREES_PER_MINUTE;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.MINUTE_HAND_ROTATION_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.OFFSET_HOUR_HAND_IN_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.OFFSET_MINUTE_HAND_IN_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.OFFSET_SECOND_HAND_IN_DEGREES;
import static apps.android.nvm_abhinav_vutukuri.in.analogclock.Constants.SECOND_HAND_ROTATION_DEGREES;

/**
 * Created by Abhinav Vutukuri on 10-12-16.
 */

class Utils
{
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

    float getHourHandDegrees()
    {
        return ((getCurrentHour() * HOUR_HAND_ROTATION_DEGREES_PER_HOUR) +
                (getCurrentMinute() * HOUR_HAND_ROTATION_DEGREES_PER_MINUTE) -
                OFFSET_HOUR_HAND_IN_DEGREES);
    }

    float getMinuteHandDegrees()
    {
        return ((getCurrentMinute() * MINUTE_HAND_ROTATION_DEGREES) - OFFSET_MINUTE_HAND_IN_DEGREES);
    }

    float getSecondHandDegrees()
    {
        return ((getCurrentSeconds() * SECOND_HAND_ROTATION_DEGREES) - OFFSET_SECOND_HAND_IN_DEGREES);
    }
}
