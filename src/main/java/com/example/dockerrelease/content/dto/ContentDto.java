package com.example.dockerrelease.content.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private Long id;

    private String contentNum;

    private Boolean likeStatus;
}
