package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.StoreRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Store;

import java.util.List;
import java.util.Map;
@Service
@AllArgsConstructor
public class StoreService implements IStoreService{
    StoreRepository storeRepository ;
    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store retrieveItem(Long idItem) {
        return storeRepository.findById(idItem).get();
    }

    @Override
    public Store add(Store store) {
         return storeRepository.save(store);
    }

    @Override
    public void delete(Long storeId) {

        storeRepository.deleteById(storeId);
    }

    @Override
    public Store update(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store findStoreByName(String storeName) {
        return storeRepository.findBystoreName(storeName);
    }


    @Override
    public void AffectProductToStore(Long storId, Long productId) {

    }

    @Override
    public int Filtrage_bad_word(String ch) {
        return 0;
    }

    @Override
    public ResponseEntity<Map<String, Object>> setLatLngToStore(Long storeId) {
        return null;
    }
}
