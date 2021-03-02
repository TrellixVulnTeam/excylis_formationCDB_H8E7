package com.excilys.formationCDB.controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.formationCDB.dto.AddComputerDTO;
import com.excilys.formationCDB.dto.EditComputerDTO;
import com.excilys.formationCDB.dto.mapper.CompanyMapper;
import com.excilys.formationCDB.dto.mapper.ComputerMapper;
import com.excilys.formationCDB.exception.CustomSQLException;
import com.excilys.formationCDB.logger.CDBLogger;
import com.excilys.formationCDB.service.CompanyService;
import com.excilys.formationCDB.service.ComputerService;

/**
 * Servlet implementation class EditComputerServlet
 */
@WebServlet("/EditComputerServlet")
public class EditComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_ERRORS = "errors";
	public static final String ATT_COMPANYLIST = "companyList";
	public static final String INPUT_ID = "computerId";
	public static final String ATT_COMPUTER_DTO = "computerDTO";
	public static final String VIEW = "/WEB-INF/views/editComputer.jsp";

	private ComputerService serviceComputer = ComputerService.getInstance();
	private CompanyService serviceCompany = CompanyService.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		handleRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EditComputerForm form = new EditComputerForm();
		EditComputerDTO computerDTO = form.editComputer(request);

		request.setAttribute(ATT_ERRORS, form.getErrors());
		request.setAttribute(ATT_COMPUTER_DTO, computerDTO);
		handleRequest(request, response);
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response) {
		addCompanyList(request);
		if (request.getParameter(INPUT_ID) != null) {
			try {
				int computerId = Integer.parseInt(request.getParameter(INPUT_ID));
				EditComputerDTO computerDTO = ComputerMapper.createEditComputerDTO(serviceComputer.getComputerById(computerId)); 
				request.setAttribute(ATT_COMPUTER_DTO, computerDTO);
				System.out.println(computerDTO);
			} catch (NumberFormatException numberFormatExceptoin) {
				CDBLogger.logInfo(numberFormatExceptoin);
			}
		}
		try {
			this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
		} catch (ServletException | IOException exception) {
			CDBLogger.logError(exception);
		}
	}
	
	private void addCompanyList(HttpServletRequest request) {
		try {
			request.setAttribute(ATT_COMPANYLIST,CompanyMapper.createAddCompanyDTOList(serviceCompany.getCompanyList()) );
		} catch (CustomSQLException exception) {
			CDBLogger.logError(exception);
		}
	}
	

}
