package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.extensaoufpb.extensaoufpb.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogin;
    private Button buttonBack;
    private Button buttonGoToRegister;

    private TextInputLayout emailField;
    private TextInputLayout passwordField;

    private Intent startIntent;
    private Toast toastMessage;

    private String emailCoordinator = "c1@gmail.com";
    private String passwordCoordinator = "c1";

    private String emailExtern = "e1@gmail.com";
    private String passwordExtern = "e1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findComponent();
        init();

    }

    private void init() {
        this.toastMessage = Toast.makeText(this, null, Toast.LENGTH_SHORT);

    }

    private void findComponent() {
        buttonLogin = findViewById(R.id.btnLogin);
        buttonBack = findViewById(R.id.btnLoginBack);
        buttonGoToRegister = findViewById(R.id.btnGoToRegister);
        emailField = findViewById(R.id.input_layout_email);
        passwordField = findViewById(R.id.input_layout_password);
        setListeners();
    }

    private void setListeners(){
        buttonLogin.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        buttonGoToRegister.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btnLoginBack):
                startActivity(new Intent(LoginActivity.this, BaseActivity.class));
                finish();
                break;
            case (R.id.btnLogin):
                boolean validFields = verifyFields(emailField, passwordField);

                if (validFields) {
                    startIntent = new Intent(LoginActivity.this, BaseActivity.class);

                    startIntent.putExtra("email", getEmail(emailField));

                    startActivity(startIntent);
                    finish();
                }

                break;
            case(R.id.btnGoToRegister):
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                //finish();
                break;
        }
    }
}