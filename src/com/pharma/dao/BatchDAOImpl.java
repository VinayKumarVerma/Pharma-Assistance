/**
 * 
 */
package com.pharma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.pharma.exceptions.PharmaException;
import com.pharma.util.PropertyUtil;
import com.pharma.vo.BatchVO;

/**
 * @author vinay.v
 *
 */
public class BatchDAOImpl implements BatchDAO {

	/**
	 * 
	 */

	@Override
	public boolean addDetails(final BatchVO batchVO) throws PharmaException {
		boolean additionflag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PropertyUtil.getConnection();
			final String ADD_DETAIL_QUERY = "INSERT INTO BATCH_INFO VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(ADD_DETAIL_QUERY);
			preparedStatement.setString(1, batchVO.getBatchCode());
			preparedStatement.setString(2, batchVO.getMedicineCode());
			preparedStatement.setDouble(3, batchVO.getWeight());
			preparedStatement.setDouble(4, batchVO.getPrice());
			preparedStatement.setString(5, batchVO.getMedicineTypeCode());
			preparedStatement.setDouble(6, batchVO.getShippingCharge());
			preparedStatement.setString(7, batchVO.getCareLevel());
			int updateCount = preparedStatement.executeUpdate();
			if (updateCount > 0) {
				additionflag = true;
			}

		} catch (SQLException e) {
			throw new PharmaException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return additionflag;
	}

	@Override
	public List<BatchVO> retrieveDetails() throws PharmaException {
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		List<BatchVO> batchList = new ArrayList<BatchVO>();
		try {
			connection = PropertyUtil.getConnection();
			String retrieveQuery = "SELECT batch_code,medicine_code,medicine_name,medicine_type_code,medicine_type_name,care_level,weight,price,shipping_charge,price+shipping_charge AS Total_Amount FROM (SELECT * FROM batch_info JOIN medicine_master USING(medicine_code)) I JOIN (SELECT medicine_type_name,medicine_type_code FROM medicine_type_master) A USING (medicine_type_code)";
			pstStatement = connection.prepareStatement(retrieveQuery);
			resultSet = pstStatement.executeQuery();
			while (resultSet.next()) {
				BatchVO batchVO = new BatchVO();
				batchVO.setBatchCode(resultSet.getString(1));
				batchVO.setMedicineCode(resultSet.getString(2));
				batchVO.setMedicineName(resultSet.getString(3));
				batchVO.setMedicineTypeCode(resultSet.getString(4));
				batchVO.setMedicineTypeName(resultSet.getString(5));
				batchVO.setCareLevel(resultSet.getString(6));
				batchVO.setWeight(resultSet.getInt(7));
				batchVO.setPrice(resultSet.getDouble(8));
				batchVO.setShippingCharge(resultSet.getDouble(9));
				batchVO.setTotalCost(resultSet.getDouble(10));
				batchList.add(batchVO);
			}
		} catch (SQLException e) {
			throw new PharmaException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pstStatement != null) {
					pstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return batchList;
	}

	/**
	 * @param batchCode
	 * @return boolean
	 * @throws PharmaException
	 */
	@Override
	public boolean checkBatchCode(final String batchCode)
			throws PharmaException {
		boolean batchCodeFlag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PropertyUtil.getConnection();
			final String batchCodeQuery = "SELECT * FROM BATCH_INFO WHERE BATCH_CODE=?";
			preparedStatement = connection.prepareStatement(batchCodeQuery);
			preparedStatement.setString(1, batchCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				batchCodeFlag = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			batchCodeFlag = false;
		} catch (SQLException e) {
			throw new PharmaException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return batchCodeFlag;
	}

	/**
	 * @param medicineCode
	 * @return boolean
	 * @throws PharmaException
	 */
	@Override
	public boolean checkMedicineCode(final String medicineCode)
			throws PharmaException {
		boolean medicineCodeFlag = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PropertyUtil.getConnection();
			final String medicineCodeQuery = "SELECT * FROM MEDICINE_MASTER WHERE MEDICINE_CODE=?";
			preparedStatement = connection.prepareStatement(medicineCodeQuery);
			preparedStatement.setString(1, medicineCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medicineCodeFlag = true;
			}
		} catch (SQLException e) {
			throw new PharmaException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return medicineCodeFlag;
	}

	/**
	 * @param medicineTypeCode
	 * @param weightRange
	 * @return shipping charge
	 * @throws PharmaException
	 */
	@Override
	public int getShippingCharge(final String medicineTypeCode,
			final String weightRange) throws PharmaException {
		int shippingCharge = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PropertyUtil.getConnection();
			final String shippingChargeQuery = "SELECT SHIPPING_CHARGE FROM SHIPPING_MASTER WHERE MEDICINE_TYPE_CODE=? AND WEIGHT_RANGE=?";
			preparedStatement = connection
					.prepareStatement(shippingChargeQuery);
			preparedStatement.setString(1, medicineTypeCode);
			preparedStatement.setString(2, weightRange);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				shippingCharge = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new PharmaException(e);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shippingCharge;

	}

}
