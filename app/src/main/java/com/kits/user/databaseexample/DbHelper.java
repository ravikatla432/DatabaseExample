package com.kits.user.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by User on 6/4/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    //Database Version
    private  static final int DATABASE_VERSION = 1;
    //DataBase Name
    private  static final String DATABASE_NAME="shopsInfo";
    //Table name
    private  static final String TABLE_NAME="shops";

    //columns names
    private  static final String KEY_ID="id";
    private  static final String KEY_NAME="name";
    private  static final String KEY_ADDRESS="shop_address";



//Create database name
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        create table tablename (id INTEGER PRIMARY KEY,name TEXT,address TEXT);
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT,"+KEY_ADDRESS+" TEXT"+")";

                db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop older if exists
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        //create our table
        onCreate(db);
    }
    //add a new row
    public void addShop(Shop shop)
    {
     SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,shop.getName());
        contentValues.put(KEY_ADDRESS,shop.getAddress());

        //insert this roew
        db.insert(TABLE_NAME,null,contentValues);
        db.close();

    }
    //getting the details
    public Shop getValues(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.query(TABLE_NAME,new String[]{KEY_ID,KEY_NAME,KEY_ADDRESS},KEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
//        table id name address
        Shop shop =new Shop(cursor.getString(1),cursor.getInt(0),cursor.getString(2));

        return shop;


    }
}
