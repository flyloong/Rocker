package com.example.lb.lbrocker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;


public class MainActivity extends ActionBarActivity {


    private RockerView rockerView1;
    private RockerView2 rockerView2;
    private   int[] rcOutputs = new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        rockerView1 = (RockerView)findViewById(R.id.rockerView1);
        rockerView1.setRockerChangeListener(new RockerView.RockerChangeListener() {
            @Override
            public void report(float x, float y) {
                rcOutputs[0]=(int)(y/rockerView1.getR()*50);
                rcOutputs[1]=(int)(x/rockerView1.getR()*50);
                getSupportActionBar().setTitle("X1:" +rcOutputs[0]  + "  Y1:" + rcOutputs[1]+"   X2:"+rcOutputs[2]+"  Y2:"+rcOutputs[3]);

            }
        });
        rockerView2 = (RockerView2)findViewById(R.id.rockerView2);
        rockerView2.setRockerChangeListener(new RockerView2.RockerChangeListener() {
            @Override
            public void report(float x, float y) {
                rcOutputs[2]=(int)(y/rockerView2.getR()*50);
                rcOutputs[3]=(int)(x/rockerView2.getR()*50);
                getSupportActionBar().setTitle("X1:" +rcOutputs[0]  + "  Y1:" + rcOutputs[1]+"   X2:"+rcOutputs[2]+"  Y2:"+rcOutputs[3]);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
