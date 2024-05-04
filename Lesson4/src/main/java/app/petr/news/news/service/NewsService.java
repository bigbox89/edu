package app.petr.news.news.service;

import app.petr.news.news.entity.News;
import app.petr.news.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News getNewsById(Long newsId) {
        return newsRepository.findById(newsId).orElse(null);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public void deleteNews(Long newsId) {
        newsRepository.deleteById(newsId);
    }
}
