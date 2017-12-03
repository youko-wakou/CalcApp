package techacademy.wakou.youko.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
    @Override
    public void onClick(View v){
        String val1 = editText1.getText().toString();
        String val2 = editText2.getText().toString();
        double value1 = Double.parseDouble(val1);
        double value2 = Double.parseDouble(val2);
//        入力チェック
        boolean bool1 = val1.isEmpty();
        boolean bool2 = val2.isEmpty();
//        空でなければ遷移先へ値を送る
        if(bool1== true || bool2 == true){
            System.out.print("数値を入力してください");
        }else {
            Intent intent = new Intent(this, SecondActivity.class);
           intent.putExtra("VALUE1", value1);
            intent.putExtra("VALUE2", value2);

//        分岐で押したボタンによって遷移先に値を送る
            if (v.getId() == R.id.button1) {
                intent.putExtra("VALUE3", 1);
//            Log.d("test",val1+val2);
            } else if (v.getId() == R.id.button2) {
                intent.putExtra("VALUE3", 2);
            } else if (v.getId() == R.id.button3) {
                intent.putExtra("VALUE3", 3);
            } else if (v.getId() == R.id.button4) {
                intent.putExtra("VALUE3", 4);
            }
            startActivity(intent);
        }
    }
}
