import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tools.ant.DirectoryScanner;

public class LazyRename {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lazyRename("iubla","bg_institute_default", "/Users/ssiddh/sunapsis/mobile/sunapsis-iom-mobile/app/App_Resources");
	}
	
	public static void lazyRename(String oldFilename, String newFilename, String baseFolder){
		
		String baseDir = baseFolder + "/";
		String pattern = "**/" + oldFilename + "*.png";
		DirectoryScanner scanner = new DirectoryScanner();
		scanner.setIncludes(new String[] {pattern});
		scanner.setBasedir(baseFolder);
		scanner.setCaseSensitive(false);
		scanner.scan();
		String[] files = scanner.getIncludedFiles();
		
		if (files.length > 0){
			for (String s: files){
				try{
					Path source = Paths.get(baseDir+s);
					Path destination = source.resolveSibling(newFilename+".png");
					if (s.contains("_2x") || s.contains("@2x")){
						destination = source.resolveSibling(newFilename+"@2x.png");
					}else if(s.contains("_3x") || s.contains("@3x")){
						destination = source.resolveSibling(newFilename+"@3x.png");
					}
					Files.move(source, destination);
					System.out.println("Renamed : " + source.toString() + " to : " + destination.toString());
				}catch(Exception e){
					System.out.println("Failed");
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("No files found! Check input parameters and try again.");
		}
	}

}
