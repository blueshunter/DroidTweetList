package example.helpers;

import android.content.Context;

import java.util.Locale;

/**
 * Helper to get current locale in ISO 2 format
 */

public class ISO2LanguageHelper {

    public static String getCurrentLocale(Context context){

        // TODO : search better way to get ISO2
        Locale currentLocale = context.getResources().getConfiguration().locale;
        return currentLocale.getISO3Language().substring(0, 2);
    }

}
