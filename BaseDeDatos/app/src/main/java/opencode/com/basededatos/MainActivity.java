package opencode.com.basededatos;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import opencode.com.db.BdFunciones;
import opencode.com.modelo.Producto;


public class MainActivity extends AppCompatActivity {

    EditText codigo , nombre , precio;

    BdFunciones funciones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = (EditText)findViewById(R.id.et_codigo);
        nombre = (EditText)findViewById(R.id.et_nombre);
        precio = (EditText)findViewById(R.id.et_precio);

        funciones = new BdFunciones(this);


    }
    public void vaciarCampos(){
        codigo.setText("");
        nombre.setText("");
        precio.setText("");
    }

    public void insertarDato(View view){
        funciones.open();
        funciones.insertar(codigo.getText().toString(), nombre.getText().toString(), precio.getText().toString());
        vaciarCampos();
        funciones.close();

    }

    public void actualizarDato(View view){
        funciones.open();
        funciones.actualizar(codigo.getText().toString(), nombre.getText().toString(), precio.getText().toString());
        vaciarCampos();
        funciones.close();
    }

    public void eliminarDatos(View view){
        funciones.open();
        funciones.borrar();
        vaciarCampos();
        funciones.close();
    }

    public void buscarPorCodigo(View view){
        funciones.open();
        Cursor cursor = funciones.getRegistrosProducto(codigo.getText().toString());
        Producto producto = funciones.getProducto(cursor);
        nombre.setText(producto.getNombre());
        precio.setText(String.valueOf(producto.getPrecio()));
        funciones.close();

    }

    public void listadoProductos(View view){
        Intent t = new Intent(this,Listado.class);
        startActivity(t);
    }
}
