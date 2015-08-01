package app.legalsoft.ve.cases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.CaseFileModel;
import app.legalsoft.ve.model.CaseFollowupModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 29/07/2015.
 */
public class CaseDetailFollowupAdapter extends RecyclerView.Adapter<CaseDetailFollowupAdapter.CaseDetailFollowupHolder> {

    private LayoutInflater layoutInflater;
    List<CaseFollowupModel> dataList = Collections.emptyList();

    public CaseDetailFollowupAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setCaseFollowupList(List<CaseFollowupModel> list)
    {
        this.dataList = new ArrayList<>(list);
        notifyItemRangeChanged(0, list.size());
    }


    public CaseDetailFollowupHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.case_detail_followup_row, parent, false);
        CaseDetailFollowupHolder holder = new CaseDetailFollowupHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CaseDetailFollowupHolder holder, int position) {
        holder.tSessionDate.setText(dataList.get(position).getSessionDate());
        holder.tNextDate.setText(dataList.get(position).getNextDate());
        holder.tMainCourt.setText(dataList.get(position).getMainCourtName());
        holder.tSubCourt.setText(dataList.get(position).getSubCourtName());
        holder.tComments.setText(dataList.get(position).getComments());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CaseDetailFollowupHolder extends RecyclerView.ViewHolder {

        TextView tSessionDate;
        TextView tNextDate;
        TextView tMainCourt;
        TextView tSubCourt;
        TextView tComments;

        public CaseDetailFollowupHolder(View itemView) {
            super(itemView);

            tSessionDate = (TextView) itemView.findViewById(R.id.tCaseFollowupSessionDate);
            tNextDate = (TextView) itemView.findViewById(R.id.tCaseFollowupNextDate);
            tMainCourt = (TextView) itemView.findViewById(R.id.tCaseFollowupMainCourt);
            tSubCourt = (TextView) itemView.findViewById(R.id.tCaseFollowupSubCourt);
            tComments = (TextView) itemView.findViewById(R.id.tCaseFollowupComments);
        }
    }
}
