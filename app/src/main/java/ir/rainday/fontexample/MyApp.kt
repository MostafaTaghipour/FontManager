package ir.rainday.fontexample

import android.app.Application
import ir.rainyday.fontmanager.AppFont
import ir.rainyday.fontmanager.FontManager
import java.util.*


/**
 * Created by mostafa-taghipour on 12/2/17.
 */
class MyApp : Application() {

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


    override fun onCreate() {
        super.onCreate()

        //set Font
        FontPrefrences.getInstance(this).selectedFont?.let {
            FontManager.getInstance().init(if (it == exo.familyName) exo else taviraj)
        }

    }
}