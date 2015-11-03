package opencode.com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{

    String tabla_productos = "CREATE TABLE productos (codigo INTEGER , nombre TEXT , precio INTEGER)";

    public DataBase(Context context) {
        super(context,"supermercado.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_productos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS productos");

        db.execSQL(tabla_productos);
    }
}
