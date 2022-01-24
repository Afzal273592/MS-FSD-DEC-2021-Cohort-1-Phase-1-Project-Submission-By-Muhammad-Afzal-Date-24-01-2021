package lockme.pvt.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Locker extends BusinessOperationsLevel 
{
	/**
	 * This function display all files in given directory.
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void displayAllFiles() throws FileNotFoundException, UnsupportedEncodingException 
	{
		try 
		{
			File folderPath = new File(FILE_PATH);
			File[] fileList = folderPath.listFiles();
			if (folderPath.exists()) 
			{
				List<File> listOffiles = Arrays.asList(fileList);
				Collections.sort(listOffiles);
				int totalFiles = listOffiles.size();
				if (totalFiles == 0) 
				{
					System.out.println("No file in this directory.");
				} 
				else 
				{
					for (var file : listOffiles) 
					{
						System.out.println(file.getName());
					}
				}
			} 
			else 
			{
				System.out.println("The system cannot find the path specified.");
			}
		} catch (Exception ex) 
		{
			if (ex.toString() == "java.lang.NullPointerException") 
			{
				System.out.println("Please chcek the given folder path.it does not exist. " + FILE_PATH);
			} else 
			{
				System.out.println(ERROR_MESSAGE);
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void mainMenuFuntions() throws InterruptedException, IOException 
	{
		displayWelcomeScreen();
		Scanner scanner = new Scanner(System.in);
		System.out.print("\t\t\t\t\t\tPlease enter the choice number you want to perform. =: ");
		int menuSelection = Integer.parseInt(scanner.nextLine());
		switch (menuSelection) 
		{
		case 1:
			displayAllFiles();
			break;
		case 2:
			businessLevel();
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Please enter a valid option.");
		}
	}

	public static void businessLevel() throws InterruptedException, IOException 
	{
		Scanner scanner = new Scanner(System.in);
		BusinessOptions businessSelection = new BusinessOperationsLevel();
		businessleveloperations();
		System.out.print("\t\t\t\tPlease enter the choice number you want to perform at Businees Level. =: ");
		int menuSelection = Integer.parseInt(scanner.nextLine());
		switch (menuSelection) 
		{
		case 1:
			businessSelection.createNewFile();
			System.exit(0);
		case 2:
			businessSelection.deletefilefromfolder();
			System.exit(0);
		case 3:
			businessSelection.searchfile();
			System.exit(0);
		case 4:
			businessSelection.Return();
		default:
			System.out.println("Please enter a valid option.");
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		Scanner scanner = new Scanner(System.in);
		String answer = "";
		try 
		{
			do 
			{
				mainMenuFuntions();
				System.out.print("Do you want to continue? (Y|N) ");
				answer = scanner.nextLine();
			} 
			while (answer.equalsIgnoreCase("Y"));
		} 
		catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		} 
		finally {
			System.out.println("Thank you for using Lockedme.com");
			scanner.close();
		}
	}
}
