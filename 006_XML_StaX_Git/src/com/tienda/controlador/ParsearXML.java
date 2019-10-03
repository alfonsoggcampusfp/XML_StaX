package com.tienda.controlador;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


import com.tienda.modelo.Producto;

public class ParsearXML {

	 	static final String CLIENTE = "cliente";
	    static final String NOMBRE = "nombre";
	    static final String TELEFONO = "telefono";
	    static final String COMENTARIOS = "unit";
	    static final String CLIENTES = "cliente";
	    static final String ID = "ID";

	    @SuppressWarnings({ "unchecked", "null" })
	    public List<Producto> readConfig(String configFile) {
	        List<Producto> items = new ArrayList<Producto>();
	        try {
	            // First, create a new XMLInputFactory
	            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	            // Setup a new eventReader
	            InputStream in = new FileInputStream(configFile);
	            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	            // read the XML document
	            Producto producto = null;

	            while (eventReader.hasNext()) {
	                XMLEvent event = eventReader.nextEvent();

	                if (event.isStartElement()) {
	                    StartElement startElement = event.asStartElement();
	                    // If we have an item element, we create a new item
	                    if (startElement.getName().getLocalPart().equals(CLIENTE)) {
	                        producto = new Producto();
	                        // We read the attributes from this tag and add the date
	                        // attribute to our object
	                        Iterator<Attribute> attributes = startElement
	                                .getAttributes();
	                        while (attributes.hasNext()) {
	                            Attribute attribute = attributes.next();
	                            if (attribute.getName().toString().equals(ID)) {
	                                producto.setCliente(attribute.getValue());
	                            }

	                        }
	                    }

	                    if (event.isStartElement()) {
	                        if (event.asStartElement().getName().getLocalPart()
	                                .equals(NOMBRE)) {
	                            event = eventReader.nextEvent();
	                            producto.setNombre(event.asCharacters().getData());
	                            continue;
	                        }
	                    }
	                    if (event.asStartElement().getName().getLocalPart()
	                            .equals(TELEFONO)) {
	                        event = eventReader.nextEvent();
	                        producto.setTelefono(event.asCharacters().getData());
	                        continue;
	                    }

	                    if (event.asStartElement().getName().getLocalPart()
	                            .equals(COMENTARIOS)) {
	                        event = eventReader.nextEvent();
	                        producto.setComentarios(event.asCharacters().getData());
	                        continue;
	                    }
	                    

	                    
	                }
	                // If we reach the end of an item element, we add it to the list
	                if (event.isEndElement()) {
	                    EndElement endElement = event.asEndElement();
	                    if (endElement.getName().getLocalPart().equals(CLIENTE)) {
	                        items.add(producto);
	                    }
	                }

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (XMLStreamException e) {
	            e.printStackTrace();
	        }
	        return items;
	    }
	    
	   
	    
}
