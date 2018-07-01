import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class MolarMass 
{
	public static void main(String[] args)
	{
		System.out.println("Enter a Compound");
        ArrayList<Character> num = new ArrayList<Character>();
        ArrayList<String> e_value = new ArrayList<String>();

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

 //************************************************************************//        		

        String[] arr = input.split("(?=\\p{Upper})");
              
		for (int i=0; i< arr.length;i++ )
		{
			String let = arr[i];
			char[] letters = new char[let.length()];
			letters = let.toCharArray();
			int length = let.length();
			
			if (Character.isDigit(letters[length-1]))
				{
				arr[i] = arr[i].replaceAll("[0-9]", "");
				num.add(letters[length-1]);
				}
			else
				{
				num.add('1');
				}
		}
		
 //**********************Scan File *******************************************//   		
		int count = 0,count2 = 0;
		File file = new File("Elements.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	        	count = count + 1;
	            String ele = sc.nextLine();
	            
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	            for (int x =0; x <arr.length; x++)
	            {
	            	if (ele.equals(arr[x])&& count2 == 0)
	            	{
	            		
	            		count2 = 1;
	            		break;
	            	}
	            }           
	            if (count%2 == 0 && count2 == 1)
	            {
	            	e_value.add(ele);
	            	count = 0;
	            	count2 = 0;
	            }
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%	            
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
//*****************************************************************//  
	    double total = 0;
	    for (int i = 0; i< arr.length;i++)
		{
			total = total+Character.getNumericValue(num.get(i))*Double.parseDouble(e_value.get(i));
		}
	    
	   System.out.println("The total is: "+total);
	}

}
