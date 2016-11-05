package com.example.administrator.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.charctor);
        tv2 = (TextView) findViewById(R.id.uidate);
        tv3 = (TextView) findViewById(R.id.uitime);
    }
    public void characterpicterdialog(View view){
        String options = "1234567890.+-*/";
        CharacterPickerDialog characterPickerDialog = new CharacterPickerDialog(this,
                new View(this),null,options,false){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                tv3.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        characterPickerDialog.show();
    }
    public void datepickerdialog(View view){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tv1.setText("日期：" + year + "-" + (+monthOfYear+1) + "-" + dayOfMonth);
            }
        },2016,10,6);
        datePickerDialog.show();
    }
    public void timepickerdialog(View view){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv2.setText(hourOfDay+":"+minute);
            }
        },00,00,true);
        timePickerDialog.show();
    }
    public void progressdialog(View view){
        final ProgressDialog progressDialog = ProgressDialog.show(this,"加载","加载中，请稍候....",
                true);
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    progressDialog.dismiss();
                }
            }
        }.start();
    }

}
