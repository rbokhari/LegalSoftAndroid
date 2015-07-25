package app.legalsoft.ve.tasks;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.util.AppDataLoader;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 24/07/2015.
 */
public class JSONObjectAsyncTask extends AsyncTask<Void, Void, JSONObject> {

    private JOSNLoadedListener jsonLoadedListener;
    private String url;

    public JSONObjectAsyncTask(JOSNLoadedListener jsonLoadedListener, String url) {
        this.jsonLoadedListener = jsonLoadedListener;
        this.url = url;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        JSONObject jsonObject = AppDataLoader.getJSONObject(url);

        return jsonObject;

    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        if (jsonLoadedListener!=null){
            GlobalFunctions.m("onPostExecute inside");
            jsonLoadedListener.onJSONLoadedObject(jsonObject);
        }
    }
}
