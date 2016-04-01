package edu.ifpb.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



import org.primefaces.context.RequestContext;

public class AbstractMB implements Serializable {
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	protected FacesMessage message;
	public AbstractMB() {
		super();
	}
	public void salvarSessao(String senha){
		FacesContext context= FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		request.getSession().setAttribute("senha", senha);
		
	}
	protected void redirectPage(String page){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			displayErrorMessageToUser("Página não encontrada");
		}  
	}
	public void efetuarLogout(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request= (HttpServletRequest) context.getExternalContext().getRequest();
		request.getSession().invalidate();
		
		
	}
	public static boolean recuperarSessao(){
		FacesContext context= FacesContext.getCurrentInstance();
		HttpServletRequest request= (HttpServletRequest) context.getExternalContext().getRequest();
		String senha = (String) request.getSession().getAttribute("senha");
		if(senha== null){
			return false;
		}else{
		return true;
		}
	}
	protected void setKeepMessage(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	protected void displayErrorMessageToUser(String message) {

		this.message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", message);

		FacesContext.getCurrentInstance().addMessage(null, this.message);
	}
	protected void displayInfoMessageToUser(String message) {

		this.message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", message);

		FacesContext.getCurrentInstance().addMessage(null, this.message);
	}
	protected void displayWarnMessageToUser(String message) {

		this.message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertência", message);

		FacesContext.getCurrentInstance().addMessage(null, this.message);
	}
	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}


}
