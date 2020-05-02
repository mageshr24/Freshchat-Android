# Freshchat-Android
Freshchat integration

## First time integration 
### [Integration Guide](https://support.freshchat.com/support/solutions/articles/50000000207)

#### Quick Steps

Need to set the designated domain based on the Datacenter using FreshchatConfig.setDomain()

Default - msdk.freshchat.com
EU - msdk.eu.freshchat.com
India - msdk.in.freshchat.com
Australia - msdk.au.freshchat.com

#### Quick Steps
Project gradle file **build.gradle**
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

App Module gradle file **(app/build.gradle)** 
```
dependencies {
    implementation 'com.github.freshdesk:freshchat-android:{latestVersion}'
}
```

