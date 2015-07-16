package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 15/07/2015.
 */
public class MainCourtModel {

    public int MainCourtID;
    public String MainCourtCode;
    public String MainCourtCode_EN;
    public String MainCourtLocation;
    public String MainCourtSpecialist;
    public int IsActive;
    public int CreatedBy;
    public String CreatedOn;
    public int ModifiedBy;
    public String ModifiedOn;
    public int UploadStatusID;

    public int getMainCourtID() {
        return MainCourtID;
    }

    public String getMainCourtCode() {
        return MainCourtCode;
    }

    public String getMainCourtCode_EN() {
        return MainCourtCode_EN;
    }

    public String getMainCourtLocation() {
        return MainCourtLocation;
    }

    public String getMainCourtSpecialist() {
        return MainCourtSpecialist;
    }

    public int getIsActive() {
        return IsActive;
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

    public int getUploadStatusID() {
        return UploadStatusID;
    }

    public MainCourtModel(){}

    public MainCourtModel(Parcel source){
        MainCourtID = source.readInt();
        MainCourtCode = source.readString();
        MainCourtCode_EN = source.readString();
        MainCourtLocation = source.readString();
        MainCourtSpecialist = source.readString();
        IsActive = source.readInt();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("Id", getMainCourtID());
        bundle.putString("Code", getMainCourtCode());
        bundle.putString("CodeEn", getMainCourtCode_EN());
        bundle.putString("Location", getMainCourtLocation());
        bundle.putString("Specialist", getMainCourtSpecialist());
        bundle.putInt("Active", getIsActive());

        return bundle;
    }

    public MainCourtModel fromBundle(Bundle b){
        MainCourtModel model = new MainCourtModel();
        model.MainCourtID = b.getInt("Id");
        model.MainCourtCode = b.getString("Code");
        model.MainCourtCode_EN = b.getString("CodeEn");
        model.MainCourtLocation = b.getString("Location");
        model.MainCourtSpecialist = b.getString("Specialist");
        model.IsActive = b.getInt("Active");

        return model;
    }

    @Override
    public String toString() {
        return getMainCourtCode();
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(getMainCourtID());
        dest.writeString(getMainCourtCode());
        dest.writeString(getMainCourtCode_EN());
        dest.writeString(getMainCourtLocation());
        dest.writeString(getMainCourtSpecialist());
        dest.writeInt(getIsActive());

    }

    public static final Parcelable.Creator<MainCourtModel> CREATOR = new Parcelable.Creator<MainCourtModel>(){

        @Override
        public MainCourtModel createFromParcel(Parcel source) {
            return new MainCourtModel(source);
        }

        @Override
        public MainCourtModel[] newArray(int size) {
            return new MainCourtModel[size];
        }
    };

}
