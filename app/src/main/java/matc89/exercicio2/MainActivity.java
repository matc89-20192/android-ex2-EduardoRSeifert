package matc89.exercicio2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private TextView textView;
    private Button btnTrocar;
    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTrocar = (Button) findViewById(R.id.btnTrocar);
        textView = (TextView) findViewById(R.id.textView);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("meutexto", nome);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        nome = savedInstanceState.getString("meutexto");
        if(!nome.equals("")){
            textView.setText("Oi, "+nome+"!");
        }
        else{
            textView.setText("Oi!");
        }
    }

    public void btnTrocarPress(View v){
        Intent intent = new Intent(this,OutraActivity.class);
        intent.putExtra(EXTRA_MESSAGE,nome);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1&&data!=null){
            nome = data.getStringExtra("editNome");
            if(!nome.equals("")){
                textView.setText("Oi, "+nome+"!");
            }
            else{
                textView.setText("Oi!");
            }
        }
    }
}
