import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;

import org.apache.tools.ant.DirectoryScanner;

public class Lazy {

	public static void main(String[] args) {
		lazyCopy("ic_filter_2", "/Users/ssiddh/Downloads/ic_filter_1_white_24dp", "/Users/ssiddh/Downloads/demo-workers-master/app/App_Resources");
	}
	
	public static void lazyCopy(String filename, String baseFolder, String destinationFolder){
		String baseDir = baseFolder + "/";
		Hashtable<String, String> fileFolder = new Hashtable<String, String>();
		fileFolder.put("drawable-hdpi", destinationFolder + "/Android/drawable-hdpi/");
		fileFolder.put("drawable-mdpi", destinationFolder + "/Android/drawable-mdpi/");
		fileFolder.put("drawable-xhdpi", destinationFolder + "/Android/drawable-xhdpi/");
		fileFolder.put("drawable-xxhdpi", destinationFolder + "/Android/drawable-xxhdpi/");
		fileFolder.put("drawable-xxxhdpi", destinationFolder + "/Android/drawable-xxxhdpi/");
		fileFolder.put("ios", destinationFolder  +"/iOS/");
		String pattern = "**/" + filename + "*.png";
		DirectoryScanner scanner = new DirectoryScanner();
		scanner.setIncludes(new String[] {pattern});
		scanner.setBasedir(baseFolder);
		scanner.setCaseSensitive(false);
		scanner.scan();
		String[] files = scanner.getIncludedFiles();
		if (files.length > 0){
			for (String s: files){
				if (s.contains("drawable-hdpi")) {
					String destinationString = fileFolder.get("drawable-hdpi");
					Path source = Paths.get(baseDir+s);
					String newName = "";
					if (s.contains("_24dp")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_24dp", "");
					}else {
						newName = source.getFileName().toString();
					}
					Path destination = Paths.get(destinationString+newName);
					try {
						Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Copied : " + source.toString() + " to : " + destination.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed");
						e.printStackTrace();
					}
				}else if (s.contains("drawable-mdpi")) {
					String destinationString = fileFolder.get("drawable-mdpi");
					Path source = Paths.get(baseDir+s);
					String newName = "";
					if (s.contains("_24dp")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_24dp", "");
					}else {
						newName = source.getFileName().toString();
					}
					Path destination = Paths.get(destinationString+newName);
					try {
						Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Copied : " + source.toString() + " to : " + destination.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed");
						e.printStackTrace();
					}
				}else if (s.contains("drawable-xhdpi")) {
					String destinationString = fileFolder.get("drawable-xhdpi");
					Path source = Paths.get(baseDir+s);
					String newName = "";
					if (s.contains("_24dp")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_24dp", "");
					}else {
						newName = source.getFileName().toString();
					}
					Path destination = Paths.get(destinationString+newName);
					try {
						Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Copied : " + source.toString() + " to : " + destination.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed");
						e.printStackTrace();
					}
				}else if (s.contains("drawable-xxhdpi")) {
					String destinationString = fileFolder.get("drawable-xxhdpi");
					Path source = Paths.get(baseDir+s);
					String newName = "";
					if (s.contains("_24dp")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_24dp", "");
					}else {
						newName = source.getFileName().toString();
					}
					Path destination = Paths.get(destinationString+newName);
					try {
						Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Copied : " + source.toString() + " to : " + destination.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed");
						e.printStackTrace();
					}
				}else if (s.contains("drawable-xxxhdpi")) {
					String destinationString = fileFolder.get("drawable-xxxhdpi");
					Path source = Paths.get(baseDir+s);
					String newName = "";
					if (s.contains("_24dp")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_24dp", "");
					}else {
						newName = source.getFileName().toString();
					}
					Path destination = Paths.get(destinationString+newName);
					try {
						Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Copied : " + source.toString() + " to : " + destination.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed");
						e.printStackTrace();
					}
				}else if (s.contains("ios")) {
					String destinationString = fileFolder.get("ios");
					Path source = Paths.get(baseDir+s);
					String newName = "";
					if (s.contains("_2x")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_2x", "@2x");
					}else if (s.contains("_3x")){
						String temp = source.getFileName().toString();
						newName = temp.replace("_3x", "@3x");
					}else {
						newName = source.getFileName().toString();
					}
					Path destination = Paths.get(destinationString+newName);
					try {
						Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Copied : " + source.toString() + " to : " + destination.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed");
						e.printStackTrace();
					}
				}
			}
		}else {
			System.out.println("No files found! Check input parameters and try again.");
		}
	}
}
