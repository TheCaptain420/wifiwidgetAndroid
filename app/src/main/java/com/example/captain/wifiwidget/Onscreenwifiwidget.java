package com.example.captain.wifiwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.wifi.WifiManager;
import android.widget.ImageButton;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */

/*
Ændrer image på button =
* https://stackoverflow.com/questions/3257969/imagebutton-in-android-homescreen-widget
* */
public class Onscreenwifiwidget extends AppWidgetProvider {

    public static String YOUR_AWESOME_ACTION = "YourAwesomeAction";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //det der gør det clickable

        Intent intent = new Intent(context, Onscreenwifiwidget.class);
        intent.setAction(YOUR_AWESOME_ACTION);


        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.onscreenwifiwidget);

        views.setOnClickPendingIntent(R.id.btn_wifiwidget, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);

        //pre skrald herunder!
        /*

        CharSequence widgetText = context.getString(R.string.appwidget_text);

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.onscreenwifiwidget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
*/
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    //https://stackoverflow.com/questions/2748590/clickable-widgets-in-android

    //måske lav en singleton med wifi manager istedet?
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(YOUR_AWESOME_ACTION)) {

            /*
            WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            if(wifi.isWifiEnabled()){
                wifi.setWifiEnabled(false); // true or false to activate/deactivate wifi
            }else{
                wifi.setWifiEnabled(true); // true or false to activate/deactivate wifi
            }
            */
        }
    }
}

