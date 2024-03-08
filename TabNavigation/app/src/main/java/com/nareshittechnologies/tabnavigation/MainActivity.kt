package com.nareshittechnologies.tabnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewpager:ViewPager2
    lateinit var tablayout:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager = findViewById(R.id.viewpager)
        tablayout =  findViewById(R.id.tabLayout)

        val vpa = ViewPagerAdapter(this)
        viewpager.adapter = vpa

        TabLayoutMediator(tablayout, viewpager){tab, position ->
            when(position){
                0-> tab.setText("RED")
                1-> tab.setText("GREEN")
                2-> tab.setText("BLUE")
            }
        }.attach()

    }

    class ViewPagerAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            if(position == 0){
                return RedFragment()
            }else if(position == 1){
                return GreenFragment()
            }else{
                return BlueFragment()
            }
        }

    }
}