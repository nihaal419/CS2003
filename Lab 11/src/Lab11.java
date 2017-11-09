import java.nio.file.*;
import java.io.File;
import java.io.IOException;

public class Lab11 {
	public static void main(String [] args) throws IOException{
		
		//Finds the proper SPEED files and deletes the ones that aren't correct
		explore(new File("/Users/Nihaal/Downloads/Backup/SPEED"));
		
		//Checks if the number listed in the filenames is the same amount as the files in the directory
		checkNumber(new File("/Users/Nihaal/Downloads/Backup/APOLLO"));
		
		
		
//		Path p1 = Paths.get("/Users/Nihaal/Downloads/Backup/SPEED/*");
//		if(Files.isReadable(p1)&&Files.isExecutable(p1)&&Files.isRegularFile(p1)) {
//			System.out.println("good");
//		}
//		else {
//			System.out.println("bad");
//		}
//		
//		//File file = new File("/Users/Nihaal/Downloads/Backup/SPEED/SPEED_20171102_1of10.txt");
//		String pattern = "SPEED_20171102_[0-9]of10.txt";
//		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
//		
//		for(int i=0; i<=10; i++) {
//			File file = new File("/Users/Nihaal/Downloads/Backup/SPEED/SPEED_20171102_" + i + "of10.txt");
//			Path filePath = Paths.get(file.getPath());
//			Path fileName = filePath.getFileName();
//			String name = fileName.toString();
//			if(matcher.matches(fileName)) 
//				System.out.println(fileName);
//			else
//				System.out.println("no match");
//		}
//		
////		Path filename = p1.getFileName();
////		if(matcher.matches(filename)) 
////			System.out.println(filename);
////		else
////			System.out.println("no match");
	}
	
	public static void explore(File dir) {
		String pattern = ".txt";
		
		File listFile[] = dir.listFiles();
		if(listFile != null) {
			for(int i=0; i<listFile.length; i++) {
				if(listFile[i].isDirectory()) {
					explore(listFile[i]);
				}
				else {
					if(listFile[i].getName().endsWith(pattern)) {
						System.out.println(listFile[i].getPath());
					}
					else {
						System.out.println("Deleted: " + listFile[i].getName());
						listFile[i].delete();
					}
				}
			}
		}
	}
	
	public static void checkNumber(File dir) {
		File listFile[] = dir.listFiles();
		String name = listFile[0].getName();
		String num = name.substring(name.length()-5, name.length()-4);
		int end = Integer.parseInt(num);
		if(listFile.length == end) {
			System.out.println("The proper amount of files are within the directory");
		}
		else {
			System.out.println("There are files missing within the directory");
		}
	}
}
