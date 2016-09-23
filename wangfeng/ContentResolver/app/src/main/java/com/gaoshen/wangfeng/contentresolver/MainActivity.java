package com.gaoshen.wangfeng.contentresolver;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> gridViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int maxMemory = (int) Runtime.getRuntime().maxMemory();

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return gridViewList.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                ImageView im = new ImageView(MainActivity.this);
//                im.setScaleType(ImageView.ScaleType.FIT_XY);
//                ViewGroup.LayoutParams par=new ViewGroup.LayoutParams(120,120);
//                im.setLayoutParams(par);

                BitmapFactory.Options option = new BitmapFactory.Options();
                option.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(String.valueOf(gridViewList.get(i)), option);


                float radio = Math.max(option.outWidth * 1.0f / 1024, option.outHeight * 1.0f / 1024);
                option.inSampleSize = (int) Math.ceil(radio);
                Log.e("****---option.outWidth",option.outWidth+"" );
                Log.e("****---option.outHeight",option.outHeight+"" );
//                option.inSampleSize = 2;
                option.inJustDecodeBounds = false;
                Bitmap bm = BitmapFactory.decodeFile(String.valueOf(gridViewList.get(i)), option);
                im.setImageBitmap(bm);

                return im;
            }
        });


        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        cursor.moveToFirst();
        String uri = "";
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            uri = cursor.getString(idx);
            Log.e("uri", uri);
//            BitmapFactory.Options option=new BitmapFactory.Options();
//            option.inJustDecodeBounds=true;
//            Bitmap bm=BitmapFactory.decodeFile(uri, option);
//            float radio=Math.max(option.outWidth *1.0f/8024,option.outHeight *1.0f/8024);
//            option.inSampleSize= (int) Math.ceil(radio);
//            option.inJustDecodeBounds=false;
//            Bitmap bm2=BitmapFactory.decodeFile(uri, option);
            gridViewList.add(uri);
        }

        cursor.close();

    }


//    public void ss(){
//        try
//        {
//            InputStream in = getContentResolver().openInputStream(uri);
//            Bitmap bitmap = BitmapFactory.decodeStream(in);
//            try
//            {
//                in.close();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//            if(null  == bitmap)
//            {
////                Toast.makeText(this, "Head is not set successful,Decode bitmap failure", 2000);
//            }
//            //原始图片的尺寸
//            int bmpWidth  = bitmap.getWidth();
//            int bmpHeight = bitmap.getHeight();
//
//            //缩放图片的尺寸
//            float scaleWidth  = (float) 40 / bmpWidth;
//            float scaleHeight = (float) 40 / bmpHeight;
//            Matrix matrix = new Matrix();
//            matrix.postScale(scaleWidth, scaleHeight);
//
//            //产生缩放后的Bitmap对象
//            Bitmap resizeBitmap = Bitmap.createBitmap(
//                    bitmap, 0, 0, bmpWidth, bmpHeight, matrix, false);
//            bitmap.recycle();
//            //Bitmap to byte[]
//            byte[] photoData = Bitmap2Bytes(resizeBitmap);
//
//            //save file
//            String fileName = "/sdcard/test.jpg";
//            FileUtil.writeToFile(fileName, photoData);
//
//            //save photo check sum to db
//            DataCenter.GetInstance().ModifyIMMUser();
//            //refresh ImageView
//        }
//        catch (FileNotFoundException exp)
//        {
//            exp.printStackTrace();
//        }
//    }
}
