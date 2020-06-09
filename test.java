package test;
import java.util.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
class User implements Comparable<User> {
	int id;
	String name;
	String email;
	String password;
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String toString() {
		return this.id+", "+this.name+", "+this.email+", "+this.password;
	}
	public int compareTo(User u) {
		if(!this.email.equals(u.email)) {
			return this.email.compareTo(u.email);
		}
		if(this.name.compareTo(u.name)>0) {
			return 1;
		} else if(this.name.compareTo(u.name)<0) {
			return -1;
		} 
		else {
			return this.password.compareTo(u.password);
		}
	}
}
public class test {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ParseException {
		// TODO Auto-generated method stub
		CardServer cardServer = new CardServer();
		Thread thread = new Thread(cardServer);
		thread.start();
		
		ValidatorReport report = new ValidatorReport();
		Scanner scanner = new Scanner(System.in);
		String line;
		
		while((line=scanner.nextLine())!=null) {
			if(line.equals("QUIT")) {
				cardServer.close();
				break;
			} else if(line.equals("REPORT")) {
				if(report.reportValidator()) {
					System.out.println("REPORT FINISH");
				}
			} else {
				String option = null;
				if(line.length()>9) {
					option = line.split(" ")[1];
				}
				report.printReport(line.substring(0, 8), option);
			}
		}
		
		String strId, strPassword;
		while(true) {
			Validator validator = new Validator();
			line = scanner.nextLine();
			if(line.length()<10) {
				System.out.println("Wrong ID Password");
				continue;
			}
			strId = line.substring(0, 8);
			strPassword = line.substring(9);
			if(validator.login(strId, strPassword)) {
				System.out.println("LOGIN SUCCESS");
				while(true) {
					line = scanner.nextLine();
					if(line.equals("LOGOUT")) {
						validator.logout();
						break;
					}
					validator.getOnBus(line);
					while(true) {
						line = scanner.nextLine();
						if(line.equals("DONE")) {
							validator.getOffBus();
							break;
						}
						validator.inspectCard(line);
					}
				}
			} else {
				System.out.println("LOGIN FAIL");
			}
		}
		/*
		Producer producer = new Producer();
		producer.setName("Producer-1");
		producer.start();
		
		Consumer consumer = new Consumer(producer);
		consumer.setName("Consumer-1");
		consumer.start();

		Consumer consumer1 = new Consumer(producer);
		consumer1.setName("Consumer-2");
		consumer1.start();
		
		Consumer consumer2 = new Consumer(producer);
		consumer2.setName("Consumer-3");
		consumer2.start();
		*/
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		solution(phone_book);
	}
	public static void copyFolder(File source, File destination)
	{
	    if (source.isDirectory())
	    {
	        if (!destination.exists())
	        {
	            destination.mkdirs();
	        }

	        String files[] = source.list();

	        for (String file : files)
	        {
	            File srcFile = new File(source, file);
	            File destFile = new File(destination, file);

	            copyFolder(srcFile, destFile);
	        }
	    }
	    else
	    {
	        InputStream in = null;
	        OutputStream out = null;

	        try
	        {
	            in = new FileInputStream(source);
	            out = new FileOutputStream(destination);

	            byte[] buffer = new byte[1024];

	            int length;
	            while ((length = in.read(buffer)) > 0)
	            {
	                out.write(buffer, 0, length);
	            }
	        }
	        catch (Exception e)
	        {
	            try
	            {
	                in.close();
	            }
	            catch (IOException e1)
	            {
	                e1.printStackTrace();
	            }

	            try
	            {
	                out.close();
	            }
	            catch (IOException e1)
	            {
	                e1.printStackTrace();
	            }
	        }
	    }
	}
	public static boolean solution(String[] phone_book) throws IOException {
        boolean answer = true;
        String input_path = "./input/";
        String output_path = "./output/";
        File[] f_list = new File(input_path).listFiles();
        for(int i=0; i<f_list.length; i++) {
        	System.out.println(f_list[i].getName());
        }
        FileReader fr = new FileReader(input_path+f_list[0].getName());
        BufferedReader br = new BufferedReader(fr);
        ArrayList<User> list = new ArrayList<>();
        int id=0, cnt=0;
        String sid="", name="", email="",password="",temp="";
        while(true) {
        	String line = br.readLine();
        	if(line == null) {
        		break;
        	}
        	if(line.contains("id")) {
        		cnt++;
        		sid = line.split(":")[1];
            	if(sid.length()!=0) {
//            		System.out.println(sid.length());
            		temp = sid.substring(0,1);
//           		System.out.println(temp);
            		id = Integer.parseInt(temp);
            	}
        	}
        	
        	else if(line.contains("name")) {
        		name = line.split(":")[1];
        		if(name.endsWith(",")) {
        			name = name.substring(0, name.length()-1);
        		}
        	}
        	else if(line.contains("email")) {
        		email = line.split(":")[1];
        		if(email.endsWith(",")) {
        			email = email.substring(0, email.length()-1);
        		}
        	}
        	else if(line.contains("password")) {
        		password = line.split(":")[1];
        		User u = new User(id, name, email, password);
//            	System.out.println(u.toString());
            	list.add(u);
        	}
        	
        }
//        System.out.println(list);
        Collections.sort(list);
        FileWriter fw = new FileWriter(output_path+f_list[0].getName());
        for(int i=0; i<list.size(); i++) {
        	fw.write(list.get(i).toString()+"\r\n");
        }
        fw.close();
        return answer;
    }
}
