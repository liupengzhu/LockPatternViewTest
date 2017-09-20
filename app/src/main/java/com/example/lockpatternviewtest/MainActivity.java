package com.example.lockpatternviewtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lockpatterviewdemo.LockPatternView;
import com.example.lockpatterviewdemo.OnLockPatternChangeListener;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    LockPatternView lockPatternView;
    private SharedPreferences pref;
    private String password;
    private TextView textView;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lockPatternView = (LockPatternView) findViewById(R.id.lock_pattern);
        textView = (TextView) findViewById(R.id.text_view);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        password = pref.getString("password",null);
        if(password==null){
            textView.setText("请设置密码");
        }else {
            textView.setText("请输入密码");
        }
        lockPatternView.setOnLockPatternChangeListener(new OnLockPatternChangeListener() {
            @Override
            public void onSuccessful(String s) {
                if(password==null){
                    editor = pref.edit();
                    editor.putString("password",s);
                    editor.apply();
                    password = pref.getString("password",null);
                    textView.setText("请输入密码");
                }else if(password.equals(s)) {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                }else if(!password.equals(s)) {
                    Toast.makeText(MainActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError() {

            }
        });
    }
}
