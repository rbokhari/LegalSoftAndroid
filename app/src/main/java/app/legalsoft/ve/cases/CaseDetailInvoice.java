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
import app.legalsoft.ve.model.InvoiceModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 01/08/2015.
 */
public class CaseDetailInvoice extends Fragment implements JOSNLoadedListener {

    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    static TextView mLoading;

    List<InvoiceModel> data = Collections.emptyList();

    public static CaseDetailInvoiceAdapter adapter;

    int intCaseFileId =0;

    public CaseDetailInvoice() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.case_detail_invoice_fragment, container, false);

        setupLoading(view);
        setupRecyclerView();
        setupSwipeRefresh();

        Bundle bundle = getArguments();
        intCaseFileId = bundle.getInt("caseFileId",0);

        new JSONAsyncTask(this, CONSTANTS.INVOICE_CASE_FILE_API_URL + "/" + intCaseFileId).execute();

        return view;
    }

    private void setupLoading(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.rvCaseInvoice);
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

        adapter = new CaseDetailInvoiceAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
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
        new JSONAsyncTask(this, CONSTANTS.INVOICE_CASE_FILE_API_URL + "/" + intCaseFileId).execute();
        //getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onJSONLoaded(JSONArray jsonArray) {
        data = Parser.parseInvoiceResponseArray(jsonArray);
        GlobalFunctions.m("data found invoice " + data.size());
        if (data.size()==0){
            mLoading.setText("No data is found !");
        }
        else {
            mLoading.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setInvoiceList(data);
        }
    }

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {

    }
}
