package tn.esprit.spring.khaddemmaramarfaoui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    Store findBystoreName(String storeName);
}
