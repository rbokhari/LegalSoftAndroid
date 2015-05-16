package app.legalsoft.ve.tasks;

import android.os.AsyncTask;

import java.util.ArrayList;

import app.legalsoft.ve.callbacks.OfficeExpensesLoadedListener;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.util.AppDataLoader;

/**
 * Created by Syed.Rahman on 16/05/2015.
 */
public class OfficeExpenseAsyncTask extends AsyncTask<Void, Void, ArrayList<OfficeExpenseModel>> {

    private OfficeExpensesLoadedListener officeExpensesLoadedListener;

    public OfficeExpenseAsyncTask(OfficeExpensesLoadedListener listener){
        this.officeExpensesLoadedListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<OfficeExpenseModel> doInBackground(Void... params) {
        ArrayList<OfficeExpenseModel> listOfficeExpense = AppDataLoader.loadOfficeExpenseData();

        return listOfficeExpense;
    }

    @Override
    protected void onPostExecute(ArrayList<OfficeExpenseModel> officeExpenseModel) {
        if (officeExpensesLoadedListener!=null){
            officeExpensesLoadedListener.onOfficeExpenseLoaded(officeExpenseModel);
        }
    }
}
