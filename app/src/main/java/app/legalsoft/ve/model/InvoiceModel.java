package app.legalsoft.ve.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Syed.Rahman on 01/08/2015.
 */
public class InvoiceModel implements Parcelable {

    public int InvoiceID;
    public String InvoiceCode;
    public int ClientID;
    public int CaseFileID;
    public String CustomerName;
    public int PaymentMethod;
    public String PaymentDate;
    public float CourtFee;
    public float OfficeFee;
    public float PaidHours;
    public float PaidFee;
    public float TotalAmount;
    public int IsPaid;
    public String PaidDate;
    public String AmountInWords;
    public String Comments;
    public int StatusID;
    public int ContractFeeTypeID;
    public int LawyerID;
    public float LawyerPercentage;
    public float LawyerAmount;
    public int CompanyBankID;
    public int CreatedBy;
    public String CreatedOn;
    public String ChequeNo;

    public String ClientName;
    public String CaseFileNo;
    public String PaymentMethodName;
    public String ContractFeeTypeName;
    public String LawyerName;

    public InvoiceModel(){}

    public InvoiceModel(Parcel source) {
        InvoiceID = source.readInt();;
        InvoiceCode = source.readString();
        ClientID = source.readInt();;
        CaseFileID = source.readInt();;
        CustomerName= source.readString();
        PaymentMethod = source.readInt();;
        PaymentDate= source.readString();
        CourtFee = source.readFloat();
        OfficeFee = source.readFloat();
        PaidHours = source.readFloat();
        PaidFee = source.readFloat();
        TotalAmount = source.readFloat();
        IsPaid = source.readInt();;
        PaidDate= source.readString();
        AmountInWords= source.readString();
        Comments= source.readString();
        StatusID = source.readInt();;
        ContractFeeTypeID = source.readInt();;
        LawyerID = source.readInt();;
        LawyerPercentage = source.readFloat();
        LawyerAmount = source.readFloat();
        CompanyBankID = source.readInt();;
        CreatedBy = source.readInt();;
        CreatedOn= source.readString();
        ChequeNo= source.readString();

        ClientName= source.readString();
        CaseFileNo= source.readString();
        PaymentMethodName= source.readString();
        ContractFeeTypeName= source.readString();
        LawyerName= source.readString();
    }


    public int getInvoiceID() {
        return InvoiceID;
    }

    public String getInvoiceCode() {
        return InvoiceCode;
    }

    public int getClientID() {
        return ClientID;
    }

