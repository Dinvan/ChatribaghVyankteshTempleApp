package commons;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dinesh on 1/7/2016.
 */
public class SharedPreferenceData
{
    public static final String NAGORIYA_MATH_FILE="nagoriya_math_file";
    public static final String APP_START_SOUND="app_start_sound";

    public static final String GALLERY_DATA="gallery_data";
    public static void setSharedPrefer(Context context,String which,String value)
    {
        SharedPreferences preference=context.getSharedPreferences(NAGORIYA_MATH_FILE, Context.MODE_APPEND);
        SharedPreferences.Editor ed=preference.edit();
        ed.putString(which,value);
        ed.commit();
    }
    public static String getSharedPrefer(Context context,String which)
    {
        SharedPreferences cureentMediaPrf=context.getSharedPreferences(NAGORIYA_MATH_FILE,Context.MODE_APPEND);
        String data=cureentMediaPrf.getString(which,"");
        return data;
    }

    public static void clearSharedPrefer(Context context)
    {
        SharedPreferences preference=context.getSharedPreferences(NAGORIYA_MATH_FILE, Context.MODE_APPEND);
        preference.edit().remove(NAGORIYA_MATH_FILE).clear().commit();
    }
}
