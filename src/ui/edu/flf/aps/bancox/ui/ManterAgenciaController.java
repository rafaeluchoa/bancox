package edu.flf.aps.bancox.ui;

import org.springframework.stereotype.Service;

import edu.flf.aps.bancox.application.ManterAgencia;
import edu.flf.aps.bancox.domain.Agencia;
import edu.flf.aps.bancox.infrastruture.ui.ManterEntidadeController;

/**
 * @author rafaeluchoa
 */
@Service
public class ManterAgenciaController extends ManterEntidadeController<
	Agencia, ManterAgenciaListView, ManterAgenciaFormView, ManterAgencia
> {
		
}
