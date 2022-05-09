package br.com.etechoracio.boa_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;

public class ViagemService {

	public class ViagemController {
		@Autowired
		private ViagemRepository repository;

		public List<Viagem> listarTodos() {
			return repository.findAll();

		}

		public Optional<Viagem> buscarPorID(Long id) {
			return repository.findById(id);
		}

		public boolean deletarPorID(Long id) {
			boolean existe = repository.existsById(id);
			if (existe) {
				repository.findById(id);
			}
			return existe;
		}

		public Viagem inserir(Viagem obj) {
			return repository.save(obj);
		}

		public Optional<Viagem> atualizar(Long id, Viagem viagem) {
			boolean existe = repository.existsById(id);
			if (!existe) {
				return null;
			}

			return Optional.of(repository.save(viagem));/*aa*/
		}
	}
}
