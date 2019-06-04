package com.kotlincourse.coursekotlin.services

import com.kotlincourse.coursekotlin.documents.Lancamento
import com.kotlincourse.coursekotlin.enums.TipoEnum
import com.kotlincourse.coursekotlin.repositories.LancamentoRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner
import java.lang.Exception
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class LancamentoServiceTest {

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    @Autowired
    private val lancamentoService: LancamentoService? = null

    private val id: String = "1"

    @Before
    @Throws(Exception::class)
    fun setUp() {

        BDDMockito.given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(id, PageRequest(0, 10)))
                .willReturn(PageImpl(ArrayList<Lancamento>()))

        BDDMockito.given<Optional<Lancamento>>(lancamentoRepository?.findById("1"))
                .willReturn(Optional.of(lancamento()))

        BDDMockito.given<Lancamento>(lancamentoRepository?.save(lancamento()))
                .willReturn(lancamento())

    }

    @Test
    fun testPersistirLancamento() {
        val lancamento: Lancamento? = this.lancamentoService?.persistir(lancamento())
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun testBuscarPorIdFuncionario() {
        val lancamento: Page<Lancamento>? = this.lancamentoService?.buscarPorFuncionarioId(id, PageRequest( 0, 10))
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun testBuscarPorId(){
        val lancamento: Lancamento? = this.lancamentoService?.buscarPorId("1")
        Assert.assertNotNull(lancamento)
    }

    private fun lancamento(): Lancamento = Lancamento(Date(), TipoEnum.INICIO_TRABALHO, id)
}