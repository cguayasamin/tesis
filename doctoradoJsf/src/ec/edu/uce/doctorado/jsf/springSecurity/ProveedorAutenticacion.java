package ec.edu.uce.doctorado.jsf.springSecurity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ProveedorAutenticacion implements AuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
//verificacion de usuario y password
		if (username.equalsIgnoreCase("administrador")) {
			if (!password.equals("123456")) {
				throw new BadCredentialsException("Usuario y/o Contraseña incorrectos.");
			}
		} else {
			throw new BadCredentialsException("Usuario y/o Contraseña incorrectos.");
		}
//asignacion de permisos
		List<ProveedorPermisos> permisos = new ArrayList<ProveedorPermisos>();
		permisos.add(new ProveedorPermisos("ADMINISTRADOR"));
		DetalleUsuario usuario = new DetalleUsuario(username, password, permisos);
		return new UsernamePasswordAuthenticationToken(usuario, password, permisos);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}