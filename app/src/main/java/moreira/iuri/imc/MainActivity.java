package moreira.iuri.imc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btCalcularIMC ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcularIMC();
    }

    public void calcularIMC() {
        btCalcularIMC = (Button) findViewById(R.id.bt_calcular);


        btCalcularIMC.setOnClickListener(new View.OnClickListener() {
            EditText txtPeso = (EditText) findViewById(R.id.txt_peso);
            EditText txtAltura = (EditText) findViewById(R.id.txt_altura);
            TextView txtResultado = (TextView) findViewById(R.id.txt_resultado);
            TextView txtClassificacao = (TextView) findViewById(R.id.txt_classificacao);

            @Override
            public void onClick(View arg0) {
                double peso = Double.parseDouble(txtPeso.getText().toString());
               double altura = Double.parseDouble(txtAltura.getText().toString());

                double resultado = peso/(altura*altura);

                if(resultado<16){
                    txtClassificacao.setText("Magreza Grave");
                }
                if(resultado>=16 && resultado<17){
                    txtClassificacao.setText("Magreza Moderada");
                }
                if(resultado>=17 && resultado<18.5){
                    txtClassificacao.setText("Magreza Leve");
                }
                if(resultado>=18.5 && resultado<25){
                    txtClassificacao.setText("Saudável");
                }
                if(resultado>=25 && resultado<30){
                    txtClassificacao.setText("Sobrepeso");
                }
                if(resultado>=30 && resultado<35){
                    txtClassificacao.setText("Obesidade Grau I");
                }
                if(resultado>=35 && resultado<40){
                    txtClassificacao.setText("Obesidade Grau II(Severa)");
                }
                if(resultado>40){
                    txtClassificacao.setText("Obesidade Grau III(Mórbida)");
                }

                txtResultado.setText(String.valueOf(resultado));









            }
        });
    }
}
