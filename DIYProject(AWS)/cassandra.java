import java.io.*:
import java.net.*:
import java.util.*:
import org.apache.commons.lang
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import tool.getIp;
import tool.CalnOutCassandra;

public class cassandra {

	public static void main(String[] args) throws IOException {
		String ip = "";
		getIp.get(ip)
		File file = new File("/home/ubuntu/report.txt");
		file.createNewFile()
		FileWriter out = new FileWriter(file, true);

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

		CalnOutCassandra.Cass();
	}
}
