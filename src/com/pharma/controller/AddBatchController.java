package com.pharma.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.bo.BatchBOImpl;
import com.pharma.exceptions.PharmaBusinessException;
import com.pharma.exceptions.PharmaException;
import com.pharma.vo.BatchVO;

/**
 * This is a Controller Class used to Add The batch Details .It takes the
 * request and response data from the addBatch JSP pages and redirects it to the
 * AddBatchController which takes care of adding it to the databases
 * 
 * Servlet implementation class AddBatchController
 */
public class AddBatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BatchBOImpl batchBO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBatchController() {
		super();
		batchBO = new BatchBOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			BatchVO batchVO = new BatchVO();
			try {
				String batchCode = request.getParameter("batchCode");
				String medicineCode = request.getParameter("medicineCode");
				int weight = Integer.parseInt(request.getParameter("weight"));
				double price = Double
						.parseDouble(request.getParameter("price"));
				String medicineTypeName = request
						.getParameter("medicineTypeName");
				boolean refrigeration = Boolean.parseBoolean(request
						.getParameter("refrigeration"));
				batchVO.setBatchCode(batchCode);
				batchVO.setMedicineCode(medicineCode);
				batchVO.setWeight(weight);
				batchVO.setPrice(price);
				batchVO.setMedicineTypeName(medicineTypeName);
				batchVO.setRefrigeration(refrigeration);
			} catch (NumberFormatException e) {
				throw new PharmaBusinessException(e);
			} catch (NullPointerException e) {
				throw new PharmaBusinessException(e);
			}
			boolean batchAdditionFlag = batchBO.addBatch(batchVO);
			if (batchAdditionFlag) {
				dispatcher = request.getRequestDispatcher("regSuccess.jsp");
				dispatcher.forward(request, response);
			}
		} catch (PharmaException e) {
			String message = e.getMessage();
			request.setAttribute("message", message);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} catch (PharmaBusinessException e) {
			String message = e.getMessage();
			request.setAttribute("message", message);
			dispatcher = request.getRequestDispatcher("addBatch.jsp");
			dispatcher.forward(request, response);
		}
	}
}
