package app.legalsoft.ve.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 28/03/2015.
 */
public class VolleySingleton {

    private static VolleySingleton sInstance = null;
    private RequestQueue mRequestQuery;

    private VolleySingleton(){
        mRequestQuery = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getsInstance()
    {
        if (sInstance==null){
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }

    public RequestQueue getRequestQuery()
    {
        return mRequestQuery;
    }

}
