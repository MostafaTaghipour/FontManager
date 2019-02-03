# Android custom font example


In this tutorial, I'm going to show you how to apply a custom font and use it in different parts of the project.

![typography](/screenshot1.gif)

![font weights](/screenshot2.png)

- Add calligraphy as dependency

```groovy
dependencies {
    compile "uk.co.chrisjenx:calligraphy:$last_calligraphy_version"
}
```
- Add your custom fonts to `assets/`
- Define your fonts in build.gradle(Module: app)

```groovy

def final fontUltraLight = "Lato-Hairline"
def final fontThin = "Lato-Thin"
def final fontLight = "Lato-Light"
def final fontRegular = "Lato-Regular"
def final fontMedium = "Lato-Medium"
def final fontSemibold = "Lato-Semibold"
def final fontBold = "Lato-Bold"
def final fontHeavy = "Lato-Heavy"
def final fontBlack = "Lato-Black"


android {

    defaultConfig {
        //...

        buildConfigField "String", "FONT_PATH_ULTRA_LIGHT", "\"fonts/${fontUltraLight}.ttf\""
        buildConfigField "String", "FONT_PATH_THIN", "\"fonts/${fontThin}.ttf\""
        buildConfigField "String", "FONT_PATH_LIGHT", "\"fonts/${fontLight}.ttf\""
        buildConfigField "String", "FONT_PATH_REGULAR", "\"fonts/${fontRegular}.ttf\""
        buildConfigField "String", "FONT_PATH_MEDIUM", "\"fonts/${fontMedium}.ttf\""
        buildConfigField "String", "FONT_PATH_SEMIBOLD", "\"fonts/${fontSemibold}.ttf\""
        buildConfigField "String", "FONT_PATH_BOLD", "\"fonts/${fontBold}.ttf\""
        buildConfigField "String", "FONT_PATH_HEAVY", "\"fonts/${fontHeavy}.ttf\""
        buildConfigField "String", "FONT_PATH_BLACK", "\"fonts/${fontBlack}.ttf\""

        resValue "string", "font_path_ultra_light", "fonts/${fontUltraLight}.ttf"
        resValue "string", "font_path_thin", "fonts/${fontThin}.ttf"
        resValue "string", "font_path_light", "fonts/${fontLight}.ttf"
        resValue "string", "font_path_regular", "fonts/${fontRegular}.ttf"
        resValue "string", "font_path_medium", "fonts/${fontMedium}.ttf"
        resValue "string", "font_path_semibold", "fonts/${fontSemibold}.ttf"
        resValue "string", "font_path_bold", "fonts/${fontBold}.ttf"
        resValue "string", "font_path_heavy", "fonts/${fontHeavy}.ttf"
        resValue "string", "font_path_black", "fonts/${fontBlack}.ttf"

    }
}

```
- Define your default font using `CalligraphyConfig`, in your `Application` class in the `#onCreate()` method.

```kotlin
override fun onCreate() {
    super.onCreate()

    CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
    .setDefaultFontPath(BuildConfig.FONT_PATH_REGULAR)
    .setFontAttrId(R.attr.fontPath)
    .build()
    )
}
```

- Wrap the `Activity` Context:

```kotlin
override fun attachBaseContext(newBase: Context?) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
}
```

- Define typography and font weights in style.xml file

```xml
<resources>

    <!-- font weights -->
    <style name="Text.UltraLight" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_ultra_light</item>
    </style>

    <style name="Text.Thin" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_thin</item>
    </style>

    <style name="Text.Light" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_light</item>
    </style>

    <style name="Text.Regular" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Medium" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_medium</item>
    </style>

    <style name="Text.Semibold" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_semibold</item>
    </style>

    <style name="Text.Bold" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_bold</item>
    </style>

    <style name="Text.Heavy" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_heavy</item>
    </style>

    <style name="Text.Black" parent="android:TextAppearance">
    <item name="fontPath">@string/font_path_black</item>
    </style>


    <!-- AppCompat Default Typography -->
    <style name="Text.Display4" parent="TextAppearance.AppCompat.Display4">
    <item name="fontPath">@string/font_path_light</item>
    </style>

    <style name="Text.Display3" parent="TextAppearance.AppCompat.Display3">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Display2" parent="TextAppearance.AppCompat.Display2">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Display1" parent="TextAppearance.AppCompat.Display1">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Headline" parent="TextAppearance.AppCompat.Headline">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Title" parent="TextAppearance.AppCompat.Title">
    <item name="fontPath">@string/font_path_medium</item>
    </style>

    <style name="Text.Subhead" parent="TextAppearance.AppCompat.Subhead">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Body2" parent="TextAppearance.AppCompat.Body2">
    <item name="fontPath">@string/font_path_medium</item>
    </style>

    <style name="Text.Body1" parent="TextAppearance.AppCompat.Body1">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

    <style name="Text.Caption" parent="TextAppearance.AppCompat.Caption">
    <item name="fontPath">@string/font_path_regular</item>
    </style>

</resources>
```

- Thats it, now you can use custom font anywhere

```xml
    <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Bold"
    android:textAppearance="@style/Text.Bold" />

    <TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Body1"
    android:textAppearance="@style/Text.Body1" />
```
