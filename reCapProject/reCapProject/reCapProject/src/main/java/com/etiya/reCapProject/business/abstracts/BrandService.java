package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Brand;

public interface BrandService {
	
	DataResult<List<Brand>> getByBrandId(int brandId);

	DataResult<List<Brand>> getAll();

	Result add(Brand brand);

	Result update(Brand brand);

	Result delete(Brand brand);
}
