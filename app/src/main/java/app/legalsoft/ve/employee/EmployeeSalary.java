package app.legalsoft.ve.employee;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.legalsoft.ve.R;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;


public class EmployeeSalary extends ActionBarActivity {

    private Toolbar toolbar;
    private int EmpId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_salary);

        Intent intent = getIntent();
        EmpId = intent.getIntExtra("empId", 0);
        GlobalFunctions.showMessage("intent : " + EmpId);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_employee_salary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_done) {
            Intent intent = new Intent(MyApplication.getAppContext(), EmployeeDetail.class);
            intent.putExtra("employeeId", EmpId);
            intent.putExtra("currentTab", 1);       // to activate finance tab after salary activity close
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
