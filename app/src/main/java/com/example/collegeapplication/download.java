package com.example.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

public class download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        String bookUrl = "URL_OF_YOUR_BOOK_FILE";
        String bookTitle = "Book_Title";
        downloadBook(bookUrl, bookTitle);
    }

    private void downloadBook(String bookUrl, String bookTitle) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(bookUrl));

        request.setTitle(bookTitle);
        request.setDescription("Downloading");

        Intent i = new Intent(download.this,custom2.class);
        startActivity(i);

        // Set the destination for the downloaded file
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, bookTitle + ".pdf");

        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        long downloadId = downloadManager.enqueue(request);
    }
}