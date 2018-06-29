import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInputHelper extends Thread
{
	public Socket connect(int port) 
	{
        try 
		{
            Socket socket = new Socket("127.0.0.1", port);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            bufferReader = new BufferedReader(new InputStreamReader(input));
            bufferWriter = new BufferedWriter(new OutputStreamWriter(output));
            return socket;
        } 
		catch (Exception e) 
		{
            return connect(port);
        }
    }
    public ReadInputHelper()
	{
		int i = 0;
		while(i < SERVER_NUM)
		{
			serverNum.add(0);
			i++;
		}
    }

    
    public boolean put(String key, String value) 
	{
		String result = null;
        if(key == null)
            return false;
        
        try 
		{
			int port;
            port = 8000 + key.hashCode() % SERVER_NUM;
            if(port < 8000) 
			{
                System.out.println("port wrong, port = " + port + ", key = " + key);
                return false;
            }
			if(port > (8000 + SERVER_NUM))
			{
				System.out.println("port wrong, port = " + port + ", key = " + key);
                return false;
			}
            Socket s = connect(port);
			
            bufferWriter.write("put " + key + " " + value + "\r\n");
            bufferWriter.flush();
			int index;
			int oldCount;
            result = bufferReader.readLine();
            index = port - 8000;
            oldCount = serverNum.get(index);
            serverNum.set(index, oldCount + 1);
            s.close();
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
        if(result.equals("1")) {
            return true;
        }
        else {
            return false;
        }
    }
    public String get(String key) 
	{
        if(key == null) {
            return null;
        }
        String result = null;
        try 
		{
			int port;
            port = 8000 + key.hashCode() % SERVER_NUM;
			
            Socket s = connect(port);
            bufferWriter.write("get " + key + "\r\n");
            bufferWriter.flush();
			
            result = bufferReader.readLine();
			
			int index;
			int oldCount;
			
            index = port - 8000;
            oldCount = serverNum.get(index);
            serverNum.set(index, oldCount + 1);
            s.close();
        } 
		catch (Exception e)
		{
            e.printStackTrace();
        }
        if(result.equals("0")) 
		{
            return null;
        }
        else 
		{
            return result;
        }
    }
    public boolean del(String key) 
	{
		String result = null;
        if(key == null) 
		{
            return false;
        }
        
        try 
		{
			int port;
            port = 8000 + key.hashCode() % SERVER_NUM;
            Socket s = connect(port);
			
            bufferWriter.write("del " + key + "\r\n");
            bufferWriter.flush();
            result = bufferReader.readLine();
			
			int index;
			int oldCount;
            index = port - 8000;
            oldCount = serverNum.get(index);
			
            serverNum.set(index, oldCount + 1);
            s.close();
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
        if(result.equals("0")) 
		{
            return  false;
        }
        else 
		{
            return true;
        }
    }
    public void printCount() 
	{
        System.out.println("The number of different servers: ");
		int i = 0;
		while(i < SERVER_NUM)
		{
			System.out.print(serverNum.get(i) + " ");
			i++;
		}
        System.out.println();
    }
    @Override
    public void run() 
	{
        try 
		{
			String line = null;
			
            Scanner input = new Scanner(System.in);
            
            for(;;) 
			{
                System.out.println("Please input the cmd");
                line = input.nextLine();
				
                String[] splits = line.split(" ");
				
                if(splits[0].equalsIgnoreCase("put")) 
				{
                    boolean result = put(splits[1], splits[2]);
                    if(result)
                        System.out.println("---your put is successful---");
                    else
                        System.out.println("your put is failure---");
                }
                else if(splits[0].equalsIgnoreCase("get"))
				{
                    String result = get(splits[1]);
                    System.out.println(result);
                }
                else if(splits[0].equalsIgnoreCase("del"))
				{
                    boolean result = del(splits[1]);
                    if(result)
                        System.out.println("---your del is successful---");
                    else 
                        System.out.println("your del is failure---");
                }
                else 
                    System.out.println("Please input correction cmd");
            }
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }
    }
	private BufferedReader bufferReader;
	
    private BufferedWriter bufferWriter;
	
    private List<Integer> serverNum = new ArrayList<Integer>();
	
    public static final int SERVER_NUM = 2;
}
