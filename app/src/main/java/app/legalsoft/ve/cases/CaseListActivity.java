package app.legalsoft.ve.cases;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import app.legalsoft.ve.R;
import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.definition.DefenderAdapter;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.model.CaseFileModel;
import app.legalsoft.ve.model.ClientModel;
import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 25/07/2015.
 */
public class CaseListActivity extends AppCompatActivity implements JOSNLoadedListener, SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static CaseListAdapter adapter;
    static TextView mLoading;

    List<CaseFileModel> caseFileModelList;

    int intTypeId = CONSTANTS.CaseTypeID.CASE_FILE;
    int intStatusId = CONSTANTS.CaseStatusID.CASE_BEFORE_COURT_OPEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_list_activity);

        setupToolbar();
        setupRecyclerView();
        setupSwipeRefreshLayout();
        setupLoading();

        setupIntent();
        setupAsyncTask();
    }

    private void setupLoading(){
        mLoading = (TextView) findViewById(R.id.tLoading);

        mLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        adapter = new CaseListAdapter(MyApplication.getAppContext());
        recyclerView.setAdapter(adapter);

    }

    private void setupIntent(){
        Intent intent = getIntent();
        intTypeId = intent.getIntExtra("TypeId", CONSTANTS.CaseTypeID.CASE_FILE);
        intStatusId =  intent.getIntExtra("StatusId", CONSTANTS.CaseStatusID.CASE_BEFORE_COURT_OPEN);
    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Legal Soft");
    }

    private void setupRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.rvCaseFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MyApplication.getAppContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MyApplication.getAppContext(), CaseDetailActivity.class);
                intent.putExtra("casefileData", caseFileModelList.get(position).toBundle());
                intent.putExtra("caseFileNo", caseFileModelList.get(position).getFileNo());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void setupSwipeRefreshLayout(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });
    }

    private void setupAsyncTask(){
        new JSONAsyncTask(this, CONSTANTS.CASE_LIST_BY_TYPE_STATUS_API_URL + intTypeId).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_defender, menu);

        final MenuItem searchItem = menu.findItem(R.id.mDefenderSearch);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(this);

        return true;

    }

    void refreshItem(){
        mLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        setupAsyncTask();
        //getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onJSONLoaded(JSONArray jsonArray) {
        caseFileModelList = Parser.parseCaseListResponseArray(jsonArray);
        GlobalFunctions.m("data found case list " + caseFileModelList.size());
        if (caseFileModelList.size()==0){
            mLoading.setText("No data is found !");
        }
        else {
            mLoading.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setCaseFileList(caseFileModelList);
        }
    }

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<CaseFileModel> filteredModelList = filter(caseFileModelList, newText);
        adapter.animateTo(filteredModelList);
        recyclerView.scrollToPosition(0);
        return true;
    }

    private List<CaseFileModel> filter(List<CaseFileModel> models, String query) {
        query = query.toLowerCase();
        final List<CaseFileModel> filteredModelList = new ArrayList<>();
        for (CaseFileModel model : models) {
            if (String.valueOf(model.getFileNo()).contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
