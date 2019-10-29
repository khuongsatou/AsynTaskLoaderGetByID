package com.nvk.muiltiscreen;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class CauHoiLoader extends AsyncTaskLoader<String> {
    private int id;
    public CauHoiLoader(@NonNull Context context,int id) {
        super(context);
        this.id = id;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return UtilsNetWork.connect("id",id+"");
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
