package com.example.a22_18069461_nguyenngochau.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a22_18069461_nguyenngochau.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateProductActivity extends AppCompatActivity {
    Button btnAdd,btnExitAdd;
    ImageButton btnTru,btnCong;
    TextView tvSL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        anhxa();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    addProduct();


            }
        });


    }
    private void addProduct(){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url ="https://60cd8f2d91cc8e00178db9fa.mockapi.io/product/product";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject =new JSONObject(response);
                            if(jsonObject.getInt("resultCode") == 0){
                                Toast.makeText(CreateProductActivity.this,"Thêm sản phẩm thành công!",Toast.LENGTH_LONG).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Nullable
            @org.jetbrains.annotations.Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("type","Donut Pink");
                params.put("price","10.00");
                params.put("content","Spicy tasty donut family");
                params.put("quantity","1");


                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void anhxa() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTru = findViewById(R.id.btnTru);
        btnCong = findViewById(R.id.btnCong);
        tvSL = findViewById(R.id.tvSl);

    }
}