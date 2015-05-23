package app.legalsoft.ve.employee;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import app.legalsoft.ve.R;
import app.legalsoft.ve.callbacks.EmployeesLoadedListener;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.recycler.rvEmployeeAdapter;
import app.legalsoft.ve.services.EmployeeService;
import app.legalsoft.ve.tasks.EmployeeAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;
import me.tatarka.support.job.JobInfo;
import me.tatarka.support.job.JobScheduler;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeFragment extends Fragment implements EmployeesLoadedListener {

    static RecyclerView employeeRecyclerView;
    private static rvEmployeeAdapter adapterEmployee;
    private SwipeRefreshLayout swipeRefreshLayout;
    static TextView tLoading;
    Spinner spinnerStatus;

    static ArrayList<EmployeeModel>  data = new ArrayList<>();

    private JobScheduler mJobScheduler;

    public EmployeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            mJobScheduler = JobScheduler.getInstance(MyApplication.getAppContext());

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    constructEmployeeJob();
                }
            }, 30000);

            //constructEmployeeJob();

        } catch (Exception e) {
            GlobalFunctions.showMessage(e.getMessage());
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_employee_client, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(CONSTANTS.EMPLOYEE_MODEL_PARCELABLE_KEY, data);
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment newFragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if (id == R.id.menuItem_client) {
            newFragment = new ClientFragment();
            transaction.replace(R.id.fragment_main_content, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            return true;
        }
        else if (id == R.id.menuItem_employee){
            newFragment = new EmployeeFragment();
            transaction.replace(R.id.fragment_main_content, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try {
            View view = inflater.inflate(R.layout.fragment_employee, container, false);

            setHasOptionsMenu(true);

            employeeRecyclerView = (RecyclerView) view.findViewById(R.id.EmployeeList);
            swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
            tLoading = (TextView) view.findViewById(R.id.tLoading);
            spinnerStatus = (Spinner) view.findViewById(R.id.spStatus);

            if (getResources().getConfiguration().orientation == CONSTANTS.DEVICE_ORIENTATION_PORTRAIT) {
                employeeRecyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getAppContext(), 2));
            }
            else if (getResources().getConfiguration().orientation == CONSTANTS.DEVICE_ORIENTATION_LANDSCAPE) {
                employeeRecyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getAppContext(), 3));
            }
            else{
                employeeRecyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getAppContext(), 2));
            }

            employeeRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
            employeeRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST ));

            adapterEmployee = new rvEmployeeAdapter(getActivity());

            employeeRecyclerView.setAdapter(adapterEmployee);
            employeeRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(MyApplication.getAppContext(), employeeRecyclerView, new RecyclerTouchListener.ClickListener() {

                @Override
                public void onClick(View view, int position) {

                    GlobalFunctions.m("----->>>>>" + ((EmployeeModel) data.get(position)).getEmpID() + "");
                    //selectItem(position);
                    Intent intent = new Intent(getActivity(), EmployeeDetail.class);
                    intent.putExtra("employeeId", ((EmployeeModel) data.get(position)).getEmpID());

                    startActivity(intent);
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

            if (savedInstanceState==null) {
                //GlobalFunctions.m("Loading data properly");
                data = MyApplication.getWriteableDatabase().getEmployees(spinnerStatus.getSelectedItemPosition() + "");
                if (data.isEmpty()){
                    new EmployeeAsyncTask(this).execute();
                }
            }
            else{
                data = savedInstanceState.getParcelableArrayList(CONSTANTS.EMPLOYEE_MODEL_PARCELABLE_KEY);
                //GlobalFunctions.m("Loading data Parcelable");
            }
            adapterEmployee.setEmployeeList(data);
            tLoading.setVisibility(View.GONE);
            employeeRecyclerView.setVisibility(View.VISIBLE);

            spinnerStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //GlobalFunctions.showMessage(MyApplication.getAppContext(), position + "");
                    tLoading.setVisibility(View.VISIBLE);
                    employeeRecyclerView.setVisibility(View.GONE);
                    data = MyApplication.getWriteableDatabase().getEmployees(position + "");

                    adapterEmployee.setEmployeeList(data);
                    employeeRecyclerView.setVisibility(View.VISIBLE);
                    tLoading.setVisibility(View.GONE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            return view;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    void refreshItem(){
        tLoading.setVisibility(View.VISIBLE);
        employeeRecyclerView.setVisibility(View.GONE);
        data = MyApplication.getWriteableDatabase().getEmployees(spinnerStatus.getSelectedItemPosition() + "");
        adapterEmployee.setEmployeeList(data);
        tLoading.setVisibility(View.GONE);
        employeeRecyclerView.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);
    }

    private void constructEmployeeJob(){
        JobInfo.Builder builder = new JobInfo.Builder(CONSTANTS.EMPLOYEE_JOB_ID,
                        new ComponentName(MyApplication.getAppContext(), EmployeeService.class));

        builder.setPeriodic(CONSTANTS.EMPLOYEE_JOB_SERVICE_PERIODIC_INTERVAL)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
                //.setPersisted(true);

        mJobScheduler.schedule(builder.build());
    }

    @Override
    public void onEmployeeLoaded(ArrayList<EmployeeModel> listEmployee) {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        adapterEmployee.setEmployeeList(listEmployee);
    }
}
