package com.example.appfront

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.appfront.R



class OneFragment : Fragment() {



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

        val View =  inflater!!.inflate(R.layout.fragment_one, container, false)

        val myListAdapter = MyListAdapter(requireActivity(), language, description, imageId)

        val listviw1 = View.findViewById(R.id.listView) as ListView
        listviw1.adapter = myListAdapter




        listviw1.setOnItemClickListener(){ adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            // Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
        // Inflate the layout for this fragment

        return View

    }
}
