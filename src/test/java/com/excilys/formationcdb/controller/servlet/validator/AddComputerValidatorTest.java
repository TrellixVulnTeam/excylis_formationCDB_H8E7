package com.excilys.formationcdb.controller.servlet.validator;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.excilys.formationcdb.controller.servlet.form.AddComputerFormImpl;
import com.excilys.formationcdb.dto.AddComputerDTO;


//@SpringBatchTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=AddComputerValidator.class)
public class AddComputerValidatorTest {

	@Test
	public void testValidateName() {
		AddComputerValidatorImpl validator = AddComputerValidatorImpl.getInstance();
		AddComputerDTO computerDTO = new AddComputerDTO();
		computerDTO.companyId = "1";
		computerDTO.computerName = "ok";
		Map<String, String> errors = validator.validate(computerDTO);
		assertEquals(true, errors.isEmpty());
		computerDTO.computerName = "";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_NAME));
		computerDTO.computerName = "é'(-è_ç";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_NAME));
	}

	@Test
	public void testValidateCompanyId() {
		AddComputerValidatorImpl validator = AddComputerValidatorImpl.getInstance();
		AddComputerDTO computerDTO = new AddComputerDTO();
		computerDTO.companyId = "1";
		computerDTO.computerName = "ok";
		Map<String, String> errors = validator.validate(computerDTO);
		assertEquals(true, errors.isEmpty());
		computerDTO.companyId = "";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_COMPANYID));
		computerDTO.companyId = "500";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_COMPANYID));
		computerDTO.companyId = "0";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_COMPANYID));
	}

	@Test
	public void testValidateDate() {
		AddComputerValidatorImpl validator = AddComputerValidatorImpl.getInstance();
		AddComputerDTO computerDTO = new AddComputerDTO();
		computerDTO.companyId = "1";
		computerDTO.computerName = "ok";
		computerDTO.discontinuedDate = "54646546546";
		computerDTO.introducedDate = "";
		Map<String, String> errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_INTRODUCED));
		computerDTO.discontinuedDate = "";
		computerDTO.introducedDate = "854625";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_INTRODUCED));
		computerDTO.discontinuedDate = "2021-01-20";
		computerDTO.introducedDate = "2021-12-20";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.containsKey(AddComputerFormImpl.INPUT_INTRODUCED));
		computerDTO.discontinuedDate = "2021-12-20";
		computerDTO.introducedDate = "2021-01-20";
		errors = validator.validate(computerDTO);
		assertEquals(true, errors.isEmpty());
	}

}
