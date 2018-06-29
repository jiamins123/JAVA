import java.io.*:
import java.net.*:
import java.util.*:
import org.apache.commons.lang
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class mongo {

	public static void main(String[] args) {
		File file = new File("/home/ubuntu/record.txt");
		file.createNewFile(); 
		FileWriter out = new FileWriter(file, true);
		
		List<addr> addresses = new List<addr>();
		addr address1 = new addr("172.31.4.144", 27301);
		addr address2 = new addr("172.31.42.", 27301);
		addr address3 = new addr("172.31.17.29", 27301);
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);

		MongoClient mongoClient = new MongoClient(addresses);

		MongoDatabase db = mongoClient.getDatabase("test_db");
		MongoCollection<Document> collection = db.getCollection("abc");



		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		String key = "";
		String value = "";

		int times = 0;
		times = 100000;
		out.write(times + " times ");
		out.flush();

		for (int j = 0; j < times; j++) {
			
			String key1=RandomStringUtils.randomAlphanumeric(10);
			String value1=RandomStringUtils.randomAlphanumeric(90);
			key = key1;
			value = value1;
			list1.add(key);
			list2.add(value);
		}
		
		long begin = 0;
		long end = 0;
		long begin = System.currentTimeMillis();
				for (int i = 0; i < times; i++) 
					{
						client.set(list1.get(i), list2.get(i));
					}
				long end = System.currentTimeMillis();
				long cost = end - begin; 
				out.write(" insert ms " + cost);
				out.flush();
				// lookup
				long begin = System.currentTimeMillis();
				for (int i = 0; i < times; i++) 
					{
						client.get(list1.get(i));
					}
				long end = System.currentTimeMillis();
				// System.out.println(end - begin + " ms");
				long cost = end - begin;
				out.write(" lookup ms " + cost));
				out.flush();

				// reomove
				
				long begin = System.currentTimeMillis();
				for (int i = 0; i < times; i++) 
					{
						client.del(list1.get(i));
					}
				long end = System.currentTimeMillis();
				long cost = end - begin;
				out.write(" remove ms " + cost));
				out.flush();
	}
}