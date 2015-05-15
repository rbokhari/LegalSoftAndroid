package app.legalsoft.ve.util;

import org.json.JSONArray;
import java.util.ArrayList;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.json.Requestor;
import app.legalsoft.ve.model.EmployeeModel;

/**
 * Created by Syed.Rahman on 02/05/2015.
 */

public class AppDataLoader {

    public static ArrayList<EmployeeModel> loadEmployeeData(){
        JSONArray response = Requestor.requestData(CONSTANTS.EMPLOYEES_API_URL);
        ArrayList<EmployeeModel> listEmployees = Parser.parseEmployeeResponseArray(response);
        MyApplication.getWriteableDatabase().InsertEmployees(listEmployees, true);

        return listEmployees;
    }

}
