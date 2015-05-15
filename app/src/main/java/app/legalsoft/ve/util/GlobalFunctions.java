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
import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 25/04/2015.
 */
public  class GlobalFunctions {

    public static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
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



}
