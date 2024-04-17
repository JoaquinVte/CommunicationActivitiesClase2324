package es.ieslavereda.communicationactivitiesclase2324;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button bUp;
    private Button bDown;
    private Button bSettings;
    private CustomGradeView customGradeView;
    private int textSize;

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

        textSize=12;

        customGradeView = findViewById(R.id.customGradeView);
        bUp = findViewById(R.id.bUp);
        bDown = findViewById(R.id.bDown);
        bSettings = findViewById(R.id.bSettings);

        customGradeView.setTextSize(12);

        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result ->{

                }
        );


        bUp.setOnClickListener(v->customGradeView.up());
        bDown.setOnClickListener(v->customGradeView.down());
        bSettings.setOnClickListener(v->{
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("grade",customGradeView.getGrade());
            intent.putExtra("barColor",customGradeView.getBarColor());
            intent.putExtra("textColor",customGradeView.getTextColor());
            intent.putExtra("textSize",textSize);

            resultLauncher.launch(intent);
        });

    }
}