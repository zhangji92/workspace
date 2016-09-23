package gaosheng.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import it.sauronsoftware.base64.Base64;

/**
 * Created by zhaofuqiang on 2016/8/16.
 * 本类提供SharedPreferences类对数据数据的增加 删除 修改 查看方法
 */
public class ShareUtils {

    //声明sharedPreferences对象
    private static SharedPreferences sharedPreferences = null;

    /**
     * 获取ShareUtils对象（单例）
     *
     * @return ShareUtils对象
     */
    private static SharedPreferences getInstance(Context context) {
        //获取唯一的SharedPreferences对象
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("develop0816", 0);

        }
        return sharedPreferences;
    }


    /**
     * 增加int型数据方法
     *
     * @param context
     * @param value   需要添加的int数据
     */
    public void put(Context context, String key, int value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        if (editor != null) {
            editor.putInt(key, value);
            editor.commit();
        }

    }

    /**
     * 增加boolean型数据方法
     *
     * @param context
     * @param flag    需要添加的int数据
     */
    public void put(Context context, String key, boolean flag) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        if (editor != null) {
            editor.putBoolean(key, flag);
            editor.commit();
        }


    }

    /**
     * 增加String类型
     *
     * @param context
     * @param key
     * @param value
     */
    public void put(Context context, String key, String value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        if (editor != null) {
            editor.putString(key, value);
            editor.commit();
        }


    }

    /**
     * 增加float类型
     *
     * @param context
     * @param key
     * @param value
     */
    public void put(Context context, String key, float value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        if (editor != null) {
            editor.putFloat(key, value);
            editor.commit();

        }

    }

    /**
     * 增加long类型
     *
     * @param context
     * @param key
     * @param value
     */
    public void put(Context context, String key, long value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        if (editor != null) {
            editor.putLong(key, value);
            editor.commit();

        }

    }

    /**
     * 增加对象
     *
     * @param context
     * @param value
     * @param key
     * @return
     */
    public void put(Context context, String key, Object value) {
        //获取SharedPreferences.Editor对象
        SharedPreferences.Editor editor = getInstance(context).edit();
        ObjectOutputStream oos = null;
        //字节数组流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            oos = new ObjectOutputStream(bos);
            //写入内存字节数组
            oos.writeObject(value);
            byte[] bytes = bos.toByteArray();
            //转成String字符创
            String objstr = new String(Base64.encode(bytes));//编码
            Log.e("1111111111111111111111", objstr);
            editor.putString(key, objstr);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 删除数据
     *
     * @param context
     * @param key     要删除数据的key值
     */
    public void remove(Context context, String key) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        if (editor != null) {
            editor.remove(key);
            editor.commit();
        }

    }

    /**
     * 查看Int型数据
     *
     * @param context
     * @param key     指定键
     * @param value   如果没有对应值，则显示默认值
     */
    public int getData(Context context, String key, int value) {
        return getInstance(context).getInt(key, value);

    }

    /**
     * 查看boolean型数据
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public boolean getData(Context context, String key, boolean value) {
        return getInstance(context).getBoolean(key, value);

    }

    /**
     * 查看String类型
     * @param context
     * @param key
     * @param value
     * @return
     */
    public String getData(Context context, String key, String value) {
        return getInstance(context).getString(key, value);

    }

    /**
     * 查看long类型
     * @param context
     * @param key
     * @param value
     * @return
     */
    public long getData(Context context, String key, long value) {
        return getInstance(context).getLong(key, value);

    }

    /**
     * 查看float类型
     * @param context
     * @param key
     * @param value
     * @return
     */
    public float getData(Context context, String key, float value) {
        return getInstance(context).getFloat(key,value);

    }
    /**
     * 查看对象
     *
     * @param context
     * @param key
     * @return
     */
    public Object getObject(Context context, String key) {
        //根据可以值读取对应字符串
        String objstr = getInstance(context).getString(key, null);
        ObjectInputStream ois = null;
        Object obj = null;
        //如果读取到内容执行
        if (objstr != null && objstr != "") {
            //将读取到的字符串转成byte数组
            byte[] bytes = Base64.decode(objstr.getBytes());
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                ois = new ObjectInputStream(bis);
                //读取对象
                obj = ois.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return obj;
    }


}
