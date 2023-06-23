package kelompok7.i.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import kelompok7.i.user.activityAsrama.AsramaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    LinearLayout t_lihatukm, t_lihatbem, t_lihatasrama, t_profilitdel, t_registerukm, t_registerbem, t_aboutus, t_logout;
    SessionManager sessionManager;
    CardView lihatUKM;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        t_lihatukm = (LinearLayout) findViewById(R.id.l_lihatukm);
        t_lihatbem = (LinearLayout)findViewById(R.id.l_lihatbem);
        t_lihatasrama = (LinearLayout)findViewById(R.id.l_lihatasrama);
        t_profilitdel = (LinearLayout)findViewById(R.id.l_profilitdel);
        t_aboutus = (LinearLayout)findViewById(R.id.l_aboutus);
        t_logout = (LinearLayout)findViewById(R.id.l_logout);
        lihatUKM = (CardView)findViewById(R.id.cvLihatUKM);


        t_lihatukm.setOnClickListener(this);
        t_lihatbem.setOnClickListener(this);
        t_lihatasrama.setOnClickListener(this);
        t_profilitdel.setOnClickListener(this);
        t_aboutus.setOnClickListener(this);
        t_logout.setOnClickListener(this);
        lihatUKM.setOnClickListener(this);

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionLogout:
                sessionManager.logoutSession();
                moveToLogin();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.l_lihatukm :
                i = new Intent(this, LihatUKMActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.l_lihatbem :
                i = new Intent(this,LihatBEMActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.l_lihatasrama :
                i = new Intent(this,AsramaActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.l_profilitdel :
                i = new Intent(this,LihatProfilItDelActivity.class);
                startActivity(i);
                break;
        }

        switch (view.getId()){
            case R.id.l_aboutus :
                i = new Intent(this,AboutUsActivity.class);
                startActivity(i);
                break;
        }
        switch (view.getId()){
            case R.id.l_logout :
                sessionManager.logoutSession();
                moveToLogin();
                break;
        }
    }
}