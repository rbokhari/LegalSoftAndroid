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
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.model.HomeMenuModel;

/**
 * Created by Syed.Rahman on 28/03/2015.
 */
public class rvEmployeeAdapter extends RecyclerView.Adapter<rvEmployeeHolder> {

    private LayoutInflater layoutInflater;
    //String[] titles;
    //int[] icons;

    List<EmployeeModel> dataList = Collections.emptyList();

    public rvEmployeeAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        /*if (dataList.size()>-1) {
            this.dataList = dataList;
            notifyItemRangeChanged(0, dataList.size());
        }*/
    }

    public void setEmployeeList(List<EmployeeModel> listEmployee)
    {
        this.dataList = listEmployee;
        notifyItemRangeChanged(0, listEmployee.size());
        Log.d("setEmployeeList", "----------------======= setEmployeeList =====--------------");
    }

    @Override
    public rvEmployeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.employee_rv_row, parent, false);
        rvEmployeeHolder holder = new rvEmployeeHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(rvEmployeeHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getEmpName());
        //holder.imgEmp.setImageResource(dataList.get(position).getEmpPicture());
        if (dataList.get(position).EmpPicture!=null) {
            //byte[] decodedString = Base64.decode(dataList.get(position).getEmpPicture(), Base64.DEFAULT);
            //Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
/*
            Bitmap decodedByte =
                    BitmapFactory.decodeByteArray(Base64.decode(dataList.get(position).getEmpPicture(), Base64.DEFAULT),
                                                0,
                                                Base64.decode(dataList.get(position).getEmpPicture(), Base64.DEFAULT).length);

            holder.imgEmp.setImageBitmap(decodedByte);*/
            holder.imgEmp.setImageBitmap(BitmapFactory.decodeByteArray(dataList.get(position).getEmpPicture(),0, dataList.get(position).getEmpPicture().length));
        }
        else{
            holder.imgEmp.setImageResource(R.drawable.photo);
        }

        //Log.d("icon:---", String.valueOf(dataList.get(position).getTitleIcon()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}