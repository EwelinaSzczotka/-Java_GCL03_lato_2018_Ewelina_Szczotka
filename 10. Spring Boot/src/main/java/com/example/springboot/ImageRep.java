package com.example.springboot;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRep {
    
    private boolean result;
    private ImageProperties properties;
    
    private static Map<Integer,Image> images;
    
    static{
        images = new HashMap<Integer,Image>(){
            {
                put(1,new Image(1,"owl","800x533",200435));
                put(2,new Image(2,"cat","224x224",5640));
                put(3,new Image(3,"dog","640x480",28269));
            }
        };
    }
    
    
    public List<Image> getList(){
        List<Image> list = new ArrayList<Image>(images.values());
        return list;
    }
    
    public Collection<Image> getImages(){
        return this.images.values();
    }

    public byte[] getImage(int id) throws IOException {
        Image image = images.get(id);
        String name = image.getName();
        //InputStream is = new FileInputStream(properties.getPath()+name+".jpg");
        InputStream in = new FileInputStream("src/main/resources/images/"+name+".jpg");
        return toByteArray(in);
    }
    
    public boolean deleteImage(int id){
        if(images.containsKey(id)){
            this.images.remove(id);
            result = true;
            return result;
        }
        else {
            result = false;
            return result;
        }
    }
    
    public byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int l;
        byte[] data = new byte[1024];
        while ((l = is.read(data, 0, data.length)) != -1) {
          buffer.write(data, 0, l);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
}
