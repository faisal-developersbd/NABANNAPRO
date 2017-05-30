package com.developersbd.nabannapro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by TC on 3/31/2017.
 */

public class dbfile extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "fertilizer";
    // Contacts table name
    private static final String TABLE_SHOPS ="sample_tbl";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SH_ADDR = "address";

    //fertilizer table
    private static final String TABLE_CATEGORY="tbl_cat";
    //COLUMNS
    private static final String COLUMN_CAT_1 = "cat_id";
    private static final String COLUMN_CAT_2 = "cat_name";

    private static final String TABLE_CROPS="tbl_crops";
    //COLUMNS
    private static final String COLUMN_CROPS_1 = "crop_id";
    private static final String COLUMN_CROPS_REF_COLUMN_CAT_1_2 = "cat_id";
    private static final String COLUMN_CROPS_3 = "crop_name";

    private static final String TABLE_LANDTYPE="tble_land";
    //COLUMNS
    private static final String COLUMN_LAND_1 = "land_id";
    private static final String COLUMN_LAND_2 = "land_type";

    private static final String TABLE_NUTRITION_STATUS="tbl_nutrition_status";
    //COLUMNS
    private static final String COLUMN_NUTRITION_STATUS_1 = "nut_id";
    private static final String COLUMN_NUTRITION_STATUS_2 = "nut_name";

    private static final String TABLE_LIMITS="tble_limits";
    //COLUMNS
    private static final String COLUMN_LIMITS_1 = "limit_id";
    private static final String COLUMN_LIMITS_REF_COLUMN_LAND_1_2 = "land_id";
    private static final String COLUMN_REF_NUTRION_STATUS_2_3= COLUMN_NUTRITION_STATUS_2;
    private static final String COLUMN_LIMITS_4 = "csn";
    private static final String COLUMN_LIMITS_5 = "lsn";
    private static final String COLUMN_LIMITS_6 = "csp";
    private static final String COLUMN_LIMITS_7 = "lsp";
    private static final String COLUMN_LIMITS_8 = "csk";
    private static final String COLUMN_LIMITS_9 = "lsk";
    private static final String COLUMN_LIMITS_10 = "css";
    private static final String COLUMN_LIMITS_11= "lss";
    private static final String COLUMN_LIMITS_12 = "cszn";
    private static final String COLUMN_LIMITS_13 = "lszn";
    private static final String COLUMN_LIMITS_14 = "csb";
    private static final String COLUMN_LIMITS_15 = "lsb";

    private static final String TABLE_SAI="tble_sai";
    //COLUMNS
    private static final String COLUMN_SAI_1 = "sai_id";
    private static final String COLUMN_SAI_REF_COLUMN_CROPS_1_2 = "crop_id";
    private static final String COLUMN_SAI_REF_NUTRION_STATUS_2_3= COLUMN_NUTRITION_STATUS_2;
    private static final String COLUMN_SAI_4 = "ufn";
    private static final String COLUMN_SAI_5 = "cin";
    private static final String COLUMN_SAI_6 = "ufp";
    private static final String COLUMN_SAI_7 = "cip";
    private static final String COLUMN_SAI_8 = "ufk";
    private static final String COLUMN_SAI_9 = "cik";
    private static final String COLUMN_SAI_10 = "ufs";
    private static final String COLUMN_SAI_11= "cis";
    private static final String COLUMN_SAI_12 = "ufzn";
    private static final String COLUMN_SAI_13 = "cizn";
    private static final String COLUMN_SAI_14 = "ufb";
    private static final String COLUMN_SAI_15 = "cib";

    private static final String TABLE_METHODS="tble_METHODS";
    //COLUMNS
    private static final String COLUMN_METHODS_1 = "method_id";
    private static final String COLUMN_METHODS_REF_CROP_ID_2 = "crop_id";
    private static final String COLUMN_METHODS_3 = "methods";

    public dbfile(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SHOPS + "("
//        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//        + KEY_SH_ADDR + " TEXT" + ")";
        Log.d("dbfile","CREATING TALBE..");
        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
                + COLUMN_CAT_1 + " INTEGER PRIMARY KEY," + COLUMN_CAT_2 + " TEXT"+")";

        String CREATE_NUTRION_STATUS_TABLE= "CREATE TABLE " + TABLE_NUTRITION_STATUS + "("
                + COLUMN_NUTRITION_STATUS_1 + " INTEGER PRIMARY KEY," + COLUMN_NUTRITION_STATUS_2 + " TEXT"+")";
        String CREATE_CROPS_TABLE = "CREATE TABLE " + TABLE_CROPS + " ("
                + COLUMN_CROPS_1+ " INTEGER PRIMARY KEY,"
                + COLUMN_CROPS_REF_COLUMN_CAT_1_2 + " TEXT,"
                + COLUMN_CROPS_3 + " TEXT"+")";
//
//        String CREATE_CROPS_TABLE = "CREATE TABLE " + TABLE_CROPS + " ("
//                + COLUMN_CROPS_1+ " INTEGER PRIMARY KEY,"
//                + COLUMN_CROPS_REF_COLUMN_CAT_1_2 + " TEXT,"
//                + COLUMN_CROPS_3 + " TEXT,FOREIGN KEY ("+COLUMN_CROPS_REF_COLUMN_CAT_1_2+") REFERENCES("+TABLE_CATEGORY+"))";
        String CREATE_LANDTYPE_TABLE = "CREATE TABLE " + TABLE_LANDTYPE +"("
                + COLUMN_LAND_1 + " INTEGER PRIMARY KEY," + COLUMN_LAND_2 + " TEXT"+")";
        String CREATE_LIMITS_TABLE = "CREATE TABLE " + TABLE_LIMITS +"("
                + COLUMN_LIMITS_1 + " INTEGER PRIMARY KEY," + COLUMN_LIMITS_REF_COLUMN_LAND_1_2 + " INTEGER,"+ COLUMN_REF_NUTRION_STATUS_2_3 + " TEXT,"
                + COLUMN_LIMITS_4 + " TEXT,"+ COLUMN_LIMITS_5 + " TEXT,"+ COLUMN_LIMITS_6 + " TEXT,"
                + COLUMN_LIMITS_7 + " TEXT,"+ COLUMN_LIMITS_8 + " TEXT,"+ COLUMN_LIMITS_9 + " TEXT,"
                + COLUMN_LIMITS_10 + " TEXT,"+ COLUMN_LIMITS_11 + " TEXT,"+ COLUMN_LIMITS_12 + " TEXT,"
                + COLUMN_LIMITS_13 + " TEXT,"+ COLUMN_LIMITS_14 + " TEXT,"+ COLUMN_LIMITS_15 + " TEXT)";
//        String CREATE_LIMITS_TABLE = "CREATE TABLE " + TABLE_LIMITS +"("
//                + COLUMN_LIMITS_1 + " INTEGER PRIMARY KEY," + COLUMN_LIMITS_REF_COLUMN_LAND_1_2 + " INTEGER,"+ COLUMN_REF_NUTRION_STATUS_2_3 + " TEXT,"
//                + COLUMN_LIMITS_4 + " TEXT,"+ COLUMN_LIMITS_5 + " TEXT,"+ COLUMN_LIMITS_6 + " TEXT,"
//                + COLUMN_LIMITS_7 + " TEXT,"+ COLUMN_LIMITS_8 + " TEXT,"+ COLUMN_LIMITS_9 + " TEXT,"
//                + COLUMN_LIMITS_10 + " TEXT,"+ COLUMN_LIMITS_11 + " TEXT,"+ COLUMN_LIMITS_12 + " TEXT,"
//                + COLUMN_LIMITS_13 + " TEXT,"+ COLUMN_LIMITS_14 + " TEXT,"+ COLUMN_LIMITS_15 + " TEXT, FOREIGN KEY ("+COLUMN_LIMITS_REF_COLUMN_LAND_1_2+") REFERENCES("+TABLE_LANDTYPE+")" +
//                ", FOREIGN KEY ("+COLUMN_REF_NUTRION_STATUS_2_3+") REFERENCES("+TABLE_NUTRITION_STATUS+"))";
//        String CREATE_SAI_TABLE = "CREATE TABLE " + TABLE_SAI +"("
//                + COLUMN_SAI_1 + " INTEGER PRIMARY KEY," + COLUMN_SAI_REF_COLUMN_CROPS_1_2 + " INTEGER,"+ COLUMN_SAI_REF_NUTRION_STATUS_2_3 + " TEXT,"
//                + COLUMN_SAI_4 + " TEXT,"+ COLUMN_SAI_5 + " TEXT,"+ COLUMN_SAI_6 + " TEXT,"
//                + COLUMN_SAI_7 + " TEXT,"+ COLUMN_SAI_8 + " TEXT,"+ COLUMN_SAI_9 + " TEXT,"
//                + COLUMN_SAI_10 + " TEXT,"+ COLUMN_SAI_11 + " TEXT,"+ COLUMN_SAI_12 + " TEXT,"
//                + COLUMN_SAI_13 + " TEXT,"+ COLUMN_SAI_14 + " TEXT,"+ COLUMN_SAI_15 + " TEXT, FOREIGN KEY ("
//                +COLUMN_SAI_REF_COLUMN_CROPS_1_2+") REFERENCES("+TABLE_CROPS+"), FOREIGN KEY ("
//                +COLUMN_SAI_REF_NUTRION_STATUS_2_3+") REFERENCES("+TABLE_NUTRITION_STATUS+"))";
        String CREATE_SAI_TABLE = "CREATE TABLE " + TABLE_SAI +"("
                + COLUMN_SAI_1 + " INTEGER PRIMARY KEY," + COLUMN_SAI_REF_COLUMN_CROPS_1_2 + " INTEGER,"+ COLUMN_SAI_REF_NUTRION_STATUS_2_3 + " TEXT,"
                + COLUMN_SAI_4 + " TEXT,"+ COLUMN_SAI_5 + " TEXT,"+ COLUMN_SAI_6 + " TEXT,"
                + COLUMN_SAI_7 + " TEXT,"+ COLUMN_SAI_8 + " TEXT,"+ COLUMN_SAI_9 + " TEXT,"
                + COLUMN_SAI_10 + " TEXT,"+ COLUMN_SAI_11 + " TEXT,"+ COLUMN_SAI_12 + " TEXT,"
                + COLUMN_SAI_13 + " TEXT,"+ COLUMN_SAI_14 + " TEXT,"+ COLUMN_SAI_15 + " TEXT)";
        String CREATE_METHODS_TABLE = "CREATE TABLE " + TABLE_METHODS + "("
                + COLUMN_METHODS_1 + " INTEGER PRIMARY KEY," + COLUMN_METHODS_REF_CROP_ID_2 + " TEXT,"+ COLUMN_METHODS_3 + " TEXT)";
try{
    db.execSQL(CREATE_CATEGORY_TABLE);
    db.execSQL(CREATE_NUTRION_STATUS_TABLE);

    db.execSQL(CREATE_LANDTYPE_TABLE);
    db.execSQL(CREATE_CROPS_TABLE);
    db.execSQL(CREATE_LIMITS_TABLE);
    db.execSQL(CREATE_SAI_TABLE);
    db.execSQL(CREATE_METHODS_TABLE);

    Log.d("dbfile","DATABASE CREATED SUCCESSFULLY");
}catch (Exception e)
{
    Log.d("dbfile",""+e);
}

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_SHOPS);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_METHODS);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_SAI);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_LIMITS);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_CROPS);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_LANDTYPE);
        db.execSQL("DROP TABLE IF EXISTS"  + TABLE_NUTRITION_STATUS);
        // Creating tables again
        onCreate(db);
    }
    public void init_nutritionStatus()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(COLUMN_NUTRITION_STATUS_1,"1");
        values.put(COLUMN_NUTRITION_STATUS_2,"vl");
        db.insert(TABLE_NUTRITION_STATUS,null,values);


        values.put(COLUMN_NUTRITION_STATUS_1,"2");
        values.put(COLUMN_NUTRITION_STATUS_2,"l");
        db.insert(TABLE_NUTRITION_STATUS,null,values);


        values.put(COLUMN_NUTRITION_STATUS_1,"3");
        values.put(COLUMN_NUTRITION_STATUS_2,"m");
        db.insert(TABLE_NUTRITION_STATUS,null,values);


        values.put(COLUMN_NUTRITION_STATUS_1,"4");
        values.put(COLUMN_NUTRITION_STATUS_2,"o");
        db.insert(TABLE_NUTRITION_STATUS,null,values);

        Log.d("dbfile","nutrition element initiated");
    }
    public void init_landType()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_LAND_1,"1");
        values.put(COLUMN_LAND_2,"উঁচু জমি");
        db.insert(TABLE_LANDTYPE, null, values);

        values.put(COLUMN_LAND_1,"2");
        values.put(COLUMN_LAND_2,"মাঝারি উঁচু জমি");
        db.insert(TABLE_LANDTYPE, null, values);

        values.put(COLUMN_LAND_1,"3");
        values.put(COLUMN_LAND_2,"নিচু জমি");
        db.insert(TABLE_LANDTYPE, null, values);

        values.put(COLUMN_LAND_1,"4");
        values.put(COLUMN_LAND_2,"মাঝারি নিচু জমি");
        db.insert(TABLE_LANDTYPE, null, values);

        values.put(COLUMN_LAND_1,"5");
        values.put(COLUMN_LAND_2,"অতি নিচু জমি");
        db.insert(TABLE_LANDTYPE, null, values);

        Log.d("dbfile","land type data initiated");
        db.close();
    }
    public void init_method()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(COLUMN_METHODS_1,"1");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"1");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ৪০-৫০ দিন পর জমি স্যাঁতস্যাঁতে থাকা অবস্থায় দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"2");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"2");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ৪০-৫০ দিন পর জমির উপরে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"3");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"3");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ৪০-৫০ দিন পর জমির উপরে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"4");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"66");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি বীজ বপনের পূর্বে, ২য় কিস্তি ও ৩য় কিস্তি বীজ বপনের ৩০-৩৫ দিন ও ৫০-৬০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"5");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"9");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ২৫-৩০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"6");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"10");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ২৫-৩০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"9");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"11");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি ফুল আসার সময়");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"10");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"13");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ২০-২৫ দিন পর, ৩য় কিস্তি ৪০-৪৫ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"11");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"14");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ২০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"12");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"14");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ২০-২৫ দিন পর");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"13");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"28");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ৩০-৩৫ দিন পর");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"14");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"16");
        values.put(COLUMN_METHODS_3,"দুই কিস্তিতে যথাক্রমে চারা রোপনের ১৫ এবং ৩৫ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"15");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"17");
        values.put(COLUMN_METHODS_3,"সমান তিন কিস্তিতে যথাক্রমে চারা রোপনের ১০-১৫, ৩০ এবং ৫০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"16");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"19");
        values.put(COLUMN_METHODS_3,"সমান তিন কিস্তিতে যথাক্রমে চারা রোপনের ১৫, ৩০ এবং ৪৫ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"17");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"20");
        values.put(COLUMN_METHODS_3,"সমান তিন কিস্তিতে যথাক্রমে চারা রোপনের ২০, ৪০ এবং ৬০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"18");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"21");
        values.put(COLUMN_METHODS_3,"তিন কিস্তিতে যথাক্রমে চারা রোপনের ২০, ৪০ ও ৬০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"19");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"22");
        values.put(COLUMN_METHODS_3,"তিন কিস্তিতে যথাক্রমে চারা রোপনের ২০, ৪০ ও ৬০ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"20");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"23");
        values.put(COLUMN_METHODS_3,"দুই কিস্তিতে যথাক্রমে চারা রোপনের ২১ এবং ৩৫ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"21");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"18");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় ও ৩য় কিস্তি বীজ বপনের ৩য় ও ৫ম সপ্তাহে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"22");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"29");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি জমি তৈরীর সময়, ২য় কিস্তি বীজ বপনের ২৫-৩০ দিন পর");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"23");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"30");
        values.put(COLUMN_METHODS_3,"দুটি কিস্তি যথাক্রমে চারা গজানোর ২ এবং ৪ সপ্তাহ পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"24");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"31");
        values.put(COLUMN_METHODS_3,"চার কিস্তিতে যথাক্রমে চারা রোপনের ১৫, ৩৫, ৫৫ ও ৭৫ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"25");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"32");
        values.put(COLUMN_METHODS_3,"চার কিস্তিতে যথাক্রমে চারা রোপনের ১৫, ৩৫, ৫৫ ও ৭৫ দিন পর।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"26");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"59");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, ২য় ও ৩য় কিস্তিতে যথাক্রমে ১৫ এবং ৩৫ দিন পর");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"27");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"60");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, ২য় কিস্তি প্রথম নিড়ানি দেয়ার সময়।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"28");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"61");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, তিন কিস্তিতে যথাক্রমে চারা রোপনের ২০, ৪০ ও ৬০ দিন পর");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"29");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"24");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, বাকি কিস্তি চারা লাগানোর ১২০-১৫০ দিনের মধ্যে প্রয়োগ করতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"30");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"73");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময় এবং ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"31");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"77");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময়, ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"32");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"76");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময়, ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"33");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"75");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময় এবং ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"34");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"64");
        values.put(COLUMN_METHODS_3,"ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, বাকি কিস্তি চারা লাগানোর ১৭-২১ দিনের মধ্যে প্রয়োগ করতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"35");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"65");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি অর্ধেক সার জমি তৈরীর সময়, বাকি কিস্তি চারা লাগানোর ১৭-৪০ দিনের মধ্যে প্রয়োগ করতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"36");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"69");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময়, ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"37");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"74");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময় এবং ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"38");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"71");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- কুশি গজানোর শুরুতে এবং ২য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"39");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"72");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময় এবং ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"40");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"70");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময়, ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);

        values.put(COLUMN_METHODS_1,"41");
        values.put(COLUMN_METHODS_REF_CROP_ID_2,"79");
        values.put(COLUMN_METHODS_3,"১ম কিস্তি- চারা রোপনের ১০-১৫ দিন পর, ২য় কিস্তি- কুশি গজানোর সময়, ৩য় কিস্তি- কাইচ থোড় আসার ৫-৭ দিন পূর্বে ছিটিয়ে দিতে হবে।");
        db.insert(TABLE_METHODS, null, values);


        Log.d("dbfile","all query methods executed");
        db.close();

    }
    public void init_category()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();


        values.put(COLUMN_CAT_1,"1");
        values.put(COLUMN_CAT_2,"আঁশ জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"2");
        values.put(COLUMN_CAT_2,"চিনি জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"3");
        values.put(COLUMN_CAT_2,"ডাল জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"4");
        values.put(COLUMN_CAT_2,"তৈল জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"5");
        values.put(COLUMN_CAT_2,"ফল জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"6");
        values.put(COLUMN_CAT_2,"মসলা জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"7");
        values.put(COLUMN_CAT_2,"শস্য জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);

        values.put(COLUMN_CAT_1,"8");
        values.put(COLUMN_CAT_2,"শাক ও সবজি জাতীয় ফসল");
        db.insert(TABLE_CATEGORY, null, values);


        Log.d("dbfile","all query category executed");
        db.close();

    }
    public void init_crops()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(COLUMN_CROPS_1,"1");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"1");
        values.put(COLUMN_CROPS_3,"পাট (তোষা পাট-২(ও-৯৮৯৭),বিজেআরআই তোষা পাট-৩(ওএম-১)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"2");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"1");
        values.put(COLUMN_CROPS_3,"মেস্তা");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"3");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"1");
        values.put(COLUMN_CROPS_3,"কার্পাস");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"4");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"3");
        values.put(COLUMN_CROPS_3,"মসুর (বারি মসুর-১, ২, ৩, ৪)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"5");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"3");
        values.put(COLUMN_CROPS_3,"ছোলা (বারি সোলা-২, ৩, ৪, ৫, ৬ এবং বিনা সোলা-২)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"6");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"3");
        values.put(COLUMN_CROPS_3,"মুগ (বারি মুগ-২, ৩, ৪, ৫ বিনা মুগ-৪, ৫ এবং বাউ মুগ");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"9");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"সরিষা (দৌলত, বারি সরিষা ৭, ৮, ১০, ১১, ১৩, রাই-৫");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"10");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"তিল (বারি তিল-১, ২, ৩ এবং বিনা তিল-১)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"11");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"চীনাবাদাম(বারি চীনাবাদাম-৫, ৬ বিনা চীনাবাদাম-১, ২ ও ৩)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"12");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"সয়াবিন");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"13");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"সূর্যমুখী (কিরনী (ডিএস-১))");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"14");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"তিসি");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"15");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"4");
        values.put(COLUMN_CROPS_3,"নাইজারনদী");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"16");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"বাঁধাকপি(বারি বাঁধাকপি-১-প্রভাতি, বারি বাঁধাকপি-২-");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"17");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"ফুলকপি (বারি ফুলকপি-১(রুপা) ও অন্যান্য জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"18");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"গাজর (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"19");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"ব্রোকলি");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"20");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"টমেটো (মানিক, রতন, বারি টমেটো-৩, ৪, ৫, ৬, ৭, ৮, ৯,");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"21");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"বেগুন (উত্তরা, তারাপুরী, কাজলা ও বারি বেগুন-৫(নয়নত");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"22");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"ঢেঁড়স (বারি ঢেঁড়স-১ ও অন্যান্য জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"23");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"মুলা (বারি মুলা-১(তাসাকিসান মুলা), বারি মুলা-২(পিং");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"24");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"2");
        values.put(COLUMN_CROPS_3,"ইক্ষু/আখ (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"25");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"3");
        values.put(COLUMN_CROPS_3,"মটরশুটি (বারি মটরশুটি-১, ২, ৩ এবং ইপ্সা মটরশুটি-১,");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"26");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"3");
        values.put(COLUMN_CROPS_3,"মাসকলাই (বারি মাষ-১, ২, ৩ এবং বিনা মাষ-১)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"28");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"আলু (হীরা, আইলসা, ডায়মন্ট, কার্ডিনাল, বারি আলু-১১,");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"29");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"সীম (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"30");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"বরবটি (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"31");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"মিষ্টিকুমড়া (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"32");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"8");
        values.put(COLUMN_CROPS_3,"লাউ (বারি লাউ-১ এবং অন্যান্য সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"43");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"কলা (বারি কলা-১, ২ ও অন্যান্য জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"44");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"আম(বারি-১,২,৩, বারি-৪ (হাইব্রিড), বারি-৫,৬,৭,৮,৯ এ");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"46");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"কাঁঠাল (বারি-১,২,বাউ-১ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"47");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"পেয়ারা (কাজী,বারি-২,৩,৫,৭,বাউ-৮,৯ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"48");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"লিচু (বারি-১,২,৩,৪, বাউ-২,৩,৪ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"49");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"নারিকেল (বারি-১,২ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"51");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"কমলা (বারি-১ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"52");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"মাল্টা (বারি-১,বাউ-১)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"54");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"সাতকরা (বারি-১ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"56");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"কুল (বাউ-১,২,৩ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"58");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"দেশি আমড়া (বারি-২ এবং অন্যান্য)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"59");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"5");
        values.put(COLUMN_CROPS_3,"পেঁয়াজ (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"60");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"6");
        values.put(COLUMN_CROPS_3,"রসুন (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"61");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"6");
        values.put(COLUMN_CROPS_3,"মরিচ(বারি মরিচ-১ ও অন্যান্য সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"62");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"6");
        values.put(COLUMN_CROPS_3,"হলুদ (ডিমলা, সিন্দুরী ও বারি হলুদ-৩)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"63");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"6");
        values.put(COLUMN_CROPS_3,"আদা (সকল জাত সমূহ)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"64");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"গম (সেচসহ) (কাঞ্চন, গৌরব, প্রতিভা, সৌরভ, অগ্রনী এব");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"65");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"গম (বৃষ্টি নির্ভর) (কাঞ্চন, আকবর, গৌরব, প্রতিভা, স");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"66");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"ভুট্টা (হাইব্রিড)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"69");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"রোপা আউশ (বিআর-৬, ২০, ২১ এবং ২৪)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"70");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"রোপা আউশ (বিআর-১, ২, ৩, ৭, ৮, ৯, ১৪, ১৬, ২৬ এবং ব্");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"71");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"আউশ (স্থানীয় উন্নত জাত)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"72");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"রোপা আমন (বি আর-৪, ১০, ১১, ২২, ২৩, ব্রিধান-৩০, ৩১,");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"73");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"রোপা আমন (বি আর-২৫, ব্রিধান-৩৩, ব্রিধান-৩৯ এবং বিন");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"74");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"রোপা আমন (বি আর-৫, ব্রিধান-৩৪, ৩৭ এবং ৩৮)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"75");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"রোপা আমন (স্থানীয় উন্নত জাত)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"76");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"বোরো (ব্রিধান-২৯, বিনাধান-৬ এবং হাইব্রিড)");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"77");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"বোরো (বিআর-৩, ৮, ৯, ১৪, ১৬, ১৭, ১৮, ১৯ এবং বিনাধান");
        db.insert(TABLE_CROPS, null, values);

        values.put(COLUMN_CROPS_1,"79");
        values.put(COLUMN_CROPS_REF_COLUMN_CAT_1_2,"7");
        values.put(COLUMN_CROPS_3,"বোরো (স্থানীয় উন্নত জাত)");
        db.insert(TABLE_CROPS, null, values);
        Log.d("dbfile","crops data initiated");
        db.close();



    }
    public void init_limit()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_LIMITS_1,"1");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"1");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0");

        values.put(COLUMN_LIMITS_6,"7.5");

        values.put(COLUMN_LIMITS_7,"0");

        values.put(COLUMN_LIMITS_8,"0.09");

        values.put(COLUMN_LIMITS_9,"0");

        values.put(COLUMN_LIMITS_10,"7.5");

        values.put(COLUMN_LIMITS_11,"0");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"0");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "2");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"1");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0.091");

        values.put(COLUMN_LIMITS_6,"7.5");

        values.put(COLUMN_LIMITS_7,"7.51");

        values.put(COLUMN_LIMITS_8,"0.09");

        values.put(COLUMN_LIMITS_9,"0.091");

        values.put(COLUMN_LIMITS_10,"7.5");

        values.put(COLUMN_LIMITS_11,"7.51");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"0.451");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0.151");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "3");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"1");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0.181");

        values.put(COLUMN_LIMITS_6,"7.5");

        values.put(COLUMN_LIMITS_7,"15.1");

        values.put(COLUMN_LIMITS_8,"0.09");

        values.put(COLUMN_LIMITS_9,"0.181");

        values.put(COLUMN_LIMITS_10,"7.5");

        values.put(COLUMN_LIMITS_11,"15.1");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"0.91");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0.31");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "4");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"1");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0.271");

        values.put(COLUMN_LIMITS_6,"7.5");

        values.put(COLUMN_LIMITS_7,"22.51");

        values.put(COLUMN_LIMITS_8,"0.09");

        values.put(COLUMN_LIMITS_9,"0.271");

        values.put(COLUMN_LIMITS_10,"7.5");

        values.put(COLUMN_LIMITS_11,"22.51");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"1.351");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0.451");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "5");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"2");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_LIMITS_4,"0.075");

        values.put(COLUMN_LIMITS_5,"0");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"0");

        values.put(COLUMN_LIMITS_8,"0.06");

        values.put(COLUMN_LIMITS_9,"0");

        values.put(COLUMN_LIMITS_10,"6");

        values.put(COLUMN_LIMITS_11,"0");

        values.put(COLUMN_LIMITS_12,"0.375");

        values.put(COLUMN_LIMITS_13,"0");

        values.put(COLUMN_LIMITS_14,"0.12");

        values.put(COLUMN_LIMITS_15,"0");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "6");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"2");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_LIMITS_4,"0.075");

        values.put(COLUMN_LIMITS_5,"0.076");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"6.1");

        values.put(COLUMN_LIMITS_8,"0.06");

        values.put(COLUMN_LIMITS_9,"0.061");

        values.put(COLUMN_LIMITS_10,"6");

        values.put(COLUMN_LIMITS_11,"6.1");

        values.put(COLUMN_LIMITS_12,"0.375");

        values.put(COLUMN_LIMITS_13,"0.376");

        values.put(COLUMN_LIMITS_14,"0.12");

        values.put(COLUMN_LIMITS_15,"0.121");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "7");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"2");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_LIMITS_4,"0.075");

        values.put(COLUMN_LIMITS_5,"0.151");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"12.1");

        values.put(COLUMN_LIMITS_8,"0.06");

        values.put(COLUMN_LIMITS_9,"0.121");

        values.put(COLUMN_LIMITS_10,"6");

        values.put(COLUMN_LIMITS_11,"12.1");

        values.put(COLUMN_LIMITS_12,"0.375");

        values.put(COLUMN_LIMITS_13,"0.751");

        values.put(COLUMN_LIMITS_14,"0.12");

        values.put(COLUMN_LIMITS_15,"0.241");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "8");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"2");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_LIMITS_4,"0.075");

        values.put(COLUMN_LIMITS_5,"0.227");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"18.1");

        values.put(COLUMN_LIMITS_8,"0.06");

        values.put(COLUMN_LIMITS_9,"0.181");

        values.put(COLUMN_LIMITS_10,"6");

        values.put(COLUMN_LIMITS_11,"18.1");

        values.put(COLUMN_LIMITS_12,"0.375");

        values.put(COLUMN_LIMITS_13,"1.126");

        values.put(COLUMN_LIMITS_14,"0.12");

        values.put(COLUMN_LIMITS_15,"0.361");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "9");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"3");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"0");

        values.put(COLUMN_LIMITS_8,"0.075");

        values.put(COLUMN_LIMITS_9,"0");

        values.put(COLUMN_LIMITS_10,"9");

        values.put(COLUMN_LIMITS_11,"0");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"0");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "10");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"3");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0.091");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"6.1");

        values.put(COLUMN_LIMITS_8,"0.075");

        values.put(COLUMN_LIMITS_9,"0.076");

        values.put(COLUMN_LIMITS_10,"9");

        values.put(COLUMN_LIMITS_11,"9.1");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"0.451");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0.151");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "11");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"3");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0.181");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"12.1");

        values.put(COLUMN_LIMITS_8,"0.075");

        values.put(COLUMN_LIMITS_9,"0.151");

        values.put(COLUMN_LIMITS_10,"9");

        values.put(COLUMN_LIMITS_11,"18.1");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"0.91");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0.31");

        db.insert(TABLE_LIMITS, null, values);
        values.put(COLUMN_LIMITS_1,
                "12");

        values.put(COLUMN_LIMITS_REF_COLUMN_LAND_1_2,"3");

        values.put(COLUMN_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_LIMITS_4,"0.09");

        values.put(COLUMN_LIMITS_5,"0.271");

        values.put(COLUMN_LIMITS_6,"6");

        values.put(COLUMN_LIMITS_7,"18.1");

        values.put(COLUMN_LIMITS_8,"0.075");

        values.put(COLUMN_LIMITS_9,"0.226");

        values.put(COLUMN_LIMITS_10,"9");

        values.put(COLUMN_LIMITS_11,"27.1");

        values.put(COLUMN_LIMITS_12,"0.45");

        values.put(COLUMN_LIMITS_13,"1.351");

        values.put(COLUMN_LIMITS_14,"0.15");

        values.put(COLUMN_LIMITS_15,"0.451");

        db.insert(TABLE_LIMITS, null, values);
        Log.d("dbfile","all query limits executed");
        db.close();
    }
    public void init_sai()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_SAI_1,"1");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"1");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"25");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"4");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"13");

        values.put(COLUMN_SAI_9,"13");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "2");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"1");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"26");

        values.put(COLUMN_SAI_9,"13");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "3");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"1");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"75");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"39");

        values.put(COLUMN_SAI_9,"13");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "4");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"1");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"52");

        values.put(COLUMN_SAI_9,"13");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "5");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"2");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"25");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"11");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "6");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"2");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"22");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "7");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"2");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"75");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"33");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "8");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"2");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"44");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "9");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"3");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"6");

        values.put(COLUMN_SAI_7,"6");

        values.put(COLUMN_SAI_8,"17");

        values.put(COLUMN_SAI_9,"17");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "10");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"3");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"6");

        values.put(COLUMN_SAI_8,"34");

        values.put(COLUMN_SAI_9,"17");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "11");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"3");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"18");

        values.put(COLUMN_SAI_7,"6");

        values.put(COLUMN_SAI_8,"51");

        values.put(COLUMN_SAI_9,"17");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "12");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"3");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"6");

        values.put(COLUMN_SAI_8,"68");

        values.put(COLUMN_SAI_9,"17");

        values.put(COLUMN_SAI_10,"0");

        values.put(COLUMN_SAI_11,"0");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "13");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"4");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"6");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"10");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "14");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"4");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"12");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "15");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"4");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"18");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"18");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "16");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"4");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"24");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "17");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"5");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"11");

        values.put(COLUMN_SAI_5,"11");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"15");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"7");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "18");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"5");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"22");

        values.put(COLUMN_SAI_5,"11");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"14");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "19");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"5");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"33");

        values.put(COLUMN_SAI_5,"11");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"45");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"21");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "20");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"5");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"44");

        values.put(COLUMN_SAI_5,"11");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"28");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "21");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"6");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"6");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"9");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"12");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "22");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"6");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"12");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"18");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"24");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "23");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"6");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"18");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"27");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"36");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"18");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "24");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"6");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"24");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"48");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "25");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"9");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"9");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "26");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"9");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"18");

        values.put(COLUMN_SAI_11,"9");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "27");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"9");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"27");

        values.put(COLUMN_SAI_11,"9");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "28");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"9");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"160");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"36");

        values.put(COLUMN_SAI_11,"9");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "29");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"10");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"26");

        values.put(COLUMN_SAI_5,"26");

        values.put(COLUMN_SAI_6,"9");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"16");

        values.put(COLUMN_SAI_9,"16");

        values.put(COLUMN_SAI_10,"7");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "30");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"10");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"52");

        values.put(COLUMN_SAI_5,"26");

        values.put(COLUMN_SAI_6,"18");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"32");

        values.put(COLUMN_SAI_9,"16");

        values.put(COLUMN_SAI_10,"14");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"1.3");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "31");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"10");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"78");

        values.put(COLUMN_SAI_5,"26");

        values.put(COLUMN_SAI_6,"27");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"48");

        values.put(COLUMN_SAI_9,"16");

        values.put(COLUMN_SAI_10,"21");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"2.6");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "32");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"10");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"104");

        values.put(COLUMN_SAI_5,"26");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"64");

        values.put(COLUMN_SAI_9,"16");

        values.put(COLUMN_SAI_10,"28");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"3.9");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "33");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"11");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"15");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"12");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "34");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"11");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"12");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.7");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "35");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"11");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"36");

        values.put(COLUMN_SAI_11,"12");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.4");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "36");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"11");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"48");

        values.put(COLUMN_SAI_11,"12");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"2.1");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "37");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"12");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"8");

        values.put(COLUMN_SAI_5,"8");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "38");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"12");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"16");

        values.put(COLUMN_SAI_5,"8");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "39");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"12");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"24");

        values.put(COLUMN_SAI_5,"8");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "40");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"12");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"32");

        values.put(COLUMN_SAI_5,"8");

        values.put(COLUMN_SAI_6,"40");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "41");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"13");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"43");

        values.put(COLUMN_SAI_5,"43");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"7");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "42");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"13");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"86");

        values.put(COLUMN_SAI_5,"43");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"14");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.8");

        values.put(COLUMN_SAI_15,"0.8");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "43");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"13");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"129");

        values.put(COLUMN_SAI_5,"43");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"21");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.6");

        values.put(COLUMN_SAI_15,"0.8");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "44");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"13");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"172");

        values.put(COLUMN_SAI_5,"43");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"28");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"2.4");

        values.put(COLUMN_SAI_15,"0.8");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "45");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"14");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"15");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"8");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "46");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"14");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"16");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "47");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"14");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"24");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "48");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"14");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"32");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "49");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"15");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"15");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"8");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "50");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"15");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"16");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "51");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"15");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"24");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "52");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"15");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"32");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "53");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"16");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"60");

        values.put(COLUMN_SAI_6,"22");

        values.put(COLUMN_SAI_7,"22");

        values.put(COLUMN_SAI_8,"25");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"8");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "54");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"16");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"60");

        values.put(COLUMN_SAI_6,"44");

        values.put(COLUMN_SAI_7,"22");

        values.put(COLUMN_SAI_8,"50");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"16");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "55");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"16");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"180");

        values.put(COLUMN_SAI_5,"60");

        values.put(COLUMN_SAI_6,"66");

        values.put(COLUMN_SAI_7,"22");

        values.put(COLUMN_SAI_8,"75");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "56");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"16");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"240");

        values.put(COLUMN_SAI_5,"60");

        values.put(COLUMN_SAI_6,"88");

        values.put(COLUMN_SAI_7,"22");

        values.put(COLUMN_SAI_8,"100");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"32");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "57");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"17");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"20");

        values.put(COLUMN_SAI_8,"38");

        values.put(COLUMN_SAI_9,"38");

        values.put(COLUMN_SAI_10,"7");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "58");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"17");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"40");

        values.put(COLUMN_SAI_7,"20");

        values.put(COLUMN_SAI_8,"76");

        values.put(COLUMN_SAI_9,"38");

        values.put(COLUMN_SAI_10,"14");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.3");

        values.put(COLUMN_SAI_15,"0.3");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "59");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"17");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"60");

        values.put(COLUMN_SAI_7,"20");

        values.put(COLUMN_SAI_8,"104");

        values.put(COLUMN_SAI_9,"38");

        values.put(COLUMN_SAI_10,"21");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.6");

        values.put(COLUMN_SAI_15,"0.3");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "60");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"17");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"160");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"80");

        values.put(COLUMN_SAI_7,"20");

        values.put(COLUMN_SAI_8,"152");

        values.put(COLUMN_SAI_9,"38");

        values.put(COLUMN_SAI_10,"28");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.9");

        values.put(COLUMN_SAI_15,"0.3");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "61");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"18");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"13");

        values.put(COLUMN_SAI_7,"13");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"8");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "62");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"18");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"26");

        values.put(COLUMN_SAI_7,"13");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"16");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "63");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"18");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"26");

        values.put(COLUMN_SAI_7,"13");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "64");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"18");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"39");

        values.put(COLUMN_SAI_7,"13");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"32");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "65");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"19");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"35");

        values.put(COLUMN_SAI_5,"35");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "66");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"19");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"70");

        values.put(COLUMN_SAI_5,"35");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.6");

        values.put(COLUMN_SAI_15,"0.6");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "67");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"19");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"105");

        values.put(COLUMN_SAI_5,"35");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"18");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.2");

        values.put(COLUMN_SAI_15,"0.6");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "68");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"19");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"140");

        values.put(COLUMN_SAI_5,"35");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.8");

        values.put(COLUMN_SAI_15,"0.6");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "69");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"20");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"25");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "70");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"20");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"50");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "71");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"20");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"135");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"45");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"75");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "72");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"20");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"180");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"60");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"100");

        values.put(COLUMN_SAI_9,"25");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "73");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"21");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "74");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"21");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"28");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "75");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"21");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "76");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"21");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"160");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "77");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"22");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "78");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"22");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.7");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "79");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"22");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.4");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "80");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"22");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"40");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"2.1");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "81");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"23");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"8");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "82");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"23");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"16");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "83");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"23");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"150");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"45");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "84");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"23");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"200");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"60");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"160");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"32");

        values.put(COLUMN_SAI_11,"8");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "85");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"25");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"16");

        values.put(COLUMN_SAI_5,"16");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"10");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"4");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "86");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"25");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"32");

        values.put(COLUMN_SAI_5,"16");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"8");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"0.7");

        values.put(COLUMN_SAI_13,"0.7");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "87");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"25");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"48");

        values.put(COLUMN_SAI_5,"16");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"1.4");

        values.put(COLUMN_SAI_13,"0.7");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "88");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"25");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"64");

        values.put(COLUMN_SAI_5,"16");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"10");

        values.put(COLUMN_SAI_10,"16");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"2.1");

        values.put(COLUMN_SAI_13,"0.7");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "89");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"26");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"6");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"6");

        values.put(COLUMN_SAI_9,"6");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "90");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"26");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"12");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"12");

        values.put(COLUMN_SAI_9,"6");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "91");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"26");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"18");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"18");

        values.put(COLUMN_SAI_9,"6");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "92");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"26");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"24");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"24");

        values.put(COLUMN_SAI_9,"6");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "93");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"28");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"45");

        values.put(COLUMN_SAI_9,"45");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "94");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"28");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"45");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"2");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "95");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"28");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"135");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"135");

        values.put(COLUMN_SAI_9,"45");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"4");

        values.put(COLUMN_SAI_13,"2");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "96");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"28");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"180");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"40");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"180");

        values.put(COLUMN_SAI_9,"45");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"6");

        values.put(COLUMN_SAI_13,"2");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "97");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"29");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"15");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"15");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "98");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"29");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "99");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"29");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"45");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "100");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"29");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"40");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "101");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"30");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"6");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"9");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"11");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "102");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"30");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"12");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"18");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"22");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.6");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0.6");

        values.put(COLUMN_SAI_15,"0.6");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "103");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"30");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"18");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"27");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"33");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.2");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"1.2");

        values.put(COLUMN_SAI_15,"0.6");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "104");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"30");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"24");

        values.put(COLUMN_SAI_5,"6");

        values.put(COLUMN_SAI_6,"26");

        values.put(COLUMN_SAI_7,"9");

        values.put(COLUMN_SAI_8,"44");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"2");

        values.put(COLUMN_SAI_15,"0.6");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "105");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"31");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"25");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"7");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "106");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"31");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"14");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.7");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "107");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"31");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"75");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"21");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.4");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "108");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"31");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"28");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"2.1");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "109");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"32");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"25");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"7");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "110");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"32");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"14");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.7");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "111");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"32");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"75");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"21");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.4");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "112");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"32");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"28");

        values.put(COLUMN_SAI_11,"7");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"2.1");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "113");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"59");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "114");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"59");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.7");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "115");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"59");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"45");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"30");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1.4");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "116");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"59");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"60");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"160");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"40");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"2.1");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "117");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"60");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"38");

        values.put(COLUMN_SAI_5,"38");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"15");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"1");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "118");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"60");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"76");

        values.put(COLUMN_SAI_5,"38");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"30");

        values.put(COLUMN_SAI_11,"15");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"2");

        values.put(COLUMN_SAI_15,"1");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "119");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"60");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"114");

        values.put(COLUMN_SAI_5,"38");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"45");

        values.put(COLUMN_SAI_11,"15");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"3");

        values.put(COLUMN_SAI_15,"1");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "120");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"60");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"152");

        values.put(COLUMN_SAI_5,"38");

        values.put(COLUMN_SAI_6,"64");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"60");

        values.put(COLUMN_SAI_11,"15");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"3");

        values.put(COLUMN_SAI_15,"1");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "121");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"61");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"32");

        values.put(COLUMN_SAI_5,"32");

        values.put(COLUMN_SAI_6,"19");

        values.put(COLUMN_SAI_7,"19");

        values.put(COLUMN_SAI_8,"32");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "122");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"61");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"64");

        values.put(COLUMN_SAI_5,"32");

        values.put(COLUMN_SAI_6,"38");

        values.put(COLUMN_SAI_7,"19");

        values.put(COLUMN_SAI_8,"64");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "123");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"61");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"96");

        values.put(COLUMN_SAI_5,"32");

        values.put(COLUMN_SAI_6,"57");

        values.put(COLUMN_SAI_7,"19");

        values.put(COLUMN_SAI_8,"96");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "124");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"61");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"128");

        values.put(COLUMN_SAI_5,"32");

        values.put(COLUMN_SAI_6,"76");

        values.put(COLUMN_SAI_7,"19");

        values.put(COLUMN_SAI_8,"128");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "125");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"62");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"35");

        values.put(COLUMN_SAI_9,"35");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "126");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"62");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"70");

        values.put(COLUMN_SAI_9,"35");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "127");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"62");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"36");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"105");

        values.put(COLUMN_SAI_9,"35");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "128");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"62");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"160");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"12");

        values.put(COLUMN_SAI_8,"140");

        values.put(COLUMN_SAI_9,"35");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "129");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"63");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "130");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"63");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "131");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"63");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"45");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "132");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"63");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"160");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"60");

        values.put(COLUMN_SAI_7,"15");

        values.put(COLUMN_SAI_8,"160");

        values.put(COLUMN_SAI_9,"40");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"4.5");

        values.put(COLUMN_SAI_13,"1.5");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "133");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"64");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "134");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"64");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1.3");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"0.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "135");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"64");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"30");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2.6");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"1");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "136");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"64");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"160");

        values.put(COLUMN_SAI_5,"40");

        values.put(COLUMN_SAI_6,"40");

        values.put(COLUMN_SAI_7,"10");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3.9");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"1.5");

        values.put(COLUMN_SAI_15,"0.5");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "137");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"65");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"15");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"12");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"2.5");

        values.put(COLUMN_SAI_11,"2.5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "138");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"65");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"24");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"2.5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0.4");

        values.put(COLUMN_SAI_15,"0.4");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "139");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"65");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"36");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"7.5");

        values.put(COLUMN_SAI_11,"2.5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0.8");

        values.put(COLUMN_SAI_15,"0.4");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "140");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"65");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"48");

        values.put(COLUMN_SAI_9,"12");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"2.5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"1.2");

        values.put(COLUMN_SAI_15,"0.4");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "141");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"66");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"32");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "142");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"66");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"64");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"1.4");

        values.put(COLUMN_SAI_13,"1.4");

        values.put(COLUMN_SAI_14,"0.7");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "143");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"66");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"150");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"48");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"96");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"30");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"2.8");

        values.put(COLUMN_SAI_13,"1.4");

        values.put(COLUMN_SAI_14,"1.4");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "144");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"66");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"200");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"64");

        values.put(COLUMN_SAI_7,"16");

        values.put(COLUMN_SAI_8,"128");

        values.put(COLUMN_SAI_9,"32");

        values.put(COLUMN_SAI_10,"40");

        values.put(COLUMN_SAI_11,"10");

        values.put(COLUMN_SAI_12,"4.2");

        values.put(COLUMN_SAI_13,"1.4");

        values.put(COLUMN_SAI_14,"2.1");

        values.put(COLUMN_SAI_15,"0.7");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "145");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"69");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"17");

        values.put(COLUMN_SAI_5,"17");

        values.put(COLUMN_SAI_6,"4");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"11");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "146");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"69");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"34");

        values.put(COLUMN_SAI_5,"17");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"22");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.6");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "147");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"69");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"51");

        values.put(COLUMN_SAI_5,"17");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"33");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.2");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "148");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"69");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"68");

        values.put(COLUMN_SAI_5,"17");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"44");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.8");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "149");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"70");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"25");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"15");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "150");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"70");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.6");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "151");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"70");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"75");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"45");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.2");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "152");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"70");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"25");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.8");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "153");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"71");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"10");

        values.put(COLUMN_SAI_5,"10");

        values.put(COLUMN_SAI_6,"3");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"8");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"2");

        values.put(COLUMN_SAI_11,"2");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "154");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"71");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"20");

        values.put(COLUMN_SAI_5,"10");

        values.put(COLUMN_SAI_6,"6");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"16");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"4");

        values.put(COLUMN_SAI_11,"2");

        values.put(COLUMN_SAI_12,"0.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "155");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"71");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"10");

        values.put(COLUMN_SAI_6,"9");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"24");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"2");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "156");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"71");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"10");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"32");

        values.put(COLUMN_SAI_9,"8");

        values.put(COLUMN_SAI_10,"8");

        values.put(COLUMN_SAI_11,"2");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "157");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"72");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"5");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"4");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "158");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"72");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"10");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"8");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"0.7");

        values.put(COLUMN_SAI_13,"0.7");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "159");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"72");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"15");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"1.4");

        values.put(COLUMN_SAI_13,"0.7");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "160");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"72");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"120");

        values.put(COLUMN_SAI_5,"30");

        values.put(COLUMN_SAI_6,"20");

        values.put(COLUMN_SAI_7,"5");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"16");

        values.put(COLUMN_SAI_11,"4");

        values.put(COLUMN_SAI_12,"2.1");

        values.put(COLUMN_SAI_13,"0.7");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "161");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"73");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"20");

        values.put(COLUMN_SAI_5,"20");

        values.put(COLUMN_SAI_6,"4");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"20");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "162");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"73");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"40");

        values.put(COLUMN_SAI_5,"20");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"40");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.6");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "163");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"73");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"20");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.2");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "164");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"73");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"80");

        values.put(COLUMN_SAI_5,"20");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"80");

        values.put(COLUMN_SAI_9,"20");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.8");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "165");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"74");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"13");

        values.put(COLUMN_SAI_5,"13");

        values.put(COLUMN_SAI_6,"3");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"15");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "166");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"74");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"26");

        values.put(COLUMN_SAI_5,"13");

        values.put(COLUMN_SAI_6,"6");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "167");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"74");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"39");

        values.put(COLUMN_SAI_5,"13");

        values.put(COLUMN_SAI_6,"9");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"45");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "168");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"74");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"52");

        values.put(COLUMN_SAI_5,"13");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"15");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "169");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"75");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"15");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"3");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"11");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "170");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"75");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"30");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"6");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"22");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "171");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"75");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"9");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"9");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "172");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"75");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"60");

        values.put(COLUMN_SAI_5,"15");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"3");

        values.put(COLUMN_SAI_8,"44");

        values.put(COLUMN_SAI_9,"11");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.5");

        values.put(COLUMN_SAI_13,"0.5");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "173");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"76");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"50");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"33");

        values.put(COLUMN_SAI_9,"33");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "174");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"76");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"100");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"66");

        values.put(COLUMN_SAI_9,"33");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"1.3");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "175");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"76");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"150");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"24");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"99");

        values.put(COLUMN_SAI_9,"33");

        values.put(COLUMN_SAI_10,"18");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"2.6");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "176");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"76");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"200");

        values.put(COLUMN_SAI_5,"50");

        values.put(COLUMN_SAI_6,"32");

        values.put(COLUMN_SAI_7,"8");

        values.put(COLUMN_SAI_8,"132");

        values.put(COLUMN_SAI_9,"33");

        values.put(COLUMN_SAI_10,"24");

        values.put(COLUMN_SAI_11,"6");

        values.put(COLUMN_SAI_12,"3.9");

        values.put(COLUMN_SAI_13,"1.3");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "177");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"77");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"45");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"7");

        values.put(COLUMN_SAI_7,"7");

        values.put(COLUMN_SAI_8,"30");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"5");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "178");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"77");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"90");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"14");

        values.put(COLUMN_SAI_7,"7");

        values.put(COLUMN_SAI_8,"60");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"10");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"1");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "179");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"77");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"135");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"21");

        values.put(COLUMN_SAI_7,"7");

        values.put(COLUMN_SAI_8,"90");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"15");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"2");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "180");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"77");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"180");

        values.put(COLUMN_SAI_5,"45");

        values.put(COLUMN_SAI_6,"28");

        values.put(COLUMN_SAI_7,"7");

        values.put(COLUMN_SAI_8,"120");

        values.put(COLUMN_SAI_9,"30");

        values.put(COLUMN_SAI_10,"20");

        values.put(COLUMN_SAI_11,"5");

        values.put(COLUMN_SAI_12,"3");

        values.put(COLUMN_SAI_13,"1");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "181");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"79");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"o");

        values.put(COLUMN_SAI_4,"23");

        values.put(COLUMN_SAI_5,"23");

        values.put(COLUMN_SAI_6,"4");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"14");

        values.put(COLUMN_SAI_9,"14");

        values.put(COLUMN_SAI_10,"3");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0");

        values.put(COLUMN_SAI_13,"0");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "182");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"79");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"m");

        values.put(COLUMN_SAI_4,"46");

        values.put(COLUMN_SAI_5,"23");

        values.put(COLUMN_SAI_6,"8");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"28");

        values.put(COLUMN_SAI_9,"14");

        values.put(COLUMN_SAI_10,"6");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"0.6");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "183");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"79");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"l");

        values.put(COLUMN_SAI_4,"69");

        values.put(COLUMN_SAI_5,"23");

        values.put(COLUMN_SAI_6,"12");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"42");

        values.put(COLUMN_SAI_9,"14");

        values.put(COLUMN_SAI_10,"9");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.2");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        values.put(COLUMN_SAI_1,
                "184");

        values.put(COLUMN_SAI_REF_COLUMN_CROPS_1_2,"79");

        values.put(COLUMN_SAI_REF_NUTRION_STATUS_2_3,"vl");

        values.put(COLUMN_SAI_4,"92");

        values.put(COLUMN_SAI_5,"23");

        values.put(COLUMN_SAI_6,"16");

        values.put(COLUMN_SAI_7,"4");

        values.put(COLUMN_SAI_8,"56");

        values.put(COLUMN_SAI_9,"14");

        values.put(COLUMN_SAI_10,"12");

        values.put(COLUMN_SAI_11,"3");

        values.put(COLUMN_SAI_12,"1.8");

        values.put(COLUMN_SAI_13,"0.6");

        values.put(COLUMN_SAI_14,"0");

        values.put(COLUMN_SAI_15,"0");

        db.insert(TABLE_SAI, null, values);
        Log.d("dbfile","all query sai executed");
        db.close();
    }
    // Adding new shop
    public void insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CAT_1, "1"); // Shop Name
        values.put(COLUMN_CAT_2, "sample"); // Shop Phone Number
