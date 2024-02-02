package br.com.jtech.services.togaf.adapters.adapters.output.comment;

import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.CommentRepository;
import br.com.jtech.services.togaf.adapters.adapters.output.comment.repository.entity.CommentEntity;
import br.com.jtech.services.togaf.core.application.domains.Comment;
import br.com.jtech.services.togaf.core.application.domains.Phase;
import br.com.jtech.services.togaf.core.application.domains.User;
import br.com.jtech.services.togaf.core.application.usecases.comment.ports.output.FindCommentByUserAndPhaseAndCreatedAtOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindCommentByUserAndPhaseAndCreatedAtAdapter implements FindCommentByUserAndPhaseAndCreatedAtOutputGateway {

    private final CommentRepository commentRepository;

    @Override
    @Cacheable(value = "comment", key = "#user.id + #phase.id + #createdAt")
    public Optional<Comment> findByUserAndPhaseAndCreateAt(User user, Phase phase, LocalDate createdAt) {
        return commentRepository.findByUserIdAndPhaseIdAndCreatedAt(user.getId(), phase.getId(), createdAt)
                .map(CommentEntity::toDomain);
    }
}
