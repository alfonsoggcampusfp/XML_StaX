package com.tienda.vista;

import java.util.List;

import com.tienda.controlador.ParsearXML;
import com.tienda.modelo.Producto;

public class VerXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ParsearXML read = new ParsearXML();
        List<Producto> readConfig = read.readConfig("Clientes.xml");
        for (Producto item : readConfig) {
            System.out.println(item);
		
        }
	}
}
