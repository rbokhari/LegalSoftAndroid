package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 25/07/2015.
 */
public class CaseFileModel implements Parcelable {

    public int CaseFileID;
    public int FileNo;
    public int PriorityID;
    public String StartDate;
    public int ClientID;
    public int ClientSpecID;
    public int PhysicalFileID;
    public int MainCourtID;
    public int ConsultancyTypeID;
    public String ConsultancySubject;
    public int ActionTakenID;
    public String OtherPerson;
    public int ComplainType;
    public int ComplainDepartment;
    public String ComplainDate;
    public String FollowUpDate;
    public String CourtCaseNo;
    public int DefenderID;
    public int DefenderCaseSpecID;
    public String DefendentLawyer;
    public String LawyerName;
    public int SpecialistID;
    public int LawyerID;
    public String TotalHours;
    public String Comments;
    public String LastResult;
    public int StatusID;
    public int Type;
    public int ReferenceCaseFileID;
    public String CaseComputerNo;
    public float CommissionPercentage;
    public int IsContractCopy;
    public String ContractFileName;
    public String PhysicalContractFileName;
    public String BankFileNo;
    public String AccountNo;
    public String Division;
    public String CloseDate;
    public int CloseBy;
    public float ContractAmount;
    public int CreatedBy;
    public String CreatedOn;
    public int ModifiedBy;
    public String ModifiedOn;

    public String ClientName;
    public String PriorityName;
    public String ClientSpecName;
    public String PhysicalFileName;
    public String MainCourtName;
    public String DefenderName;
    public String ComplainDepartmentName;
    public String ComplainTypeName;
    public String DefenderCaseSpecName;
    public String SpecialistName;

    public String getComplainDepartmentName() {
        return ComplainDepartmentName;
    }

    public String getComplainTypeName() {
        return ComplainTypeName;
    }

    public String getDefenderCaseSpecName() {
        return DefenderCaseSpecName;
    }

    public String getSpecialistName() {
        return SpecialistName;
    }

    public int getCaseFileID() {
        return CaseFileID;
    }

    public int getPriorityID() {
        return PriorityID;
    }

    public String getStartDate() {
        return StartDate;
    }

    public int getClientID() {
        return ClientID;
    }

    public int getClientSpecID() {
        return ClientSpecID;
    }

    public int getPhysicalFileID() {
        return PhysicalFileID;
    }

    public int getMainCourtID() {
        return MainCourtID;
    }

    public int getConsultancyTypeID() {
        return ConsultancyTypeID;
    }

    public String getConsultancySubject() {
        return ConsultancySubject;
    }

    public int getActionTakenID() {
        return ActionTakenID;
    }

    public String getOtherPerson() {
        return OtherPerson;
    }

    public int getComplainType() {
        return ComplainType;
    }

    public int getComplainDepartment() {
        return ComplainDepartment;
    }

    public String getComplainDate() {
        return ComplainDate;
    }

    public String getFollowUpDate() {
        return FollowUpDate;
    }

    public String getCourtCaseNo() {
        return CourtCaseNo;
    }

    public int getDefenderID() {
        return DefenderID;
    }

    public int getDefenderCaseSpecID() {
        return DefenderCaseSpecID;
    }

    public String getDefendentLawyer() {
        return DefendentLawyer;
    }

    public String getLawyerName() {
        return LawyerName;
    }

    public int getSpecialistID() {
        return SpecialistID;
    }

    public int getLawyerID() {
        return LawyerID;
    }

    public String getTotalHours() {
        return TotalHours;
    }

    public String getComments() {
        return Comments;
    }

    public String getLastResult() {
        return LastResult;
    }

    public int getStatusID() {
        return StatusID;
    }

    public int getType() {
        return Type;
    }

    public int getReferenceCaseFileID() {
        return ReferenceCaseFileID;
    }

    public String getCaseComputerNo() {
        return CaseComputerNo;
    }

    public float getCommissionPercentage() {
        return CommissionPercentage;
    }

    public int getIsContractCopy() {
        return IsContractCopy;
    }

    public String getContractFileName() {
        return ContractFileName;
    }

