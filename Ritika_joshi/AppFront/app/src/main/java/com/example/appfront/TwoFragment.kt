package com.example.appfront

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.*
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_one.*


class TwoFragment : Fragment() {


    val language = arrayOf<String>("Panzenella","Carrot Salad","Onion Salad","Mix Salad","Vegetable Salad"
        ,"Pasta Salad","Caprese Salad","Potato Salad","Caesar Salad","Carrot Salad","Onion Salad","Mix Salad","Vegetable Salad")
    val description = arrayOf<String>(
        "C programming is considered as the base for other programming languages",
        "C++ is an object-oriented programming language.",
        "Java is a programming language and a platform.",
        ".NET is a framework which is used to develop software applications.",
        "Kotlin is a open-source programming language, used to develop Android apps and much more.",
        "Ruby is an open-source and fully object-oriented programming language.",
        "Ruby on Rails is a server-side web application development framework written in Ruby language.",
        "Python is interpreted scripting  and object-oriented programming language.",
        "JavaScript is an object-based scripting language.",
        "PHP is an interpreted language, i.e., there is no need for compilation.",
        "AJAX allows you to send and receive data asynchronously without reloading the web page.",
        "Perl is a cross-platform environment used to create network and server-side applications.",
        "Hadoop is an open source framework from Apache written in Java."
    )

    val imageId = arrayOf<Int>(
        R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,
        R.drawable.i5,R.drawable.i16,R.drawable.i6,R.drawable.i12,R.drawable.i13,
        R.drawable.i14,R.drawable.i15,R.drawable.i17,R.drawable.i14
    )








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val View =  inflater!!.inflate(R.layout.fragment_three, container, false)

        val myListAdapter = MyListAdapter(requireActivity(), language, description, imageId)

        val listviw1 = View.findViewById(R.id.listView) as ListView
        listviw1.adapter = myListAdapter




        listviw1.setOnItemClickListener(){ adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(context, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
        // Inflate the layout for this fragment

        return View

    }



    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {


            R.id.nav_menu -> {

            }
            R.id.nav_order -> {

            }
            R.id.nav_signout -> {

            }




//            R.id.nav_camera -> {
//                // Handle the camera action
//            }
//            R.id.nav_gallery -> {
//
//            }
//            R.id.nav_slideshow -> {
//
//            }
//            R.id.nav_manage -> {
//
//            }
//            R.id.nav_share -> {
//
//            }
//            R.id.nav_send -> {
//
//            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return false
    }
}
