package com.e.este

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavBar: BottomNavigationView

    private var fragmentList: MutableList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TodayFragment())
            .commit()

        // for ViewPager
        fragmentList.add(TodayFragment())
        fragmentList.add(AllSheduleFragment())

        bottomNavBar = findViewById(R.id.BNV_activity_main)

        bottomNavBar.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var selectedFragment: Fragment? = null

                when(item.itemId){
                    R.id.item_today ->{
                        selectedFragment = TodayFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .addToBackStack(null)
                            .commit()
                        item.setChecked(true)

                        return true
                    }
                    R.id.item_all_shedule -> {
                        selectedFragment = AllSheduleFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .addToBackStack(null)
                            .commit()
                        item.setChecked(true)

                        return true
                    }
                }

                return false
            }
        })
    }
}