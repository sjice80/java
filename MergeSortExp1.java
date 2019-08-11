import java.io.*;
import java.util.*;
//300 2 301 3 320 1 250 15 320 99 301 5 250 20 300 10
public class MergeSortExp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>number = new ArrayList<Integer>();

        Scanner myScanner = null;
        try {
        	myScanner = new Scanner(new File("./WORKLOAD.TXT"));
        } catch (FileNotFoundException e) {

        e.printStackTrace();
        }

        while(myScanner.hasNextInt()){
        	int num = myScanner.nextInt();
            number.add(num);
            System.out.print(num+", ");
        }

        System.out.println("Before sorting" +number);
        number=mergeSort(number);
        System.out.println("Sorted Array =" +number);
    }

    public static ArrayList<Integer> mergeSort( ArrayList<Integer> Input)
    {
        if (Input.size() ==1){
        	System.out.println("last mid: "+Input.size());
            return Input;
        }
        else {
            int mid= Input.size()/2;
            System.out.println("mid: "+mid);
            ArrayList<Integer> left= new ArrayList<Integer>(mid);
            ArrayList<Integer> right=new ArrayList<Integer>(Input.size()-mid);
            for (int i = 0; i < mid; i++) {
                left.add(Input.get(i));
                } 

            for (int i = 0; i < Input.size()-mid; i++) {
                right.add(Input.get(i));
            } 

            left=mergeSort(left); 
            right=mergeSort(right);
            merge(left,right,Input);
         }
            return Input;
     }


     public static void merge (ArrayList<Integer>left,ArrayList<Integer>right,ArrayList<Integer>Input)
     {
         int i1=0;// left Index
         int i2=0;// right Index
         int InputIndex=0;

         for (int i = 0; i < Input.size(); i++) {
        	 System.out.println("merge: "+Input.size()+", "+right.size()+", "+left.size());
             if (i2>=right.size() || (i1<left.size() && left.get(i)<=right.get(i))) 
             {
                 Input.set(InputIndex,left.get(i1));
                 InputIndex++;
                 i1++;
             }
             else {
                 Input.set(InputIndex, right.get(i2));
                 InputIndex++;
                 i2++;
             }
         }
     }
}
