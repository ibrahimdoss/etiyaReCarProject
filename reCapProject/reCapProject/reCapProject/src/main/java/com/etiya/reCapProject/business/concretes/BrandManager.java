package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.BrandService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.BrandDao;
import com.etiya.reCapProject.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {
	
	private BrandDao brandDao;
	
	@Autowired
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}

	@Override
	public DataResult<List<Brand>> getByBrandId(int brandId) {
		List<Brand> brands= this.brandDao.getByBrandId(brandId);
		return new SuccessDataResult<List<Brand>>(brands,"Marka Id Listelendi");
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		List<Brand> brands= this.brandDao.findAll();
		return new SuccessDataResult<List<Brand>>(brands,"Marka Listelendi");
		
	}

	@Override
	public Result add(Brand brand) {
		this.brandDao.save(brand);
		return new SuccessResult("Marka Eklendi");
	}

	@Override
	public Result update(Brand brand) {
		this.brandDao.save(brand);
		return new SuccessResult("Marka Güncellendi");
		
	}

	@Override
	public Result delete(Brand brand) {
		this.brandDao.delete(brand);
		return new SuccessResult("Marka Silindi");
		
	}

}
