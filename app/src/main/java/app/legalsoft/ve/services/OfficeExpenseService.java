package app.legalsoft.ve.services;

import app.legalsoft.ve.tasks.OfficeExpenseAsyncTask;
import app.legalsoft.ve.util.GlobalFunctions;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;
import java.util.ArrayList;
import app.legalsoft.ve.callbacks.OfficeExpensesLoadedListener;
import app.legalsoft.ve.model.OfficeExpenseModel;

/**
 * Created by Syed.Rahman on 16/05/2015.
 */
public class OfficeExpenseService extends JobService implements OfficeExpensesLoadedListener {

    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(JobParameters params) {

        GlobalFunctions.m("OfficeExpenseService Job Start>>>>>");
        this.jobParameters = params;
        new OfficeExpenseAsyncTask(this).execute();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    @Override
    public void onOfficeExpenseLoaded(ArrayList<OfficeExpenseModel> listOfficeExpense) {
        jobFinished(jobParameters, false);
    }
}
