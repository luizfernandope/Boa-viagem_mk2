package br.com.etechoracio.boa_viagem.controller;

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

import br.com.etechoracio.boa_viagem.entity.Gasto;
import br.com.etechoracio.boa_viagem.repository.GastoRepository;
import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {
	@Autowired
	private GastoRepository repository;
	
	@GetMapping
	public List<Gasto> listarTodos()
	{
		return repository.findAll();

	}
	//fazendo metodo de requisição da tabela gasto por id
	@GetMapping("/{id}")
	public Gasto buscarPorID(@PathVariable Long id) 
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
	public ResponseEntity<Gasto> inserir(@RequestBody Gasto obj){
		repository.save(obj);
		return ResponseEntity.ok(obj);
	}
	//metodo para inserir alterações
	@PutMapping("/{id}")
	public ResponseEntity<Gasto> atualizar (@PathVariable Long id, @RequestBody Gasto gasto) {
		boolean existe = repository.existsById(id);
		if (existe) {
			return ResponseEntity.notFound().build();
		}
		
		repository.save(gasto);
		return ResponseEntity.ok(gasto);
	}
}
