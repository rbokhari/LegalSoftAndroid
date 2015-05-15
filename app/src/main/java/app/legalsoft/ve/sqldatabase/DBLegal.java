package app.legalsoft.ve.sqldatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.util.Base64;
import android.widget.Toast;

import java.util.ArrayList;

import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;

/**
 * Created by Syed.Rahman on 19/04/2015.
 */

public class DBLegal {

    private LegalDatabaseAdapter mAdapter;
    private SQLiteDatabase mDatabase;


    public DBLegal(Context context) {
        mAdapter = new LegalDatabaseAdapter(context);
        mDatabase = mAdapter.getWritableDatabase();
    }
/*
    public Boolean InsertEmployees(ArrayList<EmployeeModel> employeeModels, Boolean clearPrevious) {

        String insertSQL = "INSERT INTO EmployeeDef(EmployeeId,Emp_code,EmpName,EmpName_EN,FamilyName,SectionID,GSM,Occupation,EmpEmail,LevelID,MailAddress,EmpSalary,EmpAllowance,EmpPassword,IsActive,IsAdmin,NationalityID,CreatedBy,CreatedOn,UploadStatusID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = mDatabase.compileStatement(insertSQL);

        mDatabase.beginTransaction();
        for (int i = 0; i < employeeModels.size(); i++) {
            EmployeeModel currentEmp = employeeModels.get(i);
            statement.clearBindings();
            //for a given column index, simply bind the data to be put inside that index
            statement.bindLong(1, currentEmp.getEmpID());
            statement.bindString(2, currentEmp.getEmpCode());
            statement.bindString(3, currentEmp.getEmpName());
            statement.bindString(4, currentEmp.getEmpName_EN());
            statement.bindString(5, currentEmp.getFamilyName());
            statement.bindString(6, currentEmp.getSectionID());
            statement.bindString(7, currentEmp.getGSM());
            statement.bindString(8, currentEmp.getOccupation());
            statement.bindString(9, currentEmp.getEmpEmail());
            statement.bindString(10, currentEmp.getLevelID());
            statement.bindString(11, currentEmp.getMailAddress());
            statement.bindLong(12, currentEmp.getEmpSalary());
            statement.bindLong(13, currentEmp.getEmpAllowance());
            statement.bindString(14, currentEmp.getEmpPassword());
            statement.bindLong(15, currentEmp.getIsActive());
            statement.bindLong(16, currentEmp.getIsAdmin());
            statement.bindString(17, currentEmp.getNationalityID());
            statement.bindLong(18, currentEmp.getCreatedBy());
            statement.bindString(19, currentEmp.getCreatedOn().toString());
            statement.bindLong(20, currentEmp.getUploadStatusID());

            statement.execute();
        }
        mDatabase.setTransactionSuccessful();
        mDatabase.endTransaction();

        return true;
    }*/

    public Boolean InsertEmployees(ArrayList<EmployeeModel> employeeModels, Boolean clearPrevious) {
        if (employeeModels!=null || employeeModels.size()>0) {
            if (clearPrevious) {
                DeleteTableData("EmployeeDef");
            }
            /*String insertSQL = "INSERT INTO EmployeeDef(EmployeeId,Emp_code,EmpName,EmpName_EN, FamilyName, SectionID, " +
                    "GSM,Occupation, EmpEmail, LevelID, MailAddress, EmpSalary, EmpAllowance, IsActive, IsAdmin, StartDate, EndDate, " +
                    "NationalityID, CreatedBy, CreatedOn, EmpPicture) VALUES( " +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";   //1-21 Columns*/

            String insertSQL = EmployeeModel.Insert_Table();

            SQLiteStatement statement = mDatabase.compileStatement(insertSQL);
            GlobalFunctions.m("insertEmployees Started size :" + employeeModels.size());
            mDatabase.beginTransaction();
            for (int i = 0; i < employeeModels.size(); i++) {
                EmployeeModel currentEmp = employeeModels.get(i);
                statement.clearBindings();
                //for a given column index, simply bind the data to be put inside that index
                if (currentEmp.getEmpID() != 0) {
                    GlobalFunctions.m("EmployeeId : " + currentEmp.getEmpID());
                    statement.bindLong(1, currentEmp.getEmpID());
                    statement.bindString(2, currentEmp.getEmpCode() == null ? "" : currentEmp.getEmpCode());
                    statement.bindString(3, currentEmp.getEmpName() == null ? "" : currentEmp.getEmpName());
                    statement.bindString(4, currentEmp.getEmpName_EN() == null ? "" : currentEmp.getEmpName_EN());
                    statement.bindString(5, currentEmp.getFamilyName() == null ? "" : currentEmp.getFamilyName());
                    statement.bindString(6, currentEmp.getSectionID() == null ? "" : currentEmp.getSectionID());
                    statement.bindString(7, currentEmp.getGSM() == null ? "" : currentEmp.getGSM());
                    statement.bindString(8, currentEmp.getOccupation() == null ? "" : currentEmp.getOccupation());
                    statement.bindString(9, currentEmp.getEmpEmail() == null ? "" : currentEmp.getEmpEmail());
                    statement.bindString(10, currentEmp.getLevelID() == null ? "" : currentEmp.getLevelID());
                    statement.bindString(11, currentEmp.getMailAddress() == null ? "" : currentEmp.getMailAddress());
                    statement.bindString(12, currentEmp.getBankName() == null ? "" : currentEmp.getBankName());
                    statement.bindString(13, currentEmp.getBranchName() == null ? "" : currentEmp.getBranchName());
                    statement.bindString(14, currentEmp.getAccountNo() == null ? "" : currentEmp.getAccountNo());
                    statement.bindLong(15, currentEmp.getEmpSalary());
                    statement.bindLong(16, currentEmp.getEmpAllowance());
                    statement.bindLong(17, currentEmp.getIsActive());
                    statement.bindLong(18, currentEmp.getIsAdmin());
                    statement.bindString(19, currentEmp.getStartDate() == null ? "" : currentEmp.getStartDate());
                    statement.bindString(20, currentEmp.getEndDate() == null ? "" : currentEmp.getEndDate());
                    statement.bindString(21, currentEmp.getNationalityID() == null ? "" : currentEmp.getNationalityID());
                    statement.bindLong(22, currentEmp.getCreatedBy());
                    statement.bindString(23, currentEmp.getCreatedOn() == null ? "" : currentEmp.getCreatedOn());

                    if (currentEmp.getEmpPicture() != null) {
                        try {
                            //byte[] decodedString = Base64.decode(currentEmp.getEmpPicture(), Base64.DEFAULT);
                            statement.bindBlob(24, currentEmp.getEmpPicture());
                        } catch (IllegalArgumentException e) {
                            GlobalFunctions.m("<------- IllegalArgumentException : " + e.getMessage());
                            //statement.bindBlob(5, null);
                        }
                    } else {
                        //statement.bindNull(5);        // by default values are null
                        //statement.bindBlob(5, null);
                    }
                    statement.execute();
                }
            }
            mDatabase.setTransactionSuccessful();
            mDatabase.endTransaction();
            GlobalFunctions.m("insertEmployees finished ----------------------------");
        }
        else{
            GlobalFunctions.m("insertEmployees finished -- No Record to update !");
        }
        return true;
    }

