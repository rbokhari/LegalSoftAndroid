package app.legalsoft.ve.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 31/03/2015.
 */
public class rvClientHolder extends RecyclerView.ViewHolder {

    public TextView txtName;
    public TextView txtCode;
    public TextView txtContactPerson;
    public TextView txtContactGSM;

    public rvClientHolder(View itemView) {
        super(itemView);

        txtName = (TextView) itemView.findViewById(R.id.clientName);
        txtCode = (TextView) itemView.findViewById(R.id.clientCode);
        txtContactPerson = (TextView) itemView.findViewById(R.id.contactPerson);
        txtContactGSM = (TextView) itemView.findViewById(R.id.contactGSM);
    }
}
