package app.legalsoft.ve;

import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import app.legalsoft.ve.client.ClientFragment;
import app.legalsoft.ve.dashboard.DashboardFragment;
import app.legalsoft.ve.definition.MainCourtFragment;
import app.legalsoft.ve.definition.SpecialistFragment;
import app.legalsoft.ve.definition.SubCourtFragment;
import app.legalsoft.ve.employee.EmployeeFragment;
import app.legalsoft.ve.util.GlobalFunctions;


public class MasterActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    //RecyclerView recyclerView;
    //Fragment drawerFragmentView ;
    //NavigationDrawerFragment drawerFragment;
    private NavigationView navigationView;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_master);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            navigationView = (NavigationView) findViewById(R.id.navigation_view);

            toolbar = (Toolbar) findViewById(R.id.app_bar);

            //drawerFragmentView = getSupportFragmentManager().findFragmentById(R.layout.fragment_navigation_drawer);

            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            if (GlobalFunctions.mNavposition==0)
                selectItem(R.id.mnuDashboard);
            else
                selectItem(GlobalFunctions.mNavposition);


            final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close){

                @Override
                public void onDrawerClosed(View drawerView) {
                    // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                    super.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                    super.onDrawerOpened(drawerView);
                }
            };

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    //Checking if the item is in checked state or not, if not make it in checked state
                    if (menuItem.isChecked())
                        menuItem.setChecked(false);
                    else
                        menuItem.setChecked(true);

                    //Closing drawer on item click
                    drawerLayout.closeDrawers();
                    selectItem(menuItem.getItemId());
                    actionBarDrawerToggle.syncState();
                    return true;
                }
            });



            //Setting the actionbarToggle to drawer layout
            drawerLayout.setDrawerListener(actionBarDrawerToggle);

            //calling sync state is necessay or else your hamburger icon wont show up
            actionBarDrawerToggle.syncState();

        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            GlobalFunctions.showMessage("MasterActivity: " + e.getMessage());
        }
    }

    private void selectItem(int position) {
        Fragment newFragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        GlobalFunctions.mNavposition = position;

        switch (position){

            case R.id.mnuDashboard:
                GlobalFunctions.showMessage("dashboard");
                Fragment fragDashboard = new DashboardFragment();
                transaction.replace(R.id.fragment_main_content, fragDashboard)
                        .commit();

                break;
            case R.id.mnuSpecialist:
                Fragment fragSpec = new SpecialistFragment();
                transaction.replace(R.id.fragment_main_content, fragSpec)
                        .commit();

                break;
            case R.id.mnuMainCourt:
                Fragment fragMain = new MainCourtFragment();
                transaction.replace(R.id.fragment_main_content, fragMain)
                        .commit();

                break;
            case R.id.mnuSubCourt:
                Fragment fragSubCourt = new SubCourtFragment();
                transaction
                        .replace(R.id.fragment_main_content, fragSubCourt)
                        .commit();
                break;
            case R.id.mnuDefender:
                break;
            case R.id.mnuEmployee:
                Fragment fragEmployee = new EmployeeFragment();
                transaction.replace(R.id.fragment_main_content, fragEmployee)
                        //.addToBackStack(null)
                        .commit();

                break;
            case R.id.mnuClient:
                Fragment fragClient = new ClientFragment();
                transaction.replace(R.id.fragment_main_content, fragClient)
                        .commit();
                break;
            case R.id.mnuCaseAll:
                break;
            case R.id.mnuCaseFollowup:
                break;
            case R.id.mnuCaseFollowup2:
                break;
            case R.id.mnuCaseAdministration:
                break;
            case R.id.mnuSearch:
                break;
            case R.id.mnuCloseCase:
                break;
            case R.id.mnuNextHearing:
                break;
            case R.id.mnuJudgementDate:
                break;
            case R.id.mnuGeneralReport:
                break;
            case R.id.mnuDailyTimeSheet:
                break;
            case R.id.mnuEmployeeAllowance:
                break;
            case R.id.mnuEmployeeLeave:
                break;
            case R.id.mnuEmployeeLoan:
                break;
            case R.id.mnuInbox:
                break;
            case R.id.mnuOfficeIncome:
                break;
            case R.id.mnuOfficeExpense:
                break;
            case R.id.mnuMonthlyExpense:
                break;
            case R.id.mnuOptions:
                break;
            case R.id.mnuContactUs:

                Fragment fragContact = new Fragment();
                transaction.replace(R.id.fragment_main_content, fragContact)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.mnuSignOut:
                break;

            default:
                break;
        }
        //navigationView.getMenu()
        navigationView.getMenu().findItem(position).setChecked(true);

        drawerLayout.closeDrawer(Gravity.LEFT);
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
        } else if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        } else if (id == R.id.menuItem_client) {
            newFragment = new ClientFragment();
            transaction.replace(R.id.fragment_main_content, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            return true;
        } else if (id == R.id.menuItem_employee) {
            newFragment = new EmployeeFragment();
            transaction.replace(R.id.fragment_main_content, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
