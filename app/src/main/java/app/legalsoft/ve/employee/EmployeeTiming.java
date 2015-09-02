package app.legalsoft.ve.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.model.EmployeeTimingModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.MyApplication;


public class EmployeeTiming extends Fragment implements JOSNLoadedListener {

    RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    static TextView tLoading;

    private static EmployeeTimingAdapter adapter;
    private static List<EmployeeTimingModel> data;

    public EmployeeTiming() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_timing, container, false);

        setupLoading(view);
        setupSwipeRefresh();
        setupRecyclerView();


        new JSONAsyncTask(this, CONSTANTS.EMPLOYEE_TIMING_API_URL).execute();

        return view;
    }

    private void setupLoading(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.rvTiming);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);
        tLoading = (TextView) v.findViewById(R.id.tLoading);

    }

    private void setupSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });

    }

    private void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        adapter = new EmployeeTimingAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //selectItem(position);
                startActivity(new Intent(getActivity(), EmployeeTimingDetail.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    void refreshItem(){
        tLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        new JSONAsyncTask(this, CONSTANTS.EMPLOYEE_TIMING_API_URL).execute();
        //getData();
        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onJSONLoaded(JSONArray jsonArray) {

        data = Parser.parseEmployeeTimingResponseArray(jsonArray);

        if (data.size()==0){
            tLoading.setText("No data is found !");
        }
        else {
            tLoading.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setTimingList(data);
        }

    }

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {

    }
}
