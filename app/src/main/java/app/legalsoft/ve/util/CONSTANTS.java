package app.legalsoft.ve.util;

/**
 * Created by Syed.Rahman on 25/04/2015.
 */
public interface CONSTANTS {

    String DATABASE_NAME="LegalSoftDatabase";
    int DATABASE_VERSION = 18;

    String EMPLOYEE_MODEL_PARCELABLE_KEY = "employee_model";

    int DEVICE_ORIENTATION_PORTRAIT = 1;
    int DEVICE_ORIENTATION_LANDSCAPE = 2;

    int EMPLOYEE_JOB_ID = 101;
    int EMPLOYEE_JOB_SERVICE_PERIODIC_INTERVAL = 99000;

    int OFFICEEXPENSE_JOB_ID = 102;
    int OFFICEEXPENSE_JOB_SERVICE_PERIODIC_INTERVAL = 99000;

    String API_URL = "http://192.168.159.1:84";
    String EMPLOYEES_API_URL = API_URL + "/api/employee";
    String OFFICEEXPENSE_API_URL = API_URL + "/api/officeexpense";
    //private static final String urlData = "http://192.168.1.37:84/api/employee";//

}
