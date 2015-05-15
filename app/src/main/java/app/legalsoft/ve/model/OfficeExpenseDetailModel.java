package app.legalsoft.ve.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 11/05/2015.
 */
public class OfficeExpenseDetailModel implements Parcelable {

    public int ExpenseDetailID;
    public int ExpenseID;
    public int EmployeeID;
    public int Salary;
    public int SalaryAllowance;
    public int OtherAllowance;
    public int EmpInsurrance;
    public int CompanyInsurrance;
    public int Total;
    public String Remarks;

    public int getExpenseDetailID() {
        return ExpenseDetailID;
    }

    public int getExpenseID() {
        return ExpenseID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public int getSalary() {
        return Salary;
    }

    public int getSalaryAllowance() {
        return SalaryAllowance;
    }

    public int getOtherAllowance() {
        return OtherAllowance;
    }

    public int getEmpInsurrance() {
        return EmpInsurrance;
    }

    public int getCompanyInsurrance() {
        return CompanyInsurrance;
    }

    public int getTotal() {
        return Total;
    }

    public String getRemarks() {
        return Remarks;
    }

    public static String Create_Table()
    {
        return "CREATE TABLE OfficeExpenseDetail(ExpenseDetailID INTEGER PRIMARY KEY, ExpenseID INTEGER, EmployeeID INTEGER, " +
                "Salary NUMERIC(10,5), " +
                "SalaryAllowance NUMERIC(10,5), OtherAllowance NUMERIC(10,5)," +
                "EmpInsurrance NUMERIC(10,5), CompanyInsurrance NUMERIC(10,5), Total NUMERIC(10,5), Remarks VARCHAR(255));";

    }

    public static String Insert_Table(){
        return "INSERT INTO OfficeExpenseDetail(ExpenseDetailID, ExpenseID, EmployeeID,Salary,SalaryAllowance, OtherAllowance, EmpInsurrance, " +
                "CompanyInsurrance,Total, Remarks) VALUES( " +
                "?,?,?,?,?,?,?,?,?,?)";   //1-10 Columns
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getExpenseDetailID());
        dest.writeInt(getExpenseID());
        dest.writeInt(getEmployeeID());
        dest.writeDouble(getSalary());
        dest.writeDouble(getSalaryAllowance());
        dest.writeDouble(getOtherAllowance());
        dest.writeDouble(getEmpInsurrance());
        dest.writeDouble(getCompanyInsurrance());
        dest.writeDouble(getTotal());
        dest.writeString(getRemarks());
    }

    public static final Parcelable.Creator<OfficeExpenseDetailModel> CREATOR = new Parcelable.Creator<OfficeExpenseDetailModel>(){

        @Override
        public OfficeExpenseDetailModel createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public OfficeExpenseDetailModel[] newArray(int size) {
            return new OfficeExpenseDetailModel[size];
        }
    };

}
