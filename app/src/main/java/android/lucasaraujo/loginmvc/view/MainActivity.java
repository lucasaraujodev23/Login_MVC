package android.lucasaraujo.loginmvc.view;

import android.content.Intent;
import android.lucasaraujo.loginmvc.R;
import android.lucasaraujo.loginmvc.controller.UsuarioController;
import android.lucasaraujo.loginmvc.model.Usuario;
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

public class MainActivity extends AppCompatActivity {
    private EditText nome, email, senha;
    private Button entrar, cadastrar;
    Usuario usuario;
    UsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaCampos()){
                    usuario = new Usuario();
                    controller = new UsuarioController(getApplicationContext());

                    String name = nome.getText().toString();
                    String user = email.getText().toString();
                    String pass = senha.getText().toString();

                    boolean isCheckUser = controller.usuario(user);

                    if(isCheckUser){
                        Toast.makeText(MainActivity.this, "Usuario Já cadastrado", Integer.parseInt("3"));
                    } else {
                        usuario.setNome(name);
                        usuario.setEmail(user);
                        usuario.setSenha(pass);

                        Toast.makeText(MainActivity.this, "Cadastro realizado com sucesso", Integer.parseInt("3"));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Integer.parseInt("3"));
                }
            }
        });
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaCampos()){
                    usuario = new Usuario();
                    controller = new UsuarioController(getApplicationContext());

                    String name = nome.getText().toString();
                    String user = usuario.getEmail().toString();
                    String pass = usuario.getSenha().toString();

                    usuario.setNome(name);
                    usuario.setEmail(user);
                    usuario.setSenha(pass);

                    boolean isCheckUser = controller.usuario(user);
                    boolean isCheckPass = controller.usuarioeSenha(user, pass);

                    if(isCheckUser && isCheckPass){
                        Toast.makeText(MainActivity.this, "Login realizado com sucesso", Integer.parseInt("3"));
                    } else {
                        Toast.makeText(MainActivity.this, "Login ou senha incorretos", Integer.parseInt("3"));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Integer.parseInt("3"));
                }
            }
        });
    }

    private boolean validaCampos(){
        boolean camposValidados = true;
        if (nome.getText().toString().isEmpty() ||
            email.getText().toString().isEmpty() ||
            senha.getText().toString().isEmpty()){
            camposValidados = false;
        } else {
            camposValidados = true;
        }
        return camposValidados;
    }

    private void initComponents(){
        nome      = findViewById(R.id.nome);
        email     = findViewById(R.id.email);
        senha     = findViewById(R.id.senha);
        cadastrar = findViewById(R.id.cadastrar);
        entrar    = findViewById(R.id.entrar);
    }

}
