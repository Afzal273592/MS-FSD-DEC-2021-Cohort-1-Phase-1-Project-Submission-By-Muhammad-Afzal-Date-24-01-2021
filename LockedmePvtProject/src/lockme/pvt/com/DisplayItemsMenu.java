package lockme.pvt.com;
public class DisplayItemsMenu 
{
	public static void displayWelcomeScreen() throws InterruptedException 
	{
		System.out.println("+*****************************************************************************************************************************************************************+");
		System.out.println("|***********************************\t\t\t\tWelcome To Lockedme.com.\t\t\t\t\t**********************************|");
		System.out.println("|***********************************\t\t\t\tCreated By Muhammad Afzal.\t\t\t\t\t**********************************|");
		System.out.println("|***********************************\t\t1. Display all the files.\t2. Business-level operations.\t3. Exit.\t**********************************|");
		System.out.println("+*****************************************************************************************************************************************************************+");
	}

	public static void businessleveloperations() throws InterruptedException
	{
		System.out.println();
		System.out.println("+*****************************************************************************************************************************************************************+");
		System.out.println("|*************************\t\t\t\t\t2. Business-level operations.\t\t\t\t\t\t**************************|");
		System.out.println("|*************************\t1. Add a new file.\t2. Delete a file.\t3. Search a file.\t4. Return to Main Menu.\t\t**************************|");
		System.out.println("+*****************************************************************************************************************************************************************+");
	}
}




