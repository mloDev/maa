package de.mlo.service;

import java.util.List;

import de.mlo.exception.DuplicateReqException;
import de.mlo.exception.ReqNotFoundException;
import de.mlo.model.Req;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReqService.
 */
public interface ReqService {

	/**
	 * Adds the req.
	 *
	 * @param req the req
	 * @throws DuplicateReqException the duplicate req exception
	 */
	public void addReq(Req req)
			throws DuplicateReqException;

	/**
	 * Gets the req.
	 *
	 * @param id the id
	 * @return the req
	 * @throws ReqNotFoundException the req not found exception
	 */
	public Req getReq(int id) throws ReqNotFoundException;

	/**
	 * Gets the req.
	 *
	 * @param reqname the reqname
	 * @return the req
	 * @throws ReqNotFoundException the req not found exception
	 */
	public Req getReq(Integer reqId)
			throws ReqNotFoundException;

	/**
	 * Update req.
	 *
	 * @param req the req
	 * @throws ReqNotFoundException the req not found exception
	 * @throws DuplicateReqException the duplicate req exception
	 */
	public void updateReq(Req req)
			throws ReqNotFoundException, DuplicateReqException;

	/**
	 * Delete req.
	 *
	 * @param id the id
	 * @throws ReqNotFoundException the req not found exception
	 */
	public void deleteReq(int id) throws ReqNotFoundException;

	/**
	 * Gets the reqs.
	 *
	 * @return the reqs
	 */
	public List<Req> getReqs();

	public List<Req> getReqsByStudent(int studentId);

}
