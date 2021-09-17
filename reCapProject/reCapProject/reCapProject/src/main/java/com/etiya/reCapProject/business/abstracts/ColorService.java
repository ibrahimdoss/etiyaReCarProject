package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concretes.Color;
import com.etiya.reCapProject.entities.requests.AddColorRequest;
import com.etiya.reCapProject.entities.requests.DeleteColorRequest;
import com.etiya.reCapProject.entities.requests.UpdateColorRequest;

public interface ColorService {
	
	DataResult<List<Color>> getByColorId(int colorId);

	DataResult<List<Color>>  getAll();

	Result add(AddColorRequest addColorRequest);

	Result update(UpdateColorRequest updateColorRequest);

	Result delete(DeleteColorRequest deleteColorRequest);
}
