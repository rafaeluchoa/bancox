package com.naskar.bancox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.ContaBancaria;
import com.naskar.bancox.repository.ContaBancariaRepository;
import com.naskar.bancox.service.ConsultarSaldo;
import com.naskar.infrastructure.exception.ApplicationException;


@Service
public class ConsultarSaldoImpl implements ConsultarSaldo {
	
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;

	@Override
	public Float consultarSaldo(String numeroConta) {
		ContaBancaria conta = contaBancariaRepository.findByNumeroConta(numeroConta);
		if(conta == null) throw new ApplicationException("Conta Bancaria não encontrada.");
		
		return new Float(conta.getSaldo());
	}
	
}
