package com.mageshr2494.freshchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        freshchatInit();
    }

    private void freshchatInit() {

        FreshchatConfig config = new FreshchatConfig("APP_ID", "APP_KEY");
        
        config.setDomain("https://msdk.in.freshchat.com");
        config.setCameraCaptureEnabled(true);
        config.setGallerySelectionEnabled(true);
        config.setResponseExpectationEnabled(true);
        Freshchat.getInstance(getApplicationContext()).init(config);

        // Get the user object for the current installation
        FreshchatUser freshchatUser = Freshchat.getInstance(getApplicationContext()).getUser();
        freshchatUser.setFirstName("John");
        freshchatUser.setLastName("Doe");
        freshchatUser.setEmail("john.doe.1982@mail.com");
        freshchatUser.setPhone("+91", "9790987495");

// Call setUser so that the user information is synced with Freshchat's servers
        try {
            Freshchat.getInstance(getApplicationContext()).setUser(freshchatUser);
        } catch (MethodNotAllowedException e) {
            e.printStackTrace();
        }
        showConversations();
    }

    private void showConversations() {
        Freshchat.showConversations(getApplicationContext());

    }


}
