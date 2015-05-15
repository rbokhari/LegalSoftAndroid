package app.legalsoft.ve.services;

import android.os.AsyncTask;

import java.util.ArrayList;

import app.legalsoft.ve.callbacks.EmployeesLoadedListener;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.tasks.EmployeeAsyncTask;
import app.legalsoft.ve.util.AppDataLoader;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;
import me.tatarka.support.job.JobParameters;
import me.tatarka.support.job.JobService;

/**
 * Created by Syed.Rahman on 25/04/2015.
 */
public class EmployeeService extends JobService implements EmployeesLoadedListener {

    private JobParameters jobParameters;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        GlobalFunctions.showMessage(MyApplication.getAppContext(), "onStartJob");
        this.jobParameters = jobParameters;
        new EmployeeAsyncTask(this).execute();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        GlobalFunctions.showMessage(MyApplication.getAppContext(), "onStopJob");
        return false;
    }

    @Override
    public void onEmployeeLoaded(ArrayList<EmployeeModel> listEmployee) {
        jobFinished(jobParameters, false);
    }
}
