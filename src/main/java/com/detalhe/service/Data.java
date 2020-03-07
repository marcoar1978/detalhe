package com.detalhe.service;

import java.time.LocalDate;

public class Data {

	public static LocalDate getDataFim(Integer ano, Integer mes) {
		Integer dias = 28;
		if ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) {
			dias = 31;
		} else if ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) {
			dias = 30;
		} else if (mes == 2) {
			dias = 28;
		}
		LocalDate dataFim = LocalDate.of(ano, mes, dias);
		return dataFim;
	}

}
