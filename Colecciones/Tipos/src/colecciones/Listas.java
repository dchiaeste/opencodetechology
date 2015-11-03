package colecciones;

import java.util.ArrayList;
import java.util.List;

public class Listas {
	
	public static void main(String[] args) {
		
		List<String> nombres = new ArrayList<>();
		
		//añadir
		nombres.add("Pedro");
		nombres.add("Sara");
		nombres.add("Carlos");
		nombres.add("Alejandra");
		
		//mostrar posicion
		System.out.println(nombres.get(0));
		
		//Eliminar Elemento
		nombres.remove(1);
		
		//Validar si existe un elemento en la lista
		
		System.out.println(nombres.contains("Sara"));
		
		//modificar el elemento
		nombres.set(2, "Sofia");
		
		//Recorrer listado
		for(String nombre : nombres){
			System.out.println("nombre: "+nombre);
		}
		
		
	}

}
