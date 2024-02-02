package br.com.jtech.services.togaf.adapters.adapters.output.comment;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.CommentRepository;
import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity.CommentEntity;
import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.FindCommentByIdOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindCommentByIdAdapter implements FindCommentByIdOutputGateway {

    private final CommentRepository commentRepository;

    @Override
    @Cacheable(value = "comment", key = "#id")
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id).map(CommentEntity::toDomain);
    }
}
