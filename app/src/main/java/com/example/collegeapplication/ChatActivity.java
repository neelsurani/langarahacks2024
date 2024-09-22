package com.example.collegeapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private ArrayList<String> chatMessages;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initialize ListView for chat messages
        ListView chatListView = findViewById(R.id.chatListView);
        EditText messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendButton);

        // Initialize ArrayList to hold chat messages
        chatMessages = new ArrayList<>();

        // Set up ArrayAdapter to bind the chat messages to the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chatMessages);
        chatListView.setAdapter(adapter);

        // Send button click event
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get message from EditText
                String message = messageEditText.getText().toString().trim();

                if (!message.isEmpty()) {
                    // Add message to chat messages list
                    chatMessages.add("You: " + message);

                    // (Optional) Adding a fake response from "Bot"
                    chatMessages.add("Bot: " + generateFakeResponse(message));

                    // Notify the adapter that the data has changed so the ListView will refresh
                    adapter.notifyDataSetChanged();

                    // Clear the input after sending the message
                    messageEditText.setText("");
                }
            }
        });
    }

    // Method to generate a fake response from the "Bot"
    private String generateFakeResponse(String userMessage) {
        return "You said: " + userMessage;
    }
}
