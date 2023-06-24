package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.example.btl_thibanglaixe.DAO.NguoiDungDao;

public class DangKyActivity extends androidx.appcompat.app.AppCompatActivity{

    private EditText edtHoTen, edtTenDangNhap, edtMatKhau, edtNhapLaiMatKhau, edtEmail;
    private Button btnDangKy, btnDangNhap;
    NguoiDungDao nguoiDungDao;

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.btl_thibanglaixe.R.layout.activity_dangky);

        edtHoTen = findViewById(com.example.btl_thibanglaixe.R.id.edtHoTen);
        edtTenDangNhap = findViewById(com.example.btl_thibanglaixe.R.id.edtTenDangNhap);
        edtMatKhau = findViewById(com.example.btl_thibanglaixe.R.id.edtMatKhau);
        edtNhapLaiMatKhau = findViewById(com.example.btl_thibanglaixe.R.id.edtNhapLaiMatKhau);
        edtEmail = findViewById(com.example.btl_thibanglaixe.R.id.edtEmail);
        btnDangKy = findViewById(com.example.btl_thibanglaixe.R.id.btnDangKy);
        btnDangNhap = findViewById(com.example.btl_thibanglaixe.R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(intent);
            }
        });

        btnDangKy.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String hoTen = edtHoTen.getText().toString();
                String tenDangNhap = edtTenDangNhap.getText().toString();
                String matKhau = edtMatKhau.getText().toString();
                String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString();
                String email = edtEmail.getText().toString();
                if(hoTen.equals("") || tenDangNhap.equals("") || matKhau.equals("") || nhapLaiMatKhau.equals("") || email.equals("")) {
                    android.widget.Toast.makeText(DangKyActivity.this, "Vui lòng nhập đầy đủ thông tin", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!matKhau.equals(nhapLaiMatKhau)) {
                    android.widget.Toast.makeText(DangKyActivity.this, "Mật khẩu không khớp", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                nguoiDungDao = new NguoiDungDao(DangKyActivity.this);
                boolean check = nguoiDungDao.userExist(tenDangNhap);
                if(!check) {
                    nguoiDungDao.addUser(tenDangNhap, matKhau, email, hoTen);
                    android.widget.Toast.makeText(DangKyActivity.this, "Đăng ký thành công", android.widget.Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                    startActivity(intent);
                }
                else {
                    android.widget.Toast.makeText(DangKyActivity.this, "Người dùng đã tồn tại", android.widget.Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
