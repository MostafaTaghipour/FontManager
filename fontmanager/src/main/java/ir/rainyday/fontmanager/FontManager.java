package ir.rainyday.fontmanager;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import android.widget.TextView;


import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class FontManager {

    @Nullable
    private AppFont mCurrentFont = null;

    //region Singleton
    private static volatile FontManager instance;
    private static final Object mutex = new Object();

    public static FontManager getInstance() {
        FontManager result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new FontManager();
            }
        }
        return result;
    }
    //endregion

    //region methods
    public void init(AppFont font) {
        mCurrentFont = font;

        // Define your default font using CalligraphyConfig
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new TypographyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath(font.getDefaultFontPath())
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build()
        );

    }

    @Nullable
    public AppFont getCurrentFont() {
        return mCurrentFont;
    }

    public void setCurrentFont(AppFont font) {
        if (mCurrentFont != null && mCurrentFont.equals(font))
            return;

        init(font);
    }


    public void reset() {
        if (getCurrentFont() == null)
            return;

        mCurrentFont = null;
        ViewPump.init(ViewPump.builder().build());
    }
    //endregion

    //region helpers
    public static void applyTextAppearanceToTextView(Context context, TextView textView, @StyleRes int textAppearance) {

        AppFont font = getInstance().getCurrentFont();
        if (font == null)
            return;

        String filePath = null;
        if (textAppearance == R.style.Text_ExtraLight) {
            filePath = font.getExtraLightPath();

        } else if (textAppearance == R.style.Text_Thin) {
            filePath = font.getThinPath();

        } else if (textAppearance == R.style.Text_Light) {
            filePath = font.getLightPath();

        } else if (textAppearance == R.style.Text_Regular) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Medium) {
            filePath = font.getMediumPath();

        } else if (textAppearance == R.style.Text_SemiBold) {
            filePath = font.getSemiBoldPath();

        } else if (textAppearance == R.style.Text_Bold) {
            filePath = font.getBoldPath();

        } else if (textAppearance == R.style.Text_ExtraBold) {
            filePath = font.getExtraBoldPath();

        } else if (textAppearance == R.style.Text_Black) {
            filePath = font.getBlackPath();

        } else if (textAppearance == R.style.Text_Display1) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Display2) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Display3) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Display4) {
            filePath = font.getLightPath();

        } else if (textAppearance == R.style.Text_Subhead) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Title) {
            filePath = font.getMediumPath();

        } else if (textAppearance == R.style.Text_Headline) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Body1) {
            filePath = font.getRegularPath();

        } else if (textAppearance == R.style.Text_Body2) {
            filePath = font.getMediumPath();

        } else if (textAppearance == R.style.Text_Caption) {
            filePath = font.getRegularPath();

        }

        if (filePath != null) {
            applyFontToTextView(context, textView, filePath);
        }
    }

    public static boolean applyFontToTextView(final Context context, final TextView textView, final String filePath) {
        return CalligraphyUtils.applyFontToTextView(context, textView, filePath);
    }


    public static boolean applyFontToTextView(final TextView textView, final Typeface typeface) {
        return CalligraphyUtils.applyFontToTextView(textView, typeface);
    }

    public static Context wrapContext(@NonNull Context baseContext) {
        return ViewPumpContextWrapper.wrap(baseContext);
    }

    //endregion
}
