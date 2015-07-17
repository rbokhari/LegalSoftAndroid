package app.legalsoft.ve.json;

import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.model.OfficeExpenseDetailModel;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.model.SpecialistModel;
import app.legalsoft.ve.model.SubCourtModel;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 02/05/2015.
 */
public class Parser {

    public static ArrayList<OfficeExpenseDetailModel> officeExpenseDetailModelArrayList;

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


    public static ArrayList<OfficeExpenseModel> parseOfficeExpenseResponseArray(JSONArray response)
    {
        ArrayList<OfficeExpenseModel> officeExpenseModels = new ArrayList<>();
        officeExpenseDetailModelArrayList = new ArrayList<>();

        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    officeExpenseModels.add(parseOfficeExpenseResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return officeExpenseModels;
    }


    public static OfficeExpenseModel parseOfficeExpenseResponse(JSONObject response)
    {
        OfficeExpenseModel officeExpenseModel = new OfficeExpenseModel();
        //officeExpenseDetailModelArrayList = new ArrayList<>();

        try {
            if (GlobalFunctions.getIsNotNull(response, "expenseID")) {
                officeExpenseModel.ExpenseID = response.getInt("expenseID");
            }
            if (GlobalFunctions.getIsNotNull(response,"expenseCode")) {
                officeExpenseModel.ExpenseCode = response.getString("expenseCode");
            }
            if (GlobalFunctions.getIsNotNull(response,"expenseDate")) {
                officeExpenseModel.ExpenseDate = response.getString("expenseDate");
            }
            if (GlobalFunctions.getIsNotNull(response,"monthID")) {
                officeExpenseModel.MonthID = response.getInt("monthID");
            }
            if (GlobalFunctions.getIsNotNull(response,"year")) {
                officeExpenseModel.Year = response.getInt("year");
            }

            if (GlobalFunctions.getIsNotNull(response,"totalEmpInsurrance")) {
                officeExpenseModel.TotalEmpInsurrance = response.getInt("totalEmpInsurrance");
            }
            if (GlobalFunctions.getIsNotNull(response,"totalCompanyInsurrance")) {
                officeExpenseModel.TotalCompanyInsurrance = response.getInt("totalCompanyInsurrance");
            }
            if (GlobalFunctions.getIsNotNull(response,"totalRent")) {
                officeExpenseModel.TotalRent = response.getInt("totalRent");
            }
            if (GlobalFunctions.getIsNotNull(response,"pettyCash")) {
                officeExpenseModel.PettyCash = response.getInt("pettyCash");
            }
            if (GlobalFunctions.getIsNotNull(response,"totalSupport")) {
                officeExpenseModel.TotalSupport = response.getInt("totalSupport");
            }
            if (GlobalFunctions.getIsNotNull(response,"installment")) {
                officeExpenseModel.Installment = response.getInt("installment");
            }
            if (GlobalFunctions.getIsNotNull(response,"totalSalary")) {
                officeExpenseModel.TotalSalary = response.getInt("totalSalary");
            }
            if (GlobalFunctions.getIsNotNull(response,"grandTotal")) {
                officeExpenseModel.GrandTotal = response.getInt("grandTotal");
            }
            if (GlobalFunctions.getIsNotNull(response,"bankAccountID")) {
                officeExpenseModel.BankAccountID = response.getInt("bankAccountID");
            }
            if (GlobalFunctions.getIsNotNull(response,"createdBy")) {
                officeExpenseModel.CreatedBy = response.getInt("createdBy");
            }
            if (GlobalFunctions.getIsNotNull(response,"createdOn")) {
                officeExpenseModel.CreatedOn = response.getString("createdOn");
            }
            if (GlobalFunctions.getIsNotNull(response,"modifiedBy")) {
                officeExpenseModel.ModifiedBy = response.getInt("modifiedBy");
            }
            if (GlobalFunctions.getIsNotNull(response,"modifiedOn")) {
                officeExpenseModel.ModifiedOn = response.getString("modifiedOn");
            }

            if (GlobalFunctions.getIsNotNull(response,"officeExpenseDetails")) {
                JSONArray officeExpenseDetailArray = response.getJSONArray("officeExpenseDetails");
                GlobalFunctions.m("Length : " + officeExpenseDetailArray.length() + "");
                for (int i=0; i<officeExpenseDetailArray.length(); i++) {
                    officeExpenseDetailModelArrayList
                            .add(parseOfficeExpenseDetailResponse(officeExpenseDetailArray.getJSONObject(i)));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return officeExpenseModel;
    }

    public static OfficeExpenseDetailModel parseOfficeExpenseDetailResponse(JSONObject response){
        OfficeExpenseDetailModel detailModel = new OfficeExpenseDetailModel();

        try {
            if (GlobalFunctions.getIsNotNull(response,"expenseDetailID")) {
                detailModel.ExpenseDetailID = response.getInt("expenseDetailID");
            }
            if (GlobalFunctions.getIsNotNull(response,"expenseID")) {
                detailModel.ExpenseID = response.getInt("expenseID");
            }
            if (GlobalFunctions.getIsNotNull(response,"employeeID")) {
                detailModel.EmployeeID = response.getInt("employeeID");
            }
            if (GlobalFunctions.getIsNotNull(response,"salary")) {
                detailModel.Salary = response.getInt("salary");
            }
            if (GlobalFunctions.getIsNotNull(response,"salaryAllowance")) {
                detailModel.SalaryAllowance = response.getInt("salaryAllowance");
            }
            if (GlobalFunctions.getIsNotNull(response,"otherAllowance")) {
                detailModel.OtherAllowance = response.getInt("otherAllowance");
            }
            if (GlobalFunctions.getIsNotNull(response,"empInsurrance")) {
                detailModel.EmpInsurrance = response.getInt("empInsurrance");
            }
            if (GlobalFunctions.getIsNotNull(response,"companyInsurrance")) {
                detailModel.CompanyInsurrance = response.getInt("companyInsurrance");
            }
            if (GlobalFunctions.getIsNotNull(response,"total")) {
                detailModel.Total = response.getInt("total");
            }
            if (GlobalFunctions.getIsNotNull(response,"totalCaseAllowance")) {
                detailModel.Total = response.getInt("totalCaseAllowance");
            }
            if (GlobalFunctions.getIsNotNull(response,"remarks")) {
                detailModel.Remarks = response.getString("remarks");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return detailModel;

    }


    public static ArrayList<SpecialistModel> parseSpecialistResponseArray(JSONArray response)
    {
        ArrayList<SpecialistModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseSpecialistResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static SpecialistModel parseSpecialistResponse(JSONObject response)
    {
        SpecialistModel model= new SpecialistModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "specializeID")) {
                model.SpecializeID = response.getInt("specializeID");
            }
            if (GlobalFunctions.getIsNotNull(response, "specializeCode")) {
                model.SpecializeCode = response.getString("specializeCode");
            }
            if (GlobalFunctions.getIsNotNull(response, "specializeCode_EN")) {
                model.SpecializeCode_EN = response.getString("specializeCode_EN");
            }
            if (GlobalFunctions.getIsNotNull(response, "isActive")) {
                model.IsActive = response.getInt("isActive");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static ArrayList<MainCourtModel> parseMainCourtResponseArray(JSONArray response)
    {
        ArrayList<MainCourtModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseMainCourtResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static MainCourtModel parseMainCourtResponse(JSONObject response)
    {
        MainCourtModel model= new MainCourtModel();
        try {
            if (GlobalFunctions.getIsNotNull(response, "mainCourtID")) {
                model.MainCourtID = response.getInt("mainCourtID");
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtCode")) {
                model.MainCourtCode = response.getString("mainCourtCode");
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtCode_EN")) {
                model.MainCourtCode_EN = response.getString("mainCourtCode_EN");
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtSpecialist")) {
                model.MainCourtSpecialist = response.getString("mainCourtSpecialist");
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtLocation")) {
                model.MainCourtLocation = response.getString("mainCourtLocation");
            }
            if (GlobalFunctions.getIsNotNull(response, "isActive")) {
                model.IsActive = response.getInt("isActive");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static ArrayList<SubCourtModel> parseSubCourtResponseArray(JSONArray response)
    {
        ArrayList<SubCourtModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseSubCourtResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static SubCourtModel parseSubCourtResponse(JSONObject response)
    {
        SubCourtModel model= new SubCourtModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "subCourtID")) {
                model.SubCourtID = response.getInt("subCourtID");
            }
            if (GlobalFunctions.getIsNotNull(response, "subCourtCode")) {
                model.SubCourtCode = response.getString("subCourtCode");
            }
            if (GlobalFunctions.getIsNotNull(response, "subCourtCode_EN")) {
                model.SubCourtCode_EN = response.getString("subCourtCode_EN");
            }
            if (GlobalFunctions.getIsNotNull(response, "subCourtName")) {
                model.SubCourtName = response.getString("subCourtName");
            }
            if (GlobalFunctions.getIsNotNull(response, "isActive")) {
                model.IsActive = response.getInt("isActive");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static ArrayList<DefenderModel> parseDefenderResponseArray(JSONArray response)
    {
        ArrayList<DefenderModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseDefenderResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static DefenderModel parseDefenderResponse(JSONObject response)
    {
        DefenderModel model= new DefenderModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "defenderID")) {
                model.DefenderID = response.getInt("defenderID");
            }
            if (GlobalFunctions.getIsNotNull(response, "defenderCode")) {
                model.DefenderCode = response.getString("defenderCode");
            }
            if (GlobalFunctions.getIsNotNull(response, "defenderName")) {
                model.DefenderName = response.getString("defenderName");
            }
            if (GlobalFunctions.getIsNotNull(response, "defenderName_EN")) {
                model.DefenderName_EN = response.getString("defenderName_EN");
            }
            if (GlobalFunctions.getIsNotNull(response, "isActive")) {
                model.IsActive = response.getInt("isActive");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }
}
