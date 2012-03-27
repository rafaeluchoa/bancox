package com.naskar.infrastructure.ui;

public interface ViewFactory {

	<T extends View> T createView(Class<T> clazz);
	
}
