package eder.padilla.personal.works.telmexhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        CircularFillableLoaders circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
    }
}
