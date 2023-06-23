package kelompok7.i.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LihatUKMActivity extends AppCompatActivity {

    ImageView i_imgDelpro, i_imgDSC, i_imgDRC, i_imgPSM, i_imgPGM, i_imgEnglish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_u_k_m);



        i_imgDelpro = (ImageView)findViewById(R.id.imgDelpro);
        i_imgDSC = (ImageView)findViewById(R.id.imgDSC);
        i_imgDRC = (ImageView)findViewById(R.id.imgDRC);
        i_imgPSM = (ImageView)findViewById(R.id.imgPSM);
        i_imgPGM = (ImageView)findViewById(R.id.imgPGM);
        i_imgEnglish = (ImageView)findViewById(R.id.imgEnglish);


        i_imgDelpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatUKMActivity.this, LihatDelproActivity.class);
                startActivity(i);
            }
        });

        i_imgDRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatUKMActivity.this, LihatDRCActivity.class);
                startActivity(i);
            }
        });
        i_imgDSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatUKMActivity.this, LihatDSCActivity.class);
                startActivity(i);
            }
        });
        i_imgPSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatUKMActivity.this, LihatPSMActivity.class);
                startActivity(i);
            }
        });
        i_imgPGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatUKMActivity.this, LihatPGMActivity.class);
                startActivity(i);
            }
        });
        i_imgEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatUKMActivity.this, LihatEnglishActivity.class);
                startActivity(i);
            }
        });

    }
    /*public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.imgDelpro :
                i = new Intent(this, LihatDelproActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.imgDRC :
                i = new Intent(this,LihatDRCActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.imgDSC :
                i = new Intent(this, LihatDSCActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.LihatPSM :
                i = new Intent(this,LihatPSMActivity.class);
                startActivity(i);
                break;
        }

        switch (view.getId()){
            case R.id.LihatPGM :
                i = new Intent(this,LihatPGMActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.imgEnglish :
                i = new Intent(this,LihatEnglishActivity.class);
                startActivity(i);
                break;
        }*/
}