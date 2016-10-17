package com.pharma.dao;

import java.util.List;

import com.pharma.exceptions.PharmaException;
import com.pharma.vo.BatchVO;

/**
 * @author vinay.v
 * 
 *         This is an Interface For all the JDBC Code implementation and data
 *         Extraction logics
 *
 */
public interface BatchDAO {
	/**
	 * This methods takes batchVO objects as arguments, calculates the shipping
	 * charge and saves the batch in the system and adds them to the database
	 * specified tables if the data gets added it return true else false and
	 * throws PharmaException if any exception occurs at the SQl level
	 * 
	 * @param batchVO
	 * @return addition result
	 * @throws PharmaException
	 */
	public abstract boolean addDetails(final BatchVO batchVO)
			throws PharmaException;

	/**
	 * This method returns all the data present in the database as specifed in
	 * the SQL query in the form of List
	 * 
	 * @return Generic List of type BatchVo by fetching all the details from the
	 *         DataBase
	 * @throws PharmaException
	 */
	public abstract List<BatchVO> retrieveDetails() throws PharmaException;

	/**
	 * This method is used for validating the existence of the batch code in the
	 * system. If the batch code exists the method should return true else
	 * false.
	 * 
	 * @param batchCode
	 * @return batchCode existence status
	 * @throws PharmaException
	 */

	public boolean checkBatchCode(final String batchCode)
			throws PharmaException;

	/**
	 * This method is used for validating the existence of the medicine code in
	 * the system.If the medicine code exists the method should return true else
	 * false.
	 * 
	 * @param medicineCode
	 * @return medicineCode existence status
	 * @throws PharmaException
	 */
	public boolean checkMedicineCode(final String medicineCode)
			throws PharmaException;

	/**
	 * Used for getting the shipping charge for a specific medicine type code
	 * and weight range.
	 * 
	 * @param medicineTypeCode
	 * @param weightRange
	 * @return shippingCharges
	 * @throws PharmaException
	 */
	public int getShippingCharge(final String medicineTypeCode,
			final String weightRange) throws PharmaException;

}
