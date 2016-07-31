package de.mlo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mlo.exception.DuplicateReqException;
import de.mlo.exception.ReqNotFoundException;
import de.mlo.model.Req;
import de.mlo.repository.ReqRepository;


// TODO: Auto-generated Javadoc
/**
 * The Class ReqServiceImpl.
 */
@Service
@Transactional
public class ReqServiceImpl implements ReqService {
	
	/** The req repo. */
	@Autowired
	ReqRepository reqRepo;

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#addReq(de.mlo.model.Req)
	 */
	@Override
	public void addReq(Req req) throws DuplicateReqException {
		reqRepo.saveAndFlush(req);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#getReq(int)
	 */
	@Override
	public Req getReq(int id) throws ReqNotFoundException {
		return reqRepo.getOne(id);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#getReq(java.lang.String)
	 */
	@Override
	public Req getReq(Integer reqId) throws ReqNotFoundException {
		return reqRepo.findOne(reqId);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#updateReq(de.mlo.model.Req)
	 */
	@Override
	public void updateReq(Req req) throws ReqNotFoundException, DuplicateReqException {
		reqRepo.saveAndFlush(req);
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#deleteReq(int)
	 */
	@Override
	public void deleteReq(int id) throws ReqNotFoundException {
		reqRepo.delete(id);
		
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#getReqs()
	 */
	@Override
	public List<Req> getReqs() {
		return reqRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see de.mlo.service.ReqService#getReqsByStudent(de.mlo.model.Student)
	 */
	@Override
	public List<Req> getReqsByStudent(int studentId) {
		return reqRepo.findAllByStudentId(studentId);
	}


}
