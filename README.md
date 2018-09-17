# Movieholics
App to see the list of Upcoming movies from TMDb.

# Build instructions
This code was coded on Android Studio 3.1.4, and testing on LG k220(Android 6.0.1, API 23)
Configuration of tarket SDK Version:
```
compileSdkVersion 28
    defaultConfig {
        applicationId "com.fin.leo.movieholics"
        minSdkVersion 15
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
```
# APP issues & Improvements
- Without internet the list will be empty, missing a "empty" message, don't has a refresh button, but click in next will made another request to fill the list.
- To resolve this problem, in future will be implemented a localstore on SQLite to save datas from requests and show the list from DB either.

# Folder Structure
I've placed the image below to make it easier to navigate through the source codes.
The entities within the TMDb folder are used for the translation of the JSONs to objects easier to manipulate in the code, using the lib GSON to parse.
![estrutura_de_arquivos](https://user-images.githubusercontent.com/14237441/45603418-2fd52980-ba02-11e8-852f-5f406e50d2a4.PNG)

# ScreenShots
![screenshot_2018-09-16-21-33-46](https://user-images.githubusercontent.com/14237441/45603405-18963c00-ba02-11e8-8820-ffea4399fddd.png)
![screenshot_2018-09-16-21-33-53](https://user-images.githubusercontent.com/14237441/45603406-19c76900-ba02-11e8-9edd-2e8a368ca759.png)
![screenshot_2018-09-16-21-34-01](https://user-images.githubusercontent.com/14237441/45603407-1b912c80-ba02-11e8-9f65-1e0997140193.png)

# Libs
- 'com.google.code.gson:gson:2.8.5' - Lib to manipulate JSON's Object from API's.
- 'com.squareup.picasso:picasso:2.71828' - Lib to download, present and cache remote images by url.
- 'java.net.HttpURLConnection' - Lib used to made get requests from APIs  

# Problems
- Performance issues with VS2017 with Xamarin.
- Forgot to create master branch before start coding.
