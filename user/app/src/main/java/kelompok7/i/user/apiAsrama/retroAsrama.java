package kelompok7.i.user.apiAsrama;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retroAsrama {
    private static final String baseUrl = "http://192.168.206.141/kelompok7_pa2/";
    private static Retrofit retrofit;

    public static Retrofit koneksiRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

