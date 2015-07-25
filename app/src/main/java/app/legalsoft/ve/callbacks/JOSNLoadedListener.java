package app.legalsoft.ve.callbacks;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Syed.Rahman on 16/07/2015.
 */
public interface JOSNLoadedListener {
    public void onJSONLoaded(JSONArray jsonArray);

    public void onJSONLoadedObject(JSONObject jsonObject);
}
