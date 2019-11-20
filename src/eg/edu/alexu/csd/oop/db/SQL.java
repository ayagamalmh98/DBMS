package Main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SQL {

	File Directory;

	public SQL() {
		Directory = new File("/Users/EGYPT_LAPTOP/eclipse-workspace/DPMS/Directory");
		Directory.mkdirs();
	}

	public File createDatabase(String databaseName) {
		File dataFile = new File(Directory.getAbsolutePath() + File.separator + databaseName);
		dataFile.mkdirs();
		return dataFile;
	}

	public void dropDatabase(String databaseName) {
		File directory = new File(Directory.getAbsolutePath() + File.separator + databaseName);
		deleteDirectory(directory);
	}

	public static void deleteDirectory(File directoryToBeDeleted) {
		File[] allContents = directoryToBeDeleted.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				if (file.isDirectory()) {
					deleteDirectory(file);
				} else {
					file.delete();
				}

			}
		}
		directoryToBeDeleted.delete();
	}

	public boolean databaseExists(String databaseName) {
		for (File dir : Directory.listFiles()) {
			if (dir.getName().equalsIgnoreCase(databaseName)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void createTable(String tableName, String databaseName) {
		File tableXML = new File(
				Directory.getAbsolutePath() + File.separator + databaseName + File.separator + tableName + ".xml");
		File tableDTD = new File(
				Directory.getAbsolutePath() + File.separator + databaseName + File.separator + tableName + ".xsd");

		try {
			tableXML.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			tableDTD.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
