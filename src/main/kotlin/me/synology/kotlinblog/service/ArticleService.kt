package me.synology.kotlinblog.service

import me.synology.kotlinblog.domain.Article
import me.synology.kotlinblog.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository) {

    fun getArticle(slug: String): Article? {
        return articleRepository.findBySlug(slug);
    }
}
