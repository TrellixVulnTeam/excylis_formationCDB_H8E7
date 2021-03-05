package com.excilys.formationcdb.dao;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import com.excilys.formationcdb.dao.DAOComputer;
import com.excilys.formationcdb.exception.CustomSQLException;
import com.excilys.formationcdb.exception.NothingSelectedException;
import com.excilys.formationcdb.model.Computer;

public class DAOComputerTest {

	//@Test
	public void testGetComputerById() {
		Computer computer = new Computer.ComputerBuilder().setId(1).setName("MacBook Pro 15.4 inch").build();
		DAOComputer daoComputer = DAOComputer.getInstance();
		assertEquals(Optional.of(computer), daoComputer.getComputerById(1));
	}

	@Test
	public void testDeleteComputerById() {
		DAOComputer daoComputer = DAOComputer.getInstance();
		try {
			daoComputer.deleteComputerById(1);
		} catch (NothingSelectedException e) {
			e.printStackTrace();
		}
		assertEquals(daoComputer.getComputerById(1), Optional.empty());
	}
}
