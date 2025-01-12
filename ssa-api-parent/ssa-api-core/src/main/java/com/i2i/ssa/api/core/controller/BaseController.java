package com.i2i.ssa.api.core.controller;

import com.i2i.ssa.api.core.model.BaseModel;
import com.i2i.ssa.api.core.service.BaseService;

public class BaseController<T extends BaseService<? extends BaseModel>> {
	protected T service;

	protected BaseController(T service) {
		this.service = service;
	}
}
