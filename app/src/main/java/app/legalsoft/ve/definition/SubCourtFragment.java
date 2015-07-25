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
import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.model.SubCourtModel;
import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.AppDataLoader;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 16/07/2015.
 */
public class SubCourtFragment extends Fragment implements JOSNLoadedListener {

    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static SubCourtAdapter adapter;
    static TextView mLoading;

    public SubCourtFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subcourt_list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvSubCourt);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mLoading = (TextView) view.findViewById(R.id.tLoading);
        recyclerView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));

        adapter = new SubCourtAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                //selectItem(position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });

        new JSONAsyncTask(this, CONSTANTS.SUBCOURT_API_URL).execute();

        return view;
    }

    void refreshItem(){
        mLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        //getData();
        new JSONAsyncTask(this, CONSTANTS.SUBCOURT_API_URL).execute();
        swipeRefreshLayout.setRefreshing(false);
    }
/*
    public static List<SubCourtModel> getData(){
        List<SubCourtModel>  data = new AppDataLoader().getSubCourt();
        return data;
    }
*/

    @Override
    public void onJSONLoaded(JSONArray jsonArray) {
        List<SubCourtModel>  data = Parser.parseSubCourtResponseArray(jsonArray);
        GlobalFunctions.m("data found " + data.size());
        if (data.size()==0){
            mLoading.setText("No data is found !");
        }
        else {
            mLoading.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setSubCoutList(data);
        }
    }

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {

    }
}
