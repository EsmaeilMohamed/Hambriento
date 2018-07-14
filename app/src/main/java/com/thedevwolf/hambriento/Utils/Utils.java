package com.thedevwolf.hambriento.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.thedevwolf.hambriento.R;

public class Utils {


    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    //location dialog for denying permission
    public static void goToLocationPermissionSettings(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.MyAlertDialogStyle)
                .setMessage(R.string.location_permission_asking)
                .setPositiveButton(context.getString(R.string.settings), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", context.getPackageName(), null));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }).setNegativeButton(context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        builder.show();
    }
    //location dialog for enable GPS
    public static void goToLocationSettings(final Context context) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context,R.style.MyAlertDialogStyle);

        // Setting Dialog Title
        alertDialog.setTitle(R.string.Gps_title);

        // Setting Dialog Message
        alertDialog.setMessage(R.string.Gps_Description);

        // On pressing Settings button
        alertDialog.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                if (context instanceof Activity) {
                    ((Activity)context).startActivityForResult(intent, 300);
                } else {

                }


            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
    //String Null Checker
    public static String nullChecker(Object  check){
        if (check==null||check.toString().equals("null")){
            return "Not Available For This Restaurant";
        }
        return check.toString();
    }



}
