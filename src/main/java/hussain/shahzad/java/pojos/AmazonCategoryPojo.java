package hussain.shahzad.java.pojos;

/**
 * @author shahzad.hussain
 */


public class AmazonCategoryPojo {
	private String id;
	private String name;
	private String url;
	private String description;
	private Integer subcategoriesCount;

	public String getId(){
		return id;
	}
	public void setId(String id){
		 this.id= id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		 this.name= name;
	}
	public String getUrl(){
		return url;
	}
	public void setUrl(String url){
		 this.url= url;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		 this.description= description;
	}
	public Integer getSubcategoriesCount(){
		return subcategoriesCount;
	}
	public void setSubcategoriesCount(Integer subcategoriesCount){
		 this.subcategoriesCount= subcategoriesCount;
	}
}