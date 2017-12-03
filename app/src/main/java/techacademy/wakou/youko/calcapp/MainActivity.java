package techacademy.wakou.youko.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
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
//        引き算
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
//        足し算
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
//        掛け算
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
//        割り算
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

//        テキストエディタiD取得
        editText1= (EditText) findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
//        入力値チェック
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);

    }

    @Override
    public void onClick(View v){
        String val1 = editText1.getText().toString();
        String val2 = editText2.getText().toString();
        try{
            double value1 = Double.parseDouble(val1);
            double value2 = Double.parseDouble(val2);
//        入力チェック
//            boolean bool1 = val1.isEmpty();
//            boolean bool2 = val2.isEmpty();
            Intent intent = new Intent(this, SecondActivity.class);
           intent.putExtra("VALUE1", value1);
           if(v.getId() == R.id.button4 && value2==0) {
               Log.d("test","0で割ることはできません");
               new AlertDialog.Builder(this)
                       .setTitle("title")
                       .setMessage("0で割ることはできません")
                       .setPositiveButton("OK",null)
                       .show();

           }else {
               intent.putExtra("VALUE2", value2);
//        分岐で押したボタンによって遷移先に値を送る
               if (v.getId() == R.id.button1) {
                   intent.putExtra("VALUE3", 1);
               } else if (v.getId() == R.id.button2) {
                   intent.putExtra("VALUE3", 2);
               } else if (v.getId() == R.id.button3) {
                   intent.putExtra("VALUE3", 3);
               } else if (v.getId() == R.id.button4) {
                   intent.putExtra("VALUE3", 4);
               }
               startActivity(intent);
           }
        }catch(Exception e){
            Log.d("test","数値を入力してください");
            new AlertDialog.Builder(this)
                    .setTitle("エラー")
                    .setMessage("数値を入力してください")
                    .setPositiveButton("OK",null)
                    .show();

        }
    }
}
