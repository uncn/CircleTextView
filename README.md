# CircleTextView
CircleTextView is an open source Android library that allows developers to easily create an circle TextView with colorful shadow.

### ScreenShot
<!-- ![sample](./screenshot/Demo01.png) -->
<!-- ![sample](./screenshot/Demo02.png) -->

<a href="screenshot/Demo01.png"><img src="screenshot/Demo01.png"/></a> <a href="screenshot/Demo02.png"><img src="screenshot/Demo02.png"/></a>

### Gradle
```groovy
dependencies {
    compile 'com.github.ShortStickBoy:Timer:V1.0.0'
}
```

### Use
```groovy
        <com.sunzn.ctv.library.CircleTextView
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:gravity="center"
            android:text="C"
            android:textColor="@android:color/white"
            android:textSize="16sp"
            app:borderAlpha="0.5"
            app:borderColor="@android:color/holo_green_light"
            app:borderWidth="0"
            app:circleColor="@android:color/holo_green_light"
            app:shadowColor="@android:color/holo_green_light"
            app:shadowWidth="15" />
```

| Attribute   | Describe                               | Additional                                                        |
| ----------- | -------------------------------------- | ----------------------------------------------------------------- |
| borderWidth | Width of circle and cursor             | The greater the value, the greater the width of circle and cursor |
| filledColor | Color of bottom disc                   | Support color                                                     |
| circleColor | Color of middle circle                 | Support color                                                     |
| cursorColor | Color of top cursor                    | Support color                                                     |
| text        | Text to show in center of disc         | Support text and string reference                                 |
| textColor   | Text Color                             | Support color                                                     |
| textSize    | Text size                              | The larger the value, the larger the text                         |
| duration    | Time to wait                           | The larger the value, the more time to wait                       |
| startAngle  | The position where the curse to start  | Default value is 270                                              |

### License
```
    Copyright [2017] sunzn

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```