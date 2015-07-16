package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 16/07/2015.
 */
public class SubCourtModel {

    public int SubCourtID;
    public String SubCourtCode;
    public String SubCourtCode_EN;
    public String SubCourtName;
    public int IsActive;

    public int getSubCourtID() {
        return SubCourtID;
    }

    public String getSubCourtCode() {
        return SubCourtCode;
    }

    public String getSubCourtCode_EN() {
        return SubCourtCode_EN;
    }

    public String getSubCourtName() {
        return SubCourtName;
    }

    public int getIsActive() {
        return IsActive;
    }

    public SubCourtModel(){}

    public SubCourtModel(Parcel source){
        SubCourtID = source.readInt();
        SubCourtCode= source.readString();
        SubCourtCode_EN = source.readString();
        SubCourtName = source.readString();
        IsActive = source.readInt();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("Id", getSubCourtID());
        bundle.putString("Code", getSubCourtCode());
        bundle.putString("CodeEn", getSubCourtCode_EN());
        bundle.putString("Name", getSubCourtName());
        bundle.putInt("Active", getIsActive());

        return bundle;
    }

    public SubCourtModel fromBundle(Bundle b){
        SubCourtModel model = new SubCourtModel();
        model.SubCourtID = b.getInt("Id");
        model.SubCourtCode = b.getString("Code");
        model.SubCourtCode_EN = b.getString("CodeEn");
        model.SubCourtName = b.getString("Name");
        model.IsActive = b.getInt("Active");

        return model;
    }

    @Override
    public String toString() {
        return getSubCourtCode();
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(getSubCourtID());
        dest.writeString(getSubCourtCode());
        dest.writeString(getSubCourtCode_EN());
        dest.writeString(getSubCourtName());
        dest.writeInt(getIsActive());

    }

    public static final Parcelable.Creator<SubCourtModel> CREATOR = new Parcelable.Creator<SubCourtModel>(){

        @Override
        public SubCourtModel createFromParcel(Parcel source) {
            return new SubCourtModel(source);
        }

        @Override
        public SubCourtModel[] newArray(int size) {
            return new SubCourtModel[size];
        }
    };

}
