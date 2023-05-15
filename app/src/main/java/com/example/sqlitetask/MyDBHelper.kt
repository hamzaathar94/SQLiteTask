package com.example.sqlitetask

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.jar.Attributes.Name

class MyDBHelper(context: Context):SQLiteOpenHelper(context,"USERDB",null,1) {

//    companion object{
//
//    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(NAME TEXt,PHONE INTEGER, EMAIL TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS USERS")
        onCreate(db)
    }


    fun insertData(mydata: MyData) {
        val db = writableDatabase
        val contentValues = ContentValues()
        //contentValues.put("USERID", mydata.USERID)
        contentValues.put("NAME", mydata.NAME)
        contentValues.put("PHONE", mydata.PHONE)
        contentValues.put("EMAIL", mydata.EMAIL)

        db.insert("USERS", null, contentValues)
        db.close()


    }

    @SuppressLint("Range")
    fun getAllPersons(context: Context): ArrayList<MyData> {
        val qry="SELECT * FROM USERS"
        val db= this.readableDatabase
        val cursor= db.rawQuery(qry,null)
        val mydata=ArrayList<MyData>()
        if(cursor.count==0){
            Toast.makeText(context,"No Record Found",Toast.LENGTH_LONG).show()
        }
        else{
            while (cursor.moveToNext()){

                val name=cursor.getString(cursor.getColumnIndex("NAME"))
                val phone=cursor.getInt(cursor.getColumnIndex("PHONE"))
                val email=cursor.getString(cursor.getColumnIndex("EMAIL"))
                mydata.add(MyData(name,phone,email))


            }
        }
        cursor.close()
        db.close()
        return mydata

    }
}