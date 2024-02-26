package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
//El hecho de extender JPARepository me crea automáticamente métodos como findAll, //findById, save...
}
