package vn.iostar.services.impl;

import java.util.List;
import java.util.Locale.Category;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoimpl;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;

public class CategoryServiceimpl implements ICategoryService{
	
	public ICategoryDao cateDao = new CategoryDaoimpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if (cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if (cate != null) {
			cateDao.delete(id);
		}				
	}

	@Override
	public List<CategoryModel> findByCategoryname(String keyword) {
		return cateDao.findByCategoryname(keyword);
	}

}
