package me.synology.kotlinblog.config

import me.synology.kotlinblog.domain.Article
import me.synology.kotlinblog.domain.User
import me.synology.kotlinblog.repository.ArticleRepository
import me.synology.kotlinblog.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseSampleConfiguration {

    @Bean
    fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
    ) = ApplicationRunner {
        val smaldini = userRepository.save(User("smaldini", "Stéphane", "Maldini"))
        articleRepository.save(Article(
            title = "Reactor Bismuth is out",
            headline = "Lorem ipsum",
            slug = "this is slug",
            content = "dolor sit amet",
            author = smaldini
        ))

        articleRepository.save(Article(
            title = "Reactor Aluminium has landed",
            headline = "Lorem ipsum",
            slug = "this is not slug XD",
            content = "dolor sit amet",
            author = smaldini
        ))
    }

}
