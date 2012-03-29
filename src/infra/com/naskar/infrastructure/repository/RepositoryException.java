package com.naskar.infrastructure.repository;

@SuppressWarnings("serial")
public class RepositoryException extends RuntimeException {
	
	public RepositoryException(Exception e) {
		super(e);
	}
	
}
