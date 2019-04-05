package com.example.appfront

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Color.*
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_second.*


class FoodItem : AppCompatActivity() {

    var collapsingToolbarLayout: CollapsingToolbarLayout?= null
    private var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null


    lateinit var toolbar: Toolbar




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        viewPager = findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager!!)

        tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout!!.setupWithViewPager(viewPager)





        toolbar = findViewById(R.id.toolbar)
     //   setSupportActionBar(toolbar)
      // supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout?
        collapsingToolbarLayout!!.title = "MENU"
        collapsingToolbarLayout!!.setCollapsedTitleTextColor(Color.BLUE)
        collapsingToolbarLayout!!.setContentScrimColor(getResources().getColor(R.color.colorAccent));





        dynamicToolbarColor()
        toolbarTextAppearance()

    }






    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OneFragment(), "Panzenella")
        adapter.addFragment(TwoFragment(), "Carrot Salad")
        adapter.addFragment(ThreeFragment(), "Onion Salad")
        adapter.addFragment(OneFragment(), "Mix Salad")
        adapter.addFragment(TwoFragment(), "Vegetable Salad")
        adapter.addFragment(ThreeFragment(), "Pasta Salad")
        adapter.addFragment(OneFragment(), "Caprese Salad")
        adapter.addFragment(TwoFragment(), "Potato Salad")
        adapter.addFragment(ThreeFragment(), "Caesar Salad")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }

//








    private fun toolbarTextAppearance() {

        collapsingToolbarLayout!!.setCollapsedTitleTextAppearance(R.style.collapseappbar)
        collapsingToolbarLayout!!.setExpandedTitleTextAppearance(R.style.expandedappbar)

    }

    private fun dynamicToolbarColor() {
        var bitmap : Bitmap = BitmapFactory.decodeResource(resources,R.drawable.i3)
        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
                collapsingToolbarLayout!!.setContentScrimColor(palette!!.getMutedColor(R.attr.color))
                collapsingToolbarLayout!!.setStatusBarScrimColor(palette!!.getMutedColor(R.attr.colorAccent))
            }
        })
    }
}