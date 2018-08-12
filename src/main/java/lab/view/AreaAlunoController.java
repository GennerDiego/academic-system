package lab.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import br.com.entidades.Aluno;

@ManagedBean
@SessionScoped
public class AreaAlunoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean atualizarCadastro;
	private Aluno aluno;
	
	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
	
	@PostConstruct
	public void init() {
		aluno = new Aluno();
		aluno.setNome((String)session.getAttribute("name")); 
		atualizarCadastro = Boolean.FALSE;
	}
	
	public void exibirAtualizaCadastro(ActionEvent actionEvent) {
		atualizarCadastro = Boolean.TRUE;
	}
	
	public String atualizar() {
		atualizarCadastro = Boolean.FALSE;
		return null;
    }
	
//	public boolean isAtualizarCadastro() {
//		return atualizarCadastro;
//	}
//	public void setAtualizarCadastro(boolean atualizarCadastro) {
//		this.atualizarCadastro = atualizarCadastro;
//	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Boolean getAtualizarCadastro(){
		return atualizarCadastro;
	}

}
