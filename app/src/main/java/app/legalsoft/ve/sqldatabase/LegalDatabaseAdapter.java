package app.legalsoft.ve.sqldatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.model.OfficeExpenseDetailModel;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 19/04/2015.
 */
public class LegalDatabaseAdapter extends SQLiteOpenHelper {

    Context context;

    public LegalDatabaseAdapter(Context context) {
        super(context, CONSTANTS.DATABASE_NAME, null, CONSTANTS.DATABASE_VERSION);
        this.context = context;
        //GlobalFunctions.showMessage(context, "DB Adapter Constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(EmployeeModel.Create_Table());
            db.execSQL(OfficeExpenseModel.Create_Table());
            db.execSQL(OfficeExpenseDetailModel.Create_Table());
            GlobalFunctions.showMessage("onCreate Table Created");
        } catch (SQLException e) {
            Toast.makeText(context, "onCreate Error : " + e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

        GlobalFunctions.showMessage("onUpgrade");
    }


    public static void DeleteTableData(SQLiteDatabase database, String TableName) {
        database.delete(TableName, null, null);
    }
}
