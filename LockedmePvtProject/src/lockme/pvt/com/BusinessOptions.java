package lockme.pvt.com;

public interface BusinessOptions {
	public static final String FILE_PATH = "E:\\Full Stack Java Developer\\Material\\Files";
	public static final String ERROR_MESSAGE = "Some error occured. Please contact := adminlocker@lokcedme.com.";

	/**
	 * This method create a new file in the given directory.
	 * 
	 * @throws IOException
	 */
	abstract void createNewFile();

	/**
	 * This function will ask user to put file name. Later it will delete the file
	 * from given directory.
	 */
	abstract void deletefilefromfolder();

	/**
	 * This function checks if file exist or not.
	 * 
	 */
	abstract void searchfile();

	/**
	 * This function will return to main menu.
	 */
	abstract void Return();
}


