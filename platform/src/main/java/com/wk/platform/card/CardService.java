package com.wk.platform.card;

import com.wk.bean.Card;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface CardService {
    Result<Card> addCard(Card card, String operateUserId);

    Result<Card> updateCard(Card card,String operateUserId);

    Result deleteCard(String cardId,String operateUserId);

    Result<List<Card>> getCardList(String keyword, String customerId, String operateUserId);

    Result<PageList<Card>> getCardPageList(String keyword, int page, int size,int cardType,int status,String customerId,
                                           String operateUserId);

    Result<List<Card>> getUnbindStaffCardList(String keyword, String customerId, String operateUserId);

    Result updateCardStatus(String cardId,int status,String operateUserId);
}
