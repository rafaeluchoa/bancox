package edu.flf.aps.bancox.application;

import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.domain.Pessoa;

public interface EfetuarTransferencia {
	void transfira(ContaBancaria origem, ContaBancaria destino, Pessoa pessoa);
}
