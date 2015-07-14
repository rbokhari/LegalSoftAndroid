package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import app.legalsoft.ve.definition.SpecialistFragment;

/**
 * Created by Syed.Rahman on 14/07/2015.
 */
public class SpecialistModel {

    public int SpecializeID;
    public String SpecializeCode;
    public String SpecializeCode_EN;
    public String SpecializeArea;
    public int IsActive;
    public int CreatedBy;
    public String CreatedOn;
    public int UploadStatusID;

    public int getSpecializeID() {
        return SpecializeID;
    }

    public String getSpecializeCode() {
        return SpecializeCode;
    }

    public String getSpecializeCode_EN() {
        return SpecializeCode_EN;
    }

    public String getSpecializeArea() {
        return SpecializeArea;
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

    public int getUploadStatusID() {
        return UploadStatusID;
    }


    public SpecialistModel(){}

    public SpecialistModel(Parcel source){
        SpecializeID = source.readInt();
        SpecializeCode = source.readString();
        SpecializeCode_EN = source.readString();
        SpecializeArea = source.readString();
        IsActive = source.readInt();
        CreatedBy = source.readInt();
        CreatedOn = source.readString();

    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("Id", getSpecializeID());
        bundle.putString("Code", getSpecializeCode());
        bundle.putString("CodeEn", getSpecializeCode_EN());
        bundle.putString("Area", getSpecializeArea());
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
        return getSpecializeCode();
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(getSpecializeID());
        dest.writeString(getSpecializeCode());
        dest.writeString(getSpecializeCode_EN());
        dest.writeString(getSpecializeArea());
        dest.writeInt(getIsActive());

    }

    public static final Parcelable.Creator<SpecialistModel> CREATOR = new Parcelable.Creator<SpecialistModel>(){

        @Override
        public SpecialistModel createFromParcel(Parcel source) {
            return new SpecialistModel(source);
        }

        @Override
        public SpecialistModel[] newArray(int size) {
            return new SpecialistModel[size];
        }
    };

}
