package br.edu.ifg.interfaces;

import java.util.List;

public interface Repository <T, I>{
	
	void save(T t);
	void remove(T t);
	T get(I id);
	List<T> list();

}
