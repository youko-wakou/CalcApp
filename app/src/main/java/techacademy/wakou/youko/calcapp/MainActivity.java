package techacademy.wakou.youko.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    変数宣言
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

//        テキストエディタiD取得
        editText1= (EditText) findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
    }
    @Override
    public void onClick(View v){
        String val1 = editText1.toString();
        String val2 = editText2.toString();
        Intent intent = new Intent(this,SecondActivity.class);
//        テキストエディタ遷移先への値
        intent.putExtra("VALUE1",val1);
        intent.putExtra("VALUE2",val2);

        if(v.getId() == R.id.button1) {
            intent.putExtra("VALUE3","1");

         }else if(v.getId() == R.id.button2){
            intent.putExtra("VALUE3","2");
        }else if(v.getId() == R.id.button3){
             intent.putExtra("VALUE3","3");
        }else if(v.getId() == R.id.button4){
            intent.putExtra("VALUE3","4");
        }
        startActivity(intent);

    }
}