    public int getCaseFileID() {
        return CaseFileID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getPaymentMethod() {
        return PaymentMethod;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }

    public float getCourtFee() {
        return CourtFee;
    }

    public float getOfficeFee() {
        return OfficeFee;
    }

    public float getPaidHours() {
        return PaidHours;
    }

    public float getPaidFee() {
        return PaidFee;
    }

    public float getTotalAmount() {
        return TotalAmount;
    }

    public int getIsPaid() {
        return IsPaid;
    }

    public String getPaidDate() {
        return PaidDate;
    }

    public String getAmountInWords() {
        return AmountInWords;
    }

    public String getComments() {
        return Comments;
    }

    public int getStatusID() {
        return StatusID;
    }

    public int getContractFeeTypeID() {
        return ContractFeeTypeID;
    }

    public int getLawyerID() {
        return LawyerID;
    }

    public float getLawyerPercentage() {
        return LawyerPercentage;
    }

    public float getLawyerAmount() {
        return LawyerAmount;
    }

    public int getCompanyBankID() {
        return CompanyBankID;
    }

    public int getCreatedBy() {
        return CreatedBy;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public String getChequeNo() {
        return ChequeNo;
    }

    public String getClientName() {
        return ClientName;
    }

    public String getCaseFileNo() {
        return CaseFileNo;
    }

    public String getPaymentMethodName() {
        return PaymentMethodName;
    }

    public String getContractFeeTypeName() {
        return ContractFeeTypeName;
    }

    public String getLawyerName() {
        return LawyerName;
    }


    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putInt("InvoiceID", getInvoiceID());
        b.putString("InvoiceCode", getInvoiceCode());
        b.putInt("ClientID", getClientID());
        b.putInt("CaseFileID", getCaseFileID());
        b.putString("CustomerName", getCustomerName());
        b.putInt("PaymentMethod", getPaymentMethod());
        b.putString("PaymentDate", getPaymentDate());
        b.putFloat("CourtFee", getCourtFee());
        b.putFloat("OfficeFee", getOfficeFee());
        b.putFloat("PaidHours", getPaidHours());
        b.putFloat("PaidFee", getPaidFee());
        b.putFloat("TotalAmount", getTotalAmount());
        b.putInt("IsPaid", getIsPaid());
        b.putString("PaidDate", getPaidDate());
        b.putString("AmountInWords", getAmountInWords());
        b.putString("Comments", getComments());
        b.putInt("StatusID", getStatusID());
        b.putInt("ContractFeeTypeID", getContractFeeTypeID());
        b.putInt("LawyerID", getLawyerID());
        b.putFloat("LawyerPercentage", getLawyerPercentage());
        b.putFloat("LawyerAmount", getLawyerAmount());
        b.putInt("CompanyBankID", getCompanyBankID());
        b.putInt("CreatedBy", getCreatedBy());
        b.putString("CreatedOn", getCreatedOn());
        b.putString("ChequeNo", getChequeNo());
        b.putString("ClientName", getClientName());
        b.putString("CaseFileNo", getCaseFileNo());
        b.putString("PaymentMethodName", getPaymentMethodName());
        b.putString("ContractFeeTypeName", getContractFeeTypeName());
        b.putString("LawyerName", getLawyerName());

        return b;
    }

    public InvoiceModel fromBundel(Bundle bundle){
        InvoiceModel model = new InvoiceModel();
        Bundle b = bundle;
        model.InvoiceID = b.getInt("InvoiceID");
        model.InvoiceCode = b.getString("InvoiceCode");
        model.ClientID = b.getInt("ClientID");
        model.CaseFileID = b.getInt("CaseFileID");
        model.CustomerName = b.getString("CustomerName");
        model.PaymentMethod = b.getInt("PaymentMethod");
        model.PaymentDate = b.getString("PaymentDate");
        model.CourtFee = b.getFloat("CourtFee");
        model.OfficeFee = b.getFloat("OfficeFee");
        model.PaidHours = b.getFloat("PaidHours");
        model.PaidFee = b.getFloat("PaidFee");
        model.TotalAmount = b.getFloat("TotalAmount");
        model.IsPaid = b.getInt("IsPaid");
        model.PaidDate = b.getString("PaidDate");
        model.AmountInWords = b.getString("AmountInWords");
        model.Comments = b.getString("Comments");
        model.StatusID = b.getInt("StatusID");
        model.ContractFeeTypeID = b.getInt("ContractFeeTypeID");
        model.LawyerID = b.getInt("LawyerID");
        model.LawyerPercentage = b.getFloat("LawyerPercentage");
        model.LawyerAmount = b.getFloat("LawyerAmount");
        model.CompanyBankID = b.getInt("CompanyBankID");
        model.CreatedBy = b.getInt("CreatedBy");
        model.CreatedOn  = b.getString("CreatedOn");
        model.ChequeNo = b.getString("ChequeNo");
        model.ClientName = b.getString("ClientName");
        model.CaseFileNo = b.getString("CaseFileNo");
        model.PaymentMethodName = b.getString("PaymentMethodName");
        model.ContractFeeTypeName = b.getString("ContractFeeTypeName");
        model.LawyerName = b.getString("LawyerName");

        return model;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getInvoiceID());
        dest.writeString(getInvoiceCode());
        dest.writeInt(getClientID());
        dest.writeInt(getCaseFileID());
        dest.writeString(getCustomerName());
        dest.writeInt(getPaymentMethod());
        dest.writeString(getPaymentDate());
        dest.writeFloat(getCourtFee());
        dest.writeFloat(getOfficeFee());
        dest.writeFloat(getPaidHours());
        dest.writeFloat(getPaidFee());
        dest.writeFloat(getTotalAmount());
        dest.writeInt(getIsPaid());
        dest.writeString(getPaidDate());
        dest.writeString(getAmountInWords());
        dest.writeString(getComments());
        dest.writeInt(getStatusID());
        dest.writeInt(getContractFeeTypeID());
        dest.writeInt(getLawyerID());
        dest.writeFloat(getLawyerPercentage());
        dest.writeFloat(getLawyerAmount());
        dest.writeInt(getCompanyBankID());
        dest.writeInt(getCreatedBy());
        dest.writeString(getCreatedOn());
        dest.writeString(getChequeNo());
        dest.writeString(getClientName());
        dest.writeString(getCaseFileNo());
        dest.writeString(getPaymentMethodName());
        dest.writeString(getContractFeeTypeName());
        dest.writeString(getLawyerName());
    }

    public static final Parcelable.Creator<InvoiceModel> CREATOR = new Parcelable.Creator<InvoiceModel>(){

        @Override
        public InvoiceModel createFromParcel(Parcel source) {
            return new InvoiceModel(source);
        }

        @Override
        public InvoiceModel[] newArray(int size) {
            return new InvoiceModel[size];
        }
    };
}
