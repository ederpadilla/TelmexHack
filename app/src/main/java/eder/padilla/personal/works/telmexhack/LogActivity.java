package eder.padilla.personal.works.telmexhack;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class LogActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout buttonFacebook;
    private ImageView fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        objectInit();
        setListeners();
    }



    private void objectInit() {
       buttonFacebook=(LinearLayout)findViewById(R.id.liearlayoutbuttonFacebook);
      // fondo=(ImageView)findViewById(R.id.fondo);
        //Picasso.with(this)
          //      .load(R.drawable.friendsblue)
                //.load("https://lh3.googleusercontent.com/gdBHEk-u3YRDtuCU3iDTQ52nZd1t4GPmldYaT26Jh6EhXgp1mlhQiuLFl4eXDAXzDig5=w300")
            //    .resize(1000, 1500)                        // optional
              //  .into(fondo);
    }
    private void setListeners() {
        buttonFacebook.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.liearlayoutbuttonFacebook:
                Intent intent = new Intent(LogActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}
