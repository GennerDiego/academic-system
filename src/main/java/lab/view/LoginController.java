package lab.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.entidades.Login;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {
	
	private Login login;
	private static final long serialVersionUID = 1L;
	
	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

	@PostConstruct
	public void init() {
		login = new Login();
	}
	
	public String avancar() {
		session.setAttribute("name", login.getName());
		return "area-aluno";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
