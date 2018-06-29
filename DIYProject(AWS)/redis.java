import java.io.*:
import java.net.*:
import java.util.*:
import org.apache.commons.lang
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import tool.CalnOutRedis;
import tool.getIp;

public class redis {

	public static void main(String[] args) {

            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            writer.write("search 1.txt\r\n");
            writer.flush();
            String line = reader.readLine();
	
		File file = new File("/home/ubuntu/record.txt");
		file.createNewFile(); 
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

		JedisCluster client = null;
		
		String ip = "";
		getIp.get(ip);
		
		try {
			Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
			// Jedis Cluster will attempt to discover cluster nodes
			// automatically
			jedisClusterNodes.add(new HostAndPort(ip, 6379));
			client = new JedisCluster(jedisClusterNodes);
			
			CalnOutRedis.redis();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}