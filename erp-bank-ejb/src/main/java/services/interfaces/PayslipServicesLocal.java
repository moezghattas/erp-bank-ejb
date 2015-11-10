package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Payslip;

@Local
public interface PayslipServicesLocal {
	Boolean addMateriel(Payslip payslip);
	
	Boolean deleteMaterielById(Integer id);

	Payslip findMaterielById(Integer id);

	Boolean updateMateriel(Payslip payslip);

	Boolean deleteMateriel(Payslip payslip);

	List<Payslip> findAllPayslip();
}
