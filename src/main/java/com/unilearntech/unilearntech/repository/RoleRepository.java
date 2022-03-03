package com.unilearntech.unilearntech.repository;

import com.unilearntech.unilearntech.models.ERole;
import com.unilearntech.unilearntech.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
