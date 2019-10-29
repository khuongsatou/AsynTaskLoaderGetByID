package com.nvk.muiltiscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    public static final String KEY_LINHVUC = "123";
    private List<LinhVuc> linhVucs;
    private Button btnLinhVuc1,btnLinhVuc2,btnLinhVuc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiation();
        khoiTaoLoader();
        setData();
        setEvent();
    }

    private void setEvent() {
        btnLinhVuc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCauHoi(1);
            }
        });
        btnLinhVuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCauHoi(2);
            }
        });
        btnLinhVuc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCauHoi(3);
            }
        });

    }

    private void startCauHoi(int id){
        Intent intent = new Intent(getApplicationContext(),CauHoiActivity.class);
        intent.putExtra(KEY_LINHVUC,id);
        startActivity(intent);
    }


    private void khoiTaoLoader() {
        if (getSupportLoaderManager().getLoader(0) != null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
        getSupportLoaderManager().restartLoader(0,null,this);

    }

    private void setData() {
        linhVucs = new ArrayList<>();
    }

    private void radiation() {
        btnLinhVuc1 = findViewById(R.id.btnLinhVuc1);
        btnLinhVuc2 = findViewById(R.id.btnLinhVuc2);
        btnLinhVuc3 = findViewById(R.id.btnLinhVuc3);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new LinhVucLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject objLinhVuc = new JSONObject(data);
            JSONArray arrLinhVuc = objLinhVuc.getJSONArray("linh_vuc");
            for (int i = 0; i < arrLinhVuc.length(); i++) {
                JSONObject objItemLinhVuc = arrLinhVuc.getJSONObject(i);
                int id = objItemLinhVuc.getInt("id");
                String tenLinhVuc = objItemLinhVuc.getString("ten_linh_vuc");
                //Boolean xoa = objItemLinhVuc.getBoolean("xoa");
                LinhVuc linhVuc = new LinhVuc(id, tenLinhVuc, false);
                linhVucs.add(linhVuc);
            }
            btnLinhVuc1.setText(linhVucs.get(0).getTenLinhVuc());
            btnLinhVuc2.setText(linhVucs.get(1).getTenLinhVuc());
            btnLinhVuc3.setText(linhVucs.get(2).getTenLinhVuc());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
