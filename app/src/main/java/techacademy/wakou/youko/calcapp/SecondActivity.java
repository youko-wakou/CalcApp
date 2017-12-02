package techacademy.wakou.youko.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int value1 = intent.getIntExtra("VALUE1",0);
        int value2 = intent.getIntExtra("VALUE2",0);
        int value3 = intent.getIntExtra("VALUE3",0);

            TextView textView = (TextView) findViewById(R.id.textView);

            if (value3 == 1) {
                textView.setText(String.valueOf(value1 - value2));
            } else if (value3 == 2) {
                textView.setText(String.valueOf(value1 + value2));
            } else if (value3 == 3) {
                textView.setText(String.valueOf(value1 * value2));
            } else if (value3 == 4) {
                textView.setText(String.valueOf(value1 / value2));
            }

    }
}
