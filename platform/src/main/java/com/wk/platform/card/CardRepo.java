package com.wk.platform.card;

import com.wk.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardRepo extends JpaRepository<Card,String> {
    Card findFirstByCardNo(String cardNo);
    Card findFirstByCardOutNo(String cardOutNo);
    Card findFirstByCardNameAndCustomerIdEquals(String cardName,String customerId);

    Card findFirstByCardNoAndCardIdNot(String cardNo,String cardId);
    Card findFirstByCardOutNoAndCardIdNot(String cardNo,String cardId);
    Card findFirstByCardNameAndCustomerIdEqualsAndCardIdNot(String cardName,String customerId,String cardId);

    Card findFirstByCardId(String cardId);

    @Modifying
    @Query(value = "update card set status=?2 where card_id=?1",nativeQuery = true)
    int updateCardStatus(String cardId,int status);
}
