package app.legalsoft.ve.employee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 02/09/2015.
 */
public class EmployeeTimingDetail extends AppCompatActivity {

    private Toolbar toolbar;

    TextView tCode;
    TextView tDate;
    TextView tEmployee;
    TextView tCase;
    TextView tClient;
    TextView tDefender;
    TextView tType;
    TextView tTime;
    TextView tNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_employee_timing_detail);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Timing Sheet Detail");


        tCode = (TextView) findViewById(R.id.tTimingCode);
        tDate = (TextView) findViewById(R.id.tTimingDate);
        tEmployee = (TextView) findViewById(R.id.tEmployeeName);
        tCase = (TextView) findViewById(R.id.tCase);
        tClient = (TextView) findViewById(R.id.tClientName);
        tDefender = (TextView) findViewById(R.id.tDefenderName);
        tType = (TextView) findViewById(R.id.tTypeName);
        tTime = (TextView) findViewById(R.id.tTime);
        tNotes = (TextView) findViewById(R.id.tNotes);



    }
}
