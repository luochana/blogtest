package com.cl.blog.Dao.interf;

import com.cl.blog.Dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
