package iteration.JsonIter;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("D:\\Workouts\\userData.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONObject productslist = (JSONObject) jsonObject.get("userList");
            // Iterator<HashMap> iterator = productslist.iterator();
            ArrayList userData = (ArrayList) new ArrayList<ArrayList>(productslist.values());
            System.out.println("ArrayList" + userData);
            System.out.println("Values" + productslist.values());
            System.out.println("Data:->" + productslist);

            Iterator<ArrayList> iterator = userData.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            // while (iterator.hasNext()) {
            // System.out.println(iterator.next());
            // }
            Iterator<ArrayList> iterator2 = productslist.values().iterator();
            while (iterator2.hasNext()) {
                System.out.println("Inside the Loop :->" + iterator2.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
