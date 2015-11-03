package opencode.com.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import opencode.com.modelo.Producto;


public class BdFunciones {

    SQLiteDatabase database;
    DataBase  baseDeDatos;

    public BdFunciones(Context context){
        baseDeDatos = new DataBase(context);
    }

    public void open(){

        database = baseDeDatos.getWritableDatabase();
    }

    public void close(){
        baseDeDatos.close();
    }

    public void insertar(String codigo , String nombre , String precio){

            ContentValues contentValues = new ContentValues();
            contentValues.put("codigo",codigo);
            contentValues.put("nombre",nombre);
            contentValues.put("precio",precio);
            database.insert("productos", null, contentValues);



    }

    public void actualizar(String codigo , String nombre , String precio){

        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo",codigo);
        contentValues.put("nombre",nombre);
        contentValues.put("precio",precio);
        database.update("productos", contentValues, "codigo =" + codigo, null);

    }

    public void borrar(){

        database.delete("productos", null, null);

    }
    public void borrarPorCodigo(int codigo){

        database.delete("productos","codigo = "+codigo, null);

    }

    public Cursor getRegistros(){

        return database.query("productos",new String[]{
                "codigo",
                "nombre",
                "precio"
        },null,null,null,null,null);

    }

    public List<Producto> getDataProductos(Cursor c){

        List<Producto> productos = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                Producto producto = new Producto();
                producto.setCodigo(c.getInt(0));
                producto.setNombre(c.getString(1));
                producto.setPrecio(c.getInt(2));
                productos.add(producto);
            }while (c.moveToNext());
        }
        return productos;
    }

    public Cursor getRegistrosProducto(String codigo){

        return database.query("productos",new String[]{
                "codigo",
                "nombre",
                "precio"
        },"codigo=?",new String[]{codigo},null,null,null);



    }

    public Producto getProducto(Cursor c){
        Producto p = null;
        if(c.moveToFirst()) {
               do{
                   p = new Producto();
                   p.setNombre(c.getString(1));
                   p.setPrecio(c.getInt(2));
               }while(c.moveToNext());
        }else{
            Log.e("Producto", "Este producto no existe en la bd");
        }
        return p;
    }



}
