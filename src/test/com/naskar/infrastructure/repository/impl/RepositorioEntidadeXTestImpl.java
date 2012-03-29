package com.naskar.infrastructure.repository.impl;

import org.springframework.stereotype.Service;

import com.naskar.infrastructure.domain.EntidadeXTest;
import com.naskar.infrastructure.repository.RepositorioEntidadeXTest;


@Service
public class RepositorioEntidadeXTestImpl extends JPARepository<EntidadeXTest> implements RepositorioEntidadeXTest {
	
}