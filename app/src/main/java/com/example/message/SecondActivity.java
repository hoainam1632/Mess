package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.om.example.android.twoactivities.extra.REPLY";
    TextView txt;
    EditText mtxtmess2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mtxtmess2 = (EditText) findViewById(R.id.txt_mess2);

        txt = (TextView) findViewById(R.id.txtmess2);
        Intent intent = getIntent();
        String mess = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        txt.setText(mess);
    }

    public void Replymess(View view) {
        String m = mtxtmess2.getText().toString();
        Intent replyintent = new Intent();
        replyintent.putExtra("rep", m);
        setResult(RESULT_OK, replyintent);
        finish();
    }
}
