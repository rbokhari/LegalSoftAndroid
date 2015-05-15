package app.legalsoft.ve.employee;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.legalsoft.ve.PhotoDialog;
import app.legalsoft.ve.R;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.network.VolleySingleton;
import app.legalsoft.ve.tabs.EmployeeDetailTabPagerAdapter;
import app.legalsoft.ve.tabs.SlidingTabLayout;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;


public class EmployeeDetail extends ActionBarActivity {

    private Toolbar toolbar;

    static ViewPager mPager;
    static SlidingTabLayout mTabs;
    static int empId;
    static ImageView imgPicture ;
    static FragmentManager fragmentManager;
    final int ACTIVITY_SELECT_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        fragmentManager = getSupportFragmentManager();

        imgPicture = (ImageView) findViewById(R.id.imgEmployeeDetailPicture);

        Intent intent = getIntent();
        empId = intent.getIntExtra("employeeId", 0);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPager = (ViewPager) findViewById(R.id.tabPager);
        mTabs = (SlidingTabLayout) findViewById(R.id.employeeTabs);
        mTabs.setDistributeEvenly(true);

        getData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_employee_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Toast.makeText(this, "menu :" + id, Toast.LENGTH_SHORT).show();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_UpdatePhoto) {
            //Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
            selectImage();
            //PhotoDialog photoDialog = new PhotoDialog();
            //photoDialog.show(getSupportFragmentManager(), "Option");


            return true;
        }
        return super.onOptionsItemSelected(item);
    }
final int REQUEST_CAMERA = 102;
    final int SELECT_FILE = 103;

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(MyApplication.getAppContext());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case ACTIVITY_SELECT_IMAGE:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    GlobalFunctions.m(filePathColumn[0]);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);

                    imgPicture.setImageURI(selectedImage);
                }
        }
    }

    public static void getData(){
        EmployeeModel employeeModel = MyApplication.getWriteableDatabase().readEmployeeById(empId + "");
        if (employeeModel.getEmpPicture()!=null) {
            //GlobalFunctions.showMessage(MyApplication.getAppContext(), employeeModel.getEmpPicture().toString());
            //employeeModel.EmpPicture = jsonObject.getString("empPic");
            //byte[] decodedString = Base64.decode(employeeModel.getEmpPicture(), Base64.DEFAULT);
            //Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            imgPicture.setImageBitmap(BitmapFactory.decodeByteArray(employeeModel.getEmpPicture(),0, employeeModel.getEmpPicture().length));
        }
        mPager.setAdapter(new EmployeeDetailTabPagerAdapter(fragmentManager,employeeModel));
        mTabs.setViewPager(mPager);
    }
}
