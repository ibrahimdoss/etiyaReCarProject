package com.etiya.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.ColorService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ColorDao;
import com.etiya.reCapProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService{

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<Color>> getByColorId(int colorId) {
		
		List<Color> colors= this.colorDao.getByColorId(colorId);
		return new SuccessDataResult<List<Color>>(colors,"Renkler Id Listelendi");
	}

	@Override
	public DataResult<List<Color>> getAll() {
		List<Color> colors= this.colorDao.findAll();
		return new SuccessDataResult<List<Color>>(colors,"Renkler  Listelendi");
	}

	@Override
	public Result add(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("Renk Eklendi");
	}

	@Override
	public Result update(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("Renk Güncellendi");

		
	}

	@Override
	public Result delete(Color color) {
		this.colorDao.delete(color);
		return new SuccessResult("Renk Silindi");

	}

}
