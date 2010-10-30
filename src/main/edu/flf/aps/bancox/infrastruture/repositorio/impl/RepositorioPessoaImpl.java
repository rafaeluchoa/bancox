package edu.flf.aps.bancox.infrastruture.repositorio.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.domain.Pessoa;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioJPA;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioPessoa;

@Service
public class RepositorioPessoaImpl extends RepositorioJPA<Pessoa> implements RepositorioPessoa {
}