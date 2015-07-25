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

    String API_URL = "http://192.168.1.38:84";
    String AuthToken_URL =  "http://amc.azurewebsites.net/token";
    String EMPLOYEES_API_URL = API_URL + "/api/employee";
    String CLIENTS_API_URL = API_URL + "/api/client";
    String OFFICEEXPENSE_API_URL = API_URL + "/api/officeexpense";
    //private static final String urlData = "http://192.168.1.37:84/api/employee";//
    String SPECIALIST_API_URL = API_URL + "/api/specialist/getActive";
    String MAINCOURT_API_URL = API_URL + "/api/maincourt/getActive";
    String SUBCOURT_API_URL = API_URL + "/api/subcourt/getactive";
    String DEFENDER_API_URL = API_URL + "/api/defender/getactive";

    String CASE_COUNT_API_URL = API_URL + "/api/case/GetCountTypeStatus/";
    String CASE_LIST_BY_TYPE_STATUS_API_URL = API_URL + "/api/case/GetCaseFileByType/" + CaseTypeID.CASE_FILE;



    DecimalFormat FORMAT_CURRENCY = new DecimalFormat("0.000");
    DecimalFormat FORMAT_QUANTITY = new DecimalFormat("0.00");

    DateFormat FORMAT_DATE = new SimpleDateFormat("DD-MM-yyyy");

    static class CaseTypeID{
        public static int CASE_FILE = 26;
        public static int CASE_BANK_FILE = 133;
        public static int CASE_BEFORE_COURT = 24;
        public static int CASE_CONSULTANCY = 25;
    }

    static class CaseStatusID {
        public static int CASE_FILE_OPEN = 3;
        public static int CASE_FILE_CLOSE = 7;

        public static int CASE_BEFORE_COURT_OPEN = 2;
        public static int CASE_BEFORE_COURT_CLOSE = 4;
        public static int CASE_BEFORE_COURT_TRANSFER = 6;

        public static int CASE_CONSULTANCY_OPEN = 1;
    }

}
