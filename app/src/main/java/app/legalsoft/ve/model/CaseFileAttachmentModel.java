package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 01/08/2015.
 */
public class CaseFileAttachmentModel implements Parcelable {

    public int AttachmentID;
    public int CaseFileID;
    public String FileName;
    public String AttachmentFileName;
    public int CreatedBy;
    public String CreatedOn;

    public CaseFileAttachmentModel() {
    }

    public CaseFileAttachmentModel(Parcel source){
        AttachmentID = source.readInt();
        CaseFileID = source.readInt();
        FileName = source.readString();
        AttachmentFileName = source.readString();
        CreatedBy = source.readInt();
        CreatedOn = source.readString();
    }

    public int getAttachmentID() {
        return AttachmentID;
    }

    public int getCaseFileID() {
        return CaseFileID;
    }

    public String getFileName() {
        return FileName;
    }

    public String getAttachmentFileName() {
        return AttachmentFileName;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();

        bundle.putInt("AttachmentID", getAttachmentID());
        bundle.putInt("CaseFileID", getCaseFileID());
        bundle.putString("FileName", getFileName());
        bundle.putString("AttachmentFileName", getAttachmentFileName());
        bundle.putInt("CreatedBy", getCreatedBy());
        bundle.putString("CreatedOn", getCreatedOn());

        return bundle;
    }

    public CaseFileAttachmentModel fromBundle(Bundle bundle){
        CaseFileAttachmentModel model = new CaseFileAttachmentModel();
        model.AttachmentID = bundle.getInt("AttachmentID");
        model.CaseFileID = bundle.getInt("CaseFileID");
        model.FileName = bundle.getString("FileName");
        model.AttachmentFileName = bundle.getString("AttachmentFileName");
        model.CreatedBy = bundle.getInt("CreatedBy");
        model.CreatedOn  = bundle.getString("CreatedOn");

        return model;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getAttachmentID());
        dest.writeInt(getCaseFileID());
        dest.writeString(getFileName());
        dest.writeString(getAttachmentFileName());
        dest.writeInt(getCreatedBy());
        dest.writeString(getCreatedOn());
    }

    public static final Parcelable.Creator<CaseFileAttachmentModel> CREATOR = new Parcelable.Creator<CaseFileAttachmentModel>(){

        @Override
        public CaseFileAttachmentModel createFromParcel(Parcel source) {
            return new CaseFileAttachmentModel(source);
        }

        @Override
        public CaseFileAttachmentModel[] newArray(int size) {
            return new CaseFileAttachmentModel[size];
        }
    };
}
