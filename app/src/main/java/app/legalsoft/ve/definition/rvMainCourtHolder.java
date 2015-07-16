package app.legalsoft.ve.definition;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import app.legalsoft.ve.R;


/**
 * Created by Syed.Rahman on 15/07/2015.
 */
public class rvMainCourtHolder extends RecyclerView.ViewHolder {

    TextView tCode;
    TextView tCodeEn;
    TextView tSpecialize;
    TextView tActive;

    public rvMainCourtHolder(View itemView) {
        super(itemView);

        tCode = (TextView) itemView.findViewById(R.id.tMainCourtCode);
        tCodeEn = (TextView) itemView.findViewById(R.id.tMainCourtCodeEn);
        tSpecialize = (TextView) itemView.findViewById(R.id.tMainCourSpecializationArea);
        tActive = (TextView) itemView.findViewById(R.id.tMainCourtActive);
    }
}
