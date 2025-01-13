package com.i2i.ssa.api.core.service;

import com.i2i.ssa.api.core.model.BaseModel;
import com.i2i.ssa.api.core.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class BaseService<T extends BaseModel> {
	private static final Logger log = LoggerFactory.getLogger(BaseService.class);
	protected final BaseRepository<T> repository;

	public BaseService(BaseRepository<T> repository) {
		this.repository = repository;
	}

	public Iterable<T> findAll() {
		log.info("[findAll()]...");
    	return repository.findAll();
    }

	public Optional<T> findById(UUID id) {
		log.info("[findById()]...");
		Objects.requireNonNull(id);
		return repository.findById(id);
	}

	public T save(T entity) {
		log.info("[save()]...");
		Objects.requireNonNull(entity);
		return repository.save(entity);
	}

	public void delete(T entity) {
		log.info("[save()]...");
		Objects.requireNonNull(entity);
		repository.delete(entity);
	}
}