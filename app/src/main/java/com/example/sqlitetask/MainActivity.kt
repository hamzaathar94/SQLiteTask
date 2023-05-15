package com.example.sqlitetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitetask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    private var mydbhelper:MyDBHelper?=null
    private var recyclerView:RecyclerView?=null
    private var adapter:MyAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        mydbhelper=MyDBHelper(this)

        recyclerView?.layoutManager=LinearLayoutManager(this)


        

        binding?.btnsave?.setOnClickListener {

            val name=binding?.edtxtname?.text.toString()
            val phone=binding?.edtxtphone?.text.toString().toInt()
            val email=binding?.edtxtemail?.text.toString()

            val mydata=MyData(name,phone,email)
            mydbhelper!!.insertData(mydata)

            binding?.edtxtname?.setText("")
            binding?.edtxtphone?.setText("")
            binding?.edtxtemail?.setText("")

        }

        binding?.btnshow?.setOnClickListener {

            var helper=MyDBHelper(applicationContext)
            var db=helper.readableDatabase
            var rs=db.rawQuery("SELECT * FROM USERS",null)
            if (rs.moveToNext())
              //  Toast.makeText(applicationContext,rs.getString(0), Toast.LENGTH_LONG).show()

            binding?.edtxtname?.setText(rs.getString(0))
            binding?.edtxtphone?.setText(rs.getString(1))
            binding?.edtxtemail?.setText(rs.getString(2))

          //  startActivity(Intent(this,MainActivity2::class.java))

        }
    }
}