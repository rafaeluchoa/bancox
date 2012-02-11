package com.naskar.bancox.service.impl;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.repository.AgenciaRepository;
import com.naskar.bancox.service.ManterAgencia;
import com.naskar.infrastructure.service.impl.EntityDomainServiceImpl;


@Service
public class ManterAgenciaImpl extends EntityDomainServiceImpl<Agencia, AgenciaRepository> implements ManterAgencia {
	
}
