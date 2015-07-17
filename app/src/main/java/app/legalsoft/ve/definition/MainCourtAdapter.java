package app.legalsoft.ve.definition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.MainCourtModel;

/**
 * Created by Syed.Rahman on 17/07/2015.
 */
public class MainCourtAdapter extends RecyclerView.Adapter<MainCourtAdapter.MainCourtHolder> {

    private LayoutInflater layoutInflater;

    List<MainCourtModel> dataList = Collections.emptyList();

    public void setMainCoutList(List<MainCourtModel> list)
    {
        this.dataList = list;
        notifyItemRangeChanged(0, list.size());
    }

    public MainCourtAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MainCourtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.maincourt_rv_row, parent, false);
        MainCourtHolder holder = new MainCourtHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MainCourtHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getMainCourtCode());
        holder.tCodeEn.setText(dataList.get(position).getMainCourtCode_EN());
        holder.tSpecialize.setText(dataList.get(position).getMainCourtSpecialist());
        holder.tActive.setText(dataList.get(position).getIsActive() + "");

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class MainCourtHolder extends RecyclerView.ViewHolder {

        TextView tCode;
        TextView tCodeEn;
        TextView tSpecialize;
        TextView tActive;

        public MainCourtHolder(View itemView) {
            super(itemView);

            tCode = (TextView) itemView.findViewById(R.id.tMainCourtCode);
            tCodeEn = (TextView) itemView.findViewById(R.id.tMainCourtCodeEn);
            tSpecialize = (TextView) itemView.findViewById(R.id.tMainCourSpecializationArea);
            tActive = (TextView) itemView.findViewById(R.id.tMainCourtActive);
        }
    }

}
