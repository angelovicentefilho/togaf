package br.com.jtech.services.togaf.adapters.adapters.output.comment;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.CommentRepository;
import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.UpdateCommentOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity.CommentEntity.fromDomain;

@Service
@RequiredArgsConstructor
public class UpdateCommentAdapter implements UpdateCommentOutputGateway {

    private final CommentRepository commentRepository;

    @Override
    @CachePut(value = "comment", key = "#comment.id")
    public Optional<Comment> update(Comment comment) {
        return Optional.of(commentRepository.save(fromDomain(comment)).toDomain());
    }
}
