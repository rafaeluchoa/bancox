package com.naskar.bancox.ui;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.service.ManterAgencia;
import com.naskar.infrastructure.ui.EntityController;


/**
 * @author rafaeluchoa
 */
@Service
@Scope("prototype")
public class ManterAgenciaController extends EntityController<
	Agencia, ManterAgenciaListView, ManterAgenciaFormView, ManterAgencia
> {
		
}
