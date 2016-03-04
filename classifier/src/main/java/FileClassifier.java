import java.io.*;
import java.io.FileInputStream;
import java.nio.file.Files;
import org.apache.tika.*;


public class FileClassifier {

    public static String tarDir="";

    public static void searchFiles(File directory) throws Exception{
        Tika tika = new Tika();
        File[] list = directory.listFiles();
        for(File file : list) {
            if(file.isDirectory()){
                searchFiles(file);
            }else {
                System.out.println(file.getName());
                FileInputStream fIS = new FileInputStream(file);
                String type = tika.detect(fIS);
                fIS.close();
                System.out.println(type);
                File temp = new File(tarDir+"/"+type+"/"+"data");
                temp.mkdirs();
                File tar = new File(tarDir+"/"+type+"/"+"data"+"/"+file.getName());
                try {
                    Files.move(file.toPath(), tar.toPath());
                }catch(Exception e){
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 2){
            System.out.println("Usage: FileClassifier.java <sourcefiles_dir> <targetfiles_dir>");
        }else {
            String[] fileTypes = {"text/plain", "application/pdf", "application/rdf+xml", "application/rss+xml", "application/xhtml+xml", "text/html", "image/png", "image/jpeg", "audio/mpeg", "video/mp4", "video/quicktime", "application/x-sh", "application/gzip", "application/msword", "application/octet-stream"};
            int count = 0;
            File directory = new File(args[0]);
            tarDir =  new java.io.File(args[1]).getCanonicalPath();
            searchFiles(directory);
            System.out.println(count);
            for(int i = 0; i < fileTypes.length; i++){
                File fileType = new File(tarDir + "/" + fileTypes[i] + "/data");
                File dir = new File(tarDir+"/"+fileTypes[i]+"/"+"test_data");
                dir.mkdir();
                File[] files = fileType.listFiles();
                for(int j = 0; j < (files.length * 0.25); j++){
                    File tar = new File(tarDir+"/"+fileTypes[i]+"/"+"test_data"+"/"+files[j].getName());
                    Files.move(files[j].toPath(), tar.toPath());
                }
            }
        }
    }
}