package kr.ac.sc.computer.mobilecontents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button11);
        Button button3 = (Button) findViewById(R.id.db_btn);
        Button button4 = (Button) findViewById(R.id.file_btn);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        Intent intent = new Intent(MainActivity.this, BActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button11:
                        Intent intent2 = new Intent(MainActivity.this, ActivityA.class);
                        startActivity(intent2);
                        break;
                    case R.id.db_btn:
                        Intent intent3 = new Intent(MainActivity.this, ActivityDB.class);
                        startActivity(intent3);
                    case R.id.file_btn:
                        Intent intent4 = new Intent(MainActivity.this, MemoFileManagerActivity.class);
                        startActivity(intent4);
                }
            }
        };

        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
    }
}
