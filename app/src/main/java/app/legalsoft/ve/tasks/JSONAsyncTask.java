package app.legalsoft.ve.tasks;

import android.os.AsyncTask;

import org.json.JSONArray;

import java.util.ArrayList;

import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.util.AppDataLoader;

/**
 * Created by Syed.Rahman on 16/07/2015.
 */
public class JSONAsyncTask extends AsyncTask<Void, Void, JSONArray> {

    private JOSNLoadedListener jsonLoadedListener;

    public JSONAsyncTask(JOSNLoadedListener jsonLoadedListener) {
        this.jsonLoadedListener = jsonLoadedListener;
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        JSONArray jsonArray = AppDataLoader.getSubCourt();

        return jsonArray;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArrays) {
        if (jsonLoadedListener!=null){
            jsonLoadedListener.onJSONLoaded(jsonArrays);
        }
    }
}
