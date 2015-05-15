package app.legalsoft.ve.json;

import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 02/05/2015.
 */
public class Parser {

    public static ArrayList<EmployeeModel> parseEmployeeResponseArray(JSONArray response)
    {
        ArrayList<EmployeeModel> employeeModels = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray arrayEmployees = response; //.getJSONArray("employees");
                for (int i=0; i<arrayEmployees.length(); i++){
                    employeeModels.add(parseEmployeeResponse(arrayEmployees.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return employeeModels;
    }

    public static EmployeeModel parseEmployeeResponse(JSONObject response)
    {
        EmployeeModel employeeModel;
        employeeModel = new EmployeeModel();

            try {
                if (GlobalFunctions.getIsNotNull(response, "employeeID")) {
                    employeeModel.EmployeeId = response.getInt("employeeID");
                }
                if (GlobalFunctions.getIsNotNull(response,"empCode")) {
                    employeeModel.EmpCode = response.getString("empCode");
                }
                if (GlobalFunctions.getIsNotNull(response,"empName")) {
                    employeeModel.EmpName = response.getString("empName");
                }
                if (GlobalFunctions.getIsNotNull(response,"empName_EN")) {
                    employeeModel.EmpName_EN = response.getString("empName_EN");
                }
                if (GlobalFunctions.getIsNotNull(response,"familyName")) {
                    employeeModel.FamilyName = response.getString("familyName");
                }

                if (GlobalFunctions.getIsNotNull(response,"gsm")) {
                    employeeModel.GSM = response.getString("gsm");
                }
                if (GlobalFunctions.getIsNotNull(response,"occupation")) {
                    employeeModel.Occupation = response.getString("occupation");
                }
                if (GlobalFunctions.getIsNotNull(response,"empEmail")) {
                    employeeModel.EmpEmail = response.getString("empEmail");
                }

                if (GlobalFunctions.getIsNotNull(response,"mailAddress")) {
                    employeeModel.MailAddress = response.getString("mailAddress");
                }
                if (GlobalFunctions.getIsNotNull(response,"bankName")) {
                    employeeModel.BankName = response.getString("bankName");
                }
                if (GlobalFunctions.getIsNotNull(response,"branchName")) {
                    employeeModel.BranchName = response.getString("branchName");
                }
                if (GlobalFunctions.getIsNotNull(response,"accountNo")) {
                    employeeModel.AccountNo = response.getString("accountNo");
                }
                if (GlobalFunctions.getIsNotNull(response,"empSalary")) {
                    employeeModel.EmpSalary = response.getLong("empSalary");
                }
                if (GlobalFunctions.getIsNotNull(response,"empAllowance")) {
                    employeeModel.EmpAllowance = response.getLong("empAllowance");
                }
                if (GlobalFunctions.getIsNotNull(response,"isActive")) {
                    employeeModel.IsActive = response.getInt("isActive");
                }
                if (GlobalFunctions.getIsNotNull(response,"isAdmin")) {
                    employeeModel.IsAdmin = response.getInt("isAdmin");
                }
                if (GlobalFunctions.getIsNotNull(response,"startDate")) {
                    employeeModel.StartDate  = response.getString("startDate");
                }
                if (GlobalFunctions.getIsNotNull(response,"isAdmin")) {
                    employeeModel.IsAdmin = response.getInt("isAdmin");
                }
                if (GlobalFunctions.getIsNotNull(response,"createdBy")) {
                    employeeModel.CreatedBy = response.getInt("createdBy");
                }
                if (GlobalFunctions.getIsNotNull(response,"createdOn")) {
                    employeeModel.CreatedOn = response.getString("createdOn");
                }
                employeeModel.EmpPicture = null;
                if (GlobalFunctions.getIsNotNull(response,"empPic")) {
                    //employeeModel.EmpPicture =   arrayEmployees.getJSONObject(i).getString("empPic");
                    employeeModel.EmpPicture =   Base64.decode(response.getString("empPic"), Base64.DEFAULT);
                }
                if (GlobalFunctions.getIsNotNull(response,"sectionID")) {
                    JSONObject sectionDetail = response.getJSONObject("sectionDescription");
                    //employeeModel.SectionID = response.getString("sectionID") + "  " + sectionDetail.getString("descName");
                    if (GlobalFunctions.getIsNotNull(sectionDetail,"descName")) {
                        employeeModel.SectionID = sectionDetail.getString("descName");
                    }
                }

                if (GlobalFunctions.getIsNotNull(response,"nationalityID")) {
                    JSONObject nationalityDetail = response.getJSONObject("nationalityDescription");
                    if (GlobalFunctions.getIsNotNull(nationalityDetail,"descName")) {
                        employeeModel.NationalityID = nationalityDetail.getString("descName");
                    }
                }

                if (GlobalFunctions.getIsNotNull(response,"levelID")) {
                    JSONObject levelDetail = response.getJSONObject("levelDescription");
                    if (GlobalFunctions.getIsNotNull(levelDetail,"descName")) {
                        employeeModel.LevelID = levelDetail.getString("descName");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return employeeModel;
    }

}
