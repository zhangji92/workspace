package com.gaoshen.wangfeng.fragmentmode.fragment_4.Mode_4;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/6.
 */
public class DengluMode implements Serializable{


    /**
     * code : 10000
     * message : 成功
     * resultCode : {"Id":"91","mobile":"17073353257","nickname":"GAME0091","imgUrl":"/data/upfiles/00001.png","gender":"","age":"","address":"","token":"ZDlhYzBlZGVlMTc5NDU3OGNmNjg4Nzg0ODJlNWZkMGI=","ry_token":"","attention_count":"0","fans_count":"0"}
     */

    private String code;
    private String message;
    /**
     * Id : 91
     * mobile : 17073353257
     * nickname : GAME0091
     * imgUrl : /data/upfiles/00001.png
     * gender :
     * age :
     * address :
     * token : ZDlhYzBlZGVlMTc5NDU3OGNmNjg4Nzg0ODJlNWZkMGI=
     * ry_token :
     * attention_count : 0
     * fans_count : 0
     */

    private ResultCodeBean resultCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultCodeBean getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodeBean resultCode) {
        this.resultCode = resultCode;
    }


}
