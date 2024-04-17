package es.ieslavereda.communicationactivitiesclase2324;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

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

        Toast.makeText(this,grade+ " " +barColor+" " +textColor+" "+textSize,Toast.LENGTH_LONG).show();

    }
}







