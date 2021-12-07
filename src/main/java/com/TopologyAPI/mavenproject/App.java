package com.TopologyAPI.mavenproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws IOException
    {
		
		// encoding Object to json  and store in memory
		String jsonString = WriteJsonToString();
		System.out.println(jsonString);
		
		// encoding Object to json and write json object into example.json file
		WriteJsonToFile("example.json");
		
		// read from topology.json file and store in List;
		List<Component> list = readFromJson("topology.json");
		// query..
		QueryDecodedJsonList(list);
		
		
		
		
       
        
    }
	
	public static String WriteJsonToString() throws JsonProcessingException {
		
		 Resistance r = new Resistance(100, 10, 1000);
	     NetList net = new NetList("t1", "t2");
	     Resistor res = new Resistor("res1", "resistor",r,net );
	     
	     Resistance r2 = new Resistance(1.5, 1, 2);
	     NmosNetList net2 = new NmosNetList("n1", "vin","vss");
	     NMOS n = new NMOS("m1", "nmos", r2, net2);

	     List<Component> list = new ArrayList<Component>();
	     list.add(res);
	     list.add(n);
	     Component comp = new Component(list);
	     ObjectMapper mapper = new ObjectMapper();
	     String json = mapper.writeValueAsString(comp);
		
	     return json;

		
	}
	
	public static void WriteJsonToFile(String FileName) throws IOException {
		
		 Resistance r = new Resistance(1.2, 1, 2);
	     NetList net = new NetList("t", "t2");
	     Resistance r2 = new Resistance(1.2, 1, 2);
	     NmosNetList net2 = new NmosNetList("t0", "t2","vdd");
	     NMOS n = new NMOS("ID1", "NMOS", r2, net2);
	     Resistor res = new Resistor("id", "res",r,net );
	     ArrayList<Component> list = new ArrayList<Component>();
	     list.add(res);
	     list.add(n);
	     Component comp = new Component(list);
	     
	     ObjectMapper mapper = new ObjectMapper();
	     mapper.writeValue(new File(FileName), comp);
	     		

		
	}
	
	public static List<Component> readFromJson(String fileName) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		List<Component> components = (List<Component>) mapper.readValue(new File(fileName), Component.class);
		
		return components;
		
	}
	
	public static void QueryDecodedJsonList(List<Component> list) {
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}
}
