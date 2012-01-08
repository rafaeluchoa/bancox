package edu.flf.aps.bancox.infrastruture.ui;



/**
 * ListView
 * 
 * @author rafael
 *
 */
public interface EntityFormView<E> extends View {
	
	void setEntityListView(EntityListView entityListView);
	
	EntityListView getEntityListView();
	
	void setEntity(E entity);
	
	E getEntity();
	
	String getViewName();
	
}
