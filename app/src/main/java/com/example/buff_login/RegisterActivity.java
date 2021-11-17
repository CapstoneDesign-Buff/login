package com.example.buff_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {


    private EditText et_id, et_pass, et_phone;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 시작시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_phone = findViewById(R.id.et_phone);

        //회원가입 버튼 클릭 시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //에디트 텍스트에 현재 입력된 값을 가져온다.
                String user_id=et_id.getText().toString();
                String prv_password=et_pass.getText().toString();
                String prv_phonenumber=et_phone.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //회원가입에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원 가입이 완료되었습니다!",Toast.LENGTH_SHORT).show();
                                Intent intent  = new Intent(RegisterActivity.this, Login_activity.class);
                                startActivity(intent);
                            } else { //회원등록 실패
                                Toast.makeText(getApplicationContext(),"회원 가입이 실패되었습니다!",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 Volley를 이용해서 요청 함
                RegisterRequest registerRequest = new RegisterRequest(user_id, prv_password, prv_phonenumber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}