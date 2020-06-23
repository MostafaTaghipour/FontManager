package ir.rainday.fontexample.activities

import android.app.TaskStackBuilder
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import ir.rainday.fontexample.FontPrefrences
import ir.rainday.fontexample.MyApp
import ir.rainday.fontexample.R
import ir.rainyday.fontmanager.FontManager
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity : BaseActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        spinner.onItemSelectedListener = this

        val selectedFont = FontPrefrences.getInstance(this).selectedFont
        val selectedIndex = if (selectedFont == null) 0 else if (selectedFont == MyApp.exo.familyName) 1 else 2
        spinner.setSelection(selectedIndex)

    }


    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

        val selected = spinner.selectedItem.toString()

        FontPrefrences.getInstance(this).selectedFont = selected

        val currentFont = FontManager.getInstance().currentFont
        if (selected == "None" && currentFont != null) {
            FontManager.getInstance().reset()
            restart()
        }
        else if (selected == MyApp.exo.familyName && currentFont?.familyName != MyApp.exo.familyName) {
            FontManager.getInstance().currentFont = MyApp.exo
            restart()
        }
        else if (selected == MyApp.taviraj.familyName && currentFont?.familyName != MyApp.taviraj.familyName) {
            FontManager.getInstance().currentFont = MyApp.taviraj
            restart()
        }
    }

    private fun restart() {
        val launcherIntent = packageManager.getLaunchIntentForPackage(packageName)
        launcherIntent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        val settingIntent = Intent(this, SettingActivity::class.java)

        val stack = TaskStackBuilder.create(this)
                .addNextIntent(launcherIntent)
                .addNextIntentWithParentStack(settingIntent)


        finish()
        overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in)

        stack.startActivities()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // app icon in action bar clicked; go home
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
