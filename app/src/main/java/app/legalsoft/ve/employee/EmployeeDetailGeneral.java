package app.legalsoft.ve.employee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.EmployeeModel;
import app.legalsoft.ve.util.GlobalFunctions;
import app.legalsoft.ve.util.MyApplication;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeDetailGeneral extends Fragment {

    TextView tEmpName;
    TextView tNameEn;
    TextView tFamilyName;
    TextView tSection;
    TextView tJoiningDate;
    TextView tMobile;
    TextView tDesignation;
    TextView tEmail;
    TextView tAddress;
    TextView tNationality;

    EmployeeModel employeeModel = new EmployeeModel();

    public EmployeeDetailGeneral() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_employee_detail_general, container, false);

        Bundle b = getArguments();

        employeeModel = employeeModel.fromBundle(b);
        SimpleDateFormat format = new SimpleDateFormat("MMM dd,yyyy");

        tEmpName = (TextView) view.findViewById(R.id.txtEmpName);
        tNameEn = (TextView) view.findViewById(R.id.txtEmpNameEn);
        tFamilyName = (TextView) view.findViewById(R.id.txtFamilyName);
        tSection = (TextView) view.findViewById(R.id.txtSection);
        tJoiningDate = (TextView) view.findViewById(R.id.txtJoiningDate);
        tMobile = (TextView) view.findViewById(R.id.txtMobile);
        tDesignation = (TextView) view.findViewById(R.id.txtEmpDesignation);
        tEmail = (TextView) view.findViewById(R.id.txtEmail);
        tAddress = (TextView) view.findViewById(R.id.txtAddress);
        tNationality = (TextView) view.findViewById(R.id.txtNationality);

        tEmpName.setText(employeeModel.getEmpName());
        tNameEn.setText(employeeModel.getEmpName_EN());
        tFamilyName.setText(employeeModel.getFamilyName());
        tSection.setText(employeeModel.getSectionID());
        //try {
            //tJoiningDate.setText(format.parse(employeeModel.getStartDate().substring(0, 10)).toString());
        if (employeeModel.getStartDate().length()>0) {
            tJoiningDate.setText(employeeModel.getStartDate().substring(0, 10));
        }
        //} catch (ParseException e) {
        //    tJoiningDate.setText(employeeModel.getStartDate());
        //}
        tMobile.setText(employeeModel.getGSM());
        tDesignation.setText(employeeModel.getOccupation());
        tEmail.setText(employeeModel.getEmpEmail());
        tAddress.setText(employeeModel.getMailAddress());
        tNationality.setText(employeeModel.getNationalityID());

        return view;
    }


}
