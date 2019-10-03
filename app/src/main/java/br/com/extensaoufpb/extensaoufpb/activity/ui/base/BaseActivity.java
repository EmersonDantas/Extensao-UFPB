package br.com.extensaoufpb.extensaoufpb.activity.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.extensaoufpb.extensaoufpb.Controller.BottomSheet;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.inicio.InicioFragment;
import br.com.extensaoufpb.extensaoufpb.activity.ui.profile.PerfilActivity;

import static com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView navView;
    private BottomSheet bottomSheet;

    private Bundle emailRecovery;
    private String userEmail;

    private Fragment actualFragment;
    private FragmentManager fragmentManager;

    private Button btnSelectiveProcessCoord;
    private Button btnSeeSuggestionsCoord;
    private Button btnOpenProcessCoord;
    private Button btnRegisterProjectCoord;
    private Button btnSeeProjectsCoord;

    private Button btnSeeSelectiveProcessExt;
    private Button btnSendSuggestionsExt;
    private Button btnSeeProjectsExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide(); //remove a action bar apenas necessario nessa tela sdf #Tava crashando no meu celular
        setContentView(R.layout.activity_base);

        init();

        findViews();

        initializeFirstTabNavigation();

        initAllButtons();

        enableClickButtons();

    }


    private void init() {

        emailRecovery = getIntent().getExtras();
        userEmail = emailRecovery.getString("email");

        bottomSheet = BottomSheet.getInstance(getWindow().getDecorView().findViewById(android.R.id.content), userEmail);
        fragmentManager = getSupportFragmentManager();

    }

    private void findViews() {

        navView = findViewById(R.id.nav_view);

        btnSelectiveProcessCoord = findViewById(R.id.btn_processo_seletivo_coord);
        btnSeeSuggestionsCoord = findViewById(R.id.btn_sugestoes_novos_projetos_coord);
        btnOpenProcessCoord = findViewById(R.id.btn_abrir_processo_coord);
        btnRegisterProjectCoord = findViewById(R.id.btn_cadastrar_projeto_coord);
        btnSeeProjectsCoord = findViewById(R.id.btn_ver_projetos_coord);
        btnSeeSelectiveProcessExt = findViewById(R.id.btn_ver_processos_ext);
        btnSendSuggestionsExt = findViewById(R.id.btn_enviar_sugestoes_ext);
        btnSeeProjectsExt = findViewById(R.id.btn_ver_projetos_ext);
    }

    private void backHome(){

        navView.setSelectedItemId(R.id.navigation_inicio);


    }

    private void setNavigation() {

        navView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){
                    case R.id.navigation_menu:

                        bottomSheet.changeStateBottom();

                        break;

                    case R.id.navigation_inicio:

                        bottomSheet.closeBottomSheeet();
                        actualFragment = new InicioFragment();
                        replaceFragment();
                        break;

                    case R.id.navigation_perfil:

                        bottomSheet.closeBottomSheeet();
                        Intent perfil = new Intent(BaseActivity.this, PerfilActivity.class);
                        startActivity(perfil);
                        break;
                }

                return true;
            }

        });
    }

    private void initAllButtons() {

        setNavigation();

    }

    protected void onResume(){
        super.onResume();
        backHome();
    }

    private void enableClickButtons() {

        btnSelectiveProcessCoord.setOnClickListener(this);
        btnSeeSuggestionsCoord.setOnClickListener(this);
        btnOpenProcessCoord.setOnClickListener(this);
        btnRegisterProjectCoord.setOnClickListener(this);
        btnSeeProjectsCoord.setOnClickListener(this);
        btnSeeSelectiveProcessExt.setOnClickListener(this);
        btnSendSuggestionsExt.setOnClickListener(this);
        btnSeeProjectsExt.setOnClickListener(this);

    }

    private void replaceFragment() {
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.nav_host_fragment, actualFragment).commit();
    }

    private void initializeFirstTabNavigation(){

        bottomSheet.closeBottomSheeet();
        actualFragment = new InicioFragment();
        replaceFragment();
        backHome();
    }

    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View view) {

        bottomSheet.clickButtons(view.getId(), this);
        backHome();
    }
}