package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.CandidaciesDemands;

@Local
public interface CandidaciesDemandsServicesLocal {
Boolean addcandidaciesdemands(CandidaciesDemands candidaciesdemands);
	
	Boolean deletecandidaciesdemandsById(Integer id);

	CandidaciesDemands findcandidaciesdemandsById(Integer id);

	Boolean updatecandidaciesdemands(CandidaciesDemands candidaciesdemands);

	Boolean deletecandidaciesdemands(CandidaciesDemands candidaciesdemands);

	List<CandidaciesDemands> findAllCandidaciesDemands();
}
