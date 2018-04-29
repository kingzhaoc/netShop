package team.hymxj.dao;

import java.util.List;

import team.hymxj.entity.Category;

public interface CategoryDao {
	public boolean insertCateGory(Category category);
	public boolean deleteCateGory(Integer id);
	//public boolean update()
	public String getNameById(Integer id);
	public List<Category> findAllCategory();
}
