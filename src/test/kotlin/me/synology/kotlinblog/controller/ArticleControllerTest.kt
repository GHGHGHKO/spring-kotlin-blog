package me.synology.kotlinblog.controller

import me.synology.kotlinblog.domain.Article
import me.synology.kotlinblog.domain.User
import me.synology.kotlinblog.repository.ArticleRepository
import me.synology.kotlinblog.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
internal class ArticleControllerTest(@Autowired val mockMvc: MockMvc,
                                     @Autowired var userRepository: UserRepository,
                                     @Autowired var articleRepository: ArticleRepository) {

    @BeforeEach
    fun setUp() {
        println("Somethings set up")
    }

    @AfterEach
    fun tearDown() {
        println("Somethings tear down")
    }

    @Test
    fun `List articles`() {

        mockMvc.perform(get("/articles").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].author.login").value("smaldini"))
    }

    @Test
    fun findOne() {

        mockMvc.perform(get("/articles/{slug}", "this is not slug XD").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.author.login").value("smaldini"))
    }
}