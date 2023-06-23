package kelompok7.i.admin.api;

import kelompok7.i.admin.model.login.Login;
import kelompok7.i.admin.model.register.Register;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Apiinterface {

    @FormUrlEncoded
    @POST("loginadmin.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("nim") String nim,
            @Field("username") String username,
            @Field("password") String password,
            @Field("prodi") String prody,
            @Field("angkatan") String angkatan
    );


}
