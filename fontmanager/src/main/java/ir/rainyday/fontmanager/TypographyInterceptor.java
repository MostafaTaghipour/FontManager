package ir.rainyday.fontmanager;


import android.content.res.TypedArray;
import android.widget.TextView;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.InflateResult;

public class TypographyInterceptor extends CalligraphyInterceptor {

    public TypographyInterceptor(CalligraphyConfig calligraphyConfig) {
        super(calligraphyConfig);
    }

    @Override
    public InflateResult intercept(Chain chain) {

        InflateResult result = super.intercept(chain);

        if (result.view() instanceof TextView) {
            // Do something to result.view()
            // You have access to result.context() and result.attrs()
            TextView textView = (TextView) result.view();

            int[] set = {
                    android.R.attr.textAppearance, // idx 0
            };
            TypedArray a = result.context().obtainStyledAttributes(result.attrs(), set);
            int resourceId = a.getResourceId(0, -1);
            a.recycle();


            FontManager.applyTextAppearanceToTextView(result.context(), textView, resourceId);

        }
        return result;

    }


}
