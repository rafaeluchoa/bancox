package com.naskar.bancox.service.impl;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Endereco;
import com.naskar.bancox.repository.EnderecoRepository;
import com.naskar.bancox.service.ManterEndereco;
import com.naskar.infrastructure.service.impl.EntityDomainServiceImpl;

@Service
public class ManterEnderecoImpl extends EntityDomainServiceImpl<Endereco, EnderecoRepository> implements ManterEndereco {
	
}
