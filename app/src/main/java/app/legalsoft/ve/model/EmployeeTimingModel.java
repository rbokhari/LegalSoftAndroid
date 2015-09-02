package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Syed.Rahman on 26/08/2015.
 */

public class EmployeeTimingModel implements Parcelable {

    private int TimingID;
    private String TimingCode;
    private String TimingDate;
    private int EmployeeId;
    private String EmployeeCode;
    private String EmployeeName;
    private int CaseFileId;
    private String CaseFileNo;
    private int ClientId;
    private String ClientCode;
    private String ClientName;
    private int DefenderId;
    private String DefenderName;
    private String TimingTypeName;
    private double Hours;
    private double Minutes;
    private String Comments;

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        this.ClientId = clientId;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        this.ClientCode = clientCode;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        this.ClientName = clientName;
    }

    public int getDefenderId() {
        return DefenderId;
    }

    public void setDefenderId(int defenderId) {
        this.DefenderId = defenderId;
    }

    public String getDefenderName() {
        return DefenderName;
    }

    public void setDefenderName(String defenderName) {
        this.DefenderName = defenderName;
    }

    public void setTimingID(int timingID) {
        this.TimingID = timingID;
    }

    public void setTimingCode(String timingCode) {
        this.TimingCode = timingCode;
    }

    public String getTimingDate() {
        return TimingDate;
    }

    public void setTimingDate(String timingDate) {
        this.TimingDate = timingDate;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.EmployeeId = employeeId;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.EmployeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public int getCaseFileId() {
        return CaseFileId;
    }

    public void setCaseFileId(int caseFileId) {
        this.CaseFileId = caseFileId;
    }

    public String getCaseFileNo() {
        return CaseFileNo;
    }

    public void setCaseFileNo(String caseFileNo) {
        this.CaseFileNo = caseFileNo;
    }

    public String getTimingTypeName() {
        return TimingTypeName;
    }

    public void setTimingTypeName(String timingTypeName) {
        this.TimingTypeName = timingTypeName;
    }

    public double getHours() {
        return Hours;
    }

    public void setHours(double hours) {
        this.Hours = hours;
    }

    public double getMinutes() {
        return Minutes;
    }

    public void setMinutes(double minutes) {
        this.Minutes = minutes;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }

    public EmployeeTimingModel(){}

    public int getTimingID() {return TimingID;}

    public String getTimingCode() {return TimingCode;}

    public EmployeeTimingModel(Parcel source) {
        TimingID = source.readInt();
        TimingCode = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putInt("TimingID", getTimingID());
        b.putString("TimingCode", getTimingCode());

        return b;
    }

    public EmployeeTimingModel fromBundel(Bundle bundle) {
        EmployeeTimingModel model = new EmployeeTimingModel();
        Bundle b = bundle;
        model.TimingID = b.getInt("TimingID");
        model.TimingCode = b.getString("TimingCode");

        return model;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getTimingID());
        dest.writeString(getTimingCode());
    }

    public static final Parcelable.Creator<EmployeeTimingModel> CREATOR = new Parcelable.Creator<EmployeeTimingModel>(){

        @Override
        public EmployeeTimingModel createFromParcel(Parcel source) {
            return new EmployeeTimingModel(source);
        }

        @Override
        public EmployeeTimingModel[] newArray(int size) {
            return new EmployeeTimingModel[size];
        }
    };

}
