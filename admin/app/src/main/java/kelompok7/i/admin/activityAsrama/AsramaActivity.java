package kelompok7.i.admin.activityAsrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import kelompok7.i.admin.MainActivity;
import kelompok7.i.admin.R;
import kelompok7.i.admin.adapterAsrama.AdapterData;
import kelompok7.i.admin.apiAsrama.Asramainterface;
import kelompok7.i.admin.apiAsrama.retroAsrama;
import kelompok7.i.admin.modelAsrama.AsramaData;
import kelompok7.i.admin.modelAsrama.responseAsrama;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  AsramaActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<AsramaData> listData = new ArrayList<>();
    private Button fabTambah;
    private Button fabUbah;
    RecyclerView btnUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asrama);

        rvData = findViewById(R.id.btn_ubah);
        lmData = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);
        tbhData();
        fabTambah = (Button)findViewById(R.id.fab_peraturan);





        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AsramaActivity.this, TambahActivity.class);
                startActivity(i);
            }
        });
    }

    public void tbhData(){
        Asramainterface asramainterface = retroAsrama.koneksiRetrofit().create(Asramainterface.class);
        Call<responseAsrama> tampildata = asramainterface.ardTambahAturanAsrama();

        tampildata.enqueue(new Callback<responseAsrama>() {
            @Override
            public void onResponse(Call<responseAsrama> call, Response<responseAsrama> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

//                Toast.makeText(AsramaActivity.this,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();

                listData = response.body().getData();

                adData = new AdapterData(AsramaActivity.this,listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<responseAsrama> call, Throwable t) {
                Toast.makeText(AsramaActivity.this, "Gagal Menghungi Server", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}