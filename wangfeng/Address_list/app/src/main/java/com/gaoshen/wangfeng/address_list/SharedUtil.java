package com.gaoshen.wangfeng.address_list; /**
 * Created by Administrator on 2016/8/16.
 */

import android.content.Context;
import android.content.SharedPreferences;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import it.sauronsoftware.base64.Base64;

/**
 * 利用单例模式封装SharedPreferences.
 * <p/>
 * SharedUtil类对外提供      保存 字符串、boolean、int 、long、对象等方法。
 * 读取 字符串、boolean、int 、long、对象等方法。
 * 删除 字符串、boolean、int 、long、对象等方法。
 */
public class SharedUtil {


    static SharedPreferences shared = null;

    private SharedUtil() {

    }

    private static SharedPreferences getIn(Context context) {
        if (shared == null) {
            shared = context.getSharedPreferences("textPre", Context.MODE_APPEND);
        }
        return shared;
    }

    //储存
    public static void storeString(Context context, String var1, String var2) {
        SharedPreferences.Editor edit = getIn(context).edit();
        edit.putString(var1, var2);
        edit.commit();

    }

    public static void storeInt(Context context, String var1, int var2) {
        SharedPreferences.Editor edit = getIn(context).edit();
        edit.putInt(var1, var2);
        edit.commit();
    }

    public static void storeLong(Context context, String var1, long var2) {
        SharedPreferences.Editor edit = getIn(context).edit();
        edit.putLong(var1, var2);
        edit.commit();
    }

    public static void storeBoolean(Context context, String var1, boolean var2) {
        SharedPreferences.Editor edit = getIn(context).edit();
        edit.putBoolean(var1, var2);
        edit.commit();
    }

    public static void remove(Context context, String var1) {
        SharedPreferences.Editor edit = getIn(context).edit();
        edit.remove(var1);
        edit.commit();
    }

    //储存对象
    public static void xieduixiang(Context context, String key, Serializable objVal) {
        SharedPreferences.Editor sp = getIn(context).edit();
        if (sp != null) {
            ObjectOutputStream oo = null;
            ByteArrayOutputStream by = new ByteArrayOutputStream();
            try {
                oo = new ObjectOutputStream(by);
                oo.writeObject(objVal);

                byte[] bt = by.toByteArray();
                String string = new String(Base64.encode(bt));//使用Base64编码
                sp.putString(key, string);
                sp.commit();

                oo.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (oo != null) {
                    try {
                        oo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static Object duduixiang(Context context, String key,Serializable objVal) {
        Object je = null;
        //获取值
        String str = getIn(context).getString(key, null);

        if (str != null && !str.equals("")) {
            //将String 转化成byte数组
            byte[] bytes = Base64.decode(str.getBytes());//使用Base64解码

            ObjectInputStream oi = null;
            //将读取的ByteArrayInputStream 流添到ObjectInputStream(bi);中
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            try {
                oi = new ObjectInputStream(bi);
                je = oi.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (oi != null) {
                    try {
                        oi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return je;
        }
        return null;
    }


    //读取
    public static String getString(Context context, String var1, String var2) {
        SharedPreferences sh = getIn(context);
        if (sh != null) {

            return sh.getString(var1, var2);
        }
        return var2;
    }

    public static int getInt(Context context, String var1, int var2) {
        SharedPreferences sh = getIn(context);
        if (sh != null) {

            return sh.getInt(var1, var2);
        }
        return var2;
    }

    public static long getLong(Context context, String var1, long var2) {
        SharedPreferences sh = getIn(context);
        if (sh != null) {
            return sh.getLong(var1, var2);
        }
        return var2;
    }

    public static boolean getBoolean(Context context, String var1, boolean var2) {
        SharedPreferences sh = getIn(context);
        if (sh != null) {
            return sh.getBoolean(var1, var2);
        }
        return var2;
    }
}
