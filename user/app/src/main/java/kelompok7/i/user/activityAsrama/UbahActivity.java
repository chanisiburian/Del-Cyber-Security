package kelompok7.i.user.activityAsrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kelompok7.i.user.R;
import kelompok7.i.user.apiAsrama.Asramainterface;
import kelompok7.i.user.apiAsrama.retroAsrama;
import kelompok7.i.user.modelAsrama.responseAsrama;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahActivity extends AppCompatActivity {

    private int xIdAturan;
    private String xJudul,xDeskripsi,xPoin;
    private EditText etJudul,etDeskripsi,etPoin;
    private Button btnUbah;
    private String yJudul,yDeskripsi,yPoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        Intent terima = getIntent();
        xIdAturan = terima.getIntExtra("xId",-1);
        xJudul = terima.getStringExtra("xJudul");
        xDeskripsi = terima.getStringExtra("xDeskripsi");
        xPoin = terima.getStringExtra("xPoin");

        etJudul = findViewById(R.id.et_judul);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        etPoin = findViewById(R.id.et_poin);
        btnUbah = findViewById(R.id.btn_ubah);

        etJudul.setText(xJudul);
        etDeskripsi.setText(xDeskripsi);
        etPoin.setText(xPoin);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yJudul = etJudul.getText().toString();
                yDeskripsi = etDeskripsi.getText().toString();
                yPoin = etPoin.getText().toString();
                UpdateData();
            }
        });
    }

    private void UpdateData(){
        Asramainterface asramainterface = retroAsrama.koneksiRetrofit().create(Asramainterface.class);
        Call<responseAsrama> updatedata = asramainterface.ardUpdateData(xIdAturan,yJudul,yDeskripsi,yPoin);

        updatedata.enqueue(new Callback<responseAsrama>() {
            @Override
            public void onResponse(Call<responseAsrama> call, Response<responseAsrama> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(UbahActivity.this,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<responseAsrama> call, Throwable t) {
                Toast.makeText(UbahActivity.this,"Gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }
}