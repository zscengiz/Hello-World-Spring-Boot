package com.example.hello_world.repository;

import com.example.hello_world.entity.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {

    //verilen değer ile eşleşen veri yoksa boş optional dönüyor varsa Access Token'ı dönüyor
    Optional<AccessToken> findByAccessToken(String token);

    @Transactional // rollback yapar
    @Modifying // Update yapmak için
    @Query("UPDATE AccessToken accessToken SET accessToken.isActive = false WHERE accessToken.user.id = :userId AND accessToken.isActive = true")
    // kullanıcının mevcut access tokenlarını geçeresiz kılıyoruz böylece kullanıcının tek bir aktif tokenı oluyor.
    void updateAccessToken(Long userId);


}