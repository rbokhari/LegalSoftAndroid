package app.legalsoft.ve.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import app.legalsoft.ve.R;


/**
 * Created by Syed.Rahman on 18/05/2015.
 */
public class rvEmployeeSalaryHolder extends RecyclerView.ViewHolder {

    TextView tSalary;
    TextView tSalaryAllowance;
    TextView tOtherAllowance;
    TextView tEmpInsurrance;
    TextView tCompanyInsurrance;
    TextView tTotal;
    TextView tCaseAllowance;
    TextView tRemarks;

    TextView tMonth;

    public rvEmployeeSalaryHolder(View itemView) {
        super(itemView);

        tMonth = (TextView) itemView.findViewById(R.id.tMonth);

        tSalary = (TextView) itemView.findViewById(R.id.tSalary);
        tSalaryAllowance = (TextView) itemView.findViewById(R.id.tSalaryAllowance);
        tOtherAllowance = (TextView) itemView.findViewById(R.id.tOtherAllowance);
        tEmpInsurrance = (TextView) itemView.findViewById(R.id.tEmpInsurrance);
        tCompanyInsurrance = (TextView) itemView.findViewById(R.id.tCompanyInsurrance);
        tTotal = (TextView) itemView.findViewById(R.id.tTotal);
        tCaseAllowance = (TextView) itemView.findViewById(R.id.tCaseAllowance);

        tRemarks = (TextView) itemView.findViewById(R.id.tRemarks);

    }
}
