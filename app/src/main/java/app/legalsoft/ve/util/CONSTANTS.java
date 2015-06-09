package app.legalsoft.ve.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Syed.Rahman on 25/04/2015.
 */
public interface CONSTANTS {

    String DATABASE_NAME="LegalSoftDatabase";
    int DATABASE_VERSION = 18;

    String EMPLOYEE_MODEL_PARCELABLE_KEY = "employee_model";

    int DEVICE_ORIENTATION_PORTRAIT = 1;
    int DEVICE_ORIENTATION_LANDSCAPE = 2;


    int RECYCLERVIEW_VIEWTYPE_HEADER = 1;
    int RECYCLERVIEW_VIEWTYPE_SUBHEADER = 2;
    int RECYCLERVIEW_VIEWTYPE_ITEM = 3;

    double OFFICE_LATITUDE = 23.597966;
    double OFFICE_LONGITUDE = 58.215920;

    int EMPLOYEE_JOB_ID = 101;
    int EMPLOYEE_JOB_SERVICE_PERIODIC_INTERVAL = 99000;

    int OFFICEEXPENSE_JOB_ID = 102;
    int OFFICEEXPENSE_JOB_SERVICE_PERIODIC_INTERVAL = 99000;

    String API_URL = "http://192.168.1.35:84";
    String EMPLOYEES_API_URL = API_URL + "/api/employee";
    String CLIENTS_API_URL = API_URL + "/api/client";
    String OFFICEEXPENSE_API_URL = API_URL + "/api/officeexpense";
    //private static final String urlData = "http://192.168.1.37:84/api/employee";//


    DecimalFormat FORMAT_CURRENCY = new DecimalFormat("0.000");
    DecimalFormat FORMAT_QUANTITY = new DecimalFormat("0.00");

    DateFormat FORMAT_DATE = new SimpleDateFormat("DD-MM-yyyy");

}
