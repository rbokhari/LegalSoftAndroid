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
        RequestFuture<JSONArray> requestFuture = RequestFuture.newFuture();
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();
        if (requestQueue!=null) {
            //JsonObjectRequest request1 = new JsonObjectRequest(CONSTANTS.EMPLOYEES_API_URL,
            //        requestFuture, requestFuture);
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,(String)null, requestFuture, requestFuture);
 //           JSONObject params = new JSONObject();
 //           params.put("token", "token value");
 //           JsonObjectRequest request1 = new JsonObjectRequest((Request.Method.GET, url, new JSONObject(params), requestFuture, requestFuture);

            requestQueue.add(request);
            try {
                response = requestFuture.get(60, TimeUnit.SECONDS);
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

    public static JSONObject requestDataObject(String url){
        JSONObject response = null;
        RequestFuture<JSONObject> requestFuture = RequestFuture.newFuture();
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();
        if (requestQueue!=null) {
            //JsonObjectRequest request1 = new JsonObjectRequest(CONSTANTS.EMPLOYEES_API_URL,
            //        requestFuture, requestFuture);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,(String)null, requestFuture, requestFuture);
            //           JSONObject params = new JSONObject();
            //           params.put("token", "token value");
            //           JsonObjectRequest request1 = new JsonObjectRequest((Request.Method.GET, url, new JSONObject(params), requestFuture, requestFuture);

            requestQueue.add(request);
            try {
                response = requestFuture.get(60, TimeUnit.SECONDS);
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

}
