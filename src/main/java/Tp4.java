
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import model.Adresse;
import model.AssuranceVie;
import model.Banque;
import model.Client;
import model.Compte;
import model.LivretA;
import model.Operation;
import model.Virement;
import repository.PersistenceHelper;

public class Tp4 {

    public static void main(String[] args) {
        insertEntities();
    }
    
    private static void insertEntities() {
        EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);

        Banque banque = new Banque();
        banque.setNom("Banque Principale");
        em.persist(banque);

        Compte compte1 = new Compte();
        compte1.setNumero("10000");
        compte1.setSolde(500D);
        Compte compte2 = new Compte();
        compte2.setNumero("10001");
        compte2.setSolde(321D);
        em.persist(compte1);
        em.persist(compte2);
        
        Virement virement1 = new Virement();
        virement1.setBeneficiaire("jojo");
        em.persist(virement1);
        Virement virement2 = new Virement();
        virement2.setBeneficiaire("bobo");
        em.persist(virement2);
        
        Operation operation1 = new Operation();
        operation1.setMontant(100D);
        em.persist(operation1);
        Operation operation2 = new Operation();
        operation2.setMontant(200D);
        em.persist(operation2);
        
        
        
        List<Operation> listOperations1 = new ArrayList<>();
        listOperations1.add(virement1);
        listOperations1.add(virement2);
        listOperations1.add(operation1);
        listOperations1.add(operation2);       
        
        Compte compte3 = new Compte();
        compte3.setNumero("10003");
        compte3.setSolde(333D);
        compte3.setOperations(listOperations1);
        
        em.persist(compte3);
        
     
        
        
        AssuranceVie assuranceVie1 = new AssuranceVie();
        assuranceVie1.setTaux(3.3D);
        assuranceVie1.setNumero("1234");
        em.persist(assuranceVie1);
        
        em.persist(compte3);
        
        LivretA livretA1 = new LivretA();
        livretA1.setTaux(2.2D);
        em.persist(livretA1);
        
     
        
        
        List<Compte> listeComptes1 = new ArrayList<>();
        listeComptes1.add(compte1);
        listeComptes1.add(compte2);
        listeComptes1.add(compte3);
        List<Compte> listeComptes2 = new ArrayList<>();
        listeComptes2.add(compte2);
        listeComptes2.add(compte3);
        listeComptes2.add(assuranceVie1);
        listeComptes2.add(livretA1);
       

        Adresse adresseC1 = new Adresse();
        adresseC1.setNumero(42);
        adresseC1.setRue("Rue du test");
        adresseC1.setVille("La-Teste-De-Buch");
        adresseC1.setCodePostal(11111);
        Adresse adresseC2 = new Adresse();
        adresseC2.setNumero(99);
        adresseC2.setRue("Rue du Code");
        adresseC2.setVille("Codond-les-bois");
        adresseC2.setCodePostal(22222);
        em.persist(adresseC1);
        em.persist(adresseC2);

        Client client1 = new Client();
        client1.setNom("PREMIER");
        client1.setPrenom("Client");
        client1.setBanque(banque);
        client1.setComptes(listeComptes1);
        client1.setAdresse(adresseC1);
        Client client2 = new Client();
        client2.setNom("SECOND");
        client2.setPrenom("Client");
        client2.setBanque(banque);
        client2.setComptes(listeComptes2);
        client1.setAdresse(adresseC2);
        em.persist(client1);
        em.persist(client2);
        
        Client client3 = new Client();
        client3.setNom("TROISIEME");
        client3.setPrenom("Client");
        client3.setBanque(banque);
        client3.setComptes(listeComptes2);
        client3.setAdresse(adresseC2);
       
        em.persist(client3);
     
        
        PersistenceHelper.commitTxAndClose(em);
    }

}
