package app.legalsoft.ve.definition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
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
public class DefenderFragment extends Fragment implements JOSNLoadedListener, SearchView.OnQueryTextListener {

    static RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static DefenderAdapter adapter;
    static TextView mLoading;

    //private GestureDetectorCompat mDetector;
    List<DefenderModel> data;

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

        setHasOptionsMenu(true);

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                //selectItem(position);
                GlobalFunctions.m("positon : " + position);
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

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_defender, menu);

        final MenuItem searchItem = menu.findItem(R.id.mDefenderSearch);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(this);
        /*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //votre code ici
                GlobalFunctions.m("submit");
                //invalidateOptionsMenu();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                GlobalFunctions.m("text change :"  + s);
                //if (s.length() > 0) {
                    List<DefenderModel> filterModels = data;
                    filterModels = filter(data, s);

                if (filterModels.size()==0) filterModels = data;

                GlobalFunctions.m("filter size :" + filterModels.size());
                GlobalFunctions.m("data size :" + data.size());
                    adapter.animateTo(filterModels);
                    recyclerView.scrollToPosition(0);
                    //adapter.setDefenderList(filterModels);
                    return true;
                //} else {
                    //adapter.setDefenderList(data);
                //    adapter.animateTo(data);
                //    recyclerView.scrollToPosition(0);
                //    return false;
                //}
                //return true;
            }
        });*/
        super.onCreateOptionsMenu(menu, inflater);
    }

    private List<DefenderModel> filter(List<DefenderModel> models, String query) {
        query = query.toLowerCase();

        final List<DefenderModel> filteredModelList = new ArrayList<>();
        for (DefenderModel model : models) {
            if (model.toString().toLowerCase().contains(query) || model.getDefenderCode().toLowerCase().contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
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
        data = Parser.parseDefenderResponseArray(jsonArray);
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

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<DefenderModel> filteredModelList = filter(data, newText);
        adapter.animateTo(filteredModelList);
        recyclerView.scrollToPosition(0);
        //GlobalFunctions.m("filter size :" + filteredModelList.size());
        //GlobalFunctions.m("data size :" + data.size());
        return true;
    }
}
