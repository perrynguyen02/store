package com.perry.repository;

import com.perry.model.entity.token.Token;
import com.perry.model.entity.token.TokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    @Query(value = """
            select t from Token t inner join User u\s
            on t.user.uuid = u.uuid\s
            where u.uuid = :uuid and (t.expired = false or t.revoked = false)\s
            """)
    List<Token> findAllValidTokenByUser(UUID uuid);

    Optional<Token> findByToken(String token);

}
