package ec.edu.uce.doctorado.jsf.springSecurity;
import org.springframework.security.core.GrantedAuthority;
public class ProveedorPermisos implements GrantedAuthority{
private static final long serialVersionUID = 8645782513098410909L;
private String rol;
public ProveedorPermisos(String rol) {
this.rol = rol;
}
@Override
public String getAuthority() {
return "ROLE_" + rol;
}
}
