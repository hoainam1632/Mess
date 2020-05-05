package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "om.example.android.twoactivities.extra.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int TEXT_REQUEST = 1;
    EditText mtxtmess;
    TextView mtxt;
    TextView mtxtheader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtxt = (TextView) findViewById(R.id.txtmess);
        mtxtmess = (EditText) findViewById(R.id.txt_mess);
        mtxtheader = (TextView) findViewById(R.id.txtheader);
    }

    public void sendMessage(View view) {
        String mess = mtxtmess.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mess);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mtxtheader.setVisibility(View.VISIBLE);
                mtxtmess.setText(reply);
                mtxtmess.setVisibility(View.VISIBLE);
            }
        }
    }
}
