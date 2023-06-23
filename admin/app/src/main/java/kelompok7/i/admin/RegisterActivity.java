package kelompok7.i.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kelompok7.i.admin.api.ApiClient;
import kelompok7.i.admin.api.Apiinterface;
import kelompok7.i.admin.model.register.Register;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etNim, etUserName, etPassword, etPrody,eteAngkatan;
    Button btnRegister;
    TextView tvLogin;
    String Nim,Username,Password,Prody,Angkatan;
    Apiinterface apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNim = findViewById(R.id.etResisterNim);
        etUserName = findViewById(R.id.etRegisterName);
        etPassword = findViewById(R.id.etRegisterPassword);
        etPrody = findViewById(R.id.etRegisterPrody);
        eteAngkatan = findViewById(R.id.etRegisterAngkatan);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        tvLogin = findViewById(R.id.tvLoginHere);
        tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                Nim = etNim.getText().toString();
                Username = etUserName.getText().toString();
                Password = etPassword.getText().toString();
                Prody = etPrody.getText().toString();
                Angkatan = eteAngkatan.getText().toString();
                register(Nim,Username,Password,Prody);
                break;
            case R.id.tvLoginHere:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    private void register(String nim, String username, String password, String prody){

        apiinterface = ApiClient.getClient().create(Apiinterface.class);
        Call<Register> call = apiinterface.registerResponse(Nim,Username,Password,Prody,Angkatan);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}