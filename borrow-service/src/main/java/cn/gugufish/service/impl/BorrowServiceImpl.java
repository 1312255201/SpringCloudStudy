package cn.gugufish.service.impl;

import cn.gugufish.entity.Book;
import cn.gugufish.entity.Borrow;
import cn.gugufish.entity.User;
import cn.gugufish.entity.UserBorrowDetail;
import cn.gugufish.mapper.BorrowMapper;
import cn.gugufish.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    @Resource
    RestTemplate template;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        User user = template.getForObject("http://userservice/user/"+uid, User.class);
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://bookservice/book/"+b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
