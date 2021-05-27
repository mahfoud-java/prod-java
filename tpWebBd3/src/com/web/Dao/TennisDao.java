package com.web.Dao;

import java.util.List;

public interface TennisDao<T> {
	void ajouter(T val);

	List<T> lister();

	void modifier(T val);

	void supprimer(Long id);

	T lecture(Long id);

	List<T> rechercher(String chaine);
}
