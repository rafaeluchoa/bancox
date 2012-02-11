package com.naskar.bancox.ui;

import org.springframework.stereotype.Service;

import com.naskar.bancox.domain.Agencia;
import com.naskar.bancox.service.ManterAgencia;
import com.naskar.infrastructure.ui.EntityController;


/**
 * @author rafaeluchoa
 */
@Service
public class ManterAgenciaController extends EntityController<
	Agencia, ManterAgenciaListView, ManterAgenciaFormView, ManterAgencia
> {
		
}
