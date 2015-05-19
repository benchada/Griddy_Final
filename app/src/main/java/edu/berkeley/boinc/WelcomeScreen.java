package edu.berkeley.boinc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;



public class WelcomeScreen extends ActionBarActivity {


    private ImageView iv;
    private Bitmap bitmap;
    private ImageView imgProfilePic;
    private TextView WelcomeMsg;
   // RoundImage roundedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen2);
        imgProfilePic = (ImageView) findViewById(R.id.imageView);
       WelcomeMsg = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        String Urlvalue = extras.getString("DP");
        String UserName = extras.getString("Username");
        WelcomeMsg.setText("Welcome To Griddy,  "+UserName);




        Urlvalue = Urlvalue.substring(0,
                Urlvalue.length() - 2)
                + 500;

        new LoadProfileImage(imgProfilePic).execute(Urlvalue);
        ImageView myImageView= imgProfilePic;
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        myImageView.startAnimation(myFadeInAnimation);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                Intent startSplash = new Intent(WelcomeScreen.this,SplashActivity.class);
                startActivity(startSplash);
            }

        }, 5000);


    }

    private class LoadProfileImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;


        public LoadProfileImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
           //     roundedImage = new RoundImage(mIcon11);
             //   imgProfilePic.setImageDrawable(roundedImage);

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
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
