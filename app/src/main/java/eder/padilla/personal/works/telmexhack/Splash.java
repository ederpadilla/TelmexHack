package eder.padilla.personal.works.telmexhack;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Splash extends Activity {
    SharedPreferences sharedPreferences;
    private Thread splashTread;
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartAnimations();

    }
    /** Here we star the animation. */
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.linlay);
        l.clearAnimation();
        l.startAnimation(anim);
        /** We call the animation that says form where to where its gonna move. */
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        /** The image ots gona move.**/
        ImageView logo = (ImageView) findViewById(R.id.splashlogo);
        logo.clearAnimation();
        logo.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {

                    /** Pause the execution of the code for 3.5 secs. **/
                    sleep(3500);
                    /** We check if there is a user log in or not. **/
                    //String unm= sharedPreferences.getString(getResources().getString(R.string.Shared_Preferences_User), null);

                        Intent intent = new Intent(Splash.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    Splash.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splash.this.finish();
                }
            }
        };
        splashTread.start();

    }


}