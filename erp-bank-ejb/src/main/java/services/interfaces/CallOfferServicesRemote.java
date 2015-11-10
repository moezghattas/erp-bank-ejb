package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.CallOffer;

@Remote
public interface CallOfferServicesRemote {

	Boolean addcall_offer(CallOffer call_offer);
	
	Boolean deletecall_offerById(Integer id);

	CallOffer findcall_offerById(Integer id);

	Boolean updatecall_offer(CallOffer call_offer);

	Boolean deletecall_offer(CallOffer call_offer);

	List<CallOffer> findAllCallOffer();
}
