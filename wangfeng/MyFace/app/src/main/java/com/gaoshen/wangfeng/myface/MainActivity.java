package com.gaoshen.wangfeng.myface;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



        private static final int PICK_CODE = 0X120;
        private ImageView mPhoto;//Image View
        private Button mGetImage;//getImage Button
        private Button mDetect;// Detect Button
        private TextView mTip; //TextView
        private View mWaitting; //FrameLayout 进度条

        private  String mCurrentPhotoStr;//当前图片的一个路径

        private Bitmap mPhotoImg;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initViews();
            initEvents();
        }

        /**
         * 设置监听事件
         */
    private void initEvents(){
        mGetImage.setOnClickListener(this);
        mDetect.setOnClickListener(this);
    }

    /**
     * 初始化View
     */
    private void initViews() {
        mPhoto= (ImageView) findViewById(R.id.img);
        mGetImage= (Button) findViewById(R.id.getImage);
        mDetect= (Button) findViewById(R.id.detect);
        mTip= (TextView) findViewById(R.id.tip);
        mWaitting=findViewById(R.id.id_waitting);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.getImage:
                //获取图片操作
                Intent intent=new Intent(Intent.ACTION_PICK);
                //选择图片类型
                intent.setType("image/*");
                startActivityForResult(intent,PICK_CODE);
                break;
            case R.id.detect:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==PICK_CODE){
            if(data!=null){
                Uri uri=data.getData();
                Cursor cursor=getContentResolver().query(uri,null,null,null,null,null);
                cursor.moveToFirst();
                int idx=cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                mCurrentPhotoStr=cursor.getString(idx);
                cursor.close();

                //压缩照片
                resizePhoto();
                mPhoto.setImageBitmap(mPhotoImg);
                mTip.setText("Click Detect ==>");

            }

        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 图片压缩
     * //每张图片不能超过3M
     */
    private void resizePhoto() {


        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;

        BitmapFactory.decodeFile(mCurrentPhotoStr,options);

        double ratio=Math.max(options.outWidth * 1.0d /1024f,options.outHeight * 1.0d/1024f);

        options.inSampleSize= (int) Math.ceil(ratio);

        options.inJustDecodeBounds=false;
        mPhotoImg=BitmapFactory.decodeFile(mCurrentPhotoStr,options);


    }
    }
}
