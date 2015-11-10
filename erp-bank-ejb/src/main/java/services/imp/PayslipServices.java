package services.imp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Payslip;
import services.interfaces.PayslipServicesLocal;
import services.interfaces.PayslipServicesRemote;

/**
 * Session Bean implementation class PayslipServices
 */
@Stateless
@LocalBean
public class PayslipServices implements PayslipServicesRemote, PayslipServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PayslipServices() {
        // TODO Auto-generated constructor stub
    }
    public Boolean addMateriel(Payslip payslip) {
		Boolean b = false;
				try {
					entityManager.persist(payslip);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteMaterielById(Integer id) {
		Boolean b = false;
				try {
					entityManager.remove(findMaterielById(id));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Payslip findMaterielById(Integer id) {
		return entityManager.find(Payslip.class, id);
		
	}

	@Override
	public Boolean updateMateriel(Payslip payslip) {
		
		Boolean b = false;
				try {
					entityManager.merge(payslip);
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@Override
	public Boolean deleteMateriel(Payslip payslip) {
		Boolean b = false;
				try {
					entityManager.remove(entityManager.merge(payslip));
					b = true;
				} catch (Exception e) {
					System.err.println("ouups ...");
				}
				return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payslip> findAllPayslip() {
		String jpql = "select e from Payslip e";
				Query query = entityManager.createQuery(jpql);
				return query.getResultList();
	}


}
