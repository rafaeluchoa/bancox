package com.naskar.bancox.ui;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Endereco;
import com.naskar.bancox.service.ManterEndereco;
import com.naskar.infrastructure.ui.EntityController;


/**
 * @author rafaeluchoa
 */
@Service
public class ManterEnderecoController extends EntityController<
	Endereco, ManterEnderecoListView, ManterEnderecoFormView, ManterEndereco
> {
		
}
