package edu.flf.aps.bancox.application.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ManterAgencia;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.infrastruture.impl.ManterEntidadeImpl;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioAgencia;

@Service
public class ManterAgenciaImpl extends ManterEntidadeImpl<Agencia, RepositorioAgencia> implements ManterAgencia {
	
}
