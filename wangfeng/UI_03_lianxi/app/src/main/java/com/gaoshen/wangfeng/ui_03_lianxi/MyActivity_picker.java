package com.gaoshen.wangfeng.ui_03_lianxi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyActivity_picker extends AppCompatActivity {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private  Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_picker);

        //初始化控件
        datePicker = (DatePicker) findViewById(R.id.datep);
        timePicker = (TimePicker) findViewById(R.id.timep);

        //获取日历的一个对象
         cal = Calendar.getInstance();
        //获取日历 对应的 年 月 日 时 分 秒
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR);
        minute = cal.get(Calendar.MINUTE);

        //设置日期默认时间  OnDateChangedListener() 监听日期变化
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                CharSequence chr = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
                Toast.makeText(MyActivity_picker.this, chr, Toast.LENGTH_SHORT).show();
                //显示日期到标头
                setTitle(chr);
            }
        });


        //设置时间为24小时制  setOnTimeChangedListener监听事件变化
        timePicker.is24HourView();
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                CharSequence sequence = hourOfDay + ":" + minute;
                Toast.makeText(MyActivity_picker.this, sequence, Toast.LENGTH_SHORT).show();
                setTitle(sequence);
            }
        });


        /**this 上下文
         * new DatePickerDialog.OnDateSetListener()  事件监听器 回馈最终选择的结果
         */
        //以对话框的形式展示日历
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
            //相当于datePicker 的init 做一个初始化的操作  年 月 日  最后用show 显示
        }, year, cal.get(Calendar.MONTH), day).show();


        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay + ":" + minute);
            }
        }, hour, minute, true).show();

    }


}
