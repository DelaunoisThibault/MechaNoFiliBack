package be.technifutur.mechanofiliback.api.models.comments.dtos;

import be.technifutur.mechanofiliback.dl.entities.Comment;

public record CommentDTO(
        Long id,
        String content
) {
    public static CommentDTO fromComment(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getContent()
        );

    }
}
