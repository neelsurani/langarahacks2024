package com.example.collegeapplication;

import android.graphics.Bitmap;

public interface DownloadImage {
    Bitmap doInBackground(String... URL);

    void onPostExecute(Bitmap result);
}
