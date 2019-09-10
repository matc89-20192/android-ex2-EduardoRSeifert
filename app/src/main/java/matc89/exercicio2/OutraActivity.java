package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OutraActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnConfirmar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        editText = (EditText) findViewById(R.id.editText);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        editText.setText(message);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("meutexto", editText.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String meutexto = savedInstanceState.getString("meutexto");
        editText.setText(meutexto);
    }

    public void btnConfirmarPress(View v){
        Intent intent = new Intent();
        intent.putExtra("editNome",editText.getText().toString());
        setResult(1,intent);
        finish();
    }

    public void btnCancelarPress(View v){
        setResult(3,null);
        finish();
    }
}
