package com.example.tp2_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Joueur2 extends AppCompatActivity {
    RelativeLayout relativeLayout2 ;
    AppCompatButton appCompatButton;
    AppCompatEditText num1,num2;
    TextView textView2;
    public static final String NAME1 = "name_1", NAME2 = "name_2", NUM = "num";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur2);
        relativeLayout2 = (RelativeLayout) findViewById(R.id.layout2);
        relativeLayout2.setOnClickListener(null);

        appCompatButton=(AppCompatButton) findViewById(R.id.send_Num2);

        String name2 =getIntent().getStringExtra(Joueur1.NAME22).toString();
        String name1 =getIntent().getStringExtra(Joueur1.NAME11).toString();

        textView2 =(TextView) findViewById(R.id.textView2);
        textView2.setText(name2);


        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                num2=(AppCompatEditText) findViewById(R.id.Num2_joueir2);

                int nbrMgc = getIntent().getIntExtra(MainActivity.NUM, 0);
                int nbrSaisi = Integer.parseInt(num2.getText().toString());


                if(nbrMgc==nbrSaisi){
                    new SweetAlertDialog(Joueur2.this)
                            .setTitleText("Filicitation "+getIntent().getStringExtra(MainActivity.NAME2)+"")
                            .show();

                }else{

                    Intent intent = new Intent(Joueur2.this, Joueur1.class);
                    intent.putExtra(MainActivity.NAME1, getIntent().getStringExtra(MainActivity.NAME1));
                    intent.putExtra(MainActivity.NAME2, getIntent().getStringExtra(MainActivity.NAME2));
                    intent.putExtra(MainActivity.NUM, nbrMgc);
                    startActivity(intent);
                    finish();
                    //Log.d("messagee",nbrMgc+"");
                    //Intent joueur1=new Intent(getApplicationContext(),Joueur1.class);

                    //startActivity(joueur1);
                    //finish();
                }


            }
        });
    }

    public void restart(View view) {
        Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainActivity);

    }
}
