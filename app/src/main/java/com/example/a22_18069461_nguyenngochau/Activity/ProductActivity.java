package com.example.a22_18069461_nguyenngochau.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a22_18069461_nguyenngochau.Adapter.ProductAdapter;
import com.example.a22_18069461_nguyenngochau.Modal.Product;
import com.example.a22_18069461_nguyenngochau.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private ArrayList<Product> listProduct ;
    private RecyclerView recyclerView;
    private ProductAdapter mAdapter ;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listProduct = new ArrayList<>();
        createList();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

    }

    private void createList() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://60cd8f2d91cc8e00178db9fa.mockapi.io/product/product";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject object = new JSONObject(response);

                            if(object.getInt("resultCode") == 0 ){
                                JSONArray array = new JSONArray(object.getString("data"));
                                Log.d("TAG",array+"");
                                for(int i=0;i<array.length();i++){
                                    JSONObject jsonObject = array.getJSONObject(i);

                                    String id = jsonObject.getString("id");
                                    String type = jsonObject.getString("type");
                                    String price = jsonObject.getString("price");
                                    String content = jsonObject.getString("content");
                                    String quantity = jsonObject.getString("quantity");
                                    listProduct.add(new Product(id,type, "$ "+price,content,quantity));
                                }
                                mAdapter = new ProductAdapter(ProductActivity.this,listProduct);
                                recyclerView.setAdapter(mAdapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(ProductActivity.this));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}