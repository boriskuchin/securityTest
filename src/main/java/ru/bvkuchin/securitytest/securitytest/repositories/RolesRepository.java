package ru.bvkuchin.securitytest.securitytest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bvkuchin.securitytest.securitytest.entities.Role;
import ru.bvkuchin.securitytest.securitytest.entities.User;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
}
