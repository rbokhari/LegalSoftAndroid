package app.legalsoft.ve.employee;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.OfficeExpenseDetailModel;
import app.legalsoft.ve.model.OfficeExpenseModel;
import app.legalsoft.ve.recycler.rvEmployeeSalaryAdapter;
import app.legalsoft.ve.util.DividerItemDecoration;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;


public class EmployeeSalary extends AppCompatActivity {   //ActionBarActivity

    private Toolbar toolbar;
    TextView tHeading ;
    private int EmpId;

    RecyclerView rvExpense;

    private static rvEmployeeSalaryAdapter adapter;
    private static ArrayList<OfficeExpenseDetailModel> expenseDetailList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_salary);

        rvExpense = (RecyclerView) findViewById(R.id.RVSalary);
        tHeading = (TextView) findViewById(R.id.tHeading);

        Intent intent = getIntent();
        EmpId = intent.getIntExtra("empId", 0);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Salary Transaction");
        adapter = new rvEmployeeSalaryAdapter(MyApplication.getAppContext());
        tHeading.setText(intent.getStringExtra("empName"));

        getData();

        rvExpense.setHasFixedSize(true);
        rvExpense.setLayoutManager(new LinearLayoutManager(MyApplication.getAppContext()));
        rvExpense.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));

        adapter.setEmployeeSalaryList(expenseDetailList);

        rvExpense.setAdapter(adapter);
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

    private void getData(){
        expenseDetailList = MyApplication.getWriteableDatabase().getOfficeExpenseByEmployeeId(EmpId);

        GlobalFunctions.m("Total Year found : " + expenseDetailList.size());
    }

}
