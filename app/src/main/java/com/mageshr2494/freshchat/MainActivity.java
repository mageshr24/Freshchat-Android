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

//        FreshchatConfig config = new FreshchatConfig("b00f3ed0-2baf-47fe-9112-00c121eea513", "819ca885-b9ba-4cd7-a97a-1c48181e2857");


        //magesh@shade6.com
        FreshchatConfig config = new FreshchatConfig("e9821be8-40b6-45a0-8907-9ff3572d8738", "91552ca5-60be-4446-9485-51d69aaa23b0");


        //W2d
//        FreshchatConfig config = new FreshchatConfig("b78d884e-a79c-405f-bbc0-1b92e666641f", "89e82ab5-1366-4a8f-96a0-96e52f86375a");
//        FreshchatConfig config = new FreshchatConfig("89e82ab5-1366-4a8f-96a0-96e52f86375a", "b78d884e-a79c-405f-bbc0-1b92e666641f");
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
