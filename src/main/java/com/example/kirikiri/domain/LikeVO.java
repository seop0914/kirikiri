package com.example.kirikiri.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LikeVO {
    private Long likeId;
    private String userId;
    private Long boardId;
    private Long likeCount;
    private String likeRegisterDate;
}
