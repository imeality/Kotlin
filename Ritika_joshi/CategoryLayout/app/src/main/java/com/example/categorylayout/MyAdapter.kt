package com.example.categorylayout

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.models.DefaultResponse
import kotlinx.android.synthetic.main.row_layout.view.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList
import android.graphics.BitmapFactory
import android.widget.ImageView
import android.R.attr.bitmap
import android.net.Uri
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.IOException


class MyAdapter (private val cryptoList : ArrayList<DefaultResponse>, private val listener :

//Extend RecyclerView.Adapter//

Listener) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val GALLERY = 1




    interface Listener {
        fun onItemClick(retroCrypto :DefaultResponse)

    }

//Define an array of colours//

    private val colors : Array<String> = arrayOf("#0000ffff", "#ffffff00", "#ffffff00", "#ffffff00", "#ffffff00", "#ffffff00" , "#ffffff00" , "#ffffff00")

//Bind the ViewHolder//

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//Pass the position where each item should be displayed//

        holder.bind(cryptoList[position], listener, colors, position)

    }






















//Check how many items you have to display//

    override fun getItemCount(): Int = cryptoList.count()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)


choosePhotoFromGallary()



        return ViewHolder(view)

    }



    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

//        startActivityForResult(galleryIntent, GALLERY)
    }






//Create a ViewHolder class for your RecyclerView items//

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

//Assign values from the data model, to their corresponding Views//

        fun bind(retroCrypto: DefaultResponse, listener: Listener, colors : Array<String>, position: Int) {

//Listen for user input events//

            itemView.setOnClickListener{ listener.onItemClick(retroCrypto) }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            itemView.text_name.text = retroCrypto.Category_Name



            val file:File=  File(android.os.Environment.getExternalStorageDirectory().toString() + MyAdapter.IMAGE_DIRECTORY+retroCrypto.Category_Image.toString()+".jpg");
            println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk${file}")

            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
            println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk${bitmap}")
            itemView.imageviewcategory.setImageBitmap(bitmap);
//

        }

    }

    companion object {
        private val IMAGE_DIRECTORY = "/demonuts/"
    }



}