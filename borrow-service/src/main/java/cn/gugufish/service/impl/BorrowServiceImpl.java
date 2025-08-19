package cn.gugufish.service.impl;

import cn.gugufish.entity.Book;
import cn.gugufish.entity.Borrow;
import cn.gugufish.entity.User;
import cn.gugufish.entity.UserBorrowDetail;
import cn.gugufish.mapper.BorrowMapper;
import cn.gugufish.service.BorrowService;
import cn.gugufish.service.client.BookClient;
import cn.gugufish.service.client.UserClient;
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
    UserClient userClient;

    @Resource
    BookClient bookClient;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        User user = userClient.getUserById(uid);
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.getBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
