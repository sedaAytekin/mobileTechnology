package com.example.mobiletechnology;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginPage extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.emailET)
    EditText emailET;
    @BindView(R.id.passwordTV)
    TextView passwordTV;
    @BindView(R.id.passwordET)
    EditText passwordET;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.goBT)
    Button goBT;

    String mail = "admin@seda.com";
    String password = "111111";
    int counter = 0;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);


        //kullanıcı daha önceden beni hatırlayı işaretlediyse, otomatik içeri alıyoruz.
        if (!pref.getString("email","").equals("") &&
            !pref.getString("password","").equals("") &&
            pref.getString("email","").equals(mail) && pref.getString("password","").equals(password))
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    editor = pref.edit();
                    editor.putString("email", mail);
                    editor.putString("password", password);
                    editor.apply();
                }else
                {
                    //beni hatırla kaldırılırsa, sharedprefi temizliyoruz.
                    editor.clear();
                }

            }
        });


        goBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 2)
                {
                    goBT.setEnabled(false);
                }

                if (emailET.getText().toString().length() > 1 && passwordET.getText().toString().length() < 6)
                {
                    Toast.makeText(getApplicationContext(), "şifreniz 6 karakterden fazla olmalı :(", Toast.LENGTH_SHORT).show();
                }else
                {
                    if (emailET.getText().toString().equals(mail) && passwordET.getText().toString().equals(password))
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }else
                    {
                        Toast.makeText(getApplicationContext(), "E mail ya da şifreniz yanlış:(", Toast.LENGTH_SHORT).show();
                        counter ++;
                    }
                }
            }
        });


    }
}
