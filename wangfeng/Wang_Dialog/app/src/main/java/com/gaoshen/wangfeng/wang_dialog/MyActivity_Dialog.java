package com.gaoshen.wangfeng.wang_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyActivity_Dialog extends AppCompatActivity {

    String item_wf[] = {"足球", "蓝球", "羽毛球", "台球"};
    List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity__dialog);
    }

    /**
     * 确认对话框
     *
     * @param view 被点击的控件
     */
    public void t1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity_Dialog.this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.drawable.xiaoyang);
        builder.setMessage("此处为确认框内容");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（确定）]" + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（取消）]" + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（忽略）]" + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    /**
     * 简单列表对话框
     *
     * @param view
     */
    public void t2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity_Dialog.this);
        builder.setTitle("简单列表对话框");
        builder.setIcon(R.drawable.xiaoyang);
        builder.setItems(item_wf, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了]" + item_wf[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    /**
     * 单选列表对话框
     *
     * @param view
     */
    public void t3_1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity_Dialog.this);
        builder.setTitle("单选列表对话框");
        builder.setIcon(R.drawable.xiaoyang);
        builder.setSingleChoiceItems(item_wf, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了]" + item_wf[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（确定）]" + "", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（取消）]" + "", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    /**
     * 使用 strings 资源文件 获取数据源
     *
     * @param view
     */
    public void t3_2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity_Dialog.this);
        builder.setTitle("单选列表对话框");
        builder.setIcon(R.drawable.xiaoyang);
        builder.setSingleChoiceItems(R.array.arr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //获取strings 中的指定数据
                String[] str = getResources().getStringArray(R.array.arr);

                Toast.makeText(MyActivity_Dialog.this, "[您点击了]" + str[which], Toast.LENGTH_SHORT).show();
            }
        });


        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（确定）]" + "", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（取消）]" + "", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }


    /**
     * 多选列表对话框
     *
     * @param view
     */
    public void t4_1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity_Dialog.this);
        builder.setTitle("多选列表对话框");
        builder.setIcon(R.drawable.xiaoyang);
        // 第二个参数 可选 new boolean[]{true, false, false, false}(表示选中状态) 或 null
        builder.setMultiChoiceItems(item_wf, new boolean[]{true, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MyActivity_Dialog.this, "[您点击了]" + item_wf[which], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyActivity_Dialog.this, "[您取消了]" + item_wf[which], Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MyActivity_Dialog.this, "[您点击了（确定）]" + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（取消）]" + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    /**
     * 多选列表对话框
     *
     * @param view
     */
    public void t4_2(View view) {
        list = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity_Dialog.this);
        builder.setTitle("多选列表对话框");
        builder.setIcon(R.drawable.xiaoyang);
        // 第二个参数 可选 new boolean[]{true, false, false, false}(表示选中状态) 或 null
        builder.setMultiChoiceItems(item_wf, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if (isChecked) {
                    list.add(which);
                } else {
                    list.remove(Integer.valueOf(which));
                }

            }
        });
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                for (int j = 0; j < list.size(); j++) {
                    Log.e("MyActivity_Dialog.this", "--你选中了第--" + list.get(j) + "--项----");
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（取消）]" + "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    EditText name;
    EditText pass;

    /**
     * 自定义对话框
     *
     * @param view
     */
    public void zidingyi(View view) {
        //获取自定义布局
        final View view1 = getLayoutInflater().inflate(R.layout.activity_main_activity_zidingyi, (ViewGroup) findViewById(R.id.fu_liner));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        //给对话框添加一个自定义布局
        builder.setView(view1);

        name = (EditText) view1.findViewById(R.id.edi_yh);
        pass = (EditText) view1.findViewById(R.id.edi_ma);

        Button dl = (Button) view1.findViewById(R.id.but_dl);
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strname = name.getText().toString().trim().replace(" ", "");
                String strpass = pass.getText().toString().trim().replace(" ", "");
                if ("傻强".equals(strname) && "666".equals(strpass) || "鸡哥".equals(strname) && "jige666".equals(strpass)) {
                    Log.e("MyActivity_Dialog.this", "登陆成功");
                    Toast.makeText(MyActivity_Dialog.this, "登陆成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyActivity_Dialog.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            EditText name = (EditText) view1.findViewById(R.id.edi_yh);
            EditText pass = (EditText) view1.findViewById(R.id.edi_ma);

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "鸡哥是傻逼", Toast.LENGTH_SHORT).show();
            }

        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyActivity_Dialog.this, "[您点击了（取消）]" + "", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }
}
