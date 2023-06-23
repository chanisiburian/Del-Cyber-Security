package kelompok7.i.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class LihatDSCActivity extends AppCompatActivity {

    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_d_s_c);
        btnReg = (Button)findViewById(R.id.RegisterDSC);
        btnReg.setMovementMethod(LinkMovementMethod.getInstance());

    }
}