package app.legalsoft.ve.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import app.legalsoft.ve.R;
import app.legalsoft.ve.cases.CaseDetailGeneral;
import app.legalsoft.ve.model.CaseFileModel;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 27/07/2015.
 */
public class CaseDetailTabPagerAdapter extends FragmentPagerAdapter {
    String[] tabs;
    CaseFileModel model;
    TextView txtName;

    public CaseDetailTabPagerAdapter(FragmentManager fm, CaseFileModel model) {
        super(fm);
        tabs = MyApplication.getsInstance().getResources().getStringArray(R.array.tab_case_detail);
        this.model = model;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        //b.clear();
        //b.putInt("EmployeeId", employeeModel.getEmpID());
        b.putAll(model.toBundle());

        switch (position){
            case 0:
                CaseDetailGeneral caseDetailGeneral = new CaseDetailGeneral();
                caseDetailGeneral.setArguments(b);
                return caseDetailGeneral;

            case 1:
                CaseDetailGeneral caseDetailGeneral1 = new CaseDetailGeneral();
                caseDetailGeneral1.setArguments(b);
                return caseDetailGeneral1;
            case 2:
                CaseDetailGeneral caseDetailGeneral2 = new CaseDetailGeneral();
                caseDetailGeneral2.setArguments(b);
                return caseDetailGeneral2;
        }
        return  null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

}
