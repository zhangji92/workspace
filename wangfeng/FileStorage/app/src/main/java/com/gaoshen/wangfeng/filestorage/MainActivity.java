package com.gaoshen.wangfeng.filestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = "asdfdaaa";

        BufferedWriter bw = null;
        try {
            FileOutputStream fo = openFileOutput("aaa.txt", MODE_PRIVATE);
            bw = new BufferedWriter(new OutputStreamWriter(fo));
            bw.write(str);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();//关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        BufferedReader br = null;
        try {
            FileInputStream fi = openFileInput("aaa.txt");
            br = new BufferedReader(new InputStreamReader(fi));
            String strX = br.readLine();
            Toast.makeText(MainActivity.this, strX, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
