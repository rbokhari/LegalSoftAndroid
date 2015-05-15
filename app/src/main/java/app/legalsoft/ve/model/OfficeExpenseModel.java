package app.legalsoft.ve.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 11/05/2015.
 */
public class OfficeExpenseModel implements Parcelable {

    public int ExpenseID;
    public String ExpenseCode;
    public String ExpenseDate;
    public int MonthID;
    public int Year;
    public int TotalEmpInsurrance;
    public int TotalCompanyInsurrance;
    public int TotalRent;
    public int PettyCash;
    public int TotalSupport;
    public int Installment;
    public int TotalSalary;
    public int GrandTotal;
    public int BankAccountID;
    public int CreatedBy;
    public String CreatedOn;
    public int ModifiedBy;
    public String ModifiedOn;

    public int getExpenseID() {
        return ExpenseID;
    }

    public String getExpenseCode() {
        return ExpenseCode;
    }

    public String getExpenseDate() {
        return ExpenseDate;
    }

    public int getMonthID() {
        return MonthID;
    }

    public int getYear() {
        return Year;
    }

    public int getTotalEmpInsurrance() {
        return TotalEmpInsurrance;
    }

    public int getTotalCompanyInsurrance() {
        return TotalCompanyInsurrance;
    }

    public int getTotalRent() {
        return TotalRent;
    }

    public int getPettyCash() {
        return PettyCash;
    }

    public int getTotalSupport() {
        return TotalSupport;
    }

    public int getInstallment() {
        return Installment;
    }

    public int getTotalSalary() {
        return TotalSalary;
    }

    public int getGrandTotal() {
        return GrandTotal;
    }

    public int getBankAccountID() {
        return BankAccountID;
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

    public static String Create_Table()
    {
        return "CREATE TABLE OfficeExpense(ExpenseID INTEGER PRIMARY KEY, ExpenseCode VARCHAR(100), " +
                "ExpenseDate VARCHAR(50), MonthID INTEGER, " +
                "Year INTEGER, TotalEmpInsurrance NUMERIC(10,5)," +
                "TotalCompanyInsurrance NUMERIC(10,5), TotalRent NUMERIC(10,5), PettyCash NUMERIC(10,5), TotalSupport NUMERIC(10,5), " +
                "Installment NUMERIC(10,5), TotalSalary NUMERIC(10,5), GrandTotal NUMERIC(10,5), BankAccountID INTEGER, CreatedBy INTEGER, " +
                "CreatedOn VARCHAR(100), ModifiedBy INTEGER, ModifiedOn VARCHAR(50));";

    }

    public static String Insert_Table(){
        return "INSERT INTO OfficeExpense(ExpenseID, ExpenseCode,ExpenseDate,MonthID, Year, TotalEmpInsurrance, " +
                "TotalCompanyInsurrance,TotalRent, PettyCash, TotalSupport, Installment, TotalSalary, GrandTotal, BankAccountID, CreatedBy, CreatedOn, ModifiedBy, ModifiedOn) VALUES( " +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";   //1-18 Columns
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getExpenseID());
        dest.writeString(getExpenseCode());
        dest.writeString(getExpenseDate());
        dest.writeInt(getMonthID());
        dest.writeInt(getYear());
        dest.writeInt(getTotalEmpInsurrance());
        dest.writeInt(getTotalCompanyInsurrance());
        dest.writeInt(getTotalRent());
        dest.writeInt(getPettyCash());
        dest.writeInt(getTotalSupport());
        dest.writeInt(getInstallment());
        dest.writeInt(getTotalSalary());
        dest.writeInt(getGrandTotal());
        dest.writeInt(getBankAccountID());
        dest.writeInt(getCreatedBy());
        dest.writeString(getCreatedOn());
        dest.writeInt(getModifiedBy());
        dest.writeString(getModifiedOn());

    }

    public static final Parcelable.Creator<OfficeExpenseModel> CREATOR = new Parcelable.Creator<OfficeExpenseModel>(){

        @Override
        public OfficeExpenseModel createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public OfficeExpenseModel[] newArray(int size) {
            return new OfficeExpenseModel[size];
        }
    };

}
