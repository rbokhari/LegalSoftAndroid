package app.legalsoft.ve;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import app.legalsoft.ve.client.ClientFragment;
import app.legalsoft.ve.employee.EmployeeFragment;
import app.legalsoft.ve.model.HomeMenuModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.recycler.rvAdapter;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;


public class MasterActivity extends ActionBarActivity {

    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    //Fragment drawerFragmentView ;
    NavigationDrawerFragment drawerFragment;

    private static rvAdapter adapter;
    String[] mTitle;
    int[] mIcon;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_master);

            //GlobalFunctions.showMessage(MyApplication.getAppContext(), "onCreate");

            //Intent intent = getIntent();
            //Integer intentValue = intent.getIntExtra("default_fragment", 1);
            //View fragment =findViewById(R.id.fragment_main_content);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

            toolbar = (Toolbar) findViewById(R.id.app_bar);

            //drawerFragmentView = getSupportFragmentManager().findFragmentById(R.layout.fragment_navigation_drawer);

            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            drawerFragment =
                    (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

            drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout)findViewById(R.id.drawer_layout), toolbar);

            recyclerView = (RecyclerView) findViewById(R.id.rMenu);
            Resources res = getResources();

            mTitle =res.getStringArray(R.array.home_menu); // new String[]{"Definition", "Staff", "Case", "Forms", "Reports", "Validation"};
            mIcon = new int[]{R.drawable.ic_action_edit, R.drawable.ic_action_add_group, R.drawable.ic_action_collection, R.drawable.ic_action_dock, R.drawable.ic_action_important, R.drawable.ic_action_read};

            adapter = new rvAdapter(getApplicationContext(),getData());

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

                @Override
                public void onClick(View view, int position) {

                    //view.getParent().clearChildFocus(view);

                    view.setBackgroundColor(Color.LTGRAY);
                    //view.isSelected();
                    selectItem(position);
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            //selectItem(intentValue);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            GlobalFunctions.showMessage(MyApplication.getAppContext(), "MasterActivity: " + e.getMessage());
        }
    }

    private void selectItem(int position) {
        Fragment newFragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        View v;
        for (int i=0; i <= recyclerView.getAdapter().getItemCount(); i++)
        {
            v = recyclerView.getChildAt(i);
            if (v!=null) {
                //recyclerView.getAdapter()
                v.setBackgroundColor(Color.TRANSPARENT);
            }
        }


        switch (position) {
            case 0:

                break;
            case 1:
                newFragment = new EmployeeFragment();
                transaction.replace(R.id.fragment_main_content, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                break;
/*
            case 2:
                newFragment = new f3();
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case 3:
                newFragment = new f4();
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
*/
        }

        v = recyclerView.getChildAt(position);
        if (v!=null) {
            v.setBackgroundColor(Color.LTGRAY);
            //TextView txtview = (TextView) v.findViewById(R.id.mText);
            //Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
            //txtview.setTypeface(font);
            //txtview.setTextColor(Color.BLUE);
        }

        //DrawerList.setItemChecked(position, true);
        //setTitle(ListTitles[position]);
        drawerLayout.closeDrawer(Gravity.LEFT);
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
        getMenuInflater().inflate(R.menu.menu_master, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Fragment newFragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        else if (id == R.id.menuItem_client) {
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
