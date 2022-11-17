package me.synology.kotlinblog.repository

import me.synology.kotlinblog.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long> {
    fun findBySlug(slug: String): Article?

    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}