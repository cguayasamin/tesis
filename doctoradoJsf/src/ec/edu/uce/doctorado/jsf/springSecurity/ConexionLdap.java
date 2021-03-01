package ec.edu.uce.doctorado.jsf.springSecurity;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
public class ConexionLdap {
private String ldapAdServer;
private String ldapIPServer;
private String ldapPuerto;
 private String ldapBase;
 private String ldapUsuario;
 private String ldapPassword;

public ConexionLdap(String ldapIPServer, String ldapPuerto, String ldapBase) {
this.ldapIPServer = ldapIPServer;
this.ldapAdServer = "ldap://"+ldapIPServer+":"+ldapPuerto;
this.ldapBase = ldapBase;
}
public String getLdapAdServer() {
return ldapAdServer;
}
public void setLdapAdServer(String ldapAdServer) {
this.ldapAdServer = ldapAdServer;
}
public String getLdapBase() {
return ldapBase;
}
public void setLdapBase(String ldapBase) {
this.ldapBase = ldapBase;
}
public String getLdapUsuario() {
return ldapUsuario;
}
public void setLdapUsuario(String ldapUsuario) {
this.ldapUsuario = ldapUsuario;
}
public String getLdapPassword() {
return ldapPassword;
}
public void setLdapPassword(String ldapPassword) {
this.ldapPassword = ldapPassword;
}

 public String getLdapIPServer() {
return ldapIPServer;
}
public void setLdapIPServer(String ldapIPServer) {
this.ldapIPServer = ldapIPServer;
}
public String getLdapPuerto() {
return ldapPuerto;
}
public void setLdapPuerto(String ldapPuerto) {
this.ldapPuerto = ldapPuerto;
}
public boolean verificarLoginUsuario(String ldapUsuario, String ldapPassword){
 try {
 String usuario = "UCE\\";
 Hashtable<String, Object> env = new Hashtable<String, Object>();
 env.put(Context.SECURITY_AUTHENTICATION, "simple");
 if(ldapUsuario != null) {
 usuario = usuario + ldapUsuario.toLowerCase();
 env.put(Context.SECURITY_PRINCIPAL, usuario);
 }else{
 return false;
 }
 if(ldapPassword != null) {
 env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
 }else{
 return false;
 }
 env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
 env.put(Context.PROVIDER_URL, ldapAdServer);
 env.put("java.naming.ldap.attributes.binary", "objectSID");
 @SuppressWarnings("unused")
InitialDirContext ctx = new InitialDirContext(env);
 return true;
} catch (NamingException e) {
return false;
}


 }
}