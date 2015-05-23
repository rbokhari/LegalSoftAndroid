package app.legalsoft.ve.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.OfficeExpenseDetailModel;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 18/05/2015.
 */
public class rvEmployeeSalaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;

    List<OfficeExpenseDetailModel> dataList = Collections.emptyList();

    public rvEmployeeSalaryAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setEmployeeSalaryList(List<OfficeExpenseDetailModel> listExpenseDetail){
        this.dataList = listExpenseDetail;
        notifyItemRangeChanged(0, listExpenseDetail.size());
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return CONSTANTS.RECYCLERVIEW_VIEWTYPE_HEADER;
        }
        else
        {
            if (dataList.get(position).YearName.equals(dataList.get(position-1).YearName)) {
                return CONSTANTS.RECYCLERVIEW_VIEWTYPE_ITEM;
            }
            else {
                return CONSTANTS.RECYCLERVIEW_VIEWTYPE_HEADER;
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType ==  CONSTANTS.RECYCLERVIEW_VIEWTYPE_HEADER){
            View view = layoutInflater.inflate(R.layout.employee_salary_section_rv, parent, false);
            rvEmployeeSalarySectionHolder holder = new rvEmployeeSalarySectionHolder(view);
            return holder;

        }
        else if (viewType == CONSTANTS.RECYCLERVIEW_VIEWTYPE_ITEM) {
            View view = layoutInflater.inflate(R.layout.employee_salary_rv, parent, false);
            rvEmployeeSalaryHolder holder = new rvEmployeeSalaryHolder(view);
            return holder;
        }
        else
            return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof rvEmployeeSalarySectionHolder){
            rvEmployeeSalarySectionHolder headerHolder = (rvEmployeeSalarySectionHolder) holder;
            headerHolder.tSectionHead.setText("Year : " + dataList.get(position).YearName);
            headerHolder.tGrandTotal
                    .setText(CONSTANTS.FORMAT_CURRENCY.format(getTotalByYear(Integer.parseInt(dataList.get(position).YearName))) + " RO");
        }
        else if (holder instanceof  rvEmployeeSalaryHolder){
            rvEmployeeSalaryHolder itemHolder = (rvEmployeeSalaryHolder) holder;
            itemHolder.tSalary.setText(dataList.get(position).getSalary() + " RO");
            itemHolder.tSalaryAllowance.setText(dataList.get(position).getSalaryAllowance() + " RO");
            itemHolder.tOtherAllowance.setText(dataList.get(position).getOtherAllowance() + " RO");
            itemHolder.tEmpInsurrance.setText(dataList.get(position).getEmpInsurrance() + " RO");
            itemHolder.tCompanyInsurrance.setText(dataList.get(position).getCompanyInsurrance() + " RO");
            itemHolder.tTotal.setText(CONSTANTS.FORMAT_CURRENCY.format(dataList.get(position).getTotal()) + " RO");
            itemHolder.tCaseAllowance.setText(dataList.get(position).getTotalCaseAllowance() + " RO");

            itemHolder.tMonth.setText(GlobalFunctions.getMonthName(dataList.get(position).MonthId));

            if (dataList.get(position).getRemarks()!=null && dataList.get(position).getRemarks().length()>0) {
                itemHolder.tRemarks.setVisibility(View.VISIBLE);
                itemHolder.tRemarks.setText(dataList.get(position).getRemarks());
            }
            else
                itemHolder.tRemarks.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return dataList.size() ;
    }

    private Double getTotalByYear(int year){
        Double dblSum = 0.0;

        for (int i =0; i< dataList.size(); i++){
            if (Integer.parseInt(dataList.get(i).YearName) == year){
                dblSum+= dataList.get(i).getTotal();
            }
        }

        return dblSum;
    }
}
