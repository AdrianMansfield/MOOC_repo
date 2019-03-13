package com.exadel.MOOC.dao.repository.linkageTable;

import com.exadel.MOOC.entity.linkageTable.UserToModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToModuleRepository extends JpaRepository<UserToModule, Long> {
}
