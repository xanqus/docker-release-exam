package com.example.dockerrelease.content.controller;

import com.example.dockerrelease.content.dao.ContentRepository;
import com.example.dockerrelease.content.domain.Content;
import com.example.dockerrelease.content.dto.ContentDto;
import com.example.dockerrelease.likeList.dao.LikeListRepository;
import com.example.dockerrelease.likeList.domain.LikeList;
import com.example.dockerrelease.user.dao.UserRepository;
import com.example.dockerrelease.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {

    private final UserRepository userRepository;

    private final ContentRepository contentRepository;

    private final LikeListRepository likeListRepository;

    @GetMapping("")
    public List<Content> getContents() {

        return contentRepository.findAll();

    }

    @GetMapping("/{email}")
    public List<ContentDto> getContentsCheckLike(@PathVariable String email) {

        List<Content> contentList = contentRepository.findAll();

        User user = userRepository.findByEmail(email);

        List<LikeList> likeLists = likeListRepository.findByUser(user);

        return contentList.stream()
                .map(content -> {
                    AtomicBoolean likeStatus = new AtomicBoolean(false);
                    likeLists.forEach(likeList -> {
                        if (likeList.getContent().getId() == content.getId()) {
                            likeStatus.set(true);
                        }
                    });
                    ContentDto contentDto = ContentDto.builder()
                            .id(content.getId())
                            .contentNum(content.getContentNum())
                            .likeStatus(likeStatus.get())
                            .build();

                    return contentDto;
                }).collect(Collectors.toList());
    }
}


