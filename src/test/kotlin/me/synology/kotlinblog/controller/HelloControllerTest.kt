package me.synology.kotlinblog.controller

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
internal class HelloControllerTest(
        val mockMvc: MockMvc
) {

    @Test
    fun `hello Kotlin`() {

        mockMvc.perform(get("/hello/{language}", "kotlin"))
                .andExpect(status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("kotlin"))
    }
}
