package app.legalsoft.ve.json;

import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.legalsoft.ve.model.CaseFileAttachmentModel;
import app.legalsoft.ve.model.CaseFileModel;
import app.legalsoft.ve.model.CaseFollowupModel;
import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.model.InvoiceModel;
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
                    employeeModel.StartDate  = GlobalFunctions.getFormattedDate(response.getString("startDate"));
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
                officeExpenseModel.ExpenseDate = GlobalFunctions.getFormattedDate(response.getString("expenseDate"));
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
                officeExpenseModel.CreatedOn = GlobalFunctions.getFormattedDate(response.getString("createdOn"));
            }
            if (GlobalFunctions.getIsNotNull(response,"modifiedBy")) {
                officeExpenseModel.ModifiedBy = response.getInt("modifiedBy");
            }
            if (GlobalFunctions.getIsNotNull(response,"modifiedOn")) {
                officeExpenseModel.ModifiedOn = GlobalFunctions.getFormattedDate(response.getString("modifiedOn"));
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
            if (GlobalFunctions.getIsNotNull(response, "caseCountActive")) {
                model.CaseActive = response.getInt("caseCountActive");
            }
            if (GlobalFunctions.getIsNotNull(response, "caseCountNotActive")) {
                model.CaseNonActive = response.getInt("caseCountNotActive");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static ArrayList<CaseFileModel> parseCaseListResponseArray(JSONArray response)
    {
        ArrayList<CaseFileModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseCaseListResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static CaseFileModel parseCaseListResponse(JSONObject response)
    {
        CaseFileModel model= new CaseFileModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "caseFileID")) {
                model.CaseFileID = response.getInt("caseFileID");
            }
            if (GlobalFunctions.getIsNotNull(response, "fileNo")) {
                model.FileNo = response.getInt("fileNo");
            }
            if (GlobalFunctions.getIsNotNull(response, "priorityID")) {
                model.PriorityID = response.getInt("priorityID");
            }
            if (GlobalFunctions.getIsNotNull(response, "startDate")) {
                model.StartDate = GlobalFunctions.getFormattedDate(response.getString("startDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "clientID")) {
                model.ClientID = response.getInt("clientID");
            }
            if (GlobalFunctions.getIsNotNull(response, "clientSpecID")) {
                model.ClientSpecID = response.getInt("clientSpecID");
            }
            if (GlobalFunctions.getIsNotNull(response, "physicalFileID")) {
                model.PhysicalFileID = response.getInt("physicalFileID");
            }
            if (GlobalFunctions.getIsNotNull(response, "consultancyTypeID")) {
                model.ConsultancyTypeID = response.getInt("consultancyTypeID");
            }
            if (GlobalFunctions.getIsNotNull(response, "consultancySubject")) {
                model.ConsultancySubject = response.getString("consultancySubject");
            }
            if (GlobalFunctions.getIsNotNull(response, "actionTakenID")) {
                model.ActionTakenID = response.getInt("qctionTakenID");
            }
            if (GlobalFunctions.getIsNotNull(response, "otherPerson")) {
                model.OtherPerson = response.getString("otherPerson");
            }
            if (GlobalFunctions.getIsNotNull(response, "complainDate")) {
                model.ComplainDate = GlobalFunctions.getFormattedDate(response.getString("complainDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "followUpDate")) {
                model.FollowUpDate = GlobalFunctions.getFormattedDate(response.getString("followUpDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "courtCaseNo")) {
                model.CourtCaseNo = response.getString("courtCaseNo");
            }
            if (GlobalFunctions.getIsNotNull(response, "defendentLawyer")) {
                model.DefendentLawyer = response.getString("defendentLawyer");
            }
            if (GlobalFunctions.getIsNotNull(response, "lawyerName")) {
                model.LawyerName = response.getString("lawyerName");
            }
            if (GlobalFunctions.getIsNotNull(response, "totalHours")) {
                model.TotalHours = response.getString("totalHours");
            }
            if (GlobalFunctions.getIsNotNull(response, "comments")) {
                model.Comments = response.getString("comments");
            }
            if (GlobalFunctions.getIsNotNull(response, "lastResult")) {
                model.LastResult = response.getString("lastResult");
            }
            if (GlobalFunctions.getIsNotNull(response, "caseComputerNo")) {
                model.CaseComputerNo = response.getString("caseComputerNo");
            }
            if (GlobalFunctions.getIsNotNull(response, "commissionPercentage")) {
                model.CommissionPercentage = response.getLong("commissionPercentage");
            }
            if (GlobalFunctions.getIsNotNull(response, "contractFileName")) {
                model.ContractFileName = response.getString("contractFileName");
            }
            if (GlobalFunctions.getIsNotNull(response, "physicalContractFileName")) {
                model.PhysicalContractFileName = response.getString("physicalContractFileName");
            }
            if (GlobalFunctions.getIsNotNull(response, "bankFileNo")) {
                model.BankFileNo = response.getString("bankFileNo");
            }
            if (GlobalFunctions.getIsNotNull(response, "accountNo")) {
                model.AccountNo = response.getString("accountNo");
            }
            if (GlobalFunctions.getIsNotNull(response, "division")) {
                model.Division = response.getString("division");
            }
            if (GlobalFunctions.getIsNotNull(response, "closeDate")) {
                model.CloseDate = GlobalFunctions.getFormattedDate(response.getString("closeDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "contractAmount")) {
                model.ContractAmount = response.getLong("contractAmount");
            }

            if (GlobalFunctions.getIsNotNull(response, "statusID")) {
                model.StatusID = response.getInt("statusID");
            }
            if (GlobalFunctions.getIsNotNull(response, "type")) {
                model.Type = response.getInt("type");
            }

            if (GlobalFunctions.getIsNotNull(response,"clientID")) {
                JSONObject clientRegistration = response.getJSONObject("clientRegistration");
                if (GlobalFunctions.getIsNotNull(clientRegistration,"clientName")) {
                    model.ClientName = clientRegistration.getString("clientName");
                }
            }
            if (GlobalFunctions.getIsNotNull(response,"defenderID")) {
                JSONObject defenderDetail = response.getJSONObject("defenderDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"defenderName")) {
                    model.DefenderName = defenderDetail.getString("defenderName");

                }
            }
            if (GlobalFunctions.getIsNotNull(response,"clientSpecID")) {
                JSONObject defenderDetail = response.getJSONObject("clientSpecDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"descName")) {
                    model.ClientSpecName = defenderDetail.getString("descName");

                }
            }
            if (GlobalFunctions.getIsNotNull(response,"complainDepartment")) {
                JSONObject defenderDetail = response.getJSONObject("complainDepartmentDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"descName")) {
                    model.ComplainDepartmentName = defenderDetail.getString("descName");

                }
            }
            if (GlobalFunctions.getIsNotNull(response,"complainType")) {
                JSONObject defenderDetail = response.getJSONObject("complainTypeDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"descName")) {
                    model.ComplainTypeName = defenderDetail.getString("descName");

                }
            }
            if (GlobalFunctions.getIsNotNull(response,"defenderCaseSpecID")) {
                JSONObject defenderDetail = response.getJSONObject("defenderSpecDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"descName")) {
                    model.DefenderCaseSpecName = defenderDetail.getString("descName");
                }
            }
            if (GlobalFunctions.getIsNotNull(response,"lawyerID")) {
                JSONObject defenderDetail = response.getJSONObject("lawyerDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"empName")) {
                    model.EmployeeName = defenderDetail.getString("empName");
                }
            }
            if (GlobalFunctions.getIsNotNull(response,"priorityID")) {
                JSONObject defenderDetail = response.getJSONObject("priorityDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"descName")) {
                    model.PriorityName = defenderDetail.getString("descName");
                }
            }
            if (GlobalFunctions.getIsNotNull(response,"specialistID")) {
                JSONObject detail = response.getJSONObject("specialistDetail");
                if (GlobalFunctions.getIsNotNull(detail,"specializeCode")) {
                    model.SpecialistName = detail.getString("specializeCode");
                }
            }
            if (GlobalFunctions.getIsNotNull(response,"physicalFileID")) {
                JSONObject defenderDetail = response.getJSONObject("physicalFileDetail");
                if (GlobalFunctions.getIsNotNull(defenderDetail,"descName")) {
                    model.PhysicalFileName = defenderDetail.getString("descName");
                }
            }

        } catch (JSONException e) {
            //GlobalFunctions.showMessage("casefile parse error : " + model.FileNo + "::" + e.getMessage());
            e.printStackTrace();

        }

        return model;
    }

    public static ArrayList<CaseFollowupModel> parseCaseFollowupResponseArray(JSONArray response)
    {
        ArrayList<CaseFollowupModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseCaseFollowupResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static CaseFollowupModel parseCaseFollowupResponse(JSONObject response)
    {
        CaseFollowupModel model= new CaseFollowupModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "caseFollowUpID")) {
                model.CaseFollowUpID = response.getInt("caseFollowUpID");
            }
            if (GlobalFunctions.getIsNotNull(response, "caseFileID")) {
                model.CaseFileID = response.getInt("caseFileID");
            }
            if (GlobalFunctions.getIsNotNull(response, "clientID")) {
                model.ClientID = response.getInt("clientID");
            }
            if (GlobalFunctions.getIsNotNull(response, "clientSpecID")) {
                model.ClientSpecID = response.getInt("clientSpecID");
            }
            if (GlobalFunctions.getIsNotNull(response, "comments")) {
                model.Comments = response.getString("comments");
            }
            if (GlobalFunctions.getIsNotNull(response, "courtCaseNo")) {
                model.CourtCaseNo = response.getString("courtCaseNo");
            }
            if (GlobalFunctions.getIsNotNull(response, "daysAllowed")) {
                model.DaysAllowed = response.getInt("daysAllowed");
            }
            if (GlobalFunctions.getIsNotNull(response, "followUpDate")) {
                model.FollowUpDate = GlobalFunctions.getFormattedDate(response.getString("followUpDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "judgementDate")) {
                model.JudgementDate = GlobalFunctions.getFormattedDate(response.getString("judgementDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "judgementType")) {
                model.JudgementType = response.getInt("judgementType");
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtID")) {
                model.MainCourtID = response.getInt("mainCourtID");
            }
            if (GlobalFunctions.getIsNotNull(response, "nextDate")) {
                model.NextDate = GlobalFunctions.getFormattedDate(response.getString("nextDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "sessionDate")) {
                model.SessionDate = GlobalFunctions.getFormattedDate(response.getString("sessionDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "subCourtID")) {
                model.SubCourtID = response.getInt("subCourtID");
            }
            if (GlobalFunctions.getIsNotNull(response, "clientSpecID") && response.getInt("clientSpecID") !=0) {
                JSONObject detail = response.getJSONObject("clientSpecDetail");
                if (GlobalFunctions.getIsNotNull(detail,"descName")) {
                    model.ClientSpecName = detail.getString("descName");
                }
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtID") && response.getInt("mainCourtID") !=0) {
                JSONObject detail = response.getJSONObject("mainCourtDetail");
                if (GlobalFunctions.getIsNotNull(detail,"mainCourtCode")) {
                    model.MainCourtName = detail.getString("mainCourtCode");
                }
            }
            if (GlobalFunctions.getIsNotNull(response, "subCourtID") && response.getInt("subCourtID") !=0) {
                JSONObject detail = response.getJSONObject("subCourtDetail");
                if (GlobalFunctions.getIsNotNull(detail,"subCourtCode")) {
                    model.SubCourtName = detail.getString("subCourtCode");
                }
            }
            if (GlobalFunctions.getIsNotNull(response, "judgementType") && response.getInt("judgementType") !=0) {
                JSONObject detail = response.getJSONObject("JudgementTypeDetail");
                if (GlobalFunctions.getIsNotNull(detail,"descName")) {
                    model.JudgementTypeName = detail.getString("descName");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static List<InvoiceModel> parseInvoiceResponseArray(JSONArray response) {
        ArrayList<InvoiceModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseInvoiceResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static InvoiceModel parseInvoiceResponse(JSONObject response)
    {
        InvoiceModel model= new InvoiceModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "invoiceID")) {
                model.InvoiceID = response.getInt("invoiceID");
            }
            if (GlobalFunctions.getIsNotNull(response, "invoiceCode")) {
                model.InvoiceCode = response.getString("invoiceCode");
            }
            if (GlobalFunctions.getIsNotNull(response, "clientID")) {
                model.ClientID = response.getInt("clientID");
            }
            if (GlobalFunctions.getIsNotNull(response, "caseFileID")) {
                model.CaseFileID = response.getInt("caseFileID");
            }
            if (GlobalFunctions.getIsNotNull(response, "customerName")) {
                model.CustomerName = response.getString("customerName");
            }
            if (GlobalFunctions.getIsNotNull(response, "paymentMethod")) {
                model.PaymentMethod = response.getInt("paymentMethod");
            }
            if (GlobalFunctions.getIsNotNull(response, "paymentDate")) {
                model.PaymentDate = GlobalFunctions.getFormattedDate(response.getString("paymentDate"));
            }
            if (GlobalFunctions.getIsNotNull(response, "courtFee")) {
                model.CourtFee = response.getLong("courtFee");
            }
            if (GlobalFunctions.getIsNotNull(response, "officeFee")) {
                model.OfficeFee = response.getLong("officeFee");
            }
            if (GlobalFunctions.getIsNotNull(response, "paidHours")) {
                model.PaidHours = response.getInt("paidHours");
            }
            if (GlobalFunctions.getIsNotNull(response, "paidFee")) {
                model.PaidFee = response.getInt("paidFee");
            }
            if (GlobalFunctions.getIsNotNull(response, "totalAmount")) {
                model.TotalAmount = response.getLong("totalAmount");
            }
            if (GlobalFunctions.getIsNotNull(response, "isPaid")) {
                model.IsPaid = response.getInt("isPaid");
            }
            if (GlobalFunctions.getIsNotNull(response, "paidDate")) {
                model.PaidDate = response.getString("paidDate");
            }
            if (GlobalFunctions.getIsNotNull(response, "amountInWords")) {
                model.AmountInWords = response.getString("amountInWords");
            }
            if (GlobalFunctions.getIsNotNull(response, "comments")) {
                model.Comments = response.getString("comments");
            }
            if (GlobalFunctions.getIsNotNull(response, "statusID")) {
                model.StatusID = response.getInt("statusID");
            }
            if (GlobalFunctions.getIsNotNull(response, "contractFeeTypeID")) {
                model.ContractFeeTypeID = response.getInt("contractFeeTypeID");
            }
            if (GlobalFunctions.getIsNotNull(response, "lawyerID")) {
                model.LawyerID = response.getInt("lawyerID");
            }
            if (GlobalFunctions.getIsNotNull(response, "lawyerPercentage")) {
                model.LawyerPercentage = response.getInt("lawyerPercentage");
            }
            if (GlobalFunctions.getIsNotNull(response, "lawyerAmount")) {
                model.LawyerAmount = response.getInt("lawyerAmount");
            }
            if (GlobalFunctions.getIsNotNull(response, "companyBankID")) {
                model.CompanyBankID = response.getInt("companyBankID");
            }
            if (GlobalFunctions.getIsNotNull(response, "createdBy")) {
                model.CreatedBy = response.getInt("createdBy");
            }
            if (GlobalFunctions.getIsNotNull(response, "createdOn")) {
                model.CreatedOn = response.getString("createdOn");
            }


            if (GlobalFunctions.getIsNotNull(response, "clientID")) {
                JSONObject detail = response.getJSONObject("clientDetail");
                if (GlobalFunctions.getIsNotNull(detail,"descName")) {
                    model.ClientName = detail.getString("descName");
                }
            }
            if (GlobalFunctions.getIsNotNull(response, "mainCourtID")) {
                JSONObject detail = response.getJSONObject("caseFileDetail");
                if (GlobalFunctions.getIsNotNull(detail,"mainCourtCode")) {
                    model.CaseFileNo = detail.getString("mainCourtCode");
                }
            }
            if (GlobalFunctions.getIsNotNull(response, "subCourtID")) {
                JSONObject detail = response.getJSONObject("lawyerDetail");
                if (GlobalFunctions.getIsNotNull(detail,"subCourtCode")) {
                    model.LawyerName = detail.getString("subCourtCode");
                }
            }
            if (GlobalFunctions.getIsNotNull(response, "judgementType")) {
                JSONObject detail = response.getJSONObject("paymentMethodName");
                if (GlobalFunctions.getIsNotNull(detail,"descName")) {
                    model.PaymentMethodName = detail.getString("descName");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static List<CaseFileAttachmentModel> parseCaseAttachmentResponseArray(JSONArray response) {
        ArrayList<CaseFileAttachmentModel> models = new ArrayList<>();
        if (response!=null && response.length()>0){
            try {
                JSONArray array = response; //.getJSONArray("employees");
                for (int i=0; i<array.length(); i++){
                    models.add(parseCaseAttachmentResponse(array.getJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return models;
    }

    public static CaseFileAttachmentModel parseCaseAttachmentResponse(JSONObject response)
    {
        CaseFileAttachmentModel model= new CaseFileAttachmentModel();

        try {
            if (GlobalFunctions.getIsNotNull(response, "attachmentID")) {
                model.AttachmentID = response.getInt("attachmentID");
            }
            if (GlobalFunctions.getIsNotNull(response, "caseFileID")) {
                model.CaseFileID = response.getInt("caseFileID");
            }
            if (GlobalFunctions.getIsNotNull(response, "fileName")) {
                model.FileName = response.getString("fileName");
            }
            if (GlobalFunctions.getIsNotNull(response, "attachmentFileName")) {
                model.AttachmentFileName = response.getString("attachmentFileName");
            }
            if (GlobalFunctions.getIsNotNull(response, "createdBy")) {
                model.CreatedBy = response.getInt("createdBy");
            }
            if (GlobalFunctions.getIsNotNull(response, "createdOn")) {
                model.CreatedOn = GlobalFunctions.getFormattedDate(response.getString("createdOn"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return model;
    }

/*
    public static JSONArray parseCountByTypeStatus(JSONObject response)
    {
        JSONArray response;
        int returnValue = 0;
        if (response!=null){
            try {
                if (GlobalFunctions.getIsNotNull(response, "value")) {
                    returnValue = response.getInt("value");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return returnValue;
    }
*/
}
