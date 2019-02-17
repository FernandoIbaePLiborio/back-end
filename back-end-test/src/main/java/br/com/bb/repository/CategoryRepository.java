package br.com.bb.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bb.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
