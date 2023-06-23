package kelompok7.i.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LihatBEMActivity extends AppCompatActivity {


    ImageView c_imgDepartemenKetertiban, c_imgDepsenbud, c_imgDepkominfo, c_imgDPDK, c_imgDepol, c_imgHumas,c_imgDIPTEK, c_imgDepagsos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_b_e_m);

        c_imgDepsenbud = (ImageView)findViewById(R.id.imgDepsenbud);
        c_imgDepagsos = (ImageView)findViewById(R.id.imgDepagsos);
        c_imgHumas = (ImageView)findViewById(R.id.imgHumas);
        c_imgDepol = (ImageView)findViewById(R.id.imgDepol);
        c_imgDPDK = (ImageView)findViewById(R.id.imgDPDK);
        c_imgDepkominfo = (ImageView)findViewById(R.id.imgDepkominfo);
        c_imgDIPTEK = (ImageView)findViewById(R.id.imgDIPTEK);
        c_imgDepartemenKetertiban = (ImageView)findViewById(R.id.imgKetertiban);


        c_imgDepsenbud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDepsenbudActivity.class);
                startActivity(i);
            }
        });
        c_imgDepagsos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDepagsosActivity.class);
                startActivity(i);
            }
        });
        c_imgHumas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatHumasActivity.class);
                startActivity(i);
            }
        });
        c_imgDepol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDepolActivity.class);
                startActivity(i);
            }
        });
        c_imgDPDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDPDKActivity.class);
                startActivity(i);
            }
        });
        c_imgDepkominfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDepkominfoActivity.class);
                startActivity(i);
            }
        });
        c_imgDIPTEK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDIPTEKActivity.class);
                startActivity(i);
            }
        });
        c_imgDepartemenKetertiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LihatBEMActivity.this, LihatDepartemenKetertibanActivity.class);
                startActivity(i);
            }
        });


    }
}