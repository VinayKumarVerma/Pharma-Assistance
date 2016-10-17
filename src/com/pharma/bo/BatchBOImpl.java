/**
 * 
 */
package com.pharma.bo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pharma.dao.BatchDAO;
import com.pharma.dao.BatchDAOImpl;
import com.pharma.exceptions.PharmaBusinessException;
import com.pharma.exceptions.PharmaException;
import com.pharma.vo.BatchVO;

/**
 * @author vinay.v
 *
 */
public class BatchBOImpl implements BatchBO {
	private BatchDAO batchDAO;

	/**
	 * 
	 */
	public BatchBOImpl() {
		super();
		batchDAO = new BatchDAOImpl();
	}

	/**
	 * @param batchVO
	 * @return boolean
	 * @throws PharmaBusinessException
	 * @throws PharmaException
	 */
	@Override
	public boolean addBatch(final BatchVO batchVO)
			throws PharmaBusinessException, PharmaException {
		boolean batchUpdationFlag = false;
		boolean result1 = this.validateBatchCode(batchVO.getBatchCode());
		boolean result2 = this.validateMedicineCode(batchVO.getMedicineCode());
		boolean result3 = this.validateBatchWeight(batchVO.getWeight());
		String medicineTypeName = batchVO.getMedicineTypeName();
		switch (medicineTypeName) {
		case "Capsules":
			batchVO.setMedicineTypeCode("C");
			batchVO.setCareLevel("High");
			break;
		case "Syrups":
			batchVO.setMedicineTypeCode("S");
			batchVO.setCareLevel("Extremely_High");
			break;

		default:
			batchVO.setMedicineTypeCode("T");
			batchVO.setCareLevel("Normal");
			break;
		}
		if (result1 && result2 && result3) {
			batchVO.setShippingCharge(this.calculateShippingCharge(
					batchVO.getMedicineTypeCode(), batchVO.getWeight(),
					batchVO.isRefrigeration()));
			batchUpdationFlag = batchDAO.addDetails(batchVO);
		}
		return batchUpdationFlag;

	}

	/**
	 * 
	 * @return List, containing list of all the details to be displayed to the
	 *         user
	 * @throws PharmaBusinessException
	 * @throws PharmaException
	 */
	@Override
	public List<BatchVO> retrieveBatchDetails() throws PharmaBusinessException,
			PharmaException {
		List<BatchVO> batchList = batchDAO.retrieveDetails();
		if (batchList.isEmpty()) {
			throw new PharmaBusinessException("Batch Code Does not exist");
		}
		return batchList;
	}

	/**
	 * This method is used to validate the medicine code. If the medicine code
	 * does not exist it Throws PharmaBusinessException with error code 510
	 * 
	 * @param medicineCode
	 * @return true if medicineCode exist
	 * @throws PharmaBusinessException
	 */
	private boolean validateMedicineCode(final String medicineCode)
			throws PharmaBusinessException {
		boolean medicineCodeflag = false;
		try {
			medicineCodeflag = batchDAO.checkMedicineCode(medicineCode);
		} catch (PharmaException e) {
			e.printStackTrace();
		}
		if (medicineCodeflag == false) {
			throw new PharmaBusinessException(
					"510-Medicine Code Does Not Exist");
		}
		return medicineCodeflag;
	}

	/**
	 * This method is used to validate the batch code. If the batchcode already
	 * exist it Throws PharmaBusinessException with error code 511 and If the
	 * batch code not in the format “BTC-” then it Throws
	 * PharmaBusinessException with error code 513
	 * 
	 * @param batchCode
	 * @return batchCodeFlag
	 * @throws PharmaBusinessException
	 */
	private boolean validateBatchCode(final String batchCode)
			throws PharmaBusinessException {
		boolean batchCodeflag = false;
		try {
			batchCodeflag = batchDAO.checkBatchCode(batchCode);
		} catch (PharmaException e) {
			e.printStackTrace();
		}
		String pattren = "BTC-[0-9]{4}";
		Pattern myPattren = Pattern.compile(pattren);
		Matcher matcher = myPattren.matcher(batchCode);
		if (!matcher.matches()) {
			batchCodeflag = false;
			throw new PharmaBusinessException(
					"513-Batch format wrong. It should be in the format \"BTC-1234\" ");
		} else if (batchCodeflag == true) {
			batchCodeflag = false;
			throw new PharmaBusinessException("511-Batch Code already Exist");

		}
		return !batchCodeflag;
	}

	/**
	 * This method is used to validate the batch weight.If the batch weight is
	 * less then 100 then it Throws PharmaBusinessException with error code 512
	 * 
	 * @param weight
	 * @return true if it meets the bussiness requrements
	 * @throws PharmaBusinessException
	 */
	private boolean validateBatchWeight(final int weight)
			throws PharmaBusinessException {
		boolean batchWeightFlag = false;
		if (weight < 100) {
			throw new PharmaBusinessException(
					"512-Batch weight should be greator than 100");
		} else {
			batchWeightFlag = true;
		}
		return batchWeightFlag;
	}

	/**
	 * This method is used to get the batchWeight range based on the business
	 * logic that is is weight range is W1,W2,W3 if the batch weight is
	 * <500,500<weight<1000,>1000 respectively and first checks for the
	 * Validation of batchWeight using validateBatchWeight method, throws
	 * pharmaException from that method
	 * 
	 * @param weight
	 * @return weightRange
	 */
	private String batchWeightRange(final int weight)
			throws PharmaBusinessException {

		String weightRange = null;
		try {
			boolean weightRangeFlag = this.validateBatchWeight(weight);
			if (weightRangeFlag) {
				if (weight <= 500) {
					weightRange = "W1";
				} else if (weight <= 1000) {
					weightRange = "W2";
				} else {
					weightRange = "W3";
				}
			}
		} catch (PharmaBusinessException e) {
			e.printStackTrace();
		}
		return weightRange;
	}

	/**
	 * This method calculates the Updated Shipping Charge based on refrigeration
	 * requirement.If the refrigeration is required Shipping charge is added
	 * with 5% of shipping charge.
	 * 
	 * @param medicineTypeCode
	 * @param weight
	 * @param refrigeration
	 * @return shipping charge based on refrigeration specifiaction
	 */
	private double calculateShippingCharge(final String medicineTypeCode,
			final int weight, final boolean refrigeration) {
		boolean refrigerationFlag = refrigeration;
		double shippingCharge = 0.0d;
		String weightRange;
		try {
			weightRange = this.batchWeightRange(weight);
			shippingCharge = batchDAO.getShippingCharge(medicineTypeCode,
					weightRange);
		} catch (PharmaException e) {
			e.printStackTrace();
		} catch (PharmaBusinessException e) {
			e.printStackTrace();
		}
		if (refrigerationFlag) {
			shippingCharge += 0.05 * shippingCharge;
		}
		return shippingCharge;
	}
}