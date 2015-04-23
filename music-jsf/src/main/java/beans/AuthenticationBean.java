package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.esprit.javaee.persistence.Admin;
import org.esprit.javaee.persistence.Member;
import org.esprit.javaee.persistence.User;
import org.esprit.javaee.services.interfaces.UserServiceLocal;


@ManagedBean(name = "auth")
@SessionScoped
public class AuthenticationBean {
	
	@EJB
	private UserServiceLocal userServiceLocal;

	private User user;
	private Boolean loggedIn;
	
	
	public AuthenticationBean() {
	}
	
	@PostConstruct
	public void initModel(){
		setLoggedIn(false);
		user = new User();
	}
	
	public String doSignIn(){
		String navigateTo = null;
		User found = userServiceLocal.authenticate(user.getLogin(), user.getPassword());
		if (found!=null) {
			loggedIn = true;
			user = found;
			if (found instanceof Admin) {
				navigateTo = "/admin/manage?faces-redirect=true";
			}else if(found instanceof Member){
				navigateTo = "/member/welcome?faces-redirect=true";
			}
			
		} 
		return navigateTo;
	}
	
	public String doLogout(){
		String navigateTo = null;
		FacesContext
			.getCurrentInstance()
			.getExternalContext().
			getSessionMap()
			.clear();
		navigateTo = "/login?faces-redirect=true";
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
