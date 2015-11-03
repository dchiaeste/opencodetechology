package opencode.com.basededatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import opencode.com.modelo.Producto;

/**
 * Created by danielchia on 21/10/2015.
 */
public class ProductosAdapter extends BaseAdapter {

    private Context context;
    private List<Producto> productos;

    public ProductosAdapter(Context context,List<Producto> productos){
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productos.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        Producto p = productos.get(position);

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_producto,null);
            holder.codigo = (TextView)convertView.findViewById(R.id.item_tx_codigo);
            holder.nombre = (TextView)convertView.findViewById(R.id.item_tx_nombre);
            holder.precio = (TextView)convertView.findViewById(R.id.item_tx_precio);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.codigo.setText("CODIGO: "+p.getCodigo());
        holder.nombre.setText("NOMBRE: "+p.getNombre());
        holder.precio.setText("PRECIO  $"+p.getPrecio());

        return convertView;
    }

    static class ViewHolder{
        TextView codigo , nombre , precio;
    }

    public void eliminar(int position){
        productos.remove(position);
        notifyDataSetChanged();
    }
}
