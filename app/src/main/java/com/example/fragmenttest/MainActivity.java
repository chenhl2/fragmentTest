package com.example.fragmenttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mDetachBtn;
    private Button mAttachBtn;
    private Button mMorePicsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetachBtn = findViewById(R.id.button_detach_fragment);
        mAttachBtn = findViewById(R.id.button_attach_fragment);
        mMorePicsBtn = findViewById(R.id.button_more_pics);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.framelayout_fragment, new FragmentFull(),null)
                    .addToBackStack("addFragment")
                    .commit();
        } else {
            Log.d(TAG, "onCreate: savedInstanceState不为空，不进行fragment的添加");
        }

        findViewById(R.id.framelayout_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 替换fragment并添加至后台堆栈
                Log.d(TAG, "onClick: 替换fragment");
                Toast.makeText(MainActivity.this,getSupportFragmentManager().getFragments().toString(),Toast.LENGTH_SHORT).show();
                /*getSupportFragmentManager().beginTransaction()
                        .replace(R.id.framelayout_fragment,new FragmentNew(),null)
                        .addToBackStack("replaceFragment")
                        .commit();*/


            }
        });

        mDetachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "mDetachBtn onClick:  detach fragment'");
                getSupportFragmentManager().beginTransaction()
                        .detach(getSupportFragmentManager().findFragmentById(R.id.framelayout_fragment))
                        .commit();
            }
        });

        mAttachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "mAttachBtn onClick: attach fragment'");
                getSupportFragmentManager().beginTransaction()
                        .attach(getSupportFragmentManager().findFragmentById(R.id.framelayout_fragment))
                        .commit();
            }
        });

        mMorePicsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.framelayout_fragment,new FragmentNew())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this,"onBackPressed",Toast.LENGTH_SHORT).show();
        /*getSupportFragmentManager().beginTransaction()
                .show(getSupportFragmentManager().findFragmentById(R.id.framelayout_fragment))
                .commit();*/
        super.onBackPressed();
    }
    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (getSupportFragmentManager().findFragmentById(R.id.framelayout_fragment) != null) {
            Log.e(TAG, "AppCompatActivity中onSaveInstanceState: 移除已经存在的fragment" );
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(getSupportFragmentManager().findFragmentById(R.id.framelayout_fragment))
                    .commitAllowingStateLoss();
        }
        super.onSaveInstanceState(outState);
    }*/

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.e(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.e(TAG, "onConfigurationChanged: " );
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop: " );
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
    }
}