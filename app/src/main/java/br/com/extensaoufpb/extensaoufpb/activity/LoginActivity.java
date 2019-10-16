package br.com.extensaoufpb.extensaoufpb.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.extensaoufpb.extensaoufpb.Controller.FacadeQuestion;
import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.activity.ui.base.BaseActivity;
import br.com.extensaoufpb.extensaoufpb.activity.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogin;
    private Button buttonBack;
    private Button buttonGoToRegister;

    private CheckBox remenberCheckBox;

    private TextInputLayout emailField;
    private TextInputLayout passwordField;

    private Toast toastMessage;

    private final String emailCoordinator = "c1@gmail.com";
    private final String passwordCoordinator = "c1";

    private final String emailExtern = "e1@gmail.com";
    private final String passwordExtern = "e1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findComponent();
        init();
        setListeners();

    }

    private void init() {

        this.toastMessage = Toast.makeText(this, null, Toast.LENGTH_SHORT);

    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    private void findComponent() {

        buttonLogin = findViewById(R.id.btnLogin);
        buttonBack = findViewById(R.id.btnLoginBack);
        buttonGoToRegister = findViewById(R.id.btnGoToRegister);
        emailField = findViewById(R.id.input_layout_email);
        passwordField = findViewById(R.id.input_layout_password);
        remenberCheckBox = findViewById(R.id.remenberCheckBox);

    }

    private void setListeners(){
        buttonLogin.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        buttonGoToRegister.setOnClickListener(this);
        remenberCheckBox.setOnClickListener(this);
    }

    private boolean verifyFields(TextInputLayout inputEmail, TextInputLayout inputPassword) {

        final String email = inputEmail.getEditText().getText().toString();
        final String password = inputPassword.getEditText().getText().toString();

        boolean verify = false;

        if (email.isEmpty() || password.isEmpty()) {

            showToastMessage(toastMessage, "Há campos vazios!");

        }else if ((!email.equalsIgnoreCase(emailCoordinator) || !password.equalsIgnoreCase(passwordCoordinator)) && (!email.equalsIgnoreCase(emailExtern) || !password.equalsIgnoreCase(passwordExtern))){

            showToastMessage(toastMessage, "Email ou senha inválidos!");

        }else{

            showToastMessage(toastMessage, "Você logou com " + email);

            verify = true;

        }

        return verify;
    }

    private void showToastMessage(Toast toast, String message) {
        toast.setText(message);
        toast.show();
    }

    @Override
    public void onClick(View v) {

        Intent user = null;
        String email = emailField.getEditText().getText().toString();

        switch (v.getId()){

            case (R.id.btnLoginBack):

                user = new Intent(LoginActivity.this,BaseActivity.class);
                email = "notUser";

                break;

            case (R.id.btnLogin):

                boolean validFields = verifyFields(emailField, passwordField);

                if (validFields) {

                    user = new Intent(LoginActivity.this, BaseActivity.class);

                }

                break;

            case (R.id.btnGoToRegister):

                user = new Intent(LoginActivity.this, RegisterActivity.class);

                break;

            case (R.id.remenberCheckBox):

                emailField.getEditText().setText(emailCoordinator);
                passwordField.getEditText().setText(passwordCoordinator);

        }

        hideKeyboard();

        if(user != null){

            FacadeQuestion.getInstance().login(email);
            startActivity(user);
            finish();

        }
    }

}