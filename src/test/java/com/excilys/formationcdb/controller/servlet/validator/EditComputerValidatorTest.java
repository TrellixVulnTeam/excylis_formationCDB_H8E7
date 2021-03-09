package com.excilys.formationcdb.controller.servlet.validator;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.excilys.formationcdb.controller.servlet.AddComputerForm;
import com.excilys.formationcdb.controller.servlet.validator.AddComputerValidator;
import com.excilys.formationcdb.dto.AddComputerDTO;

public class EditComputerValidatorTest {

	@Test
	public void testValidateName() {
		AddComputerValidator validator = AddComputerValidator.getInstance();
		AddComputerDTO computerDTO = new AddComputerDTO();
		computerDTO.companyId = "1";
		computerDTO.computerName = "ok";
		Map<String, String> errors = validator.validate(computerDTO);
		assertEquals(true, errors.isEmpty());
	}

	@Test
	public void testValidateCompanyId() {
		AddComputerValidator validator = AddComputerValidator.getInstance();
		AddComputerDTO computerDTO = new AddComputerDTO();
		computerDTO.companyId = "1";
		computerDTO.computerName = "ok";
		Map<String, String> errors = validator.validate(computerDTO);
		assertEquals(true, errors.isEmpty());
		computerDTO.companyId = "";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerForm.INPUT_COMPANYID));
		computerDTO.companyId = "500";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerForm.INPUT_COMPANYID));
		computerDTO.companyId = "0";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerForm.INPUT_COMPANYID));
	}

	@Test
	public void testValidateDate() {
		AddComputerValidator validator = AddComputerValidator.getInstance();
		AddComputerDTO computerDTO = new AddComputerDTO();
		computerDTO.companyId = "1";
		computerDTO.computerName = "ok";
		computerDTO.discontinuedDate = "54646546546";
		computerDTO.introducedDate = "";
		Map<String, String> errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerForm.INPUT_INTRODUCED));
		computerDTO.discontinuedDate = "";
		computerDTO.introducedDate = "854625";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerForm.INPUT_INTRODUCED));
		computerDTO.discontinuedDate = "2021-01-20";
		computerDTO.introducedDate = "2021-12-20";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerForm.INPUT_INTRODUCED));
		computerDTO.discontinuedDate = "2021-12-20";
		computerDTO.introducedDate = "2021-01-20";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.isEmpty());
	}
}