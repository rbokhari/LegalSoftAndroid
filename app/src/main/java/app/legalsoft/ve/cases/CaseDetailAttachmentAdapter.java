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
import app.legalsoft.ve.model.CaseFileAttachmentModel;

/**
 * Created by Syed.Rahman on 01/08/2015.
 */
public class CaseDetailAttachmentAdapter extends RecyclerView.Adapter<CaseDetailAttachmentAdapter.CaseDetailAttachmentHolder> {

    private LayoutInflater layoutInflater;
    List<CaseFileAttachmentModel>  dataList = Collections.emptyList();

    public CaseDetailAttachmentAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setCaseAttachmentList(List<CaseFileAttachmentModel> list){
        this.dataList = new ArrayList<>(list);
        notifyItemRangeChanged(0, list.size());
    }

    public CaseDetailAttachmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.case_detail_attachment_row, parent,false);
        CaseDetailAttachmentHolder holder = new CaseDetailAttachmentHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CaseDetailAttachmentHolder holder, int position) {
        holder.tFileName.setText(dataList.get(position).getAttachmentFileName());
        holder.tCreatedOn.setText(dataList.get(position).getCreatedOn());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CaseDetailAttachmentHolder extends RecyclerView.ViewHolder{

        TextView tFileName;
        TextView tCreatedOn;

        public CaseDetailAttachmentHolder(View itemView) {
            super(itemView);

            tFileName = (TextView) itemView.findViewById(R.id.tCaseAttachmentName);
            tCreatedOn = (TextView) itemView.findViewById(R.id.tCaseAttachmentDate);
        }
    }
}
