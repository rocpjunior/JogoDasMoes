package com.rocpjunior.jogodasmoes;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
    }

    public void escolherPedra(View view) {
        verificarVencedor("Pedra");
    }

    public void escolherPapel(View view) {
        verificarVencedor("Papel");
    }

    public void escolherTesoura(View view) {
        verificarVencedor("Tesoura");
    }

    private String gerarEscolhaDoApp() {
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp) {
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    private void verificarVencedor(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaDoApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                        (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                        (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ) {
            textoResultado.setText("Voce perdeu o jogo! (;-;)");
        } else if (
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                        (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                        (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ) {
            textoResultado.setText("Voce ganhou o jogo! =D");
        } else {
            textoResultado.setText("Empate! (0_0)");
        }
    }
}