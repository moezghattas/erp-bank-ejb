package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Materials;

@Remote
public interface MaterialsServicesRemote {

	
	Boolean addMateriel(Materials materiel);
	
		Boolean deleteMaterielById(Integer id);
	
		Materials findMaterielById(Integer id);
	
		Boolean updateMateriel(Materials materiel);
	
		Boolean deleteMateriel(Materials materiel);
	
		List<Materials> findAllMaterials();
}
