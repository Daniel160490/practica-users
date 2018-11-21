/**
 * 
 */
package es.indra.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.usuarios.model.Usuario;

/**
 * @author daniel
 *
 */
@Service
public interface UsuarioService {

	List<Usuario> getAlUsuario();

	Usuario getUsuarioById(int id);

	Usuario updateUsuario(Usuario c);

	Usuario saveUsuario(Usuario user);

	void removeUsuario(Usuario user);

}
