package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.DAO.NguoiDungDao;

public class DatLaiMatKhauActivity extends AppCompatActivity {

        EditText edtMatKhau, edtNhapLaiMatKhau, edtMaXacNhan;
        Button btnDatLai;

        NguoiDungDao nguoiDungDao;

        protected void onCreate(android.os.Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(com.example.btl_thibanglaixe.R.layout.activity_datlaimatkhau);

            edtMatKhau = findViewById(com.example.btl_thibanglaixe.R.id.edtMatKhau);
            edtNhapLaiMatKhau = findViewById(com.example.btl_thibanglaixe.R.id.edtNhapLaiMatKhau);
            edtMaXacNhan = findViewById(com.example.btl_thibanglaixe.R.id.edtMaXacNhan);
            btnDatLai = findViewById(com.example.btl_thibanglaixe.R.id.btnDatLai);
            nguoiDungDao = new NguoiDungDao(this);
            String maXacNhanMail = "colammoicoan";

            btnDatLai.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(android.view.View v) {
                     String matKhau = edtMatKhau.getText().toString();
                     String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString();
                     String maXacNhan = edtMaXacNhan.getText().toString();
                     String email = getIntent().getStringExtra("email");
                     if (matKhau.equals("") || nhapLaiMatKhau.equals("") || maXacNhan.equals("")) {
                         android.widget.Toast.makeText(DatLaiMatKhauActivity.this, "Vui lòng nhập đầy đủ thông tin", android.widget.Toast.LENGTH_SHORT).show();
                         return;
                     }
                     if (!matKhau.equals(nhapLaiMatKhau)) {
                         android.widget.Toast.makeText(DatLaiMatKhauActivity.this, "Mật khẩu không khớp", android.widget.Toast.LENGTH_SHORT).show();
                         return;
                     }
                     if (!maXacNhan.equals(maXacNhanMail)) {
                         android.widget.Toast.makeText(DatLaiMatKhauActivity.this, "Mã xác nhận không đúng", android.widget.Toast.LENGTH_SHORT).show();
                         return;
                     }
                     if(maXacNhan.equals(maXacNhanMail) && matKhau.equals(nhapLaiMatKhau)) {
                         nguoiDungDao.updatePassword(email, matKhau);
                         android.widget.Toast.makeText(DatLaiMatKhauActivity.this, "Đặt lại mật khẩu thành công", android.widget.Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(DatLaiMatKhauActivity.this, DangNhapActivity.class);
                         startActivity(intent);
                     }

                 }
            });
        }
}
