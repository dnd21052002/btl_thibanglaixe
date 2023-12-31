package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.DAO.NguoiDungDao;

public class QuenMatKhauActivity extends AppCompatActivity {

    EditText edtEmail;
    Button btnGuiMa;
    NguoiDungDao nguoiDungDao;

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.btl_thibanglaixe.R.layout.activity_quenmatkhau);

        edtEmail = findViewById(com.example.btl_thibanglaixe.R.id.edtEmail);
        btnGuiMa = findViewById(com.example.btl_thibanglaixe.R.id.btnGuiMa);
        nguoiDungDao = new NguoiDungDao(this);

        btnGuiMa.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String email = edtEmail.getText().toString();
                if(email.equals("")) {
                    android.widget.Toast.makeText(QuenMatKhauActivity.this, "Vui lòng nhập email", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean check = nguoiDungDao.userExist(email);
                if(check) {
                    android.widget.Toast.makeText(QuenMatKhauActivity.this, "Mã xác nhận đã được gửi đến email của bạn", android.widget.Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuenMatKhauActivity.this, DatLaiMatKhauActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
                else {
                    android.widget.Toast.makeText(QuenMatKhauActivity.this, "Tài khoản không tồn tại", android.widget.Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
