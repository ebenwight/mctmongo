package mct;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.gridfs.*;
import org.bson.*;

public class DAO {

	@SuppressWarnings("resource")
	public static FindIterable<Document> insert(Document commentDoc) {
		
		MongoCursor<Document> cursor = null;
		FindIterable<Document> myDocs = null;

		try {
			MongoClient client = new MongoClient("localhost");
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("comments");
			collection.insertOne(commentDoc);
			
			
			myDocs = collection.find(commentDoc);
			System.out.println("results:");
			System.out.println(myDocs.toString());


			// from bere on it's pretty much curbed from Ians fork of the code
			cursor = collection.find().iterator();
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} finally {
			
			cursor.close();
		}

		return myDocs;
	}
	

}
