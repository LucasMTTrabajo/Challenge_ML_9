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

    /**
     * Ocultar teclado.
     *
     * @param context: Contexto actual.
     * @param view: Vista que tiene actualmente el foco.
     */
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Devuelve un LayoutParams con el ancho y alto del mismo tamaño que el padre.
     *
     * @return RelativeLayout.LayoutParams : layout_width = MATCH_PARENT ; layout_height = MATCH_PARENT
     */
    public static RelativeLayout.LayoutParams getRelativeLayuotParamsFullScreenON ( ){
        try{
            return new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        } catch ( Exception e ){
            Log.e(TAG, "getRelativeLayuorParams: e - ", e);
            return null;
        }
    }

    /**
     * Devuelve un LayoutParams con el ancho y alto adaptados al contenido.
     *
     * @return RelativeLayout.LayoutParams : layout_width = WRAP_CONTENT ; layout_height = WRAP_CONTENT
     */
    public static RelativeLayout.LayoutParams getRelativeLayuotParamsFullScreenOFF ( ){
        try{
            return new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } catch ( Exception e ){
            Log.e(TAG, "getRelativeLayuorParams: e - ", e);
            return null;
        }
    }

}
