package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Blob;
import java.util.Date;

import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 28/03/2015.
 */
public class EmployeeModel implements Parcelable {

    public int EmployeeId;
    public String EmpCode;
    public String EmpName;
    public String EmpName_EN;
    public String FamilyName;
    public String SectionID;        // use comma separated with ID & Name
    public String GSM;
    public String Occupation;
    public String EmpEmail;
    public String LevelID;      // use comma separated with ID & Name
    public String MailAddress;
    public long EmpSalary;
    public long EmpAllowance;
    public String EmpPassword;
    public String BankName;
    public String BranchName;
    public String AccountNo;
    public String StartDate;
    public String EndDate;
    public byte[] EmpPicture;
    public int IsActive;
    public int IsAdmin;
    public String NationalityID;    // use comma separated with ID & Name
    public int CreatedBy;
    public String CreatedOn;
    public int UploadStatusID;

    public EmployeeModel(){}

    public EmployeeModel(Parcel source){
        GlobalFunctions.showMessage("From Parcel source");
        EmployeeId = source.readInt();
        EmpCode = source.readString();
        EmpName = source.readString();
        EmpName_EN = source.readString();
        FamilyName = source.readString();
        SectionID = source.readString();        // use comma separated with ID & Name
        GSM = source.readString();
        Occupation= source.readString();
        EmpEmail= source.readString();
        LevelID= source.readString();      // use comma separated with ID & Name
        MailAddress= source.readString();
        EmpSalary= source.readLong();
        EmpAllowance= source.readLong();
        EmpPassword= source.readString();
        BankName= source.readString();
        BranchName= source.readString();
        AccountNo= source.readString();
        StartDate = source.readString(); // new Date(source.readLong());
        EndDate= source.readString();
        IsActive= source.readInt();
        IsAdmin= source.readInt();
        NationalityID= source.readString();    // use comma separated with ID & Name
        CreatedBy= source.readInt();
        CreatedOn= source.readString();
        byte[] _byte = new byte[source.readInt()];
        source.readByteArray(_byte);
        //UploadStatusID= source.readString();
    }

    public Integer getEmpID() {
        return EmployeeId;
    }

