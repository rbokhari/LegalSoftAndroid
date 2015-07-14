package app.legalsoft.ve;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;


public class LoginActivity extends Activity {

    Button btnLogin;

    String accessToken = "";
    final RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MasterActivity.class);
                startActivity(intent);
            }
        });

/*
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                final String accessToken;
                GlobalFunctions.showMessage("Click ");

                String url = "http://amc.azurewebsites.net/token";
                //String url1 = "http://192.168.1.36:91/token";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            String accessToken1 = json.getString("access_token");
                            GetCount(accessToken1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        GlobalFunctions.m("error comes :  " + error.getMessage() + " :" + error.networkResponse.statusCode);
                    }
                })
                {
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("username","syed.rahman");
                        params.put("password","rahman@6146");
                        params.put("grant_type", "password");
                        GlobalFunctions.m("getParams---------call");

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        //params.put("Content-Type","application/x-www-form-urlencoded");
                        GlobalFunctions.m("getHeaders---------call");
                        return params;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });
    }

    String url2 = "http://amc.azurewebsites.net/api/tajneed/GetTajneedCount";

    private void GetCount(final String accessToken){
        StringRequest request = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GlobalFunctions.showMessage("getcount response comes");
                GlobalFunctions.m("data " + response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                GlobalFunctions.showMessage("getcount error :" + error.networkResponse.statusCode);
                GlobalFunctions.m(error.getLocalizedMessage());

            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization","bearer " + accessToken);
                GlobalFunctions.m("GetCount - getHeaders---------call");
                return params;
            }

        };

        requestQueue.add(request);

    */

    }
}