    public ArrayList<EmployeeModel> readEmployees(String statusId) {
        ArrayList<EmployeeModel> list = new ArrayList<>();

        switch (statusId){
            case "0":
                statusId = "1";
                break;
            case "1":
                statusId = "0";
                break;
            case "2":
                statusId = "-1";
                break;
        }
        //get a list of columns to be retrieved, we need all of them
        String[] columns = {"EmployeeID, Emp_code, EmpName, EmpName_EN, Occupation, EmpPicture"};
        String whereClause = "IsActive = ?";
        String[] whereArgs = new String[] {
                statusId
        };
        Cursor cursor;

        if (statusId == "-1") {
            cursor = mDatabase.query("EmployeeDef", columns, null, null, null, null, null);
        }
        else {
            cursor = mDatabase.query("EmployeeDef", columns, whereClause, whereArgs, null, null, null);
        }

        if (cursor != null && cursor.moveToFirst()) {
            //L.m("loading entries " + cursor.getCount() + new Date(System.currentTimeMillis()));
            do {

                //create a new movie object and retrieve the data from the cursor to be stored in this movie object
                EmployeeModel employee = new EmployeeModel();
                //each step is a 2 part process, find the index of the column first, find the data of that column using
                //that index and finally set our blank movie object to contain our data
                employee.EmployeeId = cursor.getInt(0);
                //long releaseDateMilliseconds = cursor.getLong(cursor.getColumnIndex(MoviesHelper.COLUMN_RELEASE_DATE));
                employee.EmpCode = cursor.getString(1);
                employee.EmpName = cursor.getString(2);
                employee.EmpName_EN = cursor.getString(3);
                employee.Occupation = cursor.getString(4);
                employee.EmpPicture = cursor.getBlob(5);

                list.add(employee);
            }
            while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public EmployeeModel readEmployeeById(String id) {
        EmployeeModel employee= new EmployeeModel();

        //get a list of columns to be retrieved, we need all of them
        //String[] columns = {"EmployeeID, Emp_code, EmpName, EmpName_EN, EmpPicture"};
        String[] columns = {};
        /*String whereClause = "EmployeeId = ? AND IsActive = ?";
        String[] whereArgs = new String[] {
                id,
                "0"
        };*/
        String whereClause = "EmployeeId = ?";
        String[] whereArgs = new String[] {
                id
        };

        Cursor cursor = mDatabase.query("EmployeeDef", columns, whereClause, whereArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            employee.EmployeeId = cursor.getInt(0);
            //long releaseDateMilliseconds = cursor.getLong(cursor.getColumnIndex(MoviesHelper.COLUMN_RELEASE_DATE));
            employee.EmpCode = cursor.getString(1);
            employee.EmpName = cursor.getString(2);
            employee.EmpName_EN = cursor.getString(3);
            employee.FamilyName = cursor.getString(4);
            //GlobalFunctions.showMessage(MyApplication.getAppContext(), "section : " + cursor.getString(5));
            employee.SectionID = cursor.getString(5);

            employee.GSM = cursor.getString(6);
            employee.Occupation = cursor.getString(7);
            employee.EmpEmail = cursor.getString(8);
            employee.LevelID = cursor.getString(9);
            employee.MailAddress = cursor.getString(10);
            employee.BankName = cursor.getString(11);
            employee.BranchName = cursor.getString(12);
            employee.AccountNo = cursor.getString(13);
            employee.EmpSalary = cursor.getLong(14);
            employee.EmpAllowance = cursor.getLong(15);
            //employee.EmpPassword = cursor.getString(16);
            employee.StartDate = cursor.getString(17);
            employee.EndDate = cursor.getString(18);
            employee.IsActive = cursor.getInt(19);
            employee.IsAdmin = cursor.getInt(20);
            employee.NationalityID = cursor.getString(21);

            employee.EmpPicture = cursor.getBlob(25);

        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return employee;
    }

    public void DeleteTableData(String TableName) {
        mDatabase.delete(TableName, null, null);
    }

}