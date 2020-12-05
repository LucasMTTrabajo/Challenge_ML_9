package com.example.challenge_ml_1.utilitie;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Utilities {
    private static final String TAG = "Utilities";

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static RelativeLayout.LayoutParams getRelativeLayuotParamsFullScreenON ( ){
        try{
            return new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        } catch ( Exception e ){
            Log.e(TAG, "getRelativeLayuorParams: e - ", e);
            return null;
        }
    }

    public static RelativeLayout.LayoutParams getRelativeLayuotParamsFullScreenOFF ( ){
        try{
            return new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } catch ( Exception e ){
            Log.e(TAG, "getRelativeLayuorParams: e - ", e);
            return null;
        }
    }

    public static void getScreenSize(Context context) {

        int screenLayout = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        switch ( screenLayout ) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE  :
                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL :
                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL  :
                break;
            default :
                break;
        }
    }

    public static int getScreenDensity(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ( (Activity) context ). getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi;
    }

//    public static int getPlaceHolder ( Context context ) {
//        int density = getScreenDensity(context);
//
//        switch ( density ) {
//            case DisplayMetrics.DENSITY_HIGH  :
//                return R.mipmap.ic_placeholder_item;
//            case DisplayMetrics.DENSITY_MEDIUM :
//                break;
//            case DisplayMetrics.DENSITY_LOW  :
//                break;
//            default :
//                break;
//        }
//    }
}
