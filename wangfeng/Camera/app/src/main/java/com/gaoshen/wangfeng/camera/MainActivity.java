package com.gaoshen.wangfeng.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView mimageView;
    private String mFilePath;//记录文件的一个位置
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mimageView= (ImageView) findViewById(R.id.iv);
        //获得 SD的一个路径
        mFilePath= Environment.getExternalStorageDirectory().getPath();
        //路径加文件名
        mFilePath=mFilePath+"/"+"temp.png";
    }

    //点击后获得返回的图片是一个缩略图
    public void StartCamera1(View view){
        switch (view.getId()){
             
        }
        //启动一个相机应用
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    //点击后获得 返回的图片是原图
    public void StartCamera2(View view){
        //启动一个相机应用
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //创建一个Uri  讲一个File路径指定进来
        Uri phototUri=Uri.fromFile(new File(mFilePath));
        //通过 MediaStore.EXTRA_OUTPUT 我们可以对系统拍照完成后 所存储的路径进行更改
        //将路径更改为 phototUri路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT,phototUri);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==1){
                //获得返回的数据   data返回的图片是一个缩略图
                Bundle bundle=data.getExtras();
                Bitmap bitmap= (Bitmap) bundle.get("data");
                //将获取的数据显示到ImageView中
                mimageView.setImageBitmap(bitmap);
            }else if(requestCode==2){

                FileInputStream fis=null;
                try {
                    //将保存文件的路径指定进来
                    fis=new FileInputStream(mFilePath);
                    //通过 BitmapFactory.decodeStream(fis) 将一个流解析成一个Bitmap
                    Bitmap bitmap= BitmapFactory.decodeStream(fis);
                    mimageView.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    if(fis!=null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
