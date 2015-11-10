package services.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CertificateOfDeposit;
import services.interfaces.CerticateOfDepositRemote;

/**
 * Session Bean implementation class CerticateOfDeposit
 */
@Stateless
public class CerticateOfDeposit implements CerticateOfDepositRemote, CerticateOfDepositLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public CerticateOfDeposit() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addCertificateOfDeposit(CertificateOfDeposit certificateOfDeposit) {
  		Boolean b = false;
  				
  					entityManager.persist(certificateOfDeposit);
  					b = true;
  				
  				return b;
  	}

  	public Boolean deleteCertificateOfDepositById(Integer id) {
  		Boolean b = false;
  				try {
  					entityManager.remove(findCertificateOfDepositById(id));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	
  	public CertificateOfDeposit findCertificateOfDepositById(Integer id) {
  		return entityManager.find(CertificateOfDeposit.class, id);
  		
  	}

  	public Boolean updateCertificateOfDeposit(CertificateOfDeposit certificateOfDeposit) {
  		
  		Boolean b = false;
  				try {
  					entityManager.merge(certificateOfDeposit);
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	public Boolean deleteCertificateOfDeposit(CertificateOfDeposit certificateOfDeposit) {
  		Boolean b = false;
  				try {
  					entityManager.remove(entityManager.merge(certificateOfDeposit));
  					b = true;
  				} catch (Exception e) {
  					System.err.println("ouups ...");
  				}
  				return b;
  	}

  	@SuppressWarnings("unchecked")
  	
  	public List<CertificateOfDeposit> findAllCertificateOfDeposit() {
  		String jpql = "select e from CertificateOfDeposit e";
  				Query query = entityManager.createQuery(jpql);
  				return query.getResultList();
  	}


}
