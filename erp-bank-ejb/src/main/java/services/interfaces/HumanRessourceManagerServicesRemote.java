package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.HumanRessourceManager;

@Remote
public interface HumanRessourceManagerServicesRemote {
	Boolean addhumanressource_manager(HumanRessourceManager humanressource_manager);
	
	Boolean deletehumanressource_managerById(Integer id);

	HumanRessourceManager findhumanressource_managerById(Integer id);

	Boolean updatehumanressource_manager(HumanRessourceManager humanressource_manager);

	Boolean deletehumanressource_manager(HumanRessourceManager humanressource_manager);

	List<HumanRessourceManager> findAllHumanRessourceManager();	
}
