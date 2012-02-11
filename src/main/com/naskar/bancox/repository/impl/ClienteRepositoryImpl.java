package com.naskar.bancox.repository.impl;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Cliente;
import com.naskar.bancox.repository.ClienteRepository;
import com.naskar.infrastructure.repository.impl.JPARepository;


@Service
public class ClienteRepositoryImpl extends JPARepository<Cliente> implements ClienteRepository {
}