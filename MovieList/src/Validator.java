import java.util.Scanner;


public class Validator
{
	public static int promptForIntegerResponse(String prompt)
	{
		Scanner sc = new Scanner(System.in);
		int responseInt = 0;
		boolean isValid = false;
		
		while (!isValid)
		{
			System.out.print(prompt);
			
			if (sc.hasNextInt())
			{
				try
				{
					responseInt = sc.nextInt();
					isValid = true;
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("\nInput error! " + prompt + "\n");
					sc.nextLine(); 	// flush the input buffer of any artifacts
				}
			}
			else
			{
				System.out.println("\nInput error! " + prompt + "\n");
				sc.nextLine(); 	// flush the input buffer of any artifacts
			}
		}
		// sc.close();
		return responseInt;
	}
	
	public static String promptForStringResponse(String prompt)
	{
		Scanner sc = new Scanner(System.in);
		String responseString = "";
		boolean isValid = false;
		
		while (!isValid)
		{
			System.out.print(prompt);
			
			if (sc.hasNext())
			{
				responseString = sc.next();
				isValid = true;
				
			}
			else
			{
				System.out.println("\nInput error! " + prompt + "\n");
				sc.nextLine(); 	// flush the input buffer of any artifacts
			}
		}
		// sc.close();
		return responseString;
	}
}
