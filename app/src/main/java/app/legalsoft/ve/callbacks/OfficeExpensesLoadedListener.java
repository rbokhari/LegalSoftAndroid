package app.legalsoft.ve.callbacks;

import java.util.ArrayList;

import app.legalsoft.ve.model.OfficeExpenseModel;

/**
 * Created by Syed.Rahman on 16/05/2015.
 */
public interface OfficeExpensesLoadedListener {

    void onOfficeExpenseLoaded(ArrayList<OfficeExpenseModel> listOfficeExpense);
}
