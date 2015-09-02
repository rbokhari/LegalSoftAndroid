package app.legalsoft.ve.employee;

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
import app.legalsoft.ve.model.EmployeeTimingModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 26/08/2015.
 */
public class EmployeeTimingAdapter extends RecyclerView.Adapter<EmployeeTimingAdapter.EmployeeTimingHolder> {

    private LayoutInflater layoutInflater;
    List<EmployeeTimingModel> dataList = Collections.emptyList();

    public EmployeeTimingAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setTimingList(List<EmployeeTimingModel> list){
        dataList = new ArrayList<>(list);
        notifyItemRangeChanged(0, list.size());
    }

    @Override
    public EmployeeTimingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.employee_timing_row, parent, false);
        EmployeeTimingHolder holder = new EmployeeTimingHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EmployeeTimingHolder holder, int position) {

        holder.tTimingCode.setText(dataList.get(position).getTimingCode());
        holder.tTimingDate.setText(dataList.get(position).getTimingDate());
        holder.tClient.setText(dataList.get(position).getClientName());
        holder.tType.setText(dataList.get(position).getTimingTypeName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeTimingHolder extends RecyclerView.ViewHolder {

        TextView tTimingCode;
        TextView tTimingDate;
        TextView tClient;
        TextView tType;
        public EmployeeTimingHolder(View itemView) {
            super(itemView);
            tTimingCode = (TextView) itemView.findViewById(R.id.tTimingCode);
            tTimingDate = (TextView) itemView.findViewById(R.id.tTimingDate);
            tClient = (TextView) itemView.findViewById(R.id.tTimingClient);
            tType = (TextView) itemView.findViewById(R.id.tTimingTypeName);
        }
    }

}
