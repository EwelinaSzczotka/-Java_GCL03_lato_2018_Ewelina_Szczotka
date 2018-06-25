package source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class IO {
    public static void main(String[] args) {
        
        ScatterSystem system = new ScatterSystem();
        ExtendedSystemCache cache = new ExtendedSystemCache();
        
        double[] input = {10,20,30};
        Double output = cache.get(input);
        
        if(output==null){
            output=system.makeOpertaion(input);
            cache.put(input,output);
        }
        
        double[] input2 = {5,2,5};
        Double output2 = cache.get(input2);
        
        if(output2==null){
            output2=system.makeOpertaion(input2);
            cache.put(input2,output2);
        }
        
        String path = "C:" + File.separator + "Java" + File.separator + "IO" + File.separator + "file.csv";
        File file = new File(path);
        OutputStream os = null;
        InputStream is = null;
        File sFile = new File("C:/Java/IO/sFile.ser");
        File tFile = new File("C:/Java/IO/tFile.bin");
        
        
        try{
            //CSV
            System.out.println("CSV:");
            cache.exportCSV(path);
            cache.importCSV(path);
            cache.exportCSV(file);
            cache.importCSV(file);
            os = new FileOutputStream(file);
            cache.exportCSV(os);
            is = new FileInputStream(file);
            cache.importCSV(is);
            //Serialization
            System.out.print("\nSerialization:\n");
            cache.serialize(sFile);
            cache.deserialize(sFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
            os.close();
            is.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
        
        System.out.print("\nData I/O S0tream:\n");
        
        cache.printMap();
        try{
            cache.save(tFile);
            cache.load(tFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        cache.printMap();
        
        
        System.out.print("\nRandomAccesFile:\n");
        
        RandomAccessFileSystemCache randomCache = new RandomAccessFileSystemCache("C:/Java/IO/randomFile.bin",3);
        
        double[] input3 = {10,20,30};
        Double output3 = randomCache.get(input3);
        if(output3==null){
            output3=system.makeOpertaion(input3);
            randomCache.set(input3,output3);
        }
        double[] input4 = {5,2,5};
        Double output4 = randomCache.get(input4);
        if(output4==null){
            output4=system.makeOpertaion(input4);
            randomCache.set(input4,output4);
        }

        randomCache.printMap();
        
    }
}
