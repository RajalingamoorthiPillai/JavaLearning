package in.conceptarchitect.bookmanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Authors")
public class Author {
	
	@Id
	public String id;
	public String name;
	
	@Column(length = 5000)
	public String biography;
	
	public String tags;
	
	@Column(name="profile_photo")
	public String photoUrl;
	
	
	@OneToMany(mappedBy = "author")
	public List<Book> books=new ArrayList<Book>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + "]";
	}
	public Author(String id, String name, String biography, String tags, String photoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
		this.tags = tags;
		this.photoUrl = photoUrl;
	}
	public Author() {
		super();
	}
	
	

}
