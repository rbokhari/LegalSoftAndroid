package app.legalsoft.ve.employee;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
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
import android.view.ContextThemeWrapper;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    private static final int PIC_CROP = 104;
    private Toolbar toolbar;

    static ViewPager mPager;
    static SlidingTabLayout mTabs;
    static int empId;
    static int currentTab = 0;
    static ImageView imgPicture ;
    static FragmentManager fragmentManager;
    final int REQUEST_CAMERA = 102;
    final int SELECT_FILE = 103;

    static EmployeeModel employeeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        fragmentManager = getSupportFragmentManager();

        imgPicture = (ImageView) findViewById(R.id.imgEmployeeDetailPicture);

        Intent intent = getIntent();
        empId = intent.getIntExtra("employeeId", 0);
        currentTab = intent.getIntExtra("currentTab",0);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPager = (ViewPager) findViewById(R.id.tabPager);
        mTabs = (SlidingTabLayout) findViewById(R.id.employeeTabs);
        mTabs.setDistributeEvenly(true);

        getData();

        mPager.setCurrentItem(currentTab);
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
            //Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //startActivityForResult(takePicture, ACTIVITY_SELECT_IMAGE);//zero can be replaced with any action code

            return true;
        }
        else if (id== R.id.action_AddContact){
            // Creates a new Intent to insert a contact
            Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            // Sets the MIME type to match the Contacts Provider
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.EMAIL, employeeModel.getEmpEmail())
                    .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                    .putExtra(ContactsContract.Intents.Insert.NAME, employeeModel.getEmpName())
                    .putExtra(ContactsContract.Intents.Insert.JOB_TITLE, employeeModel.getOccupation())
                    .putExtra(ContactsContract.Intents.Insert.POSTAL, employeeModel.getMailAddress())
                    .putExtra(ContactsContract.CommonDataKinds.Photo.PHOTO, employeeModel.getEmpPicture())
                    .putExtra(ContactsContract.Intents.Insert.PHONE, employeeModel.getGSM())
                    .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
            startActivity(intent);

            return true;
        }
        else if(id== R.id.action_Call){
            if (employeeModel!=null && employeeModel.getGSM().length()>0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + employeeModel.getGSM()));
                startActivity(callIntent);
            }
            return true;
        }
        else if (id==R.id.action_SMS){
            if (employeeModel!=null && employeeModel.getGSM().length()>0) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + employeeModel.getGSM()));
                //sendIntent.putExtra("sms_body", x);       // put extra message
                startActivity(sendIntent);
            }
            return true;
        }
        else if (id == R.id.action_email){
            if (employeeModel!=null && employeeModel.getEmpEmail().length()>0){
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "From LegalSoft");
                //intent.putExtra(Intent.EXTRA_TEXT, "Body of email");
                intent.setData(Uri.parse("mailto:" + employeeModel.getEmpEmail())); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }


    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        //AlertDialog.Builder builder = new AlertDialog.Builder(EmployeeDetail.this);
        //android.R.style.Theme_Holo_Light_DarkActionBar

        AlertDialog.Builder builder = new AlertDialog.Builder(
                new ContextThemeWrapper(EmployeeDetail.this, android.R.style.Theme_Holo));

        builder.setTitle("Update Photo");
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
            case SELECT_FILE:
                if(resultCode == RESULT_OK){

                    Uri selectedImage = data.getData();
/*
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    GlobalFunctions.m(filePathColumn[0]);
                    cursor.close();
*/
                    //Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);


                    imgPicture.setImageURI(selectedImage);


                    Bitmap thumbnail = null;
                    try {
                        thumbnail = MediaStore.Images.Media
                                .getBitmap(getContentResolver(), selectedImage);

                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        thumbnail.compress(Bitmap.CompressFormat.JPEG,100, stream);
                        byte[] imgBytes = stream.toByteArray();

                        // Update sqlLite database with this image
                        MyApplication.getWriteableDatabase().UpdatePhoto(empId, imgBytes);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    /*try {
                        InputStream inputStream = getContentResolver().openInputStream(selectedImage);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }*/

                }
                break;
            case REQUEST_CAMERA:
                if (resultCode == RESULT_OK){
                    //Uri selectedImage = data.getData();
                    //imgPicture.setImageURI(selectedImage);

                    performCrop(data.getData());

                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imgPicture.setImageBitmap(thumbnail);

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    thumbnail.compress(Bitmap.CompressFormat.JPEG,100, stream);
                    byte[] imgBytes = stream.toByteArray();

                    // Update sqlLite database with this image
                    MyApplication.getWriteableDatabase().UpdatePhoto(empId, imgBytes);

                }
                break;
        }
    }

    private void performCrop(Uri imageUri){
        try {
            //call the standard crop action intent (the user device may not support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            //indicate image type and Uri
            cropIntent.setDataAndType(imageUri, "image/*");
            //set crop properties
            cropIntent.putExtra("crop", "true");
            //indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            //indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            //retrieve data on return
            cropIntent.putExtra("return-data", true);
            //start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, PIC_CROP);
        }
        catch(ActivityNotFoundException anfe){
            //display an error message
            String errorMessage = "Whoops - your device doesn't support the crop action!";
            GlobalFunctions.showMessage(errorMessage);
        }
    }

    public static void getData(){
        employeeModel = MyApplication.getWriteableDatabase().readEmployeeById(empId + "");
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
