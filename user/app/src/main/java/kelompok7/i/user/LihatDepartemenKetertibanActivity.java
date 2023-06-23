package kelompok7.i.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class LihatDepartemenKetertibanActivity extends AppCompatActivity {

    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_departemen_ketertiban);

        btnReg = (Button)findViewById(R.id.RegisterDepartemenKetertiban);
        btnReg.setMovementMethod(LinkMovementMethod.getInstance());
    }
}