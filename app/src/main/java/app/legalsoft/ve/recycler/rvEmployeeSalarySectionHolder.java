package app.legalsoft.ve.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 22/05/2015.
 */
public class rvEmployeeSalarySectionHolder extends RecyclerView.ViewHolder {

    TextView tSectionHead;
    TextView tGrandTotal;

    public rvEmployeeSalarySectionHolder(View itemView) {
        super(itemView);

        tSectionHead = (TextView) itemView.findViewById(R.id.tEmpSalarySection);
        tGrandTotal = (TextView) itemView.findViewById(R.id.tGrandTotal);

    }
}
