package com.yianEr.noteme;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import java.io.WriteAbortedException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;


//QR Generator Library and Saves the QR Code as Image

public class qrApp extends AppCompatActivity {

    EditText qrValue;
    Button generateBtn;
    ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_app);

        qrValue = findViewById(R.id.editText);
        generateBtn = findViewById(R.id.generateBtn);
        qrImage = findViewById(R.id.qr_image);


        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = qrValue.getText().toString();
                QRGEncoder qrgEncoder = new QRGEncoder(data,null, QRGContents.Type.TEXT, 300);
                try{
                    Bitmap qrBits = qrgEncoder.encodeAsBitmap();
                    qrImage.setImageBitmap(qrBits);
                }catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
