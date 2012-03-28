package com.naskar.bancox.repository.impl;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Endereco;
import com.naskar.bancox.repository.EnderecoRepository;
import com.naskar.infrastructure.repository.impl.JPARepository;

@Service
public class EnderecoRepositoryImpl extends JPARepository<Endereco> implements EnderecoRepository {
}
