package com.naskar.bancox.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.domain.Pessoa;
import com.naskar.bancox.domain.PessoaFisica;
import com.naskar.bancox.domain.PessoaJuridica;
import com.naskar.bancox.domain.TipoPessoa;
import com.naskar.bancox.service.AbrirConta;
import com.naskar.bancox.service.vo.AbrirContaVO;
import com.naskar.infrastructure.ui.Controller;
import com.naskar.infrastructure.ui.ViewFactory;


/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class AbrirContaController extends Controller {
	
	@Autowired
	private ViewFactory viewFactory;

	@Autowired
	private AbrirConta abrirConta;
	
	public AbrirContaView init() {
		return viewFactory.createView(AbrirContaView.class);
	}
	
	public List<Agencia> busqueAgencias() {
		return abrirConta.getAgencias();
	}

	public void abraConta(AbrirContaView view) {

		Pessoa pessoa;
		if (view.getTipoPessoa() == TipoPessoa.FISICA) {
			pessoa = new PessoaFisica();
			pessoa.setNome(view.getFisicaNome());
			pessoa.setEmail(view.getFisicaEmail());
		} else {
			pessoa = new PessoaJuridica();
			// TODO: logica da pessoa juridica
		}

		AbrirContaVO vo = new AbrirContaVO();
		vo.setPessoa(pessoa);
		vo.setTipoContaBancaria(view.getTipoConta());
		vo.setAgencia(view.getAgencia());
		
		abrirConta.abraConta(vo);
		
		getViewManager().removeView(view);
	}
	
	public List<Agencia> getAgencias() {
		return abrirConta.getAgencias();
	}

}
