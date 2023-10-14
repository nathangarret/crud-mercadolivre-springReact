package br.com.crud.backend.repositorio;

import br.com.crud.backend.modelo.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {
}