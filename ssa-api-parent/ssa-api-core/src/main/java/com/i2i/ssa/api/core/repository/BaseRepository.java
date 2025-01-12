package com.i2i.ssa.api.core.repository;

import com.i2i.ssa.api.core.model.BaseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface BaseRepository<T extends BaseModel> extends CrudRepository<T, UUID> {
}
