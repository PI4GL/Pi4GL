package tn.esprit.PiDev.Remotes;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.PiDev.entities.Category;
import tn.esprit.PiDev.entities.Skill;

@Remote
public interface CategoryServiceRemote {

	public List<Skill> getAllSkills();
	public Category addCategory(Category category);
	public Category updateCategoryById(Category category);
	public void deleteCategory(Category category);
	public List<Skill> listSkills(Category category);
	public List<Category> ListAllCategories();
	public Category getCategoryById(long categoryId);
	public Category getCategoryByName(String categoryName);
}
