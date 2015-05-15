package app.legalsoft.ve;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import app.legalsoft.ve.model.HomeMenuModel;
import app.legalsoft.ve.recycler.RecyclerTouchListener;
import app.legalsoft.ve.recycler.rvAdapter;
import app.legalsoft.ve.util.DividerItemDecoration;


public class HomeActivity extends ActionBarActivity {

    RecyclerView recyclerView;
    private static rvAdapter adapter;
    String[] mTitle;
    int[] mIcon;

    public void HomeActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Toast.makeText(this, "HomeActivity",Toast.LENGTH_LONG).show();

        recyclerView = (RecyclerView) findViewById(R.id.rMenu);
        Resources res = getResources();

        mTitle =res.getStringArray(R.array.home_menu); // new String[]{"Definition", "Staff", "Case", "Forms", "Reports", "Validation"};
        mIcon = new int[]{R.drawable.ic_action_edit, R.drawable.ic_action_add_group, R.drawable.ic_action_collection, R.drawable.ic_action_dock, R.drawable.ic_action_important, R.drawable.ic_action_read};

        adapter = new rvAdapter(getApplicationContext(),getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST ));


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:

                        break;
                    case 1:
                        Intent intent = new Intent(getApplicationContext(),MasterActivity.class);
                        //intent.putExtra("default_fragment", position);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    private ArrayList<HomeMenuModel> getData()
    {
        ArrayList<HomeMenuModel> menu=new ArrayList<HomeMenuModel>();
        for (int i=0;i<mTitle.length; i++)
        {
            menu.add(new HomeMenuModel(mTitle[i], mIcon[i]));
        }
        return menu;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            startActivity(new Intent(this, LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
