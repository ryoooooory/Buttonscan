package jp.techinstitute.oshimaryo.buttonscan;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private SharedPreferences dataStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);


        final Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.edittext);
        final TextView textView = (TextView) findViewById(R.id.text);

        String text = "こんにちは" + dataStore.getString("input","");    //以前に入力していればそれを加える
        textView.setText(text);             //textviewにtextの内容をセット


        button.setOnClickListener(new View.OnClickListener() {      //クリック時のイベント
            @Override
            public void onClick(View view) {
                String inputtext = editText.getText().toString(); //ここに押された時の処理を記述
                SharedPreferences.Editor edit = dataStore.edit();
                String text = "こんにちは" + dataStore.getString("input","");    //以前に入力していればそれを加える
                textView.setText(text);             //textviewにtextの内容をセット
                edit.putString("input", inputtext);          //キーと一緒に保存
                edit.apply();                       //入力内容の更新

            }
        });



    }
}
