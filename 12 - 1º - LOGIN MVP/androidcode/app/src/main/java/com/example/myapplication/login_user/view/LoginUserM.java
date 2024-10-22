package com.example.myapplication.login_user.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.beans.User;
import com.example.myapplication.login_user.ContractLoginUser;
import com.example.myapplication.login_user.presenter.LoginUserPresenter;

public class LoginUserM extends AppCompatActivity implements ContractLoginUser.View {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private LoginUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);
        presenter = new LoginUserPresenter(this);
        initComponents();//Posible error, no inicializar los componentes???


    }

    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(edtEmail.getText().toString(), edtPassword.getText().toString());
                presenter.login(user);
            }
        });
    }

    @Override
    public void successLogin(User user) {
        Toast.makeText(this, "Login succesful: " + user.getEmail(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(this, "Login failed: " + err, Toast.LENGTH_SHORT).show();

    }
}