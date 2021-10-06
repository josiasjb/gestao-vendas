package com.gvendas.gestaovendas.servive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.execao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorio.CategorioRepositorio;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategorioRepositorio categorioRepositorio;
	
	public List<Categoria> listarTodas() {
		return categorioRepositorio.findAll();
		
	}

	public Optional<Categoria> buscarPorCodigo(Long codigo) {
		return categorioRepositorio.findById(codigo);
		
	}
	
	public Categoria salvar(Categoria categoria) {
		validarCategoriaDuplicada(categoria);
		return categorioRepositorio.save(categoria);
		
	}
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalvar = validaCategoriaExiste(codigo);
		validarCategoriaDuplicada(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
		return categorioRepositorio.save(categoriaSalvar);
	}
	
	public void deletar(Long codigo) {
		categorioRepositorio.deleteById(codigo);
	}

	private Categoria validaCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarPorCodigo(codigo);
		if (categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();
	}
	
	private void validarCategoriaDuplicada(Categoria categoria) {
		Categoria categoriaEncontrada = categorioRepositorio.findByNome(categoria.getNome());
		if (categoriaEncontrada != null && categoriaEncontrada.getCodigo() != categoria.getCodigo()) {
			throw new RegraNegocioException(
					String.format("A categoria %s já esta cadastrada", categoria.getNome().toUpperCase()));
		}
	}
}
