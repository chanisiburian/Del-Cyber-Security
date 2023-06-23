package kelompok7.i.user.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("nim")
    private String nim;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("prody")
    private String prody;

    @SerializedName("username")
    private String username;

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getNim(){
        return nim;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    public void setPrody(String prody){
        this.prody = prody;
    }

    public String getPrody(){
        return prody;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
