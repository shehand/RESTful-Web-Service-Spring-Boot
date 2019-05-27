package com.neuroon.app.ws.io.repositories;

import org.springframework.data.repository.CrudRepository;

import com.neuroon.app.ws.io.entity.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long> {

}
