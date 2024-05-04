package app.petr.news.news.controller;

import app.petr.news.news.entity.News;
import app.petr.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable Long newsId) {
        return newsService.getNewsById(newsId);
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.createNews(news);
    }

    @DeleteMapping("/{newsId}")
    public void deleteNews(@PathVariable Long newsId) {
        newsService.deleteNews(newsId);
    }
}