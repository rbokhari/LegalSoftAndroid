package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 29/07/2015.
 */
public class CaseFollowupModel implements Parcelable {

    public int CaseFollowUpID;
    public int CaseFileID;
    public int ClientID;
    public int MainCourtID;
    public int SubCourtID;
    public int SubCourtLocationID;
    public int ClientSpecID;
    public String CourtCaseNo;
    public String SessionDate;
    public String NextDate;
    public int TotalHours;
    public String Comments;
    public String JudgementDate;
    public int JudgementType;
    public int DaysAllowed;
    public String FollowUpDate;
    public int StatusID;

    public String MainCourtName;
    public String SubCourtName;
    public String ClientSpecName;
    public String JudgementTypeName;
    public String CreatedByName;

    public CaseFollowupModel() {}

    public CaseFollowupModel(Parcel source) {

    }

    public int getCaseFollowUpID() {
        return CaseFollowUpID;
    }

    public int getCaseFileID() {
        return CaseFileID;
    }

    public int getClientID() {
        return ClientID;
    }

    public int getMainCourtID() {
        return MainCourtID;
    }

    public int getSubCourtID() {
        return SubCourtID;
    }

    public int getSubCourtLocationID() {
        return SubCourtLocationID;
    }

    public int getClientSpecID() {
        return ClientSpecID;
    }

    public String getCourtCaseNo() {
        return CourtCaseNo;
    }

    public String getSessionDate() {
        return SessionDate;
    }

    public String getNextDate() {
        return NextDate;
    }

    public int getTotalHours() {
        return TotalHours;
    }

    public String getComments() {
        return Comments;
    }

    public String getJudgementDate() {
        return JudgementDate;
    }

    public int getJudgementType() {
        return JudgementType;
    }

    public int getDaysAllowed() {
        return DaysAllowed;
    }

    public String getFollowUpDate() {
        return FollowUpDate;
    }

    public int getStatusID() {
        return StatusID;
    }

    public String getMainCourtName() {
        return MainCourtName;
    }

    public String getSubCourtName() {
        return SubCourtName;
    }

    public String getClientSpecName() {
        return ClientSpecName;
    }

    public String getJudgementTypeName() {
        return JudgementTypeName;
    }

    public String getCreatedByName() {
        return CreatedByName;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();

        bundle.putInt("CaseFollowUpID", getCaseFollowUpID());
        bundle.putInt("CaseFileID", getCaseFileID());
        bundle.putInt("ClientID", getClientID());
        bundle.putInt("MainCourtID", getMainCourtID());
        bundle.putInt("SubCourtID", getSubCourtID());
        bundle.putInt("SubCourtLocationID", getSubCourtLocationID());
        bundle.putInt("ClientSpecID", getClientSpecID());
        bundle.putString("CourtCaseNo", getCourtCaseNo());
        bundle.putString("SessionDate", getSessionDate());
        bundle.putString("NextDate", getNextDate());
        bundle.putInt("TotalHours", getTotalHours());
        bundle.putString("Comments", getComments());
        bundle.putString("JudgementDate", getJudgementDate());
        bundle.putInt("JudgementType", getJudgementType());
        bundle.putInt("DaysAllowed", getDaysAllowed());
        bundle.putString("FollowUpDate", getFollowUpDate());

        bundle.putString("MainCourtName", getMainCourtName());
        bundle.putString("SubCourtName", getSubCourtName());
        bundle.putString("JudgementTypeName", getJudgementTypeName());
        bundle.putString("ClientSpecName", getClientSpecName());

        return bundle;
    }

    public CaseFollowupModel fromBundle(Bundle b){
        CaseFollowupModel model = new CaseFollowupModel();

        model.CaseFollowUpID = b.getInt("CaseFollowUpID");
        model.CaseFileID = b.getInt("CaseFileID");
        model.ClientID = b.getInt("ClientID");
        model.MainCourtID = b.getInt("MainCourtID");
        model.SubCourtID = b.getInt("SubCourtID");
        model.SubCourtLocationID = b.getInt("SubCourtLocationID");
        model.ClientSpecID = b.getInt("ClientSpecID");
        model.CourtCaseNo = b.getString("CourtCaseNo");
        model.SessionDate = b.getString("SessionDate");
        model.NextDate = b.getString("NextDate");
        model.TotalHours  = b.getInt("TotalHours");
        model.Comments = b.getString("Comments");
        model.JudgementDate = b.getString("JudgementDate");
        model.JudgementType = b.getInt("JudgementType");
        model.DaysAllowed = b.getInt("DaysAllowed");
        model.FollowUpDate = b.getString("FollowUpDate");

        model.MainCourtName = b.getString("MainCourtName");
        model.SubCourtName = b.getString("SubCourtName");
        model.JudgementTypeName = b.getString("JudgementTypeName");
        model.ClientSpecName = b.getString("ClientSpecName");

        return model;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<CaseFollowupModel> CREATOR = new Parcelable.Creator<CaseFollowupModel>(){

        @Override
        public CaseFollowupModel createFromParcel(Parcel source) {
            return new CaseFollowupModel(source);
        }

        @Override
        public CaseFollowupModel[] newArray(int size) {
            return new CaseFollowupModel[size];
        }
    };

}
