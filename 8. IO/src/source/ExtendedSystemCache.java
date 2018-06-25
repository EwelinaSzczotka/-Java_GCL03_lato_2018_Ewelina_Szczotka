package source;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class ExtendedSystemCache extends SystemCache{
    
    void exportCSV(String path) throws IOException{
        
        exportCSV(new FileOutputStream(new File(path)));
        
    }
    
    void exportCSV(File file) throws IOException{
        
        exportCSV(new FileOutputStream(file));
        
    }
    
    void exportCSV(OutputStream stream) throws IOException{
        
        StringBuilder line = new StringBuilder();
        Iterator it = cache.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry)it.next();
                line.append(entry.getKey().toString());
                line.append(String.valueOf(entry.getValue()));
                line.append("\n");
                it.remove();
            }
            
        stream.write(line.toString().getBytes());
        
        System.out.println("File exported successfully.");
        
    }
    
    
    void importCSV(String path) throws IOException{
        
        importCSV(new FileInputStream(new File(path)));
        
    }
    
    void importCSV(File file) throws IOException{
        
        importCSV(new FileInputStream(file));
        
    }
    
    void importCSV(InputStream stream) throws IOException{
        
        Scanner scanner = null;
        try{
            scanner = new Scanner(stream);
            String line;
            cache.clear();
            while(scanner.hasNext()){
                line=scanner.next();
                String[] values = line.split(",");
                double[] input = new double[values.length-1];
                Double output = null;
                for(int i = 0; i<values.length;i++){
                    if(i==((values.length)-1))
                        output=Double.parseDouble(values[i]);
                    else
                        input[i] = Double.parseDouble(values[i]);  
                }
                put(input, output);
            }
            System.out.println("File imported successfully.");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        scanner.close();
        }   
        
    }
    
    
    void serialize(String path) throws IOException{
        
        serialize(new FileOutputStream(new File(path)));
  
    }
    
    void serialize(File file) throws IOException{
        
        serialize(new FileOutputStream(file));
        
    }
    
    void serialize(OutputStream stream) throws IOException{
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(this);
            oos.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Serialization successfull.");
        
    }
    
    
    void deserialize(String path) throws IOException{
        
        deserialize(new FileInputStream(new File(path)));
        
    }
    
    void deserialize(File file) throws IOException{
        
        deserialize(new FileInputStream(file));
    }
    
    void deserialize(InputStream stream) throws IOException{
        
        ExtendedSystemCache systemCache = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(stream);
            systemCache = (ExtendedSystemCache)ois.readObject();
            this.cache = systemCache.cache;
            ois.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Deserialization successfull.");
        
    }
    
    void save(String path) throws IOException{
        
        save(new File(path));
        
    }
    
    void save(File file) throws IOException{
        
        save(new FileOutputStream(file));
        
    }
    
    void save(OutputStream stream) throws IOException{
        
            DataOutputStream dos = new DataOutputStream(stream);
            
            Iterator it = cache.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry)it.next();
                String key = entry.getKey().toString();
                String[] in = key.split(",");
                double[] input = new double[in.length];
                for(int i = 0;i<in.length;i++){
                    input[i] = Double.parseDouble(in[i]);
                    dos.writeDouble(input[i]);
                }
                String value = String.valueOf(entry.getValue());
                dos.writeDouble(Double.parseDouble(value));
                it.remove();
            }
            System.out.println("File saved successfully.");
            dos.close();
    }
    
    void load(String path) throws IOException {
        
        load(new FileInputStream(new File(path)));
        
    }
    
    void load(File file) throws IOException{
        
        load(new FileInputStream(file));
    }
    
    void load(InputStream stream) throws IOException{
        
        DataInputStream dis = null;
        cache.clear();
        try {
            dis = new DataInputStream(stream);
            while (true) {
                double i1 = dis.readDouble();
                double i2 = dis.readDouble();
                double i3 = dis.readDouble();
                double output = dis.readDouble();       
                double[] input = {i1,i2,i3};
                put(input,output);
            }
        } catch (EOFException e) {
        dis.close();
        }
        System.out.println("File loaded successfully.");
        
    }
}
