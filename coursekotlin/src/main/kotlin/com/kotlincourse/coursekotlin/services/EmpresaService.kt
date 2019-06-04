package com.kotlincourse.coursekotlin.services

import com.kotlincourse.coursekotlin.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa
}