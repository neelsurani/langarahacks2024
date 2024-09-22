package com.example.collegeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Download_Image extends AppCompatActivity {

    String url = "https://images.pexels.com/photos/1226302/pexels-photo1226302.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";    private static final int PERMISSION_REQUEST_CODE = 100;
    private String imageUrl;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_download_image);
//        image = findViewById(R.id.image);
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new DownloadImage().execute(url);
//            }
//        });
//    }
//    private class DownloadImage extends AsyncTask implements com.example.collegeapplication.DownloadImage {
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mProgressDialog = new ProgressDialog(Download_Image.this);
//            mProgressDialog.setTitle("Download Image Tutorial");
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
//        }
//
//        @Override
//        public Bitmap doInBackground(String... URL) {
//            String imageURL = URL[0];
//            Bitmap bitmap = null;
//            try {
//                // Download Image from URL
//                InputStream input = new java.net.URL(imageURL).openStream();
//                // Decode Bitmap
//                bitmap = BitmapFactory.decodeStream(input);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return bitmap;
//        }
//        @Override
//        public void onPostExecute(Bitmap result) {
//            // Set the bitmap into ImageView
//            image.setImageBitmap(result);
//            // Close progressdialog
//            mProgressDialog.dismiss();
//        }
        ImageView imageView = findViewById(R.id.image);
        Button downloadButton = findViewById(R.id.downloadbutton);

        // Get the image URL from the intent
        Intent intent = getIntent();
        imageUrl = intent.getStringExtra("image");

        // Load the image using Picasso (add the Picasso library in your build.gradle)
        Picasso.get().load(imageUrl).into(imageView);

        // Download button click listener
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    downloadImage();
                } else {
                    requestPermission();
                }
            }
        });
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                downloadImage();
            }
        }
    }

    private void downloadImage() {
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(imageUrl);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, uri.getLastPathSegment());

        if (downloadManager != null) {
            downloadManager.enqueue(request);
        }
    }
}