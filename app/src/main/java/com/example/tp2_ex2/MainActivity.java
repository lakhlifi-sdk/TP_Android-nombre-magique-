package com.example.tp2_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout,relativeLayout1,relativeLayout2 ;
    AppCompatButton appCompatButton;
    private static final String TAG = "MyActivity";
    public static final String NAME1 = "name_1", NAME2 = "name_2", NUM = "num";
    AppCompatEditText name1,name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.RelativL);
        relativeLayout.setOnClickListener(null);
        appCompatButton=(AppCompatButton) findViewById(R.id.jouer);



        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name1=(AppCompatEditText) findViewById(R.id.name1);

                name2=(AppCompatEditText) findViewById(R.id.name2);
                Random number=new Random();

                int num=number.nextInt(10)*2;
                System.out.println("the nuuuuuuuber is : "+num);
                Log.d("message",num+"");

                Intent joueur1=new Intent(getApplicationContext(),Joueur1.class);
                joueur1.putExtra(NUM,num);
                joueur1.putExtra(NAME1,name1.getText().toString());
                joueur1.putExtra(NAME2,name2.getText().toString());
                startActivity(joueur1);

            }
        });


    }



}
