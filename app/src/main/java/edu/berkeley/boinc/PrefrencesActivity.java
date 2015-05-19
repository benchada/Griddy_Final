package edu.berkeley.boinc;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class PrefrencesActivity extends ActionBarActivity {
    public PrefsFragment PrefsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrences);

        System.out.println("1");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // CreateCustomFragment fragment = new CreateCustomFragment();

        PrefsFragment = new PrefsFragment();

/*
        transaction.replace(R.id.frame_preferences, PrefsFragment);
*/
        transaction.commit();
        System.out.println("2");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prefrences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
