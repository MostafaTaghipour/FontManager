package ir.rainday.fontexample

import android.content.Context
import android.content.SharedPreferences

class FontPrefrences(context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: FontPrefrences? = null

        fun getInstance(context: Context): FontPrefrences {
            return INSTANCE ?: synchronized(this) {
                FontPrefrences(context).also {
                    INSTANCE = it
                }
            }
        }
    }

    private var lngPreferences: SharedPreferences = context.getSharedPreferences("FONT_PREF", Context.MODE_PRIVATE)

    var selectedFont: String?
        get() {
            val res = lngPreferences.getString("Font_KEY","None")
            if (!(res.isEmpty() || res == "None")) {
                return res
            }
            return null
        }
        set(value) {
            lngPreferences.edit().apply {
                putString("Font_KEY", value ?: "None")
                apply()
            }
        }

}
