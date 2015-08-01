package app.legalsoft.ve.cases;

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
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.model.CaseFollowupModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 29/07/2015.
 */
public class CaseDetailFollowup extends Fragment implements JOSNLoadedListener {

    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    static TextView mLoading;
    List<CaseFollowupModel> data = Collections.emptyList();

    private static CaseDetailFollowupAdapter adapter;

    int intCaseFileId =0;

    public CaseDetailFollowup() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.case_detail_followup_fragment, container, false);

        setupLoading(view);
        setupRecyclerView();
        setupSwipeRefresh();

        Bundle bundle = getArguments();
        intCaseFileId = bundle.getInt("caseFileId",0);

        new JSONAsyncTask(this, CONSTANTS.CASE_FOLLOWUPS_API_URL + "/" + intCaseFileId).execute();

        return view;
    }

    private void setupLoading(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.rvCaseFollowup);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);
        mLoading = (TextView) v.findViewById(R.id.tLoading);

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

        adapter = new CaseDetailFollowupAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //selectItem(position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    void refreshItem(){
        mLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        new JSONAsyncTask(this, CONSTANTS.CASE_FOLLOWUPS_API_URL + "/" + intCaseFileId).execute();
        //getData();
        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onJSONLoaded(JSONArray jsonArray) {
        data = Parser.parseCaseFollowupResponseArray(jsonArray);
        GlobalFunctions.m("data found " + data.size());
        if (data.size()==0){
            mLoading.setText("No data is found !");
        }
        else {
            mLoading.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setCaseFollowupList(data);
        }
    }

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {

    }
}
