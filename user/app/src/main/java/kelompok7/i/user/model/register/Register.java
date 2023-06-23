package kelompok7.i.user.model.register;

import com.google.gson.annotations.SerializedName;

public class Register{

    @SerializedName("data")
    private RefactorData refactorData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public void setRefactorData(RefactorData refactorData){
        this.refactorData = refactorData;
    }

    public RefactorData getRefactorData(){
        return refactorData;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean isStatus(){
        return status;
    }
}
