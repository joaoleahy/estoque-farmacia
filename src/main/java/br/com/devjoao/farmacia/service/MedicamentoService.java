package br.com.devjoao.farmacia.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.devjoao.farmacia.dao.DAO;
import br.com.devjoao.farmacia.model.Medicamento;
import br.com.devjoao.farmacia.utility.NegocioException;

public class MedicamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Medicamento> dao;

	public void salvar(Medicamento m) throws NegocioException {
		if (m.getNome().length() < 3) {
			throw new NegocioException("O nome do medicamento não pode ter menos que 3 caracteres");
		}
		dao.salvar(m);
	}

	public void remover(Medicamento m) throws NegocioException {
		dao.remover(Medicamento.class, m.getId());
	}

	public List<Medicamento> todosOsMedicamentos() {
		return dao.buscarTodos("select m from Medicamento m order by m.nome");
	}
}
