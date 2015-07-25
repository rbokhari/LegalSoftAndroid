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
import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 25/07/2015.
 */
public class CaseListAdapter extends RecyclerView.Adapter<CaseListAdapter.CaseListHolder> {

    private LayoutInflater layoutInflater;

    List<CaseFileModel> dataList = Collections.emptyList();

    public CaseListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);;
    }

    public void setCaseFileList(List<CaseFileModel> list)
    {
        this.dataList = new ArrayList<>(list);
        notifyItemRangeChanged(0, list.size());
    }


    @Override
    public CaseListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.case_list_row, parent, false);
        CaseListHolder holder = new CaseListHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(CaseListHolder holder, int position) {
        holder.tCaseNo.setText(dataList.get(position).getFileNo() + "");
        holder.tClientName.setText(dataList.get(position).ClientName);
        holder.tDefender.setText(dataList.get(position).DefenderName);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public CaseFileModel removeItem(int position) {
        final CaseFileModel model = dataList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, CaseFileModel model) {
        dataList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final CaseFileModel model = dataList.remove(fromPosition);
        dataList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<CaseFileModel> models){
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<CaseFileModel> newModels) {
        for (int i = dataList.size() - 1; i >= 0; i--) {
            final CaseFileModel model = dataList.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<CaseFileModel> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final CaseFileModel model = newModels.get(i);
            if (!dataList.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<CaseFileModel> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final CaseFileModel model = newModels.get(toPosition);
            final int fromPosition = dataList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }


    public class CaseListHolder extends RecyclerView.ViewHolder {

        TextView tCaseNo;
        TextView tClientName;
        TextView tDefender;

        public CaseListHolder(View itemView) {
            super(itemView);

            tCaseNo  = (TextView) itemView.findViewById(R.id.tCaseFileNo);
            tClientName = (TextView) itemView.findViewById(R.id.tClientName);
            tDefender = (TextView) itemView.findViewById(R.id.tCaseDefenderName);

        }
    }
}
