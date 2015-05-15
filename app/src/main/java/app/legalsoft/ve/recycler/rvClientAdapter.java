package app.legalsoft.ve.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.ClientModel;
import app.legalsoft.ve.model.EmployeeModel;

/**
 * Created by Syed.Rahman on 31/03/2015.
 */
public class rvClientAdapter extends RecyclerView.Adapter<rvClientHolder> {

    private LayoutInflater layoutInflater;
    //String[] titles;
    //int[] icons;

    List<ClientModel> dataList = Collections.emptyList();

    public rvClientAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setClientList(List<ClientModel> listClient)
    {
        this.dataList = listClient;
        notifyItemRangeChanged(0, listClient.size());
        Log.d("setEmployeeList", "----------------======= setEmployeeList =====--------------");
    }

    @Override
    public rvClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.client_rv_row, parent, false);
        rvClientHolder holder = new rvClientHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(rvClientHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getClientName());
        holder.txtCode.setText(dataList.get(position).getClientCode());
        holder.txtContactPerson.setText(dataList.get(position).getContactPerson());
        holder.txtContactGSM.setText(dataList.get(position).getContactGSM());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
