package kelompok7.i.admin.adapterAsrama;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kelompok7.i.admin.R;
import kelompok7.i.admin.activityAsrama.AsramaActivity;
import kelompok7.i.admin.activityAsrama.UbahActivity;
import kelompok7.i.admin.apiAsrama.Asramainterface;
import kelompok7.i.admin.apiAsrama.retroAsrama;
import kelompok7.i.admin.modelAsrama.AsramaData;
import kelompok7.i.admin.modelAsrama.responseAsrama;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<AsramaData> listData;
    private int idAturan;
    private List<AsramaData> listAsrama;

    public AdapterData(Context ctx, List<AsramaData> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardasrama,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        AsramaData ad = listData.get(position);

        holder.tvid_peraturan.setText(String.valueOf(ad.getId_aturan()));
        holder.tvjudul.setText(ad.getJudul());
        holder.tvdeskripsi.setText(ad.getDeskripsi());
        holder.tvpoin.setText(ad.getPoin());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvid_peraturan,tvjudul,tvdeskripsi,tvpoin;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvid_peraturan = itemView.findViewById(R.id.tvId_Aturan);
            tvjudul = itemView.findViewById(R.id.tv_judul);
            tvdeskripsi = itemView.findViewById(R.id.tv_peraturan);
            tvpoin = itemView.findViewById(R.id.tv_poin);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.        setMessage("Pilih Operasi yang akan di lakukan");
                    dialogPesan.setTitle("Perhatian");
                    dialogPesan.setIcon(R.mipmap.ic_launcher);
                    dialogPesan.setCancelable(true);

                    idAturan = Integer.parseInt(tvid_peraturan.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteAturan();
                            dialogInterface.dismiss();
                            Handler hand = new Handler();
                            hand.postDelayed(new Runnable() {
                                @Override
                                public void run() { ((AsramaActivity) ctx).tbhData();
                                }
                            }, 100);

                        }
                    });

                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getAturan();
                            dialogInterface.dismiss();
                            Handler hand = new Handler();
                            hand.postDelayed(new Runnable() {
                                @Override
                                public void run() {((AsramaActivity)ctx).tbhData();}

                            },100);
                        }
                    });

                    dialogPesan.show();

                    return false;
                }
            });
        }

        private void deleteAturan(){
            Asramainterface asramainterface = retroAsrama.koneksiRetrofit().create(Asramainterface.class);
            Call<responseAsrama> hapusData = asramainterface.ardDeleteAsrama(idAturan);

            hapusData.enqueue(new Callback<responseAsrama>() {
                @Override
                public void onResponse(Call<responseAsrama> call, Response<responseAsrama> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                }

                @Override
                public void onFailure(Call<responseAsrama> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server : "+t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void getAturan(){
            Asramainterface asramainterface = retroAsrama.koneksiRetrofit().create(Asramainterface.class);
            Call<responseAsrama> ambilData = asramainterface.ardGetAsrama(idAturan);

            ambilData.enqueue(new Callback<responseAsrama>() {
                @Override
                public void onResponse(Call<responseAsrama> call, Response<responseAsrama> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();
                    listAsrama = response.body().getData();

                    int varIdAsrama = listAsrama.get(0).getId_aturan();
                    String varJudul = listAsrama.get(0).getJudul();
                    String varDeskripsi = listAsrama.get(0).getDeskripsi();
                    String varPoin = listAsrama.get(0).getPoin();

                    // Toast.makeText(ctx,"Kode : "+kode+" | Pesan : "+pesan+"Data : | "+varIdAsrama+" | "+varJudul+" | "+varDeskripsi+" | "+varPoin,Toast.LENGTH_SHORT).show();

                    Intent kirim = new Intent(ctx, UbahActivity.class);
                    kirim.putExtra("xId",varIdAsrama);
                    kirim.putExtra("xJudul",varJudul);
                    kirim.putExtra("xDeskripsi",varDeskripsi);
                    kirim.putExtra("xPoin", varPoin);
                    ctx.startActivity(kirim);


                }

                @Override
                public void onFailure(Call<responseAsrama> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server : "+t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
