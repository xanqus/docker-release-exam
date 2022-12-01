package com.example.dockerrelease.likeList.dao;

import com.example.dockerrelease.likeList.domain.LikeList;
import com.example.dockerrelease.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeListRepository extends JpaRepository<LikeList, Long> {
    List<LikeList> findByUser(User user);
}
