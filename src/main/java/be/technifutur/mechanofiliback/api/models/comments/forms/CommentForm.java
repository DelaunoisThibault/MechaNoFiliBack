package be.technifutur.mechanofiliback.api.models.comments.forms;

import be.technifutur.mechanofiliback.dl.entities.Comment;

public record CommentForm(
        String content
) {
    public Comment toComment(){
        return new Comment(
          content
        );
    }
}
