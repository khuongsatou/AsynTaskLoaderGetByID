package com.nvk.muiltiscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.nvk.muiltiscreen.MainActivity.KEY_LINHVUC;

public class CauHoiActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    List<CauHoi> cauHoiList;
    TextView tvNoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_hoi);

        cauHoiList = new ArrayList<>();
        tvNoiDung = findViewById(R.id.tvNoiDung);

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
        getSupportLoaderManager().restartLoader(0, null, this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new CauHoiLoader(this, getIntent().getIntExtra(KEY_LINHVUC, -1));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject objCauHoi = new JSONObject(data);
            JSONObject arrCauHoi = objCauHoi.getJSONObject("cau_hoi");
            String noiDung = arrCauHoi.getString("noi_dung");
            CauHoi cauHoi = new CauHoi();
            cauHoi.setNoiDung(noiDung);
            tvNoiDung.setText(cauHoi.getNoiDung());
            cauHoiList.add(cauHoi);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
