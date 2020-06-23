package ir.rainday.fontexample.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import ir.rainyday.fontmanager.FontManager

/**
 * Created by mostafa-taghipour on 12/2/17.
 */

abstract class BaseActivity : AppCompatActivity(){

    override fun attachBaseContext(newBase: Context) {
      super.attachBaseContext(FontManager.wrapContext(newBase))
    }

}
