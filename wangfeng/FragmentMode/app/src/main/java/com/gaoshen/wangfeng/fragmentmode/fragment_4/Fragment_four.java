package com.gaoshen.wangfeng.fragmentmode.fragment_4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaoshen.wangfeng.fragmentmode.BaseFragment;
import com.gaoshen.wangfeng.fragmentmode.R;
import com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4.ResultCodeBean;

import net.tsz.afinal.FinalDb;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Fragment_four extends BaseFragment implements View.OnClickListener {

    private TextView delzc;
    private ResultCodeBean res;
    private ResultCodeBean listcode;
    private TextView guanz;
    private TextView fensi;
    private TextView gang;
    private Handler mhangdle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 912:
                    listcode = (ResultCodeBean) msg.obj;
                    FinalDb db = FinalDb.create(getActivity());
                    res = db.findById(listcode.getId(), ResultCodeBean.class);
                    delzc.setText(res.getNickname());

            }

        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.framment_4, container, false);
        ((MyApplication) getActivity().getApplication()).setAhandler(mhangdle);
        delzc = (TextView) view.findViewById(R.id.dlzc);
        guanz = (TextView) view.findViewById(R.id.guanz);
        fensi = (TextView) view.findViewById(R.id.fensi);
        gang = (TextView) view.findViewById(R.id.gang);

        delzc.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String str = delzc.getText().toString();
        switch (view.getId()) {
            case R.id.dlzc:
                if (str.equals("登录/注册")) {
                    Intent intent = new Intent(getActivity(), Login.class);
                    startActivityForResult(intent, 2);
                } else {
                    Intent intent = new Intent(getActivity(), User.class);
                    startActivityForResult(intent, 1);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == 11) {
                    Bundle bundle = data.getExtras();
                    String str = bundle.getString("str");
                    delzc.setText(str);
                    guanz.setText("");
                    fensi.setText("");
                    gang.setText("");
                }
                break;
            case 2:
                if (resultCode == 55) {
                    guanz.setText("关注 : 0");
                    gang.setText(" | ");
                    fensi.setText("粉丝 : 0");
                }
                break;
        }
    }
}