    public String getEmpCode() {
        return EmpCode;
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getEmpName_EN() {
        return EmpName_EN;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public String getSectionID() {
        return SectionID;
    }

    public String getGSM() {
        return GSM;
    }

    public String getOccupation() {
        return Occupation;
    }

    public String getEmpEmail() {
        return EmpEmail;
    }

    public String getLevelID() {
        return LevelID;
    }

    public String getMailAddress() {
        return MailAddress;
    }

    public long getEmpSalary() {
        return EmpSalary;
    }

    public long getEmpAllowance() {
        return EmpAllowance;
    }

    public String getEmpPassword() {
        return EmpPassword;
    }

    public String getBankName() {
        return BankName;
    }

    public String getBranchName() {
        return BranchName;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public int getIsActive() {
        return IsActive;
    }

    public int getIsAdmin() {
        return IsAdmin;
    }

    public String getNationalityID() {
        return NationalityID;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public int getUploadStatusID() {
        return UploadStatusID;
    }

    public byte[] getEmpPicture() {
        return EmpPicture;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putInt("EmployeeId", getEmpID());
        bundle.putString("EmpCode", getEmpCode());
        bundle.putString("EmpName", getEmpName());
        bundle.putString("EmpName_EN",getEmpName_EN());
        bundle.putString("FamilyName",getFamilyName());
        bundle.putString("SectionID",getSectionID());
        bundle.putString("GSM",getGSM());
        bundle.putString("Occupation",getOccupation());
        bundle.putString("EmpEmail",getEmpEmail());
        bundle.putString("LevelID",getLevelID());
        bundle.putString("MailAddress", getMailAddress());
        bundle.putDouble("EmpSalary", getEmpSalary());
        bundle.putDouble("EmpAllowance", getEmpAllowance());
        bundle.putString("EmpPassword", getEmpPassword());
        bundle.putString("StartDate",getStartDate());
        bundle.putString("BankName",getBankName());
        bundle.putString("BranchName",getBranchName());
        bundle.putString("AccountNo",getAccountNo());
        bundle.putInt("IsActive", getIsActive());
        bundle.putInt("IsAdmin", getIsAdmin());
        bundle.putString("NationalityID",getNationalityID());
        bundle.putInt("CreatedBy", getCreatedBy());
        bundle.putString("CreatedOn", getCreatedOn());
        bundle.putInt("UploadStatusID", getUploadStatusID());
        bundle.putByteArray("EmpPicture", getEmpPicture());
        return bundle;
    }

    public EmployeeModel fromBundle(Bundle b){
        EmployeeModel employeeModel = new EmployeeModel();
        Bundle bundle = b;
        employeeModel.EmployeeId = bundle.getInt("EmployeeId");
        employeeModel.EmpCode = bundle.getString("EmpCode");
        employeeModel.EmpName = bundle.getString("EmpName");
        employeeModel.EmpName_EN = bundle.getString("EmpName_EN");
        employeeModel.FamilyName = bundle.getString("FamilyName");
        employeeModel.SectionID = bundle.getString("SectionID");
        employeeModel.GSM = bundle.getString("GSM");
        employeeModel.Occupation = bundle.getString("Occupation");
        employeeModel.EmpEmail = bundle.getString("EmpEmail");
        employeeModel.LevelID = bundle.getString("LevelID");
        employeeModel.MailAddress = bundle.getString("MailAddress");
        employeeModel.EmpSalary = (long)bundle.getDouble("EmpSalary");
        employeeModel.EmpAllowance = (long)bundle.getDouble("EmpAllowance");
        employeeModel.EmpPassword = bundle.getString("EmpPassword");
        employeeModel.BankName = bundle.getString("BankName");
        employeeModel.BranchName = bundle.getString("BranchName");
        employeeModel.AccountNo = bundle.getString("AccountNo");
        employeeModel.IsActive = bundle.getInt("IsActive");
        employeeModel.IsAdmin = bundle.getInt("IsAdmin");
        employeeModel.StartDate = bundle.getString("StartDate");
        employeeModel.NationalityID = bundle.getString("NationalityID");
        employeeModel.CreatedBy = bundle.getInt("CreatedBy");
        employeeModel.CreatedOn = bundle.getString("CreatedOn");
        employeeModel.UploadStatusID = bundle.getInt("UploadStatusID");
        employeeModel.EmpPicture = bundle.getByteArray("EmpPicture");
        return employeeModel;
    }

    @Override
    public String toString() {
        return getEmpName();
    }

    public static String Create_Table()
    {
        return "CREATE TABLE EmployeeDef(EmployeeId INTEGER PRIMARY KEY, Emp_code VARCHAR(500), " +
                "EmpName VARCHAR(500), EmpName_EN VARCHAR(500), " +
                "FamilyName VARCHAR(500), SectionID VARCHAR(255)," +
                "GSM VARCHAR(50), Occupation VARCHAR(255), EmpEmail VARCHAR(50), LevelID VARCHAR(255), " +
                "MailAddress VARCHAR(255), Bank VARCHAR(255), Branch VARCHAR(255), AccountNo NUMERIC(10,5), EmpSalary NUMERIC(10,5), EmpAllowance NUMERIC(10,5), EmpPassword VARCHAR(50), " +
                "StartDate VARCHAR(50), EndDate VARCHAR(50), IsActive INTEGER, IsAdmin INTEGER, NationalityID VARCHAR(255), CreatedBy INTEGER, " +
                "CreatedOn VARCHAR(100), UploadStatusID INTEGER, EmpPicture Blob);";

    }

    public static String Insert_Table(){
        return "INSERT INTO EmployeeDef(EmployeeId,Emp_code,EmpName,EmpName_EN, FamilyName, SectionID, " +
                "GSM,Occupation, EmpEmail, LevelID, MailAddress, Bank, Branch, AccountNo, EmpSalary, EmpAllowance, IsActive, IsAdmin, StartDate, EndDate, " +
                "NationalityID, CreatedBy, CreatedOn, EmpPicture) VALUES( " +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";   //1-24 Columns
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // Must be read in same order as saving right here
        dest.writeInt(EmployeeId);
        dest.writeString(EmpCode);
        dest.writeString(EmpName);
        dest.writeString(EmpName_EN);
        dest.writeString(FamilyName);
        dest.writeString(SectionID);        // use comma separated with ID & Name
        dest.writeString(GSM);
        dest.writeString(Occupation);
        dest.writeString(EmpEmail);
        dest.writeString(LevelID);      // use comma separated with ID & Name
        dest.writeString(MailAddress);
        dest.writeLong(EmpSalary);
        dest.writeLong(EmpAllowance);
        dest.writeString(EmpPassword);
        dest.writeString(BankName);
        dest.writeString(BranchName);
        dest.writeString(AccountNo);
/*        dest.writeLong(new Date(StartDate).getTime());
        dest.writeLong(new Date(EndDate).getTime());
        dest.writeInt(IsActive);
        dest.writeInt(IsAdmin);
        dest.writeString(NationalityID);    // use comma separated with ID & Name
        dest.writeInt(CreatedBy);
        dest.writeLong(new Date(CreatedOn).getTime());
        dest.writeInt(EmpPicture.length);
        dest.writeByteArray(EmpPicture);*/
        //dest.writeInt(UploadStatusID);
    }

    public static final Parcelable.Creator<EmployeeModel> CREATOR = new Parcelable.Creator<EmployeeModel>(){

        @Override
        public EmployeeModel createFromParcel(Parcel source) {
            return new EmployeeModel(source);
        }

        @Override
        public EmployeeModel[] newArray(int size) {
            return new EmployeeModel[size];
        }
    };

}
