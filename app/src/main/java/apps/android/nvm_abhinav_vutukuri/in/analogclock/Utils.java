package apps.android.nvm_abhinav_vutukuri.in.analogclock;

import java.util.Calendar;

/**
 * Created by Abhinav Vutukuri on 10-12-16.
 */

class Utils
{
    int getCurrentHour()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR);
    }

    int getCurrentMinute()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    int getCurrentSeconds()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.SECOND);
    }
}
