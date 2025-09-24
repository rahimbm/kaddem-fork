package tn.esprit.spring.khaddemmaramarfaoui.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.khaddemmaramarfaoui.Repository.ContratRepository;
import tn.esprit.spring.khaddemmaramarfaoui.enties.Contrat;


import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ContratServiceIM implements IContratService{
ContratRepository contratRepository ;


    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        contratRepository.save(c);
        return null;
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat.longValue()).get();
    }

    @Override
    public void deleteContrat(Integer idContrat) {

        contratRepository.deleteById(idContrat.longValue());
    }

    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void retrieveAndUpdateStatusContrat(){
        List<Contrat> c = retrieveAllContrats();


        for (int i=0;i<c.size();i++){
            Long r = c.get(i).getDateFinContrat().getTime()- new Date().getTime();
            log.info("r"+r);
            Long t = r/86400000;
            log.info("t"+t);
            if ( t==0){
                c.get(i).setArchive(true);

                log.info("contrat ta3 sayed walla archivee"  +c.get(i).getEtudiant().getNomE());
            }
            else if (1<=t && t<=15){
                log.info("contrat de l'etudiant "+c.get(i).getEtudiant().getNomE() +"  "+ c.get(i).getEtudiant().getPrenomE()+"  va s'expirer le  " +
                        " "+ c.get(i).getDateFinContrat() );
            }

            else{
                log.info("contrat de l'etudiant "+c.get(i).getEtudiant().getNomE() +"  "+ c.get(i).getEtudiant().getPrenomE()+" mazeelllll  b3iddd");
            }


}}}
