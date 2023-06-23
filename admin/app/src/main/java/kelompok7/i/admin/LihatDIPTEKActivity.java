package kelompok7.i.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class LihatDIPTEKActivity extends AppCompatActivity {

    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_d_i_p_t_e_k);

        btnReg = (Button)findViewById(R.id.RegisterDIPTEK);
        btnReg.setMovementMethod(LinkMovementMethod.getInstance());
    }
}