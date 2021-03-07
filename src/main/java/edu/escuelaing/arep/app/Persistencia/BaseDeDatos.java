package edu.escuelaing.arep.app.Persistencia;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//mongo dependecy
/* mongodb+srv://soytiyi:Pascual2017@tallercinco.7725n.mongodb.net/myFirstDatabase?retryWrites=true&w=majority */


//shell
/* mongo "mongodb+srv://tallercinco.7725n.mongodb.net/myFirstDatabase" --username soytiyi */
public class BaseDeDatos {
    private MongoCollection<org.bson.Document> columnas;
	private String key;
	private int llave;


	public BaseDeDatos() {
		llave = 0;
		key = "content";
		MongoClientURI uri = new MongoClientURI("mongodb+srv://soytiyi:Pascual2017@tallercinco.7725n.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase dataBase = mongoClient.getDatabase("labcinco");
		columnas = dataBase.getCollection("message");
	}

	public void insert(String message){
		Document value = new Document(key, message);
		columnas.insertOne(value);
	}

	public String consult() {
		String data = "";
		int i=1;
		long total = columnas.countDocuments();
		for(Document d : columnas.find()){
			if(i-1 > total- 10) {
				data += "Mensaje numero " + String.valueOf(i) + " " + d.get(key).toString()+"\n";
			}
			i++;
		}
		return data;
	}
}
