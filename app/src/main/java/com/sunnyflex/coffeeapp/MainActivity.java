package com.sunnyflex.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    Button minusBtn;
    TextView quantityView;
    Button plusBtn;

    RadioGroup coffeeMenu;
    
    
    TextView resultView;
    Button orderBtn;
    
    int quantityCount = 0;
    int price = 1500;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        quantityView = findViewById(R.id.quantity_view);
        resultView = findViewById(R.id.result_view);
        minusBtn = findViewById(R.id.minus_btn);
        plusBtn = findViewById(R.id.plus_btn);
        orderBtn = findViewById(R.id.order_btn);
        
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusBtnClick(view);
              
            }
        });
        
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusBtnClick(view);
                
            }
        });
        
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderBtnClick(view);
            }
        });

        
    }

    private void orderBtnClick(View view) {
        price = price * quantityCount;
        resultView.setText(String.valueOf(price) + "원");
        quantityCount = 0;
    }

    private void plusBtnClick(View view) {
        quantityCount = quantityCount + 1;
        quantityView.setText(String.valueOf(quantityCount));
    }

    private void minusBtnClick(View view) {

        if (quantityCount > 0){
            quantityCount = quantityCount - 1;
            quantityView.setText(String.valueOf(quantityCount));
        }else{
            Toast.makeText(getApplicationContext(), "갯수가 0 개입니다.", Toast.LENGTH_SHORT).show();
        }
    }
}