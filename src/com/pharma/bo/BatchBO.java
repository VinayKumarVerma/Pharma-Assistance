/**
 * 
 */
package com.pharma.bo;

import java.util.List;

import com.pharma.exceptions.PharmaBusinessException;
import com.pharma.exceptions.PharmaException;
import com.pharma.vo.BatchVO;

/**
 * @author vinay.v
 *
 */
public interface BatchBO {
	/**
	 * This is Interface for the Business Object Class and acts as interaction
	 * between the Controllers Class and the DAO Class Interface
	 * 
	 * @param batchVO
	 * @return boolean
	 * @throws PharmaBusinessException
	 * @throws PharmaException
	 */
	public abstract boolean addBatch(final BatchVO batchVO)
			throws PharmaBusinessException, PharmaException;

	/**
	 * @return List
	 * @throws PharmaBusinessException
	 * @throws PharmaException
	 */
	public abstract List<BatchVO> retrieveBatchDetails()
			throws PharmaBusinessException, PharmaException;

}
