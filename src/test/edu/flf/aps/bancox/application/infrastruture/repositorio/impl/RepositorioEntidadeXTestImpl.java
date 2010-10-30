package edu.flf.aps.bancox.application.infrastruture.repositorio.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.domain.EntidadeXTest;
import edu.flf.aps.bancox.application.infrastruture.repositorio.RepositorioEntidadeXTest;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioJPA;

@Service
public class RepositorioEntidadeXTestImpl extends RepositorioJPA<EntidadeXTest> implements RepositorioEntidadeXTest {
	
}