package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imgResultado = findViewById(R.id.imgResultado); //seleciona o ImageView da tela pelo id
        TextView txtResultado = findViewById(R.id.txtResultado); //seleciona o TextView da tela pelo id

        String[] opcoes = {"Pedra", "Papel", "Tesoura"}; //array de string para definir o nome em ordem
        int numero = new Random().nextInt(3); //gera número aleatório 0, 1, 2
        String opcaoApp = opcoes[numero];
        /*String opcaoApp = opcoes [numero]; //puxa uma string e a classifica de acordo com o resultado passado em "numero"
*/
        switch (opcaoApp){
            case "Pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (    (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Pesoura")){
                txtResultado.setText("Você perdeu =("); //Faz o TextView alterar o texto de acordo com o teste if


        } else if (//usuário ganhador
                (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel") ||
                (opcaoSelecionada == "Papel" && opcaoApp == "Pedra") ||
                (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura")){
                txtResultado.setText("Você ganhou =)"); //Faz o TextView alterar o texto de acordo com o teste if


        }else {//Empate
            txtResultado.setText("Empatamos desta vez =/"); //Faz o TextView alterar o texto de acordo com o teste if
        }

        System.out.println("Item clicado: " + opcaoApp);

    }
}
