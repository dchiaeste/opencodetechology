package colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Diccionario {
	
	public static void main(String[] args) {
		
		Map<String, String> vehiculos = new HashMap<>();
		vehiculos.put("98612","Chevrolet");
		vehiculos.put("23432","Mazda");
		vehiculos.put("80064","Toyota");
		vehiculos.put("12345","Hyundai");
		
		vehiculos.get("98612");
		
		vehiculos.isEmpty();
		
		vehiculos.containsKey("GBN555");
		
		Iterator it = vehiculos.keySet().iterator();
		while(it.hasNext()){
			String clave = it.next().toString();
			System.out.println("CODIGO: "+clave+" del vehiculo marca "+vehiculos.get(clave));
		}
		
	}

}
