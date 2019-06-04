package com.kotlincourse.coursekotlin.repositories

import com.kotlincourse.coursekotlin.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String> {

    fun findByCnpj(cnpj: String): Empresa
}