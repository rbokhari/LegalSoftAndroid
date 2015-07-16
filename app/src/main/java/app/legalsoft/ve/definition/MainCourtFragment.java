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
import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.model.SpecialistModel;
import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 15/07/2015.
 */
public class MainCourtFragment extends Fragment {

    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static rvMainCourtAdapter adapter;
    static TextView mLoading;

    public MainCourtFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maincourt_list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvMainCourt);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mLoading = (TextView) view.findViewById(R.id.tLoading);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));

        adapter = new rvMainCourtAdapter(getActivity());

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST ));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {

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
        recyclerView.setVisibility(View.GONE);
        getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    public static List<MainCourtModel> getData(){
        final List<MainCourtModel>  data = new ArrayList<>();
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();

        if (requestQueue!=null) {
            JsonArrayRequest request = new JsonArrayRequest(CONSTANTS.MAINCOURT_API_URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Iterator<JSONObject> jsonObjectIterator = response.iterator();
                    //Toast.makeText(MyApplication.getAppContext(), "Response", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < response.length(); i++) {
                        //response.getJSONObject(i);
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            MainCourtModel model = new MainCourtModel();
                            model.MainCourtID = jsonObject.getInt("mainCourtID");
                            model.MainCourtCode = jsonObject.getString("mainCourtCode");
                            model.MainCourtCode_EN = jsonObject.getString("mainCourtCode_EN");
                            model.MainCourtSpecialist = jsonObject.getString("mainCourtSpecialist");
                            model.MainCourtLocation = jsonObject.getString("mainCourtLocation");
                            model.IsActive = jsonObject.getInt("isActive");

                            data.add(model);
                        } catch (JSONException e) {
                            Log.d("error", "<<<<<<<<<<<<< getData() -<<<<<<<<<< ");
                            e.printStackTrace();
                        }
                    }
                    adapter.setMainCoutList(data);
                    mLoading.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
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
