package app.legalsoft.ve.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.List;
import app.legalsoft.ve.R;
import app.legalsoft.ve.model.HomeMenuModel;

/**
 * Created by Syed.Rahman on 14/03/2015.
 */
public class rvAdapter extends RecyclerView.Adapter<rvHolder> {

    private LayoutInflater layoutInflater;
    String[] titles;
    int[] icons;

    List<HomeMenuModel> dataList = Collections.emptyList();

    public rvAdapter(Context context, List<HomeMenuModel> employeeModel) {
        this.layoutInflater = LayoutInflater.from(context);
        if (employeeModel.size()>-1) {
            this.dataList = employeeModel;
        }
    }

    @Override
    public rvHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.rv_main_menu, viewGroup, false);
        rvHolder holder = new rvHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(rvHolder rvHolder, int position) {

        rvHolder.menuText.setText(dataList.get(position).getTitleText());
        rvHolder.menuIcon.setImageResource(dataList.get(position).getTitleIcon());
        Log.d("icon:---", String.valueOf(dataList.get(position).getTitleIcon()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
