package app.legalsoft.ve.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.DefenderModel;

/**
 * Created by Syed.Rahman on 25/04/2015.
 */
public  class GlobalFunctions {

    public static int mNavposition = 0;

    public static void showMessage(String message){
        //Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        Toast.makeText(MyApplication.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    public static Boolean getIsNotNull(JSONObject jsonObject, String key){
        return jsonObject!=null && jsonObject.has(key) && !jsonObject.isNull(key) ? true : false;
    }

    public static void m(String message) {
        Log.d("Legal------>>>>>>>.", "" + message);
    }

    public static String getVolleyError(VolleyError error){
        if (error instanceof TimeoutError || error instanceof NoConnectionError){
            return MyApplication.getAppContext().getResources().getString(R.string.volley_time_out);

        }
        else if (error instanceof ServerError){
            return MyApplication.getAppContext().getResources().getString(R.string.volley_server_error);
        }
        else if (error instanceof NetworkError){
            return MyApplication.getAppContext().getResources().getString(R.string.volley_network_error);
        }
        else if (error instanceof ParseError){
            return MyApplication.getAppContext().getResources().getString(R.string.volley_parse_error);
        }
        return "";
    }

    public static String getMonthName(int month){
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }

    public static String getFormattedDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = simpleDateFormat.parse(date);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd MMMM yyyy");
            return fmtOut.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }


/*
    private List<T> filter(List<T> models, String query) {
        query = query.toLowerCase();

        final List<T> filteredModelList = new ArrayList<>();
        for (T model : models) {
            final String text = model.toString().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

*/
}
