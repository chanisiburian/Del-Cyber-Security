package kelompok7.i.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class LihatEnglishActivity extends AppCompatActivity {


    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_english);

        btnReg = (Button)findViewById(R.id.RegisterEnglish);
        btnReg.setMovementMethod(LinkMovementMethod.getInstance());
    }
}