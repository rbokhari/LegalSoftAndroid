package app.legalsoft.ve.callbacks;

import java.util.ArrayList;

import app.legalsoft.ve.model.EmployeeModel;

/**
 * Created by Syed.Rahman on 03/05/2015.
 */
public interface EmployeesLoadedListener {
    public void onEmployeeLoaded(ArrayList<EmployeeModel> listEmployee);
}
