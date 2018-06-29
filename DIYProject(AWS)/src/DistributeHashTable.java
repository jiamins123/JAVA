import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DistributeHashTable {
    
    public DistributeHashTable() {
        try 
		{
			String input = null;
			BufferedReader rec;
			
            File configFile = new File("port.txt");
            rec = new BufferedReader(new InputStreamReader(new FileInputStream(configFile)));
            
            for (;(input = rec.readLine()) != null;) 
			{
                connectPort = Integer.parseInt(input);
            }
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
    }
    public boolean put(String key, String value)
	{
		if(value == null)
			return false;
        if(key == null) 
		{
            return false;
        }
		String s = hashData.put(key, value);
        if(s == null)
		{
            return false;
        }
        return true;
    }
    public String get(String key) 
	{
		String s = hashData.get(key);
        return s;
    }
    public boolean del(String key) {
        if(key == null) {
            return false;
        }
		String s = hashData.remove(key);
        if(s == null) 
		{
            return false;
        }
        return true;
    }

    public void start() 
	{
        try 
		{
            serSocket = new ServerSocket(connectPort);
            client = new ReadInputHelper();
            client.start();
            for(;;) 
			{
                Socket s = serSocket.accept();
                new ParseLine(s, hashData).start();
            }
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
		int i = 0;
		int connectPort;
		while(i<8)
		{
			connectPort = i + 8000;
			i++;
		}
        DistributeHashTable s = new DistributeHashTable();
        new Helper(s).start();
        for(;;) 
		{
            Thread.sleep(9000);
        }
    }
	private Map<String, String> hashData = new Hashtable<>();
	
    private ServerSocket serSocket;
	
	private int connectPort;
    
    private List<Socket> all_clients = new ArrayList<Socket>();
	
    private ReadInputHelper client;
}
class ParseLine extends Thread
{
    
    @Override
    public void run() 
	{
        try 
		{
			String input;
			OutputStream outputs = s.getOutputStream();
            
			InputStream inputs = s.getInputStream();
            
            BufferedReader rec = new BufferedReader(new InputStreamReader(inputs));
            
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputs));
            input = input = rec.readLine();
            if(input != null) 
			{
                String hashValue = null;
				
                String[] splits = input.split(" ");
				
                String order = splits[0];
                String hashKey = splits[1];
                if(order.equals("put")) 
				{
                    hashData.put(hashKey, splits[2]);
                    writer.write("1\r\n");
                    writer.flush();
                }
                else if(order.equals("get"))
				{
                    if(hashData.get(hashKey) == null)
                        writer.write("0\r\n");
                    else
                        writer.write(hashData.get(hashKey) + "\r\n");
                    writer.flush();
                }
                else if(order.equals("del")) 
				{
                    if(hashData.remove(hashKey) == null)
                        writer.write("0\r\n");
                    else
                        writer.write(hashData.remove(hashKey) + "\r\n");
                    writer.flush();
                }
                else
                    System.out.println("Wrong request from client");
                s.close();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public ParseLine(Socket s, Map<String, String> hashData)
	{
        this.s = s;
        this.hashData = hashData;
    }
	private Socket s;
	
    private Map<String, String> hashData;
}
class Helper extends Thread
{
    private DistributeHashTable s;

    public Helper(DistributeHashTable s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.start();
    }
}
