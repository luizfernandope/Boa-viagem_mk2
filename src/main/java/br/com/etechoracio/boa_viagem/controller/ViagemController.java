package br.com.etechoracio.boa_viagem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;

@RestController
@RequestMapping("/viagem")
public class ViagemController {
	@Autowired
	private ViagemRepository repository;
	
	@GetMapping
	public List<Viagem> listarTodos()
	{
		return repository.findAll();

	}
	//fazendo metodo de requisição da tabela gasto por id
	@GetMapping("/{id}")
	public Viagem buscarPorID(@PathVariable Long id) 
	{
		return repository.findById(id).orElse(null);
	}
	//metodo para deletar 
	@DeleteMapping("/{id}")
	public void deletarPorID(@PathVariable Long id) 
	{
		repository.findById(id);
	}
	//metodo para postar alterações na tabela
	@PostMapping("/{id}")
	public ResponseEntity<Viagem> inserir(@RequestBody Viagem obj){
		repository.save(obj);
		return ResponseEntity.ok(obj);
	}
	//metodo para inserir alterações a1
	@PutMapping("/{id}")
	public ResponseEntity<Viagem> atualizar (@PathVariable Long id, @RequestBody Viagem viagem) {
		boolean existe = repository.existsById(id);
		if (existe) {
			return ResponseEntity.notFound().build();
		}
		
		repository.save(viagem);
		return ResponseEntity.ok(viagem);
	}
}
