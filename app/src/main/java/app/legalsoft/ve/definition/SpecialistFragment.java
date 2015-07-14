package app.legalsoft.ve.definition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.ClientModel;
import app.legalsoft.ve.model.SpecialistModel;
import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.recycler.rvClientAdapter;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 14/07/2015.
 */
public class SpecialistFragment extends Fragment {

    static RecyclerView specialistRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static rvSpecialistAdapter adapter;
    static TextView mLoading;

    public SpecialistFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.specialist_list_fragment, container, false);

        specialistRecyclerView = (RecyclerView) view.findViewById(R.id.rvSpecialist);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mLoading = (TextView) view.findViewById(R.id.tLoading);
        specialistRecyclerView.setVisibility(View.VISIBLE);
        specialistRecyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));

        adapter = new rvSpecialistAdapter(getActivity());

        specialistRecyclerView.setAdapter(adapter);

        specialistRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST ));

        specialistRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), specialistRecyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(getApplicationContext(), "onClick " + position, Toast.LENGTH_SHORT).show();

                //selectItem(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(), "onLongClick " + position, Toast.LENGTH_SHORT).show();
            }
        }));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });

        getData();
        return view;

    }

    void refreshItem(){
        mLoading.setVisibility(View.VISIBLE);
        specialistRecyclerView.setVisibility(View.GONE);
        getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    public static List<SpecialistModel> getData(){
        final List<SpecialistModel>  data = new ArrayList<>();
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();

        if (requestQueue!=null) {
            JsonArrayRequest request = new JsonArrayRequest(CONSTANTS.SPECIALIST_API_URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Iterator<JSONObject> jsonObjectIterator = response.iterator();
                    //Toast.makeText(MyApplication.getAppContext(), "Response", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < response.length(); i++) {
                        //response.getJSONObject(i);
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            SpecialistModel model = new SpecialistModel();
                            model.SpecializeID = jsonObject.getInt("specializeID");
                            model.SpecializeCode = jsonObject.getString("specializeCode");
                            model.SpecializeCode_EN = jsonObject.getString("specializeCode_EN");
                            model.IsActive = jsonObject.getInt("isActive");

                            data.add(model);
                        } catch (JSONException e) {
                            Log.d("error", "<<<<<<<<<<<<< getData() -<<<<<<<<<< ");
                            e.printStackTrace();
                        }
                    }
                    adapter.setSpecialistList(data);
                    mLoading.setVisibility(View.GONE);
                    specialistRecyclerView.setVisibility(View.VISIBLE);
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
            requestQueue.add(request);
        }
        /*for (int i=0; i<titles.length && i<titles.length; i++){
            InformationModel current = new InformationModel();
            current.ItemName = titles[i];
            current.ItemId = icons[0];
            data.add(current);
        }*/
        return data;
    }

}
