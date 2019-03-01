package info.androidhive.androidlocation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 10.02.2019.
 */

public class VeriYardimci extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "posMarket.db";
    public static final String TABLE_NAME = "employee_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "LOCATION";

    public VeriYardimci(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL("create table " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DESCRIPTION TEXT,LOCATION INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int i, int i1) {
        db2.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db2);
    }
    public boolean insertData(String name,String description,String location) {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,description);
        contentValues.put(COL_4,location);
        long result = db2.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor res = db2.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }
    /*public boolean updateData(String id,String name,String description,String location){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,description);
        contentValues.put(COL_4,location);
        db2.update(TABLE_NAME,contentValues,"ID = ?",new String [] { id });
        return true;
    } */
}
