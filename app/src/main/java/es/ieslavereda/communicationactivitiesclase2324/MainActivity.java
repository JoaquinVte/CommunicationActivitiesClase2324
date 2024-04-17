package es.ieslavereda.communicationactivitiesclase2324;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button bUp;
    private Button bDown;
    private Button bSettings;
    private CustomGradeView customGradeView;

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

        customGradeView = findViewById(R.id.customGradeView);
        bUp = findViewById(R.id.bUp);
        bDown = findViewById(R.id.bDown);
        bSettings = findViewById(R.id.bSettings);

        bUp.setOnClickListener(v->customGradeView.up());
        bDown.setOnClickListener(v->customGradeView.down());
        bSettings.setOnClickListener(v->{
            Intent in
        });

    }
}