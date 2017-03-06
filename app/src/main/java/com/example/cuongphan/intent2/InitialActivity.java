package com.example.cuongphan.intent2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
    }
    public void calSum(View view){
        int btn_id = view.getId();
        int number_1, number_2;
        EditText et_number1 = (EditText)findViewById(R.id.et_number1);
        EditText et_number2 = (EditText)findViewById(R.id.et_number2);
        String address;
        if(btn_id == R.id.btn_intput){
            if(et_number1.getText().toString().isEmpty() && et_number2.getText()
                    .toString().isEmpty()){
                number_1 = 10;
                number_2 = 20;
            }
            else{
                number_1 = Integer.parseInt(et_number1.getText().toString());
                number_2 = Integer.parseInt(et_number2.getText().toString());
            }
        }
        else{
            Random rd = new Random();
            number_1 = rd.nextInt(100);
            number_2 = rd.nextInt(100);
        }
        address = makeAddress(number_1, number_2);
        Uri uri = Uri.parse(address);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private String makeAddress(int number1, int number_2) {

        String addressNumber_1;
        String addressNumber_2;
        String baseAddress = "sum://example.com/add";

        addressNumber_1 = String.format("number_1=%d", number1);
        addressNumber_2 = String.format("number_2=%d", number_2);
        String address = String.format("%s?%s&%s", baseAddress, addressNumber_1, addressNumber_2);
        return address;
    }
}
