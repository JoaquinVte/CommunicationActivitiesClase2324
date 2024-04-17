package es.ieslavereda.communicationactivitiesclase2324;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText etGrade;
    private EditText etTextSize;
    private Button bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int grade = intent.getExtras().getInt("grade");
        Color barColor = (Color) intent.getExtras().get("barColor");
        Color textColor = (Color) intent.getExtras().get("textColor");
        int textSize = intent.getExtras().getInt("textSize");

        spinner = findViewById(R.id.spinner);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        etGrade = findViewById(R.id.etGrade);
        etTextSize = findViewById(R.id.etTextSize);
        bBack = findViewById(R.id.bBack);

        spinner.setAdapter(new CustomArrayAdapter<>(this, R.layout.spinner_item, Color.values()));

        for(int i=0;i<radioGroup.getChildCount();i++){
            RadioButton rb = (RadioButton) radioGroup.getChildAt(i);
            if(rb.getText().toString().equalsIgnoreCase(barColor.getDescription()))
                rb.setChecked(true);
        }
        spinner.setSelection(textColor.ordinal());
        etTextSize.setText(String.valueOf(textSize));
        etGrade.setText(String.valueOf(grade));




        bBack.setOnClickListener( v -> {
            int barColorSelected = radioGroup.getCheckedRadioButtonId();
            if(isCorrect()){

                Intent intentResultado = new Intent();
                intentResultado.putExtra("grade",Integer.parseInt(etGrade.getText().toString()));
                intentResultado.putExtra("barColor",(Color)((barColorSelected==-1)?Color.DEFAULT:Color.values()[barColorSelected]));
                intentResultado.putExtra("textColor",(Color)spinner.getSelectedItem());
                intentResultado.putExtra("textSize",Integer.parseInt(etTextSize.getText().toString()));
                setResult(RESULT_OK,intentResultado);
                finish();

            }

        });


    }

    private boolean isCorrect() {
        if(etGrade.getText().toString().isEmpty()) {
            showError("Se debe introducir valores en grade.");
            return false;
        }
        if(etTextSize.getText().toString().isEmpty()) {
            showError("Se debe introducir valores en textSize.");
            return false;
        }

        int textSize = Integer.parseInt(etTextSize.getText().toString());
        int grade = Integer.parseInt(etGrade.getText().toString());

        if(textSize>60 || textSize<10){
            showError("El valor de textSize debe estar entre 10 y 60.");
            return false;
        }

        if(grade>100 || grade<0){
            showError("Grade debe estar entre 0 y 100");
            return false;
        }
        return true;

    }
    private void showError(String error){
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }
}







