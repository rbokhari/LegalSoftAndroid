package app.legalsoft.ve.cases;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.legalsoft.ve.MasterActivity;
import app.legalsoft.ve.R;
import app.legalsoft.ve.callbacks.JOSNLoadedListener;
import app.legalsoft.ve.json.Parser;
import app.legalsoft.ve.tasks.JSONAsyncTask;
import app.legalsoft.ve.util.CONSTANTS;
import app.legalsoft.ve.util.GlobalFunctions;

/**
 * Created by Syed.Rahman on 23/07/2015.
 */
public class CaseCourtFragment extends Fragment implements JOSNLoadedListener {

    TextView tCaseCount;
    TextView tCaseCountClose;
    TextView tBankCaseCount;
    TextView tBankCaseCountClose;
    TextView tCaseBeforeCount;
    TextView tCaseBeforeCountClose;
    TextView tCaseConsultancyCount;
    TextView tCaseConsultancyCountClose;

    LinearLayout linearGeneralCases;
    LinearLayout linearBankCases;
    LinearLayout linearBeforeCourt;
    LinearLayout linearConsultancy;

    public CaseCourtFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.case_count_fragment, container, false);

        tCaseCount = (TextView) view.findViewById(R.id.tCaseCount);
        tCaseCountClose = (TextView) view.findViewById(R.id.tCaseCountClose);
        tBankCaseCount = (TextView) view.findViewById(R.id.tBankCaseCount);
        tBankCaseCountClose = (TextView) view.findViewById(R.id.tBankCaseCountClose);
        tCaseBeforeCount = (TextView) view.findViewById(R.id.tCaseBeforeCount);
        tCaseBeforeCountClose = (TextView) view.findViewById(R.id.tCaseBeforeCountClose);
        tCaseConsultancyCount = (TextView) view.findViewById(R.id.tCaseConsultancyCount);
        tCaseConsultancyCountClose = (TextView) view.findViewById(R.id.tCaseConsultancyCountClose);

        setupLinearLayout(view);

        new JSONAsyncTask(this, CONSTANTS.CASE_COUNT_API_URL).execute();

        return view;
    }

    private void setupLinearLayout(View view){
        linearGeneralCases = (LinearLayout) view.findViewById(R.id.linearGeneralCase);
        linearBankCases = (LinearLayout) view.findViewById(R.id.linearBankCases);
        linearBeforeCourt = (LinearLayout) view.findViewById(R.id.linearBeforeCourt);
        linearConsultancy = (LinearLayout) view.findViewById(R.id.linearConsultancy);


        linearGeneralCases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_FILE, CONSTANTS.CaseStatusID.CASE_FILE_OPEN);
            }
        });

        linearGeneralCases.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_FILE, CONSTANTS.CaseStatusID.CASE_FILE_CLOSE);
                return true;
            }
        });

        linearBankCases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_BANK_FILE, CONSTANTS.CaseStatusID.CASE_FILE_OPEN);            }
        });

        linearBankCases.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_BANK_FILE, CONSTANTS.CaseStatusID.CASE_FILE_CLOSE);
                return true;
            }
        });

        linearBeforeCourt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_BEFORE_COURT, CONSTANTS.CaseStatusID.CASE_BEFORE_COURT_OPEN);
            }
        });

        linearBeforeCourt.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_BEFORE_COURT, CONSTANTS.CaseStatusID.CASE_BEFORE_COURT_CLOSE);
                return true;
            }
        });

        linearConsultancy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setupLinearLayoutClick(CONSTANTS.CaseTypeID.CASE_CONSULTANCY, CONSTANTS.CaseStatusID.CASE_CONSULTANCY_OPEN);
            }
        });

    }

    private void setupLinearLayoutClick(int typeId, int statusId){
        Intent intent = new Intent(getActivity(),CaseListActivity.class);
        intent.putExtra("TypeId", typeId);
        intent.putExtra("StatusId", statusId);

        startActivity(intent);
    }

    @Override
    public void onJSONLoaded(JSONArray jsonArray) {
        GlobalFunctions.m("CaseCourtFragment ---- onJSONLoaded");

        if (jsonArray==null) return;

        try {
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (GlobalFunctions.getIsNotNull(jsonObject, "typeId") && GlobalFunctions.getIsNotNull(jsonObject, "statusId")) {
                    if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_FILE && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_FILE_OPEN) {
                        tCaseCount.setText(jsonObject.getInt("typeCount") + "");
                    } else if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_FILE && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_FILE_CLOSE) {
                        tCaseCountClose.setText("Close Count : " + jsonObject.getInt("typeCount") + "");
                    } else if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_BANK_FILE && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_FILE_OPEN) {
                        tBankCaseCount.setText(jsonObject.getInt("typeCount") + "");
                    } else if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_BANK_FILE && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_FILE_CLOSE) {
                        tBankCaseCountClose.setText("Close Count : " + jsonObject.getInt("typeCount") + "");
                    } else if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_BEFORE_COURT && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_BEFORE_COURT_OPEN) {
                        tCaseBeforeCount.setText(jsonObject.getInt("typeCount") + "");
                    } else if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_BEFORE_COURT && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_BEFORE_COURT_CLOSE) {
                        tCaseBeforeCountClose.setText("Close Count : " + jsonObject.getInt("typeCount") + "");
                    } else if (jsonObject.getInt("typeId") == CONSTANTS.CaseTypeID.CASE_CONSULTANCY && jsonObject.getInt("statusId") == CONSTANTS.CaseStatusID.CASE_CONSULTANCY_OPEN) {
                        tCaseConsultancyCount.setText(jsonObject.getInt("typeCount") + "");
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onJSONLoadedObject(JSONObject jsonObject) {
        //GlobalFunctions.m("CaseCourtFragment ---- onJSONLoadedObject");
        //tCaseCount.setText(Parser.parseValueResponseObject(jsonObject) + "");
    }

}
