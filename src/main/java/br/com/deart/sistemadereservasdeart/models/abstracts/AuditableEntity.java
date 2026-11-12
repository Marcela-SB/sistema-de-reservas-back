package br.com.deart.sistemadereservasdeart.models.abstracts;

import java.time.LocalDateTime;

import br.com.deart.sistemadereservasdeart.user.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditableEntity extends BaseEntity {

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", updatable = false)
    private UserModel createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_user_id")
    private UserModel updatedBy;

    @PrePersist
    @Override
    protected void onCreate() {
        super.onCreate(); // Gera o UUID da BaseEntity
        this.createdAt = LocalDateTime.now();
        // Aqui você poderia buscar o usuário do contexto de segurança, ex:
        // this.createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        // Mesma lógica para o usuário que está editando
        // this.updatedBy = ...
    }
}