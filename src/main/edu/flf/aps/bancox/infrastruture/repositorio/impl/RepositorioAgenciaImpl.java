package edu.flf.aps.bancox.infrastruture.repositorio.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioJPA;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioAgencia;

@Service
public class RepositorioAgenciaImpl extends RepositorioJPA<Agencia> implements RepositorioAgencia {
}
