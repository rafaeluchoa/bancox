package edu.flf.aps.bancox.application;

import java.util.List;

import edu.flf.aps.bancox.application.vo.AutenticarClienteDTO;

public interface AutenticarCliente {
	List<Integer[]> gerarTeclasAleatorias();
	void autenticarCliente(AutenticarClienteDTO vo);
}
