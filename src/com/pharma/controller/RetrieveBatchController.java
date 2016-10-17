package com.pharma.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharma.bo.BatchBO;
import com.pharma.bo.BatchBOImpl;
import com.pharma.exceptions.PharmaBusinessException;
import com.pharma.exceptions.PharmaException;
import com.pharma.vo.BatchVO;

/**
 * This is a Controller Class used to Retrieve the batch Details .It takes the
 * request and response data from the retrieve.jsp JSP pages and redirects it to
 * the RetrieveJSTl page and then to RetrieveBatchController which takes care of
 * retrieving the data from the databases
 * 
 * Servlet implementation class RetrieveBatchController
 */
public class RetrieveBatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BatchBO batchBO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveBatchController() {
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
			List<BatchVO> batchList = batchBO.retrieveBatchDetails();
			request.setAttribute("batchList", batchList);
			dispatcher = request.getRequestDispatcher("retrieveJSTL.jsp");
			dispatcher.forward(request, response);
		} catch (PharmaBusinessException e) {
			String message = e.getMessage();
			request.setAttribute("message", message);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} catch (PharmaException e) {
			String message = e.getMessage();
			request.setAttribute("message", message);
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
