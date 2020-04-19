package com.example.mail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    FragmentManager fragmentManager;
    Toolbar toolbar;
    String mail="";
    Button btnlogout;
    private static  final String PREFER_NAME="pref";
    private static  final String KEY_EMAIL="email_key";
    private static  final String KEY_PASSWORD="pass_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("All mails");
//        toolbar.setTitle("All mails");
//        setSupportActionBar(toolbar);
        Fragment listFr=new MailListFragment();
        Fragment detailFr=new MailDetailFragment();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.MailList,listFr).commit();

        FragmentManager fragmentManagerD=getSupportFragmentManager();
        FragmentTransaction ft2=fragmentManagerD.beginTransaction();
        ft2.replace(R.id.MailDetail,detailFr).commit();


        btnlogout=findViewById(R.id.logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString(KEY_EMAIL,"");
                editor.putString(KEY_PASSWORD, "");
                editor.apply();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
//
//    public void clicked(Mails mail){
//        fragmentManager.beginTransaction().replace(R.id.MailList, new MailDetailFragment(mail)).commit();
//    }
//    public void onCallBack(View view) {
//        fragmentManager.beginTransaction().replace(R.id.MailList, MailListFragment).commit();
//    }
}
