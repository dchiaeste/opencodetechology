package opencode.com.basededatos;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import opencode.com.db.BdFunciones;
import opencode.com.modelo.Producto;

public class Listado extends AppCompatActivity {

    ListView listado;
    BdFunciones funciones;
    ProductosAdapter adapter;
    List<Producto> productos;
    Producto p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listado = (ListView)findViewById(R.id.ls_productos);
        funciones = new BdFunciones(this);
        funciones.open();
        Cursor c = funciones.getRegistros();
        productos = funciones.getDataProductos(c);
        adapter = new ProductosAdapter(this,productos);
        listado.setAdapter(adapter);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                p = productos.get(position);
                AlertDialog dialog = new AlertDialog.Builder(Listado.this)
                        .setTitle("Eliminar Producto")
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                      adapter.eliminar(position);
                                      funciones.borrarPorCodigo(p.getCodigo());
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                       dialog.dismiss();
                            }
                        })
                        .create();
                        dialog.show();
            }
        });
    }
}
