package com.example.wallapop.register_user.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wallapop.R;
import com.example.wallapop.beans.User;
import com.example.wallapop.register_user.ContractRegisterUser;
import com.example.wallapop.register_user.presenter.RegisterUserPresenter;

public class RegisterUserView extends AppCompatActivity implements ContractRegisterUser.View {
    private EditText edtRegisterEmail;
    private EditText edtRegisterPassword;
    private Button btnRegister;
    private RegisterUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_m);
        presenter = new RegisterUserPresenter(this);
        initComponents();
    }

    private void initComponents() {
        // Inicializa los componentes de la interfaz de usuario
        edtRegisterEmail = findViewById(R.id.edtRegisterEmail);
        edtRegisterPassword = findViewById(R.id.edtRegisterPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Configura el evento onClick para el botón de registro
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un objeto User con los datos ingresados por el usuario
                String email = edtRegisterEmail.getText().toString();
                String password = edtRegisterPassword.getText().toString();
                User user = new User(email, password);

                // Llama al método register en el presentador
                presenter.register(user);
            }
        });
    }

    @Override
    public void successRegister(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureRegister(String err) {
        // Muestra un mensaje de error cuando el registro falla
        Toast.makeText(this, "Error de registro: " + err, Toast.LENGTH_SHORT).show();
    }


}
