package kelompok7.i.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class LihatDelproActivity extends AppCompatActivity {


    Button linkReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_delpro);

        linkReg = (Button)findViewById(R.id.RegisterDelpro);
        linkReg.setMovementMethod(LinkMovementMethod.getInstance());
    }
}