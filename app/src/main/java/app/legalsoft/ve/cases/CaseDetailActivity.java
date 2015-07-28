package app.legalsoft.ve.cases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.CaseFileModel;
import app.legalsoft.ve.tabs.CaseDetailTabPagerAdapter;
import app.legalsoft.ve.tabs.EmployeeDetailTabPagerAdapter;
import app.legalsoft.ve.tabs.SlidingTabLayout;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 25/07/2015.
 */
public class CaseDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    static ViewPager mPager;
    static SlidingTabLayout mTabs;
    static int currentTab = 0;
    static FragmentManager fragmentManager;

    static CaseFileModel caseFileModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_detail_activity);

        setupLoading();
        setupToolbar();


        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("casefileData");

        caseFileModel = new CaseFileModel().fromBundle(b);

        //GlobalFunctions.m(caseFileModel.getFileNo() + "");

        setupIntent();
        setupTabs();
    }

    private void setupLoading(){
        //caseFileModel = new CaseFileModel();
        fragmentManager = getSupportFragmentManager();

        mPager = (ViewPager) findViewById(R.id.tabPagerCaseDetail);
    }

    private void setupIntent(){
    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Case Detail");
    }

    private void setupTabs(){
        mTabs = (SlidingTabLayout) findViewById(R.id.caseDetailTabs);
        mTabs.setDistributeEvenly(true);
        mPager.setAdapter(new CaseDetailTabPagerAdapter(fragmentManager,caseFileModel));
        mTabs.setViewPager(mPager);
    }


}
