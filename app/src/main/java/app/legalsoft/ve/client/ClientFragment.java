package app.legalsoft.ve.client;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.recycler.rvClientAdapter;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.MyApplication;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClientFragment extends Fragment {

    static RecyclerView clientRecyclerView;
    //private static final String urlData = "http://192.168.1.37:84/api/client";//   "http://192.168.159.1:90/api/supplier";
    //private static final String urlData = "http://192.168.159.1:84/api/client";
    private static rvClientAdapter adapterClient;
    private SwipeRefreshLayout swipeRefreshLayout;
    static TextView mLoading;

    public ClientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_employee_client, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client, container, false);
        setHasOptionsMenu(true);

        clientRecyclerView = (RecyclerView) view.findViewById(R.id.ClientList);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mLoading = (TextView) view.findViewById(R.id.tLoading);
        clientRecyclerView.setVisibility(View.VISIBLE);
        clientRecyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));

        adapterClient = new rvClientAdapter(getActivity());

        clientRecyclerView.setAdapter(adapterClient);

        clientRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST ));

        clientRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), clientRecyclerView, new RecyclerTouchListener.ClickListener() {

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
        clientRecyclerView.setVisibility(View.GONE);
        getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    public static List<ClientModel> getData(){
        final List<ClientModel>  data = new ArrayList<>();
        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQuery();

        if (requestQueue!=null) {
            JsonArrayRequest request = new JsonArrayRequest(CONSTANTS.CLIENTS_API_URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //Iterator<JSONObject> jsonObjectIterator = response.iterator();
                    //Toast.makeText(MyApplication.getAppContext(), "Response", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < response.length(); i++) {
                        //response.getJSONObject(i);
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ClientModel clientModel = new ClientModel();
                            clientModel.ClientName = jsonObject.getString("clientName");
                            clientModel.ClientCode = jsonObject.getString("clientCode");
                            clientModel.ContactGSM = jsonObject.getString("contactGSM");
                            clientModel.ContactPerson = jsonObject.getString("contactPerson");

                            data.add(clientModel);
                        } catch (JSONException e) {
                            Log.d("error", "<<<<<<<<<<<<< getData() -<<<<<<<<<< ");
                            e.printStackTrace();
                        }
                    }
                    adapterClient.setClientList(data);
                    mLoading.setVisibility(View.GONE);
                    clientRecyclerView.setVisibility(View.VISIBLE);
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
