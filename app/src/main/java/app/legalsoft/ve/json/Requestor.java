package app.legalsoft.ve.json;

/**
 * Created by Syed.Rahman on 02/05/2015.
 */

import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;

public class Requestor {
/*
    public static JSONObject requestMoviesJSON(RequestQueue requestQueue, String url) {
        JSONObject response = null;
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                (String) null, requestFuture, requestFuture);

        requestQueue.add(request);
        try {
            response = requestFuture.get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            GlobalFunctions.m(e + "");
        } catch (ExecutionException e) {
            GlobalFunctions.m(e + "");
        } catch (TimeoutException e) {
            GlobalFunctions.m(e + "");
        }
        return response;
    }*/



    public static JSONArray requestData(String url){
        JSONArray response = null;
        GlobalFunctions.m("--- request data 1 ---");
        RequestFuture<JSONArray> requestFuture = RequestFuture.newFuture();
        GlobalFunctions.m("--- request data 2 ---");
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();
        GlobalFunctions.m("--- request data 3 ---");
        if (requestQueue!=null) {
            //JsonObjectRequest request1 = new JsonObjectRequest(CONSTANTS.EMPLOYEES_API_URL,
            //        requestFuture, requestFuture);
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,(String)null, requestFuture, requestFuture);
            GlobalFunctions.m("--- request data 4 ---");
 //           JSONObject params = new JSONObject();
 //           params.put("token", "token value");
 //           JsonObjectRequest request1 = new JsonObjectRequest((Request.Method.GET, url, new JSONObject(params), requestFuture, requestFuture);

            requestQueue.add(request);
            GlobalFunctions.m("--- request data 5 ---");
            try {
                response = requestFuture.get(60, TimeUnit.SECONDS);
                GlobalFunctions.m("--- request data 6 ---");
            } catch (InterruptedException e) {
                GlobalFunctions.m("InterruptedException-------" + e.getMessage());
            } catch (ExecutionException e) {
                GlobalFunctions.m("ExecutionException-------" + e.getMessage());
            } catch (TimeoutException e) {
                GlobalFunctions.m("TimeoutException-------" + e.getMessage());
            }
        }
        //GlobalFunctions.m("response length in getData : " + response.length());
        return response;
    }
/*
    public static JSONArray requestData1(String url){
        final JSONArray responseData;
        RequestFuture<JSONArray> requestFuture = RequestFuture.newFuture();
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();
        if (requestQueue!=null) {
            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    responseData = response;
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Toast.makeText(getApplicationContext(), "error ; " + error, Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("CUSTOM_HEADER", "Yahoo");
                    headers.put("ANOTHER_CUSTOM_HEADER", "Google");
                    return headers;
                }
            };

        }

        return responseData;
    }
    */

    public JSONArray requestData1(String url){
        JSONArray response = null;
        GlobalFunctions.m("--- request data 1 ---");
        RequestFuture<JSONArray> requestFuture = RequestFuture.newFuture();
        GlobalFunctions.m("--- request data 2 ---");
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();
        GlobalFunctions.m("--- request data 3 ---");
        if (requestQueue!=null) {
            //JsonObjectRequest request1 = new JsonObjectRequest(CONSTANTS.EMPLOYEES_API_URL,
            //        requestFuture, requestFuture);
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,(String)null, requestFuture, requestFuture);
            GlobalFunctions.m("--- request data 4 ---");
            //           JSONObject params = new JSONObject();
            //           params.put("token", "token value");
            //           JsonObjectRequest request1 = new JsonObjectRequest((Request.Method.GET, url, new JSONObject(params), requestFuture, requestFuture);

            requestQueue.add(request);
            GlobalFunctions.m("--- request data 5 ---");
            try {
                response = requestFuture.get();
                GlobalFunctions.m("--- request data 6 ---");
            } catch (InterruptedException e) {
                GlobalFunctions.m("InterruptedException-------" + e.getMessage());
            } catch (ExecutionException e) {
                GlobalFunctions.m("ExecutionException-------" + e.getMessage());
            }
        }
        //GlobalFunctions.m("response length in getData : " + response.length());
        return response;
    }

}
