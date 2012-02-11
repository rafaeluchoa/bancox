package com.naskar.bancox.service;

import com.naskar.bancox.domain.ContaBancaria;
import com.naskar.bancox.domain.Pessoa;

public interface EfetuarTransferencia {
	void transfira(ContaBancaria origem, ContaBancaria destino, Pessoa pessoa);
}
