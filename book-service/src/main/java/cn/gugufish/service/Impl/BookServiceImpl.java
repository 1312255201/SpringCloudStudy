package cn.gugufish.service.Impl;

import cn.gugufish.entity.Book;
import cn.gugufish.mapper.BookMapper;
import cn.gugufish.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.selectById(bid);
    }
}