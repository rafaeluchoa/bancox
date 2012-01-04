package edu.flf.aps.bancox.infrastruture.ui;


public interface ViewFactory {

	<T extends View> T createView(Class<T> clazz);
	
}
