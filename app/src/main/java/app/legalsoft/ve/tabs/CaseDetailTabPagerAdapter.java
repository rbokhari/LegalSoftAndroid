package app.legalsoft.ve.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import app.legalsoft.ve.R;
import app.legalsoft.ve.cases.CaseDetailAttachment;
import app.legalsoft.ve.cases.CaseDetailFollowup;
import app.legalsoft.ve.cases.CaseDetailGeneral;
import app.legalsoft.ve.cases.CaseDetailInvoice;
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
        b.clear();
        //b.putInt("EmployeeId", employeeModel.getEmpID());


        switch (position){
            case 0:
                b.putAll(model.toBundle());
                CaseDetailGeneral caseDetailGeneral = new CaseDetailGeneral();
                caseDetailGeneral.setArguments(b);
                return caseDetailGeneral;
            case 1:
                b.clear();
                b.putInt("caseFileId", model.getCaseFileID());
                CaseDetailFollowup caseDetailFollowup = new CaseDetailFollowup();
                caseDetailFollowup.setArguments(b);
                return caseDetailFollowup;
            case 2:
                b.clear();
                b.putInt("caseFileId", model.getCaseFileID());
                CaseDetailInvoice caseDetailInvoice = new CaseDetailInvoice();
                caseDetailInvoice.setArguments(b);
                return caseDetailInvoice;
            case 3:
                b.clear();
                b.putInt("caseFileId", model.getCaseFileID());
                CaseDetailAttachment caseDetailAttachment = new CaseDetailAttachment();
                caseDetailAttachment.setArguments(b);
                return caseDetailAttachment;

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
