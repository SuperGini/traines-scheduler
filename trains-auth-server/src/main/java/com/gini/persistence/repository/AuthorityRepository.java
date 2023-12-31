package com.gini.persistence.repository;

import com.gini.persistence.model.Authority;
import com.gini.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface AuthorityRepository extends JpaRepository<Authority, UUID> {

    @Query("""
                SELECT auth FROM Authority auth WHERE auth.role IN :roles
        """)
    Set<Authority> getAuthority(Set<Role> roles);

}
