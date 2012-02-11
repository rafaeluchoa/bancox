package com.naskar.bancox.repository.impl;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.repository.AgenciaRepository;
import com.naskar.infrastructure.repository.impl.JPARepository;


@Service
public class AgenciaRepositoryImpl extends JPARepository<Agencia> implements AgenciaRepository {
}
