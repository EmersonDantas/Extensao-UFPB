package br.com.extensaoufpb.extensaoufpb.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.inicio.InicioFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.perfil.PerfilFragment;

public class BaseActivity extends AppCompatActivity {

    private BottomNavigationView navView;
    private BottomSheet bottomSheet;
    private Fragment actualFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //remove a action bar apenas necessario nessa tela sdf
        setContentView(R.layout.activity_base);

        init();

        findViews();

        initializeFirstTabNavigation();

        setNavigation();

    }

    private void init(){

        bottomSheet = BottomSheet.getInstance(getWindow().getDecorView().findViewById(android.R.id.content));
        fragmentManager = getSupportFragmentManager();

    }

    private void findViews(){

        navView = findViewById(R.id.nav_view);

    }
    private void setNavigation(){
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.navigation_menu:
                        bottomSheet.changeStateBottom();
                        break;
                    case R.id.navigation_inicio:
                        actualFragment = new InicioFragment();
                        break;
                    case R.id.navigation_perfil:
                        actualFragment = new PerfilFragment();
                        break;
                }

                repliceFragment();
                return true;
            }
        });
    }

    private void repliceFragment(){
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.nav_host_fragment, actualFragment).commit();
    }

    private void initializeFirstTabNavigation(){

        bottomSheet.closeBottomSheeet();
        actualFragment = new InicioFragment();
        repliceFragment();

    }

}
