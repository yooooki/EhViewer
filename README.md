# NOTES
This repo is maintained for personal use only. It is maintained based on the latest public available release from Hippo (1.7.3). No major features will be added to this repo except for fixes, thus the version number will go on like 1.7.3.x.

By the time EhViewer was developed, mobile phones usually have 512MB or even 256MB RAM, while the official libraries of Android is crab. To develope a smoothy app, one need to be smart. That's why this project depends heavily on Hippo's other projects, including an image libaray based on JNI.
Nowadays Android phones have more RAM than my laptop, and there are plenty of high-quality libraries, the necessity of making all wheels is almost eliminated. I'll keep maintaining this repo though.

## Build
Since Eh switchs to Webp years ago, changes must be made on the "image" library, which is also referenced by some other libraries. 
One must first build the image library, then other libraries, then manually include the built files into gradle to replace the original libraries on maven. This is a little bit frustrating, but such inconvenient for an old project like this is acceptable.
The modified image library is here: https://github.com/yooooki/Image/tree/ehviewer
The built aar file in also included in the repo.

# DEPRECATED

[![Telegram](https://img.shields.io/badge/chat-Telegram-blue.svg)](https://t.me/ehviewer)

# EhViewer

![Icon](art/launcher_icon-web.png)

这是一个 E-Hentai Android 平台的浏览器。

An E-Hentai Application for Android.


# Screenshot

![screenshot-01](art/screenshot-01.png)


# Build

Windows

    > git clone https://github.com/seven332/EhViewer
    > cd EhViewer
    > gradlew app:assembleDebug

Linux

    $ git clone https://github.com/seven332/EhViewer
    $ cd EhViewer
    $ ./gradlew app:assembleDebug

生成的 apk 文件在 app\build\outputs\apk 目录下

The apk is in app\build\outputs\apk


# Download

[下载](https://github.com/seven332/EhViewer/releases)

[Download](https://github.com/seven332/EhViewer/releases)


# Thanks

本项目受到了诸多开源项目的帮助

Here is the libraries

- [AOSP](http://source.android.com/)
- [android-advancedrecyclerview](https://github.com/h6ah4i/android-advancedrecyclerview)
- [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)
- [apng](http://apng.sourceforge.net/)
- [giflib](http://giflib.sourceforge.net)
- [greenDAO](https://github.com/greenrobot/greenDAO)
- [jsoup](https://github.com/jhy/jsoup)
- [libjpeg-turbo](http://libjpeg-turbo.virtualgl.org/)
- [libpng](http://www.libpng.org/pub/png/libpng.html)
- [okhttp](https://github.com/square/okhttp)
- [roaster](https://github.com/forge/roaster)
- [ShowcaseView](https://github.com/amlcurran/ShowcaseView)
- [Slabo](https://github.com/TiroTypeworks/Slabo)
- [TagSoup](http://home.ccil.org/~cowan/tagsoup/)


# License

    Copyright (C) 2014-2019 Hippo Seven

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

ic_launcher 图标为 Hippo Seven 所有，所有权利保留
