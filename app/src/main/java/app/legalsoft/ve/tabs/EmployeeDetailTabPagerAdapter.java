package app.legalsoft.ve.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.style.BulletSpan;
import android.widget.TextView;

import app.legalsoft.ve.employee.EmployeeDetailFinance;
import app.legalsoft.ve.employee.EmployeeDetailGeneral;
import app.legalsoft.ve.R;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 13/04/2015.
 */
public class EmployeeDetailTabPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;
    EmployeeModel employeeModel;
    TextView txtName;

    public EmployeeDetailTabPagerAdapter(FragmentManager fm, EmployeeModel employeeModel) {
        super(fm);
        tabs = MyApplication.getsInstance().getResources().getStringArray(R.array.tab_employee_detail);
        this.employeeModel = employeeModel;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle b = new Bundle();
        //b.clear();
        //b.putInt("EmployeeId", employeeModel.getEmpID());
        b.putAll(employeeModel.toBundle());

        switch (position){
            case 0:
                EmployeeDetailGeneral empGeneral = new EmployeeDetailGeneral();
                empGeneral.setArguments(b);
                return empGeneral;

            case 1:
                EmployeeDetailFinance empFinance = new EmployeeDetailFinance();
                empFinance.setArguments(b);
                return empFinance;
            case 2:

                EmployeeDetailGeneral empGeneral1 = new EmployeeDetailGeneral();
                empGeneral1.setArguments(b);
                return empGeneral1;
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
