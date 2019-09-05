package com.ahmed.gamal.matchatak;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;


public class MatchWidget extends AppWidgetProvider {

    String status,homeTeam, awayTeam, homeTeamResult, awayTeamResult;



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {


            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.match_widget);
            views.setTextViewText(R.id.appwidget_status, status);
            views.setTextViewText(R.id.appwidget_home_team, homeTeam);
            views.setTextViewText(R.id.appwidget_away_team, awayTeam);
            views.setTextViewText(R.id.appwidget_home_team_result, homeTeamResult);
            views.setTextViewText(R.id.appwidget_away_team_result, awayTeamResult);

            appWidgetManager.updateAppWidget( appWidgetId,views);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("bundle")) {
            Bundle bundle = intent.getBundleExtra("bundle");
            if (bundle != null) {
                status=bundle.getString("status");
                homeTeam = bundle.getString("homeTeam");
                awayTeam = bundle.getString("awayTeam");
                homeTeamResult = bundle.getString("homeTeamResult");
                awayTeamResult = bundle.getString("awayTeamResult");
            }
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            ComponentName componentName = new ComponentName(context, MatchWidget.class);
            this.onUpdate(context, manager, manager.getAppWidgetIds(componentName));
        } else
            super.onReceive(context, intent);
    }

}

