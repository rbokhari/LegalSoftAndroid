package app.legalsoft.ve.definition;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.client.ClientFragment;
import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 17/07/2015.
 */
public class DefenderAdapter extends RecyclerView.Adapter<DefenderAdapter.DefenderHolder> {

    private LayoutInflater layoutInflater;

    List<DefenderModel> dataList = Collections.emptyList();

    public void setDefenderList(List<DefenderModel> list)
    {
        this.dataList = new ArrayList<>(list);
        notifyItemRangeChanged(0, list.size());
    }

    public DefenderAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public DefenderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.defender_row, parent, false);
        DefenderHolder holder = new DefenderHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(DefenderHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getDefenderCode());
        holder.tName.setText(dataList.get(position).getDefenderName());
        //holder.tNameEn.setText(dataList.get(position).getDefenderName_EN());
        holder.bCaseActive.setText(dataList.get(position).getCaseActive() + "");
        holder.bCaseNonActive.setText(dataList.get(position).getCaseNonActive() + "");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public DefenderModel removeItem(int position) {
        final DefenderModel model = dataList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, DefenderModel model) {
        dataList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final DefenderModel model = dataList.remove(fromPosition);
        dataList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<DefenderModel> models){
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<DefenderModel> newModels) {
        for (int i = dataList.size() - 1; i >= 0; i--) {
            final DefenderModel model = dataList.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<DefenderModel> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final DefenderModel model = newModels.get(i);
            if (!dataList.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<DefenderModel> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final DefenderModel model = newModels.get(toPosition);
            final int fromPosition = dataList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }


    public class DefenderHolder extends RecyclerView.ViewHolder {

        TextView tCode;
        TextView tName;
        //TextView tNameEn;
        Button bCaseActive;
        Button bCaseNonActive;

        public DefenderHolder(final View itemView) {
            super(itemView);

            tCode = (TextView) itemView.findViewById(R.id.tDefenderCode);
            tName = (TextView) itemView.findViewById(R.id.tDefenderName);
            //tNameEn = (TextView) itemView.findViewById(R.id.tDefenderNameEn);
            bCaseActive = (Button) itemView.findViewById(R.id.bCaseActive);
            bCaseNonActive = (Button) itemView.findViewById(R.id.bCaseNonActive);

            bCaseActive.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    //Fragment fragClient = new ClientFragment();
                    //transaction.replace(R.id.fragment_main_content, fragClient)
                            //.commit();
                    GlobalFunctions.showMessage("button active");
                }


            });
        }
    }
}
