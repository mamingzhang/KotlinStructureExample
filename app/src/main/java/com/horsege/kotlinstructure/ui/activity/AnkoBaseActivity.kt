package horsege.com.supportdesiginexample.ui.avtivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.horsege.kotlinstructure.ui.activity.BaseActivity
import org.jetbrains.anko.setContentView

abstract class AnkoBaseActivity<out UI : ActivityAnkoComponent<out AppCompatActivity>> : BaseActivity() {

    abstract val ui: UI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (ui as ActivityAnkoComponent<AppCompatActivity>).setContentView(this)
    }
}