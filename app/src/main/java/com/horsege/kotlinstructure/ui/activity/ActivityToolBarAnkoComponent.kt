package horsege.com.supportdesiginexample.ui.avtivity

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

interface ActivityToolBarAnkoComponent<T : AppCompatActivity> : ActivityAnkoComponent<T> {
    val toolbar: Toolbar
}