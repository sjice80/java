import java.util.*;

public class RunManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TextFileReader fileReader = new TextFileReader();
		String line = "";
		while(true)
		{
			line = sc.nextLine();
			List<String> readStrArray = fileReader.readFile(line+".txt");
			List<String> readFileStrArray = fileReader.readFile(readStrArray.get(0));
			System.out.println(readFileStrArray.get(0));
		}
		
	}

}
