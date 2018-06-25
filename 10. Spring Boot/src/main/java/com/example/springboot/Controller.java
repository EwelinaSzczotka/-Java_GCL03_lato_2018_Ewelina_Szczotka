package com.example.springboot;

import java.io.IOException;
import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/gallery")
public class Controller {
    
    @Autowired
    private ImageService imageService;
    
    
    @RequestMapping(value= "/pictures2", method = RequestMethod.GET)
    public ModelAndView getImg(){
        List<Image> list = imageService.getList();
        ModelAndView model = new ModelAndView("images");
        model.addObject("lists", list);
        return model;
    }
    
    @RequestMapping("/a")
   public String index() {
      return "index";
   }
    
    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id") int id) throws IOException {
        return imageService.getImage(id);
    }
    
    @RequestMapping(value= "/pictures", method = RequestMethod.GET)
    public Collection<Image> getImages(){
        return imageService.getImages();
    }
    
    @RequestMapping(value = "/picture/{id}", method = RequestMethod.DELETE)
    public boolean deleteImage(@PathVariable("id") int id){
        return imageService.deleteImage(id);
    }
    
}
