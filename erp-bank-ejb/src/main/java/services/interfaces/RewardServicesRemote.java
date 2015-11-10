package services.interfaces;

import java.util.List;


import javax.ejb.Remote;

import entities.Reward;

@Remote
public interface RewardServicesRemote {
Boolean addreward(Reward reward);
	
	Boolean deleterewardById(Integer id);

	Reward findrewardById(Integer id);

	Boolean updatereward(Reward reward);

	Boolean deletereward(Reward reward);

	List<Reward> findAllReward();
}
