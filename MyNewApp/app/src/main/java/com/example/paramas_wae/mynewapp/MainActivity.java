package com.example.paramas_wae.mynewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.myButton);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick (View view){
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Button Clicked");
                    }
                }
        );
    }

}
