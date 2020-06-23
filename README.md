# AndroidFontManager

[![](https://jitpack.io/v/MostafaTaghipour/fontmanager.svg)](https://jitpack.io/#MostafaTaghipour/fontmanager)

## [iOS version is here](https://github.com/MostafaTaghipour/mtpFontManager)

AndroidFontManger is a font manager for Android:

- Support custom fonts
- Apply to entire app
- Support Multiple fonts
- Change font at runtime
- XML compatible
- Code compatible
- Supports various text appearances and font weights


![custom font app](https://raw.githubusercontent.com/MostafaTaghipour/FontManager/master/screenshots/1.gif)


## Requirements

- Api 14+

## Installation

Add JitPack to repositories in your project's root `build.gradle` file:

```Gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency to your module's `build.gradle` file:

[![](https://jitpack.io/v/MostafaTaghipour/fontmanager.svg)](https://jitpack.io/#MostafaTaghipour/fontmanager)

```Gradle
dependencies {
    ...
    implementation 'com.github.MostafaTaghipour:fontmanager:${version}'
}
```


## Usage

- Add your custom fonts to your project

![fonts](https://raw.githubusercontent.com/MostafaTaghipour/FontManager/master/screenshots/1.png)

- Declare your fonts

```kotlin
companion object {
    val exo: AppFont
        get() = AppFont.AppFontBuilder(1, "Exo", "fonts/exo/", "Exo-Regular", "ttf")
                .thin("Exo-Thin")
                .extraLight("Exo-ExtraLight")
                .light("Exo-Light")
                .regular("Exo-Regular")
                .medium("Exo-Medium")
                .semiBold("Exo-SemiBold")
                .bold("Exo-Bold")
                .extraBold("Exo-ExtraBold")
                .black("Exo-Black")
                .build()


    val taviraj: AppFont
        get() = AppFont.AppFontBuilder(2, "Taviraj", "fonts/taviraj/", "Taviraj-Regular", "ttf")
                .thin("Taviraj-Thin")
                .extraLight("Taviraj-ExtraLight")
                .light("Taviraj-Light")
                .regular("Taviraj-Regular")
                .medium("Taviraj-Medium")
                .semiBold("Taviraj-SemiBold")
                .bold("Taviraj-Bold")
                .extraBold("Taviraj-ExtraBold")
                .black("Taviraj-Black")
                .build()
}
```

- Wrap the `Activity` Context:

```kotlin
override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(FontManager.wrapContext(newBase))
}
```

- Any time you need to change the font of the application use the following code

```kotlin
FontManager.getInstance().currentFont = taviraj /* your desired font */
```

- Thats it, enjoy it


### TextAppearance
If you want use TextAppearances use the following code

#### XML
```xml
<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="some text"
        android:textAppearance="@style/Text.Subhead" />
```

#### Code
```kotlin
FontManager.applyTextAppearanceToTextView(this,textView,R.style.Text_Bold)
```

## Dependencies

- [Calligraphy3](https://github.com/InflationX/Calligraphy)
- [Viewpump](https://github.com/InflationX/ViewPump)


## Author

Mostafa Taghipour, mostafa@taghipour.me

## License

AndroidFontManager is available under the MIT license. See the LICENSE file for more info.
