package app.legalsoft.ve.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 28/03/2015.
 */

public class rvEmployeeHolder extends RecyclerView.ViewHolder {

    public ImageView imgEmp;
    public TextView txtName;
    public ImageView imgDelete;


    public rvEmployeeHolder(View itemView) {
        super(itemView);

        imgEmp = (ImageView) itemView.findViewById(R.id.empIcon);
        txtName = (TextView) itemView.findViewById(R.id.empName);
    }


}
