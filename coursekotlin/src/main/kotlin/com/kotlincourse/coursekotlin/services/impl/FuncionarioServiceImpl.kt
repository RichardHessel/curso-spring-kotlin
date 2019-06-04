package com.kotlincourse.coursekotlin.services.impl

import com.kotlincourse.coursekotlin.documents.Funcionario
import com.kotlincourse.coursekotlin.repositories.FuncionarioRepository
import com.kotlincourse.coursekotlin.services.FuncionarioService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)

    override fun buscaPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)

    override fun buscarPorId(id: String): Funcionario? {
        var result = funcionarioRepository.findById(id)

        return result.get()
    }
}