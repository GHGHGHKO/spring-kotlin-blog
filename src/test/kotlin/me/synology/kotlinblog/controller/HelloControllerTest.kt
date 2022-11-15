package me.synology.kotlinblog.controller

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
internal class HelloControllerTest(
        val mockMvc: MockMvc
) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `hello Kotlin`() {

        mockMvc.perform(get("/hello/{language}", "kotlin"))
                .andExpect(status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("kotlin"))
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}
