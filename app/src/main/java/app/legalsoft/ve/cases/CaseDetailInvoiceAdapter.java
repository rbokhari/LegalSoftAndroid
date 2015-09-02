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
import app.legalsoft.ve.model.InvoiceModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 01/08/2015.
 */
public class CaseDetailInvoiceAdapter extends RecyclerView.Adapter<CaseDetailInvoiceAdapter.CaseDetailInvoiceHolder> {

    private LayoutInflater layoutInflater;
    List<InvoiceModel> dataList = Collections.emptyList();

    public CaseDetailInvoiceAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setInvoiceList(List<InvoiceModel> list){
        dataList = new ArrayList<>(list);
        notifyItemRangeChanged(0, list.size());
    }

    public CaseDetailInvoiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.case_detail_invoice_row, parent, false);
        CaseDetailInvoiceHolder holder = new CaseDetailInvoiceHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CaseDetailInvoiceHolder holder, int position) {
        holder.tInvoiceDate.setText(dataList.get(position).getInvoiceCode() + "-" + dataList.get(position).getPaymentDate());
        holder.tInvoiceAmount.setText(dataList.get(position).getTotalAmount() + "");
        holder.tComments.setText(dataList.get(position).getComments());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CaseDetailInvoiceHolder extends RecyclerView.ViewHolder {

        TextView tInvoiceDate;
        TextView tInvoiceAmount;
        TextView tComments;

        public CaseDetailInvoiceHolder(View itemView) {
            super(itemView);

            tInvoiceDate = (TextView) itemView.findViewById(R.id.tCaseInvoiceDate);
            tInvoiceAmount = (TextView) itemView.findViewById(R.id.tCaseInvoiceAmount);
            tComments = (TextView) itemView.findViewById(R.id.tCaseInvoiceComments);
        }
    }

}
