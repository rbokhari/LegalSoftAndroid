package app.legalsoft.ve.util;

import android.app.Application;
import android.content.Context;

import app.legalsoft.ve.sqldatabase.DBLegal;

/**
 * Created by Syed.Rahman on 28/03/2015.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    private static DBLegal mDatabase;

    public void onCreate()
    {
        super.onCreate();
        sInstance = this;
        mDatabase = new DBLegal(this);
    }

    public synchronized static DBLegal getWriteableDatabase(){
        if (mDatabase==null){
            mDatabase = new DBLegal(getAppContext());
        }
        return mDatabase;
    }

    public static MyApplication getsInstance()
    {
        return sInstance;
    }

    public static Context getAppContext()
    {
        return sInstance.getApplicationContext();
    }

}
