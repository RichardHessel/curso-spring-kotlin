package com.kotlincourse.coursekotlin.utils

import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBCrypt(senha: String): String = BCryptPasswordEncoder().encode(senha)
}