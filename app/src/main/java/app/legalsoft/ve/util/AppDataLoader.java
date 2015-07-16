package app.legalsoft.ve.util;

import org.json.JSONArray;
import java.util.ArrayList;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.json.Requestor;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.model.OfficeExpenseDetailModel;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.model.SubCourtModel;

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

    public static ArrayList<OfficeExpenseModel> loadOfficeExpenseData(){
        JSONArray response = Requestor.requestData(CONSTANTS.OFFICEEXPENSE_API_URL);
        ArrayList<OfficeExpenseModel> listOfficeExpense = Parser.parseOfficeExpenseResponseArray(response);
        ArrayList<OfficeExpenseDetailModel> listOfficeExpenseDetail = Parser.officeExpenseDetailModelArrayList;

        MyApplication.getWriteableDatabase().InsertOfficeExpense(listOfficeExpense, listOfficeExpenseDetail, true);

        return  listOfficeExpense;
    }

    public static JSONArray getSubCourt(){
        GlobalFunctions.m(".......... AddDataLoader start........");
        JSONArray response = Requestor.requestData(CONSTANTS.SUBCOURT_API_URL);
        GlobalFunctions.m(".......... AddDataLoader ........");
        //ArrayList<SubCourtModel> list = Parser.parseSubCourtResponseArray(response);
        GlobalFunctions.m(".......... AddDataLoader AFter........");
        return response;
    }

}
