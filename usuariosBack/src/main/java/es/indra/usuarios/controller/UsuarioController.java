/**
 * 
 */
package es.indra.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.usuarios.model.Usuario;
import es.indra.usuarios.service.UsuarioService;

/**
 * @author daniel
 *
 */
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	/*
	 * Esta linea CrossOrigin permite el acceso de otra direccion
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllUsuario() {

		List<Usuario> todosLosUsuarios = this.usuarioService.getAlUsuario();
		ResponseEntity<List<Usuario>> response = new ResponseEntity<List<Usuario>>(todosLosUsuarios, HttpStatus.OK);

		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getToDoById(@PathVariable("id") int id) {
		Usuario user = this.usuarioService.getUsuarioById(id);
		if (user == null) {
			return new ResponseEntity<Usuario>(user, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<Void> crearBlog(@RequestBody Usuario user) {
		Usuario usuarios = this.usuarioService.saveUsuario(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateToDo(@RequestBody Usuario c) {

		Usuario usuarios = this.usuarioService.updateUsuario(c);

		if (usuarios == null) {
			return new ResponseEntity<Usuario>(usuarios, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Usuario>(usuarios, HttpStatus.OK);
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeToDoById(@PathVariable("id") int id) {
		Usuario user = usuarioService.getUsuarioById(id);
		usuarioService.removeUsuario(user);
		return new ResponseEntity<String>("Usuario eliminado", HttpStatus.OK);
	}
}
