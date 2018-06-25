
package com.example.springboot;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ImageService {
    
    @Autowired
    private ImageRep imageRep;
    
    public Collection<Image> getImages(){
        return this.imageRep.getImages();
    }
    
    public boolean deleteImage(int id){
        return this.imageRep.deleteImage(id);
    }
    
    public byte[] getImage(int id) throws IOException {
        return this.imageRep.getImage(id);
    }
    
    public List<Image> getList(){
        return this.imageRep.getList();
    }
}
