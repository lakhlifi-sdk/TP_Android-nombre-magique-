package com.example.tp2_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;
public class Joueur1 extends AppCompatActivity {
    RelativeLayout relativeLayout1 ;
    AppCompatButton appCompatButton;
    AppCompatEditText num1,num2;
    TextView textView1;
    public static final String NAME11 = "name_1", NAME22 = "name_2", NUM = "num";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur1);
        relativeLayout1 = (RelativeLayout) findViewById(R.id.layout1);
        relativeLayout1.setOnClickListener(null);
        appCompatButton=(AppCompatButton) findViewById(R.id.send_Num1);
        textView1 =(TextView) findViewById(R.id.textView1);

        String name1 =getIntent().getStringExtra(MainActivity.NAME1).toString();
        String name11  =getIntent().getStringExtra(Joueur2.NAME1).toString();
//just for test
        if(name1.isEmpty()){
            name1=name11;
        }

        textView1.setText(name1);

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1=(AppCompatEditText) findViewById(R.id.Num1_joueir1);

                int nbrMgc = getIntent().getIntExtra(MainActivity.NUM, 0);
                int nbrSaisi = Integer.parseInt(num1.getText().toString());


                if(nbrMgc==nbrSaisi){
                    new SweetAlertDialog(Joueur1.this)
                            .setTitleText("Filicitation "+getIntent().getStringExtra(MainActivity.NAME1)+"")
                            .show();

                }else{

                    Intent intent = new Intent(Joueur1.this, Joueur2.class);
                    intent.putExtra(MainActivity.NAME1, getIntent().getStringExtra(MainActivity.NAME1));
                    intent.putExtra(MainActivity.NAME2, getIntent().getStringExtra(MainActivity.NAME2));
                    intent.putExtra(MainActivity.NUM, nbrMgc);
                    startActivity(intent);
                    finish();

                   /* Log.d("messagee",nbrMgc+"");
                    String name2 =getIntent().getStringExtra(MainActivity.NAME2).toString();
                    String name1 =getIntent().getStringExtra(MainActivity.NAME2).toString();
                    Intent joueur1=new Intent(getApplicationContext(),Joueur2.class);
                    joueur1.putExtra(NAME22, name2);
                    joueur1.putExtra(NAME11, name2);

                    startActivity(joueur1);*/

                }



            }
        });
    }

    public void restart(View view) {
        Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainActivity);
    }
}
