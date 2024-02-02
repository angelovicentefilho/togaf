package br.com.jtech.services.togaf.adapters.adapters.output.comment;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.CommentRepository;
import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.DeleteCommentOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentAdapter implements DeleteCommentOutputGateway {

    private final CommentRepository commentRepository;

    @Override
    @CacheEvict(value = "comment", key = "#comment.id")
    public void delete(Comment comment) {
        commentRepository.deleteById(comment.getId());
    }
}
