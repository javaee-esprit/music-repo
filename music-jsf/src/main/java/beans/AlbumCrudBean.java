package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.esprit.javaee.persistence.Album;
import org.esprit.javaee.services.interfaces.SongServiceLocal;

@ManagedBean
@RequestScoped
public class AlbumCrudBean {
	
	@EJB
	private SongServiceLocal songServiceLocal;
	
	private Integer id;
	private String name;
	private List<Album> albums;
	
	public AlbumCrudBean() {
	}
	@PostConstruct
	public void initModel(){
		albums = songServiceLocal.findAllAlbums();
	}
	
	public String doAdd(){
		String navigateTo = null;
		Album album = new Album(id, name);
		songServiceLocal.create(album);
		return navigateTo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	
	
	

}
