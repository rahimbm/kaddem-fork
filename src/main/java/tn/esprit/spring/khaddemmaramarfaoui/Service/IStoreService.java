package tn.esprit.spring.khaddemmaramarfaoui.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Store;

import java.util.List;
import java.util.Map;

public interface IStoreService {
    List<Store> findAll();

    Store retrieveItem(Long idItem);
    Store add(Store store) ;

    void delete(Long id);

    Store update(Store Storee1);
    public Store findStoreByName(String storeName);

    public void AffectProductToStore(Long storId ,Long productId);


    public int Filtrage_bad_word(String ch) ;

    //public ResponseEntity<?> addressMapss(Long  idEvent) throws IOException, InterruptedException;
    public ResponseEntity<Map<String, Object>> setLatLngToStore(Long storeId);
}
