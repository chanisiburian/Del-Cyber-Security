package kelompok7.i.admin.activityAsrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kelompok7.i.admin.R;
import kelompok7.i.admin.apiAsrama.Asramainterface;
import kelompok7.i.admin.apiAsrama.retroAsrama;
import kelompok7.i.admin.modelAsrama.responseAsrama;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etJudul,etDeskripsi,etPoin;
    private Button btnSimpan,btnCancel;
    private String judul,deskripsi,poin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etJudul = findViewById(R.id.et_judul);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        etPoin = findViewById(R.id.et_poin);
        btnSimpan = findViewById(R.id.btn_simpan);
        btnCancel = findViewById(R.id.btnBack);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TambahActivity.this, AsramaActivity.class);
                startActivity(i);
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                judul = etJudul.getText().toString();
                deskripsi = etDeskripsi.getText().toString();
                poin = etPoin.getText().toString();

                if(judul.trim().equals("")){
                    etJudul.setError("Judul Harus Diisi");
                }
                else if(deskripsi.trim().equals("")){
                    etDeskripsi.setError("Deskripsi Harus Di isi");
                }
                else if(poin.trim().equals("")){
                    etPoin.setError("Poin Harus Diisi");
                }
                else {
                    createData();
                }
            }
        });
    }
    private void createData(){
        Asramainterface asramainterface = retroAsrama.koneksiRetrofit().create(Asramainterface.class);
        Call<responseAsrama> simpandata = asramainterface.ardCreateData(judul,deskripsi,poin);

        simpandata.enqueue(new Callback<responseAsrama>() {
            @Override
            public void onResponse(Call<responseAsrama> call, Response<responseAsrama> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<responseAsrama> call, Throwable t) {
                Toast.makeText(TambahActivity.this,"Gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }
}