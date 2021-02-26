package com.excilys.formationCDB.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.excilys.formationCDB.exception.InvalidInputCLIHandlerException;

public class Computer {

	private String name;
	private int id;
	private LocalDate introduced;
	private LocalDate discontinued;
	private Company company;

	public static class ComputerBuilder {
		private String name;
		private int id;
		private LocalDate introduced;
		private LocalDate discontinued;
		private Company company;
		
		public ComputerBuilder setId(int id) {
			this.id = id;
			return this;
		}
		
		public ComputerBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public ComputerBuilder setIntroduced(LocalDate introduced) {
			this.introduced = introduced;
			return this;
		}
		
		public ComputerBuilder setDiscontinued(LocalDate discontinued) {
			this.discontinued = discontinued;
			return this;
		}
		
		public ComputerBuilder setCompany(Company company) {
			this.company = company;
			return this;
		}
		
		public Computer build() {
			return new Computer(name, id, introduced, discontinued, company);
		}
	}
	
	private Computer(String name, int id, LocalDate introduced, LocalDate discontinued, Company company) {
		this.name = name;
		this.id = id;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	public LocalDate getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(LocalDate discontinued) {
		this.discontinued = discontinued;
	}

	public LocalDate getIntroduced() {
		return introduced;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name).append(", constructed ");
		if (company != null) {
			stringBuilder.append("by ").append(company.getName()).append(",");
		}
		stringBuilder.append(" from ");
		stringBuilder.append(localDateToString(introduced));
		stringBuilder.append(" to ");
		stringBuilder.append(localDateToString(discontinued));
		return stringBuilder.toString();
	}

	private String localDateToString(LocalDate localDate) {
		if (localDate == null) {
			return "///";
		} else {
			return localDate.toString();
		}
	}
}
