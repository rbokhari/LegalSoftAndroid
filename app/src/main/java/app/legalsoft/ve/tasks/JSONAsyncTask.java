package app.legalsoft.ve.tasks;

import android.os.AsyncTask;

import org.json.JSONArray;

import java.util.ArrayList;

import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.util.AppDataLoader;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 16/07/2015.
 */
public class JSONAsyncTask extends AsyncTask<Void, Void, JSONArray> {

    private JOSNLoadedListener jsonLoadedListener;
    private String url;

    public JSONAsyncTask(JOSNLoadedListener jsonLoadedListener, String url) {
        this.jsonLoadedListener = jsonLoadedListener;
        this.url = url;
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        JSONArray jsonArray = AppDataLoader.getJSONArray(url);

        return jsonArray;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArrays) {
        if (jsonLoadedListener!=null){
            GlobalFunctions.m("onPostExecute inside");
            jsonLoadedListener.onJSONLoaded(jsonArrays);
        }
    }
}
