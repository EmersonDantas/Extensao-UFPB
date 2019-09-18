package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.extensaoufpb.extensaoufpb.R;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonBack;

    private TextInputLayout emailField;
    private TextInputLayout passwordField;

    private Intent startIntent;
    private Toast toastMessage;

    private String emailCoordinator = "coordenador@gmail.com";
    private String passwordCoordinator = "coordenador";

    private String emailExtern = "externo@gmail.com";
    private String passwordExtern = "externo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findComponent();
        init();

    }

    private void init() {

        this.toastMessage = Toast.makeText(this, null, Toast.LENGTH_SHORT);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validFields = verifyFields(emailField, passwordField);

                if (validFields) {
                    startIntent = new Intent(LoginActivity.this, BaseActivity.class);

                    startIntent.putExtra("email", getEmail(emailField));

                    startActivity(startIntent);
                    finish();
                }

            }
        });


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startIntent = new Intent(LoginActivity.this, BaseActivity.class);

                startActivity(startIntent);
                finish();

            }
        });

    }

    private void findComponent() {
        buttonLogin = findViewById(R.id.btnLogin);
        buttonBack = findViewById(R.id.btnBack);
        emailField = findViewById(R.id.input_layout_email);
        passwordField = findViewById(R.id.input_layout_password);
    }

    private boolean verifyFields(TextInputLayout email, TextInputLayout password) {

        if (emailIsEmpty(email) || passwordIsEmpty(password)) {
            showToastMessage(toastMessage, "Há campos vazios!");

            return false;

        } else if ((!getEmail(email).equals(emailCoordinator) || !getPassword(password).equals(passwordCoordinator)) && (!getEmail(email).equals(emailExtern) || !getPassword(password).equals(passwordExtern))) {
            showToastMessage(toastMessage, "Email ou senha inválidos!");

            return false;

        } else {
            showToastMessage(toastMessage, "Você logou com " + getEmail(email));

            return true;
        }
    }


    private String getEmail(TextInputLayout emailField) {
        return emailField.getEditText().getText().toString();
    }

    private String getPassword (TextInputLayout emailField) {
        return emailField.getEditText().getText().toString();
    }

    private boolean emailIsEmpty(TextInputLayout input_email) {
        return getEmail(input_email).isEmpty();
    }

    private boolean passwordIsEmpty(TextInputLayout input_password) {
        return getPassword(input_password).isEmpty();
    }

    private void showToastMessage(Toast toast, String message) {
        toast.setText(message);
        toast.show();
    }

}