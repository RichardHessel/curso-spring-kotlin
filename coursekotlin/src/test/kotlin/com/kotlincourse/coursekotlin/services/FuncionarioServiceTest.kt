package com.kotlincourse.coursekotlin.services

import com.kotlincourse.coursekotlin.documents.Funcionario
import com.kotlincourse.coursekotlin.enums.PerfilEnum
import com.kotlincourse.coursekotlin.repositories.FuncionarioRepository
import com.kotlincourse.coursekotlin.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit4.SpringRunner
import java.lang.Exception
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

    @Autowired // serviço à ser testado
    private val funcionarioService: FuncionarioService? = null

    @MockBean // mock
    private val funcionarioRepository: FuncionarioRepository? = null

    private val email: String = "email@email.com"
    private val cpf: String = "34234855948"
    private val id: String = "1"

    @Before //rodará antes dos testes
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
                .willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id))
                .willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByEmail(email))
                .willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf))
                .willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorId() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorId(id)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorEmail() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(email)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorCPF() {
        val funcionario: Funcionario? = this.funcionarioService?.buscaPorCpf(cpf)
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario = Funcionario("Nome", email, SenhaUtils().gerarBCrypt("123456"),
            cpf, PerfilEnum.ROLE_USUARIO, id)
}