    public String getPhysicalContractFileName() {
        return PhysicalContractFileName;
    }

    public String getBankFileNo() {
        return BankFileNo;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public String getDivision() {
        return Division;
    }

    public String getCloseDate() {
        return CloseDate;
    }

    public int getCloseBy() {
        return CloseBy;
    }

    public float getContractAmount() {
        return ContractAmount;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public int getModifiedBy() {
        return ModifiedBy;
    }

    public String getModifiedOn() {
        return ModifiedOn;
    }

    public String getClientName() {
        return ClientName;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    public String getClientSpecName() {
        return ClientSpecName;
    }

    public String getPhysicalFileName() {
        return PhysicalFileName;
    }

    public String getMainCourtName() {
        return MainCourtName;
    }

    public String getDefenderName() {
        return DefenderName;
    }

    public CaseFileModel() {}

    public CaseFileModel(Parcel source) {

    }

    public int getFileNo() {
        return FileNo;
    }


    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putInt("CaseFileId", getCaseFileID());
        bundle.putInt("FileNo", getFileNo());
        bundle.putString("StartDate", getStartDate());
        bundle.putInt("ClientId", getClientID());
        bundle.putString("ClientName", getClientName());
        bundle.putInt("ClientSpecID", getClientSpecID());
        bundle.putInt("PhysicalFileID", getPhysicalFileID());
        bundle.putInt("MainCourtID", getMainCourtID());
        bundle.putInt("ConsultancyTypeID", getConsultancyTypeID());
        bundle.putString("ConsultancySubject", getConsultancySubject());
        bundle.putInt("ActionTakenID", getActionTakenID());
        bundle.putString("OtherPerson", getOtherPerson());
        bundle.putInt("ComplainType", getComplainType());
        bundle.putInt("ComplainDepartment", getComplainDepartment());
        bundle.putString("ComplainDate", getComplainDate());
        bundle.putString("FollowUpDate", getFollowUpDate());
        bundle.putString("CourtCaseNo", getCourtCaseNo());
        bundle.putInt("DefenderID", getDefenderID());
        bundle.putInt("DefenderCaseSpecID", getDefenderCaseSpecID());
        bundle.putString("LawyerName", getLawyerName());
        bundle.putInt("SpecialistID", getSpecialistID());
        bundle.putInt("LawyerID", getLawyerID());
        bundle.putString("TotalHours", getTotalHours());
        bundle.putString("Comments", getComments());
        bundle.putString("LastResult", getLastResult());
        bundle.putInt("StatusID", getStatusID());
        bundle.putInt("Type", getType());
        bundle.putInt("ReferenceCaseFileID", getReferenceCaseFileID());
        bundle.putString("CaseComputerNo", getCaseComputerNo());
        bundle.putFloat("CommissionPercentage", getCommissionPercentage());
        bundle.putInt("IsContractCopy", getIsContractCopy());
        bundle.putString("ContractFileName", getContractFileName());
        bundle.putString("PhysicalContractFileName", getPhysicalContractFileName());
        bundle.putString("BankFileNo", getBankFileNo());
        bundle.putString("AccountNo", getAccountNo());
        bundle.putString("Division", getDivision());
        bundle.putString("CloseDate", getCloseDate());
        bundle.putInt("CloseBy", getCloseBy());
        bundle.putFloat("ContractAmount", getContractAmount());
        bundle.putInt("CreatedBy", getCreatedBy());
        bundle.putString("CreatedOn", getCreatedOn());
        bundle.putInt("ModifiedBy", getModifiedBy());
        bundle.putString("ModifiedOn", getModifiedOn());

        bundle.putString("ClientName", getClientName());
        bundle.putString("PriorityName", getPriorityName());
        bundle.putString("ClientSpecName", getClientSpecName());
        bundle.putString("PhysicalFileName", getPhysicalFileName());
        bundle.putString("MainCourtName", getMainCourtName());
        bundle.putString("DefenderName", getDefenderName());

        return bundle;
    }

    public CaseFileModel fromBundle(Bundle b){
        CaseFileModel caseFileModel = new CaseFileModel();
        Bundle bundle = b;
        caseFileModel.CaseFileID = bundle.getInt("CaseFileId");

        caseFileModel.FileNo = bundle.getInt("FileNo");
        caseFileModel.StartDate = bundle.getString("StartDate");
        caseFileModel.ClientID = bundle.getInt("ClientId");
        caseFileModel.ClientName = bundle.getString("ClientName");
        caseFileModel.ClientSpecID = bundle.getInt("ClientSpecID");
        caseFileModel.PhysicalFileID = bundle.getInt("PhysicalFileID");
        caseFileModel.MainCourtID = bundle.getInt("MainCourtID");
        caseFileModel.ConsultancyTypeID = bundle.getInt("ConsultancyTypeID");
        caseFileModel.ConsultancySubject = bundle.getString("ConsultancySubject");
        caseFileModel.ActionTakenID = bundle.getInt("ActionTakenID");
        caseFileModel.OtherPerson = bundle.getString("OtherPerson");
        caseFileModel.ComplainType = bundle.getInt("ComplainType");
        caseFileModel.ComplainDepartment = bundle.getInt("ComplainDepartment");
        caseFileModel.ComplainDate = bundle.getString("ComplainDate");
        caseFileModel.FollowUpDate = bundle.getString("FollowUpDate");
        caseFileModel.CourtCaseNo = bundle.getString("CourtCaseNo");
        caseFileModel.DefenderID = bundle.getInt("DefenderID");
        caseFileModel.DefenderCaseSpecID = bundle.getInt("DefenderCaseSpecID");
        caseFileModel.LawyerName = bundle.getString("LawyerName");
        caseFileModel.SpecialistID = bundle.getInt("SpecialistID");
        caseFileModel.LawyerID = bundle.getInt("LawyerID");
        caseFileModel.TotalHours = bundle.getString("TotalHours");
        caseFileModel.Comments = bundle.getString("Comments");
        caseFileModel.LastResult = bundle.getString("LastResult");
        caseFileModel.StatusID = bundle.getInt("StatusID");
        caseFileModel.Type = bundle.getInt("Type");
        caseFileModel.ReferenceCaseFileID = bundle.getInt("ReferenceCaseFileID");
        caseFileModel.CaseComputerNo = bundle.getString("CaseComputerNo");
        caseFileModel.CommissionPercentage = bundle.getFloat("CommissionPercentage");
        caseFileModel.IsContractCopy = bundle.getInt("IsContractCopy");
        caseFileModel.ContractFileName = bundle.getString("ContractFileName");
        caseFileModel.PhysicalContractFileName = bundle.getString("PhysicalContractFileName");
        caseFileModel.BankFileNo = bundle.getString("BankFileNo");
        caseFileModel.AccountNo = bundle.getString("AccountNo");
        caseFileModel.Division = bundle.getString("Division");
        caseFileModel.CloseDate = bundle.getString("CloseDate");
        caseFileModel.CloseBy = bundle.getInt("CloseBy");
        caseFileModel.ContractAmount = bundle.getFloat("ContractAmount");
        caseFileModel.CreatedBy = bundle.getInt("CreatedBy");
        caseFileModel.CreatedOn = bundle.getString("CreatedOn");
        caseFileModel.ModifiedBy = bundle.getInt("ModifiedBy");
        caseFileModel.ModifiedOn = bundle.getString("ModifiedOn");

        caseFileModel.ClientName = bundle.getString("ClientName");
        caseFileModel.PriorityName = bundle.getString("PriorityName");
        caseFileModel.ClientSpecName = bundle.getString("ClientSpecName");
        caseFileModel.PhysicalFileName = bundle.getString("PhysicalFileName");
        caseFileModel.MainCourtName = bundle.getString("MainCourtName");
        caseFileModel.DefenderName = bundle.getString("DefenderName");

        return caseFileModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<CaseFileModel> CREATOR = new Parcelable.Creator<CaseFileModel>(){

        @Override
        public CaseFileModel createFromParcel(Parcel source) {
            return new CaseFileModel(source);
        }

        @Override
        public CaseFileModel[] newArray(int size) {
            return new CaseFileModel[size];
        }
    };
}
