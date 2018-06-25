package source;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;

public class RandomAccessFileSystemCache{
    
    private HashMap<Parameter, Double> cache = new HashMap<>();
    private RandomAccessFile raf = null;
    private File file = null;
    private int numberOfEntries = 0;
    private int numberOfInputs = 0;
    
    public RandomAccessFileSystemCache(String path, int numberOfInputs){
        this.numberOfInputs=numberOfInputs;
        file = new File(path);
        if(file.exists()){
            importFile(file);
        }
        else{
            try{
                file.createNewFile();
                System.out.println("File created.");
            }
            catch(IOException e){
                e.printStackTrace();
            }
            numberOfEntries = 0;
        }
    }
    
    public void importFile(File file){
        
        try{
            raf = new RandomAccessFile(file, "rw");
            raf.seek(0);
            int numberOfEntries = raf.readInt();
            int number = raf.readInt();
            if(number==numberOfInputs){
                    try {
                        while (true) {
                            double[] input = new double[numberOfInputs];
                            double output = 0;
                            for(int i = 0; i <= numberOfInputs;i++){
                                double n = raf.readDouble();
                                if(i==numberOfInputs)
                                    output = n;
                                else
                                    input[i] = n;
                            }
                            put(input,output);
                        }
                    }catch (EOFException ex){}
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                System.out.println("File imported.");
                raf.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void set(double[] input, double output){
        
        if(input.length == numberOfInputs){
            numberOfEntries++;
            put(input,output);

            try{
                raf=new RandomAccessFile(file, "rw");
                raf.seek(0);
                raf.writeInt(numberOfEntries);
                raf.seek(8+numberOfEntries*(numberOfInputs*8+8));
                for(int i = 0; i<numberOfInputs;i++){
                    raf.writeDouble(input[i]);
                }
                raf.writeDouble(output);
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }finally{
                try{
                    if(file!=null)
                    raf.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            System.out.println("File and map updated.");
        }
        else{
            System.out.println("Wrong number of inputs.");
        }
        
    }
    
    public Double get( double[] input ){
        if(input.length!=numberOfInputs)
            throw new IllegalArgumentException();
        return this.cache.get( new Parameter( input ) );
    }
    
    public void put( double[] input, double output ){
        this.cache.put( new Parameter( input ), output );
    }
    
    public void printMap(){
        for (HashMap.Entry<Parameter, Double> entry : cache.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
    
    private class Parameter{
        
        private double[] values;

        public Parameter( double[] values )
        {
            this.values = values;
        }
        
        @Override
        public int hashCode()
        {
            return 31 + Arrays.hashCode( this.values );
        }
        
        @Override
        public boolean equals( Object obj )
        {
            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( this.getClass() != obj.getClass() )
                return false;
            Parameter other = (Parameter) obj;
            if ( !Arrays.equals( this.values, other.values ) )
                return false;
            return true;
        }
        
        public String toString(){
            String s="";
            for(double x:values){
                s+=x+" ";
            }
            return s;
        }
    }
}
