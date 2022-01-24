package lockme.pvt.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class BusinessOperationsLevel extends DisplayItemsMenu implements BusinessOptions 
{
	@Override
	public void createNewFile() 
	{
		Scanner scanner = new Scanner(System.in);
		try 
		{
			File folderPath = new File(FILE_PATH);
			if (folderPath.exists()) 
			{
				System.out.println("Please enter file Name to create new file.");
				String fileName = scanner.nextLine();
				File filetoCreate = new File(FILE_PATH + "\\" + fileName + ".txt");
				if (filetoCreate.exists()) 
				{
					System.out.println("File (" + filetoCreate.getName()
							+ ") already exists. Please enter different name than (" + filetoCreate.getName() + ")");
				} else 
				{
					BufferedWriter bufferWriter = new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream(filetoCreate), "utf-8"));
					System.out.println("How many Line you want to write in the file?");
					int totalline = Integer.parseInt(scanner.nextLine());
					for (int i = 1; i <= totalline; i++) 
					{
						System.out.println("Enter the text for the line := " + i);
						String input = scanner.nextLine();
						bufferWriter.write(input + "\n");
					}
					System.out.println("File has been created and text data is stored as well.");
					bufferWriter.close();
				}
			} else 
			{
				System.out.println("The system cannot find the path specified. " + FILE_PATH);
			}
		} 
		catch (Exception ex) 
		{
			System.out.println(ERROR_MESSAGE);
			System.out.println(ex.getMessage());
		} finally 
		{
			scanner.close();
		}
	}

	@Override
	public void deletefilefromfolder() 
	{
		Scanner scanner = new Scanner(System.in);
		try 
		{
			File folderPath = new File(FILE_PATH);
			boolean pathExists = folderPath.exists();
			if (pathExists) 
			{
				File[] fileList = folderPath.listFiles();
				int numberOffiles = fileList.length;
				if (numberOffiles == 0) 
				{
					System.out.println("No file in this folder");
				} else 
				{
					System.out.println("Please enter file Name to be delelted.");
					String filename = scanner.nextLine();
					filename = filename.toLowerCase();
					File filetodelete = new File(FILE_PATH + "\\" + filename + ".txt");
					if (filetodelete.exists()) 
					{
						filetodelete.delete();
						System.out.println("File (" + filetodelete.getName() + ") deleted successfully.");
					} else 
					{
						System.out.println("File do not exist. Please check the file name you entered.");
						if (numberOffiles == 1) 
						{
							System.out.println("\nGiven path contain below file.");
							Locker.displayAllFiles();
						} else 
						{
							System.out.println("\nGiven path contains below files.");
							Locker.displayAllFiles();
						}
					}
				}
			} else 
			{
				System.out.println("The system cannot find the path specified. " + FILE_PATH);
			}
		} 
		catch (Exception ex) 
		{
			System.out.println(ERROR_MESSAGE);
			System.out.println(ex.getMessage());
		} finally 
		{
			scanner.close();
		}
	}

	@Override
	public void searchfile() 
	{
		Scanner scanner = new Scanner(System.in);
		try 
		{
			File folderPath = new File(FILE_PATH);
			boolean pathExists = folderPath.exists();
			if (pathExists) 
			{
				File[] fileList = folderPath.listFiles();
				int numberOffiles = fileList.length;
				if (numberOffiles == 0) 
				{
					System.out.println("No file in this folder");
				} 
				else 
				{
					System.out.println("Please enter file Name you want to search.");
					String fileName = scanner.nextLine();
					List<String> listallFileName = new LinkedList<>();
					for (var name : fileList) 
					{
						listallFileName.add(name.getName());
					}
					if (listallFileName.contains(fileName)) 
					{
						System.out
								.println("Given file (" + fileName + ") exists in the folder and found  successfully.");
					} 
					else 
					{
						System.out.println("File (" + fileName + ") do not exist in this folder.");
						if (numberOffiles == 1) 
						{
							System.out.println("\nGiven path contain below file.");
							Locker.displayAllFiles();
						} else 
						{
							System.out.println("\nGiven path contains below files.");
							Locker.displayAllFiles();
						}
					}
				}
			} 
			else 
			{
				System.out.println("The system cannot find the path specified. " + FILE_PATH);
			}
		} 
		catch (Exception ex) 
		{
			System.out.println(ERROR_MESSAGE);
			System.out.println(ex.getMessage());
		} finally 
		{
			scanner.close();
		}
	}

	@Override
	public void Return() 
	{
		try 
		{
			Locker.mainMenuFuntions();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
