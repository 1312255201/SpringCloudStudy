package cn.gugufish.service;

import cn.gugufish.entity.UserBorrowDetail;

public interface BorrowService {

    UserBorrowDetail getUserBorrowDetailByUid(int uid);
}