// Inserting Row
        db.insert(TABLE_SHOPS, null, values);
        db.close(); // Closing database connection
    }

    // Updating a shop
    public int updateShop(String id,String name,String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_SH_ADDR, address);
// updating row
        return db.update(TABLE_SHOPS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    // Deleting a shop
    public void deleteShop(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOPS, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }


    public Cursor getAllData(String tbl_name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+tbl_name,null);
        return res;
    }

    public Cursor getCategory()
    {

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor res=db.rawQuery("SELECT * FROM tbl_cat",null);

        return res;
    }

    public Cursor geAllCrops(int id)
    {

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_CROPS+" WHERE "+COLUMN_CROPS_REF_COLUMN_CAT_1_2+" ="+id,null);

        return res;
    }

    public Cursor getAllNutritionStatus()
    {

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_NUTRITION_STATUS,null);

        return res;
    }
    public Cursor getAllSoilType()
    {

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_LANDTYPE,null);

        return res;
    }


    public Cursor getSingleDataById(String parameter,String tbl_name,String col,String value)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT "+parameter+" FROM "+tbl_name+" WHERE "+col+"="+value,null);
        return res;
    }
    public Cursor getSt(String nutrition,int soilId)
    {
        Cursor res=null;
        SQLiteDatabase db=this.getReadableDatabase();
        if(nutrition.equals("ni"))
        {
            res=db.rawQuery("SELECT "+COLUMN_REF_NUTRION_STATUS_2_3+","+COLUMN_LIMITS_4+","+COLUMN_LIMITS_5+" FROM "+TABLE_LIMITS+" WHERE "+COLUMN_LAND_1+"="+soilId+" ORDER BY "+COLUMN_LIMITS_5,null);

        }
        else  if(nutrition.equals("ph"))
        {
            res=db.rawQuery("SELECT "+COLUMN_REF_NUTRION_STATUS_2_3+","+COLUMN_LIMITS_6+","+COLUMN_LIMITS_7+" FROM "+TABLE_LIMITS+" WHERE "+COLUMN_LAND_1+"="+soilId+" ORDER BY "+COLUMN_LIMITS_7,null);

        }
        else  if(nutrition.equals("ka"))
        {
            res=db.rawQuery("SELECT "+COLUMN_REF_NUTRION_STATUS_2_3+","+COLUMN_LIMITS_8+","+COLUMN_LIMITS_9+" FROM "+TABLE_LIMITS+" WHERE "+COLUMN_LAND_1+"="+soilId+" ORDER BY "+COLUMN_LIMITS_9,null);

        }
        else  if(nutrition.equals("sa"))
        {
            res=db.rawQuery("SELECT "+COLUMN_REF_NUTRION_STATUS_2_3+","+COLUMN_LIMITS_10+","+COLUMN_LIMITS_11+" FROM "+TABLE_LIMITS+" WHERE "+COLUMN_LAND_1+"="+soilId+" ORDER BY "+COLUMN_LIMITS_11+" DESC",null);

        }
        else  if(nutrition.equals("zn"))
        {
            res=db.rawQuery("SELECT "+COLUMN_REF_NUTRION_STATUS_2_3+","+COLUMN_LIMITS_12+","+COLUMN_LIMITS_13+" FROM "+TABLE_LIMITS+" WHERE "+COLUMN_LAND_1+"="+soilId+" ORDER BY "+COLUMN_LIMITS_13+" DESC",null);

        }
        else  if(nutrition.equals("bo"))
        {
            res=db.rawQuery("SELECT "+COLUMN_REF_NUTRION_STATUS_2_3+","+COLUMN_LIMITS_14+","+COLUMN_LIMITS_15+" FROM "+TABLE_LIMITS+" WHERE "+COLUMN_LAND_1+"="+soilId+" ORDER BY "+COLUMN_LIMITS_15+" DESC",null);

        }

        return res;
    }
    public Cursor getUfCi(String nutrition,int cropId,String sai) {
        Cursor res = null;
        SQLiteDatabase db = this.getReadableDatabase();
        if (nutrition.equals("ni"))
        {
            res=db.rawQuery("SELECT "+COLUMN_SAI_4+" , "+COLUMN_SAI_5+" FROM "+TABLE_SAI+" WHERE "+COLUMN_SAI_REF_COLUMN_CROPS_1_2+"="+cropId+" and "+COLUMN_SAI_REF_NUTRION_STATUS_2_3+" = \""+sai+"\"",null);
            Log.d("checkValue","query for ni column 4 and 5 and nutrition = "+nutrition);
         }
         else  if (nutrition.equals("ph"))
        {
            res=db.rawQuery("SELECT "+COLUMN_SAI_6+" , "+COLUMN_SAI_7+" FROM "+TABLE_SAI+" WHERE "+COLUMN_SAI_REF_COLUMN_CROPS_1_2+"="+cropId+" and "+COLUMN_SAI_REF_NUTRION_STATUS_2_3+" = \""+sai+"\"",null);
            Log.d("checkValue","query for ph column 6 and 7 nutrition = "+nutrition);
        }
        else  if (nutrition.equals("ka"))
        {
            res=db.rawQuery("SELECT "+COLUMN_SAI_8+" , "+COLUMN_SAI_9+" FROM "+TABLE_SAI+" WHERE "+COLUMN_SAI_REF_COLUMN_CROPS_1_2+"="+cropId+" and "+COLUMN_SAI_REF_NUTRION_STATUS_2_3+" = \""+sai+"\"",null);

        }
        else  if (nutrition.equals("sa"))
        {
            res=db.rawQuery("SELECT "+COLUMN_SAI_10+" , "+COLUMN_SAI_11+" FROM "+TABLE_SAI+" WHERE "+COLUMN_SAI_REF_COLUMN_CROPS_1_2+"="+cropId+" and "+COLUMN_SAI_REF_NUTRION_STATUS_2_3+" = \""+sai+"\"",null);

        }
        else  if (nutrition.equals("zn"))
        {
            res=db.rawQuery("SELECT "+COLUMN_SAI_12+" , "+COLUMN_SAI_13+" FROM "+TABLE_SAI+" WHERE "+COLUMN_SAI_REF_COLUMN_CROPS_1_2+"="+cropId+" and "+COLUMN_SAI_REF_NUTRION_STATUS_2_3+" = \""+sai+"\"",null);

        }
        else  if (nutrition.equals("bo"))
        {
            res=db.rawQuery("SELECT "+COLUMN_SAI_14+" , "+COLUMN_SAI_15+" FROM "+TABLE_SAI+" WHERE "+COLUMN_SAI_REF_COLUMN_CROPS_1_2+"="+cropId+" and "+COLUMN_SAI_REF_NUTRION_STATUS_2_3+" = \""+sai+"\"",null);

        }
        return res;
    }
    public Cursor getAppMethod(int cropId) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT "+COLUMN_METHODS_3+" FROM "+TABLE_METHODS+" WHERE "+COLUMN_METHODS_REF_CROP_ID_2+"="+cropId,null);
        return res;
    }

}
