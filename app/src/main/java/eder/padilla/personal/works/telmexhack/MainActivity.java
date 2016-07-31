package eder.padilla.personal.works.telmexhack;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView dezliablePic;
    private RecyclerView recView;
    private ArrayList<Amigos> amiguitos;
    private Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objectInit();
        setListeners();
    }
    private void objectInit() {
        dezliablePic=(ImageView)findViewById(R.id.my_awesome_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);
        recView.setItemAnimator(new SlideInLeftAnimator());
        recView.getItemAnimator().setAddDuration(800);
        recView.getItemAnimator().setRemoveDuration(800);
        amiguitos = new ArrayList<Amigos>();
        for(int i=0; i<10; i++){
            amiguitos.add(new Amigos(""));}
        adaptador = new Adaptador(amiguitos,this.getApplicationContext());
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



        recView.setItemAnimator(new DefaultItemAnimator());
    }
    private void setListeners() {
        dezliablePic.setOnClickListener(this);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento " + recView.getChildAdapterPosition(v));
                Amigos amigo = amiguitos.get(recView.getChildAdapterPosition(v));

            }
        });
    }
    private void seleccionarGaleria() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                if(resultCode == Activity.RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getApplicationContext().getContentResolver().query(
                            selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();

                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                    dezliablePic.setImageBitmap(yourSelectedImage);
                    Log.i("Entramos","a un activity result");
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_awesome_pager:
                seleccionarGaleria();
                break;
        }

    }
}
