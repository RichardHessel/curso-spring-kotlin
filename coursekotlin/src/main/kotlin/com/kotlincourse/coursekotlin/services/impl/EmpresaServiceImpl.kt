package com.kotlincourse.coursekotlin.services.impl

import com.kotlincourse.coursekotlin.documents.Empresa
import com.kotlincourse.coursekotlin.repositories.EmpresaRepository
import com.kotlincourse.coursekotlin.services.EmpresaService
import org.springframework.stereotype.Service

@Service // para o container de ioc
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)

}