package iteration.JsonIter;

import java.util.Collection;
import java.util.Iterator;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.json.simple.parser.JSONParser;

public class App {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            MongoClient mongoClient = MongoClients
                    .create("mongodb://krishna:6666@172.20.8.96:27017/admin?authSource=admin");

            MongoDatabase database = mongoClient.getDatabase("user_database");
            MongoCollection<Document> collection = database.getCollection("userData");
            Document myDoc = new Document();

            Document filterDoc = new Document();

            filterDoc.append("_id", "userData");

            Iterator<Document> iter = collection.find(filterDoc).iterator();
            while (iter.hasNext()) {
                Document data = (Document) iter.next().get("userList");

                // List<Document> plantComments = (List<Document>) ((Document)
                // plant.get("metadata")).get("comments");
                Collection<Object> usersData = data.values();

                System.out.println("Data :->" + data.values());
                System.out.println("Data :->" + usersData.iterator());
                Iterator i = usersData.iterator();
                while (i.hasNext()) {
                    System.out.println(i.next());
                }
            }

            // JSONObject usersList = (JSONObject) jsonObject.get("userList");
            // System.out.println("Values" + usersList.values());
            // System.out.println("Data:->" + usersList);

            // This Part Belongs to JSON Document

            // Object obj = parser.parse(new FileReader("D:\\Workouts\\userData.json"));

            // JSONObject jsonObject = (JSONObject) obj;

            // JSONObject productslist = (JSONObject) jsonObject.get("userList");
            // // Iterator<HashMap> iterator = productslist.iterator();
            // ArrayList userData = (ArrayList) new
            // ArrayList<ArrayList>(productslist.values());
            // System.out.println("ArrayList" + userData);
            // System.out.println("Values" + productslist.values());
            // System.out.println("Data:->" + productslist);

            // Iterator<ArrayList> iterator = userData.iterator();

            // while (iterator.hasNext()) {
            // System.out.println(iterator.next());
            // }
            // // while (iterator.hasNext()) {
            // // System.out.println(iterator.next());
            // // }
            // Iterator<ArrayList> iterator2 = productslist.values().iterator();
            // while (iterator2.hasNext()) {
            // System.out.println("Inside the Loop :->" + iterator2.next());
            // }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
