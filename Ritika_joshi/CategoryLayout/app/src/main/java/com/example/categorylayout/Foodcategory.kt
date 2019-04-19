package com.example.categorylayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.myapplication.models.DefaultResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_foodcategory.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Foodcategory : AppCompatActivity() , MyAdapter.Listener {

    private var myAdapter: MyAdapter? = null
    private var myCompositeDisposable: CompositeDisposable? = null
    private var myRetroCryptoArrayList: ArrayList<DefaultResponse>? = null
    private val BASE_URL = "http://10.0.2.2:3002/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodcategory)

        myCompositeDisposable = CompositeDisposable()
        initRecyclerView()
        loadData()
    }

   //Initialise the RecyclerView//

    private fun initRecyclerView() {

//Use a layout manager to position your items to look like a standard ListView//

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        cryptocurrency_list.layoutManager = layoutManager

    }

//Implement loadData//

    private fun loadData() {

//Define the Retrofit request//

        val requestInterface = Retrofit.Builder()

//Set the API’s base URL//

            .baseUrl(BASE_URL)

//Specify the converter factory to use for serialization and deserialization//

            .addConverterFactory(GsonConverterFactory.create())

//Add a call adapter factory to support RxJava return types//

            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

//Build the Retrofit instance//

            .build().create(Api::class.java)

//Add all RxJava disposables to a CompositeDisposable//

        myCompositeDisposable?.add(requestInterface.getApi()

//Send the Observable’s notifications to the main UI thread//

            .observeOn(AndroidSchedulers.mainThread())

//Subscribe to the Observer away from the main UI thread//

            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse))

    }

    private fun handleResponse(cryptoList: List<DefaultResponse>) {

        myRetroCryptoArrayList = ArrayList(cryptoList)
        myAdapter = MyAdapter(myRetroCryptoArrayList!!, this)

//Set the adapter//

        cryptocurrency_list.adapter = myAdapter

    }

    override fun onItemClick(retroCrypto:DefaultResponse) {

//If the user clicks on an item, then display a Toast//

        Toast.makeText(this, "You clicked: ${retroCrypto.Category_Image}", Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        super.onDestroy()

//Clear all your disposables//

        myCompositeDisposable?.clear()

    }

}
