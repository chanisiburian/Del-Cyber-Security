package kelompok7.i.admin.apiAsrama;

import androidx.annotation.VisibleForTesting;

import kelompok7.i.admin.modelAsrama.responseAsrama;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Asramainterface {
    @GET("tambah_aturan_asrama.php")
    Call<responseAsrama> ardTambahAturanAsrama();

    @FormUrlEncoded
    @POST("createAturanAsrama.php")
    Call<responseAsrama> ardCreateData(
            @Field("judul") String judul,
            @Field("deskripsi") String deskripsi,
            @Field("poin") String poin
    );

    @FormUrlEncoded
    @POST("deleteAturanAsrama.php")
    Call<responseAsrama> ardDeleteAsrama(
            @Field("id_aturan") int id_aturan
    );

    @FormUrlEncoded
    @POST("getAturanAsrama.php")
    Call<responseAsrama> ardGetAsrama(
            @Field("id_aturan") int id_aturan
    );

    @FormUrlEncoded
    @POST("updateAturanAsrama.php")
    Call<responseAsrama> ardUpdateData(
            @Field("id_aturan") int id_aturan,
            @Field("judul") String judul,
            @Field("deskripsi") String deskripsi,
            @Field("poin") String poin
    );
}
