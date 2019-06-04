package com.kotlincourse.coursekotlin.documents

import com.kotlincourse.coursekotlin.enums.TipoEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document //annotation mongo client

data class Lancamento ( //data -> getters e setters
        val data: Date,
        val tipo: TipoEnum,
        val funcionarioId: String,
        val descricao: String? = "",
        val localizacao: String? = "",
        @Id val id: String? = null
)