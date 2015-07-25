package app.legalsoft.ve.model;

/**
 * Created by Syed.Rahman on 25/07/2015.
 */
public class CaseFileModel {

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

    public int getFileNo() {
        return FileNo;
    }
}
