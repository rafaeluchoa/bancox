package edu.flf.aps.bancox.application.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.AutenticarCliente;
import edu.flf.aps.bancox.application.dto.AutenticarClienteDTO;

/**
 * @author rafaeluchoa
 */
@Service
public class AutenticarClienteImpl implements AutenticarCliente {
	
	private Random random;
	
	public AutenticarClienteImpl() {
		random = new Random(new Date().getTime());
	}

	public List<Integer[]> gerarTeclasAleatorias() {		
		List<Integer> numeros = new ArrayList<Integer>(10);
		while(numeros.size() < 10) {
			int n = random.nextInt(10);
			if(!numeros.contains(n)) {
				numeros.add(n);
			}
		}
		List<Integer[]> digitos = new ArrayList<Integer[]>();
		for(int i = 0; i < numeros.size(); i += 2) {
			digitos.add(new Integer[] { numeros.get(i), numeros.get(i+1) });
		}
		return digitos;
	}

	@Override
	public void autenticarCliente(AutenticarClienteDTO vo) {
		
		// TODO:autenticarClienteImpl
	}
	
	

}
