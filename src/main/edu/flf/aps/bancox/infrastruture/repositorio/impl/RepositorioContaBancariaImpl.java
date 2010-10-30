package edu.flf.aps.bancox.infrastruture.repositorio.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.domain.ContaBancaria;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioJPA;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioContaBancaria;

@Service
public class RepositorioContaBancariaImpl extends RepositorioJPA<ContaBancaria> implements RepositorioContaBancaria {
}
