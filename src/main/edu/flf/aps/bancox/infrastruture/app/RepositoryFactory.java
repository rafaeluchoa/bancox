package edu.flf.aps.bancox.infrastruture.app;

import edu.flf.aps.bancox.infrastruture.Entidade;
import edu.flf.aps.bancox.infrastruture.Repositorio;

public interface RepositoryFactory {

	<E extends Entidade, T extends Repositorio<E>> T createRepository(Class<T> clazz);
	
}
