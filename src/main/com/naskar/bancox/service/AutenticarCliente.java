package com.naskar.bancox.service;

import java.util.List;

import com.naskar.bancox.service.vo.AutenticarClienteVO;


public interface AutenticarCliente {
	List<Integer[]> gerarTeclasAleatorias();
	void autenticarCliente(AutenticarClienteVO vo);
}
