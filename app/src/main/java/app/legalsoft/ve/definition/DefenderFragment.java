package app.legalsoft.ve.definition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 17/07/2015.
 */
public class DefenderFragment extends Fragment implements JOSNLoadedListener {

    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static DefenderAdapter adapter;
    static TextView mLoading;

    public DefenderFragment() {;}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.defender_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvDefender);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mLoading = (TextView) view.findViewById(R.id.tLoading);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));

        adapter = new DefenderAdapter(getActivity());

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

        new JSONAsyncTask(this, CONSTANTS.DEFENDER_API_URL).execute();

        //getData();
        return view;

    }

    void refreshItem(){
        mLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        new JSONAsyncTask(this, CONSTANTS.DEFENDER_API_URL).execute();
        //getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onJSONLoaded(JSONArray jsonArray) {
        List<DefenderModel> data = Parser.parseDefenderResponseArray(jsonArray);
        GlobalFunctions.m("data found " + data.size());
        if (data.size()==0){
            mLoading.setText("No data is found !");
        }
        else {
            mLoading.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setDefenderList(data);
        }
    }


}
