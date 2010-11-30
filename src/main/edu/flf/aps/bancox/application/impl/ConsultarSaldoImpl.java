package edu.flf.aps.bancox.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ConsultarSaldo;
import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.infrastruture.app.NegocioException;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioContaBancaria;

@Service
public class ConsultarSaldoImpl implements ConsultarSaldo {
	
	@Autowired
	private RepositorioContaBancaria repositorioContaBancaria;

	@Override
	public Float consultarSaldo(String numeroConta) {
		ContaBancaria conta = repositorioContaBancaria.findByNumeroConta(numeroConta);
		if(conta == null) throw new NegocioException("Conta Bancaria não encontrada.");
		
		return new Float(conta.getSaldo());
	}
	
}
