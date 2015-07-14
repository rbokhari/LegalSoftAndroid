package app.legalsoft.ve;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import app.legalsoft.ve.callbacks.OfficeExpensesLoadedListener;
import app.legalsoft.ve.model.HomeMenuModel;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.recycler.rvAdapter;
import app.legalsoft.ve.services.EmployeeService;
import app.legalsoft.ve.services.OfficeExpenseService;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.MyApplication;
import me.tatarka.support.job.JobInfo;
import me.tatarka.support.job.JobScheduler;


public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private static rvAdapter adapter;
    String[] mTitle;
    int[] mIcon;
    private JobScheduler mJobScheduler;

    public void HomeActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mJobScheduler = JobScheduler.getInstance(MyApplication.getAppContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                constructOfficeExpenseJob();
            }
        }, 99000);

        recyclerView = (RecyclerView) findViewById(R.id.rMenu);
        Resources res = getResources();

        mTitle =res.getStringArray(R.array.home_menu);
        mIcon = new int[]{R.drawable.ic_action_edit,
                R.drawable.ic_action_add_group,
                R.drawable.ic_action_collection,
                R.drawable.ic_action_dock,
                R.drawable.ic_action_important,
                R.drawable.ic_action_read,
                R.drawable.ic_pin_drop_grey600_18dp,
                R.drawable.ic_action_read};

        adapter = new rvAdapter(getApplicationContext(),getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST ));


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:

                        break;
                    case 1:
                        Intent intent = new Intent(getApplicationContext(),MasterActivity.class);
                        //intent.putExtra("default_fragment", position);
                        startActivity(intent);
                        break;

                    case 6:
                        Intent intent1 = new Intent(getApplicationContext(),MasterActivity.class);
                        //intent.putExtra("default_fragment", position);
                        startActivity(intent1);
                        break;
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    private ArrayList<HomeMenuModel> getData()
    {
        ArrayList<HomeMenuModel> menu=new ArrayList<HomeMenuModel>();
        for (int i=0;i<mTitle.length; i++)
        {
            menu.add(new HomeMenuModel(mTitle[i], mIcon[i]));
        }
        return menu;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            startActivity(new Intent(this, LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void constructOfficeExpenseJob(){
        JobInfo.Builder builder = new JobInfo.Builder(CONSTANTS.OFFICEEXPENSE_JOB_ID,
                new ComponentName(MyApplication.getAppContext(), OfficeExpenseService.class));

        builder.setPeriodic(CONSTANTS.OFFICEEXPENSE_JOB_SERVICE_PERIODIC_INTERVAL)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        //.setPersisted(true);

        mJobScheduler.schedule(builder.build());
    }

}
