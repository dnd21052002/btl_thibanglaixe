package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.DAO.NguoiDungDao;
import com.example.btl_thibanglaixe.R;

import java.util.List;

public class DangNhapActivity extends AppCompatActivity{

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private Button mButtonRegister;

    private Button btnQuenMatKhau;
    NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        mEditTextUsername = findViewById(R.id.usernameEditText);
        mEditTextPassword = findViewById(R.id.passwordEditText);
        mButtonLogin = findViewById(R.id.loginButton);
        mButtonRegister = findViewById(R.id.registerButton);
        btnQuenMatKhau = findViewById(R.id.forgotPasswordButton);
        nguoiDungDao = new NguoiDungDao(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEditTextUsername.getText().toString();
                String password = mEditTextPassword.getText().toString();
                String name = nguoiDungDao.getName(username);
//                kiểm tra username và password đã được nhập chưa, nếu chưa thì yêu cầu
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(DangNhapActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean check = nguoiDungDao.checkLogin(username, password);
                if(check) {
                    Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(DangNhapActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });

        btnQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, QuenMatKhauActivity.class);
                startActivity(intent);
            }
        });
    }

}