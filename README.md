# Library for Android: messenger-opener 
Library can open specific chats in the most popular messengers. It can be useful for user support.

## Setup
To add this libraty to your project just add the following dependency to your app level build.gradle file:
```bash
implementation 'com.github.Lukyanov03851:messenger-opener:1.0.0'
```
Also yout need to add the JitPack repository to your root build.gradle at the end of repositories:
```bash
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
## Sample code (See the app for an example)
First, we'll assume that you're going to launch the messenger from a button, and that you've set the button's onClick handler in the onCreate() method. Then, implement handler in such way:
```bash
btnWhatsapp.setOnClickListener{
    Opener.openWatsApp(context, WATSAPP_ACCOUNT)
}
```
## Maintainers
This project is mantained by:
* [Slava Lukyanov](http://github.com/Lukyanov03851)
