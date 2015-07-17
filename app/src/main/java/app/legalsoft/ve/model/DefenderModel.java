package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 17/07/2015.
 */
public class DefenderModel {

    public int DefenderID;
    public String DefenderCode;
    public String DefenderName;
    public String DefenderName_EN;
    public int IsActive;
    public String LoginPassword;
    public int CreatedBy;
    public String CreatedOn;
    public int ModifiedBy;
    public String ModifiedOn;

    public int getDefenderID() {
        return DefenderID;
    }

    public String getDefenderCode() {
        return DefenderCode;
    }

    public String getDefenderName() {
        return DefenderName;
    }

    public String getDefenderName_EN() {
        return DefenderName_EN;
    }

    public int getIsActive() {
        return IsActive;
    }

    public String getLoginPassword() {
        return LoginPassword;
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

    public DefenderModel() {}

    public DefenderModel(Parcel source){
        DefenderID = source.readInt();
        DefenderCode = source.readString();
        DefenderName = source.readString();
        DefenderName_EN = source.readString();
        IsActive = source.readInt();
        CreatedBy = source.readInt();
        CreatedOn = source.readString();

    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("Id", getDefenderID());
        bundle.putString("Code", getDefenderCode());
        bundle.putString("Name", getDefenderName());
        bundle.putString("NameEn", getDefenderName_EN());
        bundle.putInt("Active", getIsActive());

        return bundle;
    }

    public SpecialistModel fromBundle(Bundle b){
        SpecialistModel model = new SpecialistModel();
        model.SpecializeID = b.getInt("Id");
        model.SpecializeCode = b.getString("Code");
        model.SpecializeCode_EN = b.getString("CodeEn");
        model.SpecializeArea = b.getString("Area");
        model.IsActive = b.getInt("Active");

        return model;
    }

    @Override
    public String toString() {
        return getDefenderName();
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(getDefenderID());
        dest.writeString(getDefenderCode());
        dest.writeString(getDefenderName());
        dest.writeString(getDefenderName_EN());
        dest.writeInt(getIsActive());

    }

    public static final Parcelable.Creator<DefenderModel> CREATOR = new Parcelable.Creator<DefenderModel>(){

        @Override
        public DefenderModel createFromParcel(Parcel source) {
            return new DefenderModel(source);
        }

        @Override
        public DefenderModel[] newArray(int size) {
            return new DefenderModel[size];
        }
    };
}
