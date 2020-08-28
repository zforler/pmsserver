package com.wk.platform.card;

import com.wk.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card,String> {
    Card findFirstByCardNo(String cardNo);
    Card findFirstByCardNameAndCustomerIdEquals(String cardName,String customerId);

    Card findFirstByCardNoAndCardIdNot(String cardNo,String cardId);
    Card findFirstByCardNameAndCustomerIdEqualsAndCardIdNot(String cardName,String customerId,String cardId);

    Card findFirstByCardId(String cardId);
}
