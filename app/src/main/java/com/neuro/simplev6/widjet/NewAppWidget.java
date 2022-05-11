package com.neuro.simplev6.widjet;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.ScrollView;

import com.neuro.simplev6.R;
import com.neuro.simplev6.ui.notifications.NotificationsFragment;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider  {
    ListView listViewwirget;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {



    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);


        }
        // RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        // remoteViews.setAdapter(getlist());;

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }






}