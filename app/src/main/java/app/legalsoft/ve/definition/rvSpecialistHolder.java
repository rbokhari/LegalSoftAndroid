package app.legalsoft.ve.definition;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 14/07/2015.
 */
public class rvSpecialistHolder extends RecyclerView.ViewHolder {

    public TextView tCode;
    public TextView tCodeEn;
    public TextView tArea;
    public TextView tActive;

    public rvSpecialistHolder(View itemView) {
        super(itemView);

        tCode = (TextView) itemView.findViewById(R.id.tSpecialistCode);
        tCodeEn = (TextView) itemView.findViewById(R.id.tSpecialistCodeEn);
        tArea = (TextView) itemView.findViewById(R.id.tSpecialistArea);
        tActive = (TextView) itemView.findViewById(R.id.tSpecialistActive);


    }
}
