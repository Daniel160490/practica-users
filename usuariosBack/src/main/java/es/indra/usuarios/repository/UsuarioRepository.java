/**
 * 
 */
package es.indra.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.indra.usuarios.model.Usuario;

/**
 * @author daniel
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
