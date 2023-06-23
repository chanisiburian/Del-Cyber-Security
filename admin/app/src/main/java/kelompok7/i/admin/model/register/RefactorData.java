package kelompok7.i.admin.model.register;

import com.google.gson.annotations.SerializedName;

public class RefactorData {

    @SerializedName("password")
    private String password;

    @SerializedName("nim")
    private String nim;

    @SerializedName("angkatan")
    private String angkatan;

    @SerializedName("prodi")
    private String prodi;

    @SerializedName("username")
    private String username;

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getNim(){
        return nim;
    }

    public void setAngkatan(String angkatan){
        this.angkatan = angkatan;
    }

    public String getAngkatan(){
        return angkatan;
    }

    public void setPrody(String prody){
        this.prodi = prody;
    }

    public String getPrody(){
        return prodi;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
