package br.com.aprendendospringmvc.entity;

import br.com.aprendendospringmvc.repository.impl.ListInMemoryRepository;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Created by ellison on 24/04/14.
 */
public class Tarefa implements Pojo {

    private Long id;

    @NotBlank(message = "{validation.bean.notBlank}")
    @Size(min = 5, message = "{validation.bean.size.min}")
    private String descricao;

    private boolean finalizado;

    private Calendar dataFinalizacao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public void salvar() {
        // Need to check if there are required fields.
        ListInMemoryRepository.getInstance().save(this);
    }

}
