package tn.esprit.spring.khaddemmaramarfaoui.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.khaddemmaramarfaoui.Service.EtudiantServiceIM;
import tn.esprit.spring.khaddemmaramarfaoui.Service.StoreService;
import tn.esprit.spring.khaddemmaramarfaoui.enties.ImageSModel;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Store;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/store")
public class StoreController {
    StoreService storeService ;
    EtudiantServiceIM etudiantService;


    @PostMapping(value="/addStore",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Store add(@RequestPart("store") Store store,
                     @RequestPart("imageFile") MultipartFile[] file)  {

        try {
           Set<ImageSModel> images = uploadImage(file);
           store.setStoreImages(images);
           return storeService.add(store);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null ;
        }

    }
public Set<ImageSModel> uploadImage(MultipartFile[] multipartFiles)  throws IOException {
    Set<ImageSModel> imageSModels = new HashSet<>();
    for(MultipartFile file : multipartFiles){
        ImageSModel imageSModel =new ImageSModel(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes()
        );
        imageSModels.add(imageSModel);
    }
    return imageSModels ;
}
    @GetMapping("/get_all_Stores")
    public List<Store> findAll() {
        return storeService.findAll();
    }

    @PutMapping("/updateStore")
    public Store update(@RequestBody Store store) {
        return storeService.update(store);
    }

    @DeleteMapping("/deleteStore/{storeId}")
    public void delete(@PathVariable("storeId") Long storeId) {
        storeService.delete(storeId);
    }

    @GetMapping("/findStoreByName/{storeName}")
    public Store findStoreByName(@PathVariable("storeName") String storeName) {
        return storeService.findStoreByName(storeName);
    }
}
