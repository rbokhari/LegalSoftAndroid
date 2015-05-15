package app.legalsoft.ve.tasks;

import android.os.AsyncTask;
import java.util.ArrayList;

import app.legalsoft.ve.callbacks.EmployeesLoadedListener;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.services.EmployeeService;
import app.legalsoft.ve.util.AppDataLoader;

/**
 * Created by Syed.Rahman on 02/05/2015.
 */
public class EmployeeAsyncTask extends AsyncTask<Void, Void, ArrayList<EmployeeModel>> {
    private EmployeesLoadedListener employeesLoadedListener;
    //EmployeeService employeeService;
/*
    public EmployeeAsyncTask(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
*/
    public EmployeeAsyncTask(EmployeesLoadedListener listener){
        this.employeesLoadedListener = listener;
        //this.employeeService = employeeService;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<EmployeeModel> doInBackground(Void... params) {
        ArrayList<EmployeeModel> listEmployees = AppDataLoader.loadEmployeeData();

        return listEmployees;
    }

    @Override
    protected void onPostExecute(ArrayList<EmployeeModel> listEmployees) {
        //employeeService.jobFinished(null, false);
        if (employeesLoadedListener!=null){
            employeesLoadedListener.onEmployeeLoaded(listEmployees);
        }
    }
}
