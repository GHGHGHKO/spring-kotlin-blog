package me.synology.kotlinblog.controller;

import me.synology.kotlinblog.repository.ArticleRepository
import me.synology.kotlinblog.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
class ArticleController(
    private val articleService: ArticleService,
    private val articleRepository: ArticleRepository) {

    @GetMapping
    fun findAll() = articleRepository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String) = articleService.getArticle(slug)

}
