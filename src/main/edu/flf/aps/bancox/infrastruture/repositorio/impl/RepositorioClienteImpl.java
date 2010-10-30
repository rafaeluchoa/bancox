package edu.flf.aps.bancox.infrastruture.repositorio.impl;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.domain.Cliente;
import edu.flf.aps.bancox.infrastruture.impl.RepositorioJPA;
import edu.flf.aps.bancox.infrastruture.repositorio.RepositorioCliente;

@Service
public class RepositorioClienteImpl extends RepositorioJPA<Cliente> implements RepositorioCliente {
}