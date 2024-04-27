package com.prithviraj.sharedprefrencespractice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

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
        editText=findViewById(R.id.editText1);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.btn);
        prevdisplay();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                displaytext(s);
            }
        });


    }

    private void prevdisplay() {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedData",MODE_PRIVATE);
        String s1= sharedPreferences.getString("text"," ");
        textView.setText(s1);
    }

    private void displaytext(String text) {
        textView.setText(text);
        SharedPreferences sharedPreferences = getSharedPreferences("SharedData",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("text",text);
        editor.commit();
    }
}