package com.naskar.bancox.repository.impl;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Pessoa;
import com.naskar.bancox.repository.PessoaRepository;
import com.naskar.infrastructure.repository.impl.JPARepository;


@Service
public class PessoaRepositoryImpl extends JPARepository<Pessoa> implements PessoaRepository {
}