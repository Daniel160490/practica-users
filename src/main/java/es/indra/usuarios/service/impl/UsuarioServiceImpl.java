/**
 * 
 */
package es.indra.usuarios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.usuarios.model.Usuario;
import es.indra.usuarios.repository.UsuarioRepository;
import es.indra.usuarios.service.UsuarioService;

/**
 * @author daniel
 *
 */
@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.indra.usuarios.service.UsuarioService#getAlUsuario()
	 */
	@Override
	public List<Usuario> getAlUsuario() {

		return this.usuarioRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.indra.usuarios.service.UsuarioService#getCategoriaById(int)
	 */
	@Override
	public Usuario getUsuarioById(int id) {

		/*
		 * Optional se usa por si lo que se esta buscando no está
		 */
		Optional<Usuario> cate = this.usuarioRepository.findById(id);
		if (cate.isPresent()) {
			return cate.get();

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.indra.usuarios.service.UsuarioService#updateUsuario(es.indra.usuarios.
	 * model.Usuario)
	 */
	@Override
	public Usuario updateUsuario(Usuario c) {

		if (this.getUsuarioById(c.getId()) != null) {
			return this.usuarioRepository.save(c);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.indra.usuarios.service.UsuarioService#saveUsuario(es.indra.usuarios.model.
	 * Usuario)
	 */
	@Override
	public Usuario saveUsuario(Usuario user) {

		return this.usuarioRepository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.indra.usuarios.service.UsuarioService#removeUsuario(es.indra.usuarios.
	 * model.Usuario)
	 */
	@Override
	public void removeUsuario(Usuario user) {
		this.usuarioRepository.delete(user);
	}

}
