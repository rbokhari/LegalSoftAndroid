package app.legalsoft.ve.cases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.CaseFileModel;

/**
 * Created by Syed.Rahman on 28/07/2015.
 */
public class CaseDetailGeneral extends Fragment {

    CaseFileModel caseFileModel = new CaseFileModel();

    TextView tCaseFileNo;
    TextView tCasePriority;
    TextView tCaseStartDate;
    TextView tCaseClientName;
    TextView tCaseComputerNo;
    TextView tCaseBankFileNo;
    TextView tCaseAccountNo;
    TextView tCaseClientSpec;
    TextView tCasePhysicalFile;
    TextView tCaseComplainType;
    TextView tCaseComplainDepartment;
    TextView tCaseDefender;
    TextView tCaseDefenderSpecs;
    TextView tCaseDefenderLawyer;
    TextView tCaseDefenderLawyerName;
    TextView tCaseLawyerName;
    TextView tCaseSummary;

    public CaseDetailGeneral() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.case_detail_general_fragment, container, false);

        Bundle b = getArguments();
        caseFileModel = caseFileModel.fromBundle(b);

        setupLoading(view);

        return view;
    }

    private void setupLoading(View v){
        tCaseFileNo = (TextView) v.findViewById(R.id.tCaseFileNo);
        tCasePriority = (TextView) v.findViewById(R.id.tCasePriority);
        tCaseStartDate = (TextView) v.findViewById(R.id.tCaseStartDate);
        tCaseClientName = (TextView) v.findViewById(R.id.tCaseClientName);
        tCaseComputerNo = (TextView) v.findViewById(R.id.tCaseComputerNo);
        tCaseBankFileNo = (TextView) v.findViewById(R.id.tCaseBankFileNo);
        tCaseAccountNo = (TextView) v.findViewById(R.id.tCaseAccountNo);
        tCaseClientSpec = (TextView) v.findViewById(R.id.tCaseClientSpec);
        tCasePhysicalFile = (TextView) v.findViewById(R.id.tCasePhysicalFile);
        tCaseComplainType = (TextView) v.findViewById(R.id.tCaseComplainDepartment);
        tCaseComplainDepartment = (TextView) v.findViewById(R.id.tCaseComplainDepartment);
        tCaseDefender = (TextView) v.findViewById(R.id.tCaseDefender);
        tCaseDefenderSpecs = (TextView) v.findViewById(R.id.tCaseDefenderSpecs);
        tCaseDefenderLawyer = (TextView) v.findViewById(R.id.tCaseDefenderLawyer);
        tCaseDefenderLawyerName = (TextView) v.findViewById(R.id.tCaseDefenderLawyerName);
        tCaseLawyerName = (TextView) v.findViewById(R.id.tCaseLawyerName);
        tCaseSummary = (TextView) v.findViewById(R.id.tCaseSummary);

        tCaseFileNo.setText(caseFileModel.getFileNo() + "");
        tCasePriority.setText(caseFileModel.getPriorityName());
        tCaseStartDate.setText(caseFileModel.getStartDate());
        tCaseClientName.setText(caseFileModel.getClientName());
        tCaseComputerNo.setText(caseFileModel.getCaseComputerNo());
        tCaseBankFileNo.setText(caseFileModel.getBankFileNo());
        tCaseAccountNo.setText(caseFileModel.getAccountNo());
        tCaseClientSpec.setText(caseFileModel.getClientSpecName());
        tCasePhysicalFile.setText(caseFileModel.getPhysicalFileName());
        tCaseComplainType.setText(caseFileModel.getComplainTypeName());
        tCaseComplainDepartment.setText(caseFileModel.getComplainDepartmentName());
        tCaseDefender.setText(caseFileModel.getDefenderName());
        tCaseDefenderSpecs.setText(caseFileModel.getDefenderCaseSpecName());
        tCaseDefenderLawyer.setText(caseFileModel.getDefenderName());
        tCaseDefenderLawyerName.setText(caseFileModel.getLawyerName());
        tCaseLawyerName.setText(caseFileModel.getLawyerName());
        tCaseSummary.setText(caseFileModel.getComments());

    }

}
