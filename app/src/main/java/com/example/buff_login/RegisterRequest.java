package com.example.buff_login;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL;

    static {
        URL = "http://s00.dothome.co.kr/Register.php";
    }
    private Map<String,String> map;

    public RegisterRequest(String user_id, String prv_password, String prv_phonenumber, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);

        map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("prv_password",prv_password);
        map.put("prv_phonenumber",prv_phonenumber);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
