package edu.flf.aps.bancox.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.AbrirConta;
import edu.flf.aps.bancox.application.vo.AbrirContaVO;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.domain.Pessoa;
import edu.flf.aps.bancox.domain.PessoaFisica;
import edu.flf.aps.bancox.domain.PessoaJuridica;
import edu.flf.aps.bancox.domain.TipoPessoa;

/**
 * @author rafaeluchoa
 */
@Service
public class AbrirContaController implements Controller {

	@Autowired
	private AbrirConta abrirConta;
	
	public AbrirContaView init(ViewManager viewManager) {
		AbrirContaView view = new AbrirContaView(this);
		view.setViewManager(viewManager);
		view.init(abrirConta.getAgencias());
		return view;
	}

	public void abraConta(AbrirContaView view) {

		Pessoa pessoa;
		if (view.getTipoPessoa() == TipoPessoa.FISICA) {
			pessoa = new PessoaFisica();
			pessoa.setNome(view.getFisicaNome());
			pessoa.setEmail(view.getFisicaEmail());
		} else {
			pessoa = new PessoaJuridica();
			// TODO
		}

		AbrirContaVO vo = new AbrirContaVO();
		vo.setPessoa(pessoa);
		vo.setTipoContaBancaria(view.getTipoConta());
		vo.setAgencia(view.getAgencia());
		
		try {
			abrirConta.abraConta(vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	// TODO: melhorar isso aqui
		view.getViewManager().feche(view);
	}
	
	public List<Agencia> getAgencias() {
		return abrirConta.getAgencias();
	}

}
