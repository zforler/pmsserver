package com.wk.platform.card;

import com.wk.bean.Card;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    private final Logger logger = LoggerFactory.getLogger(CardController.class);
    
    @Autowired
    private CardService cardService;
    @ApiOperation("添加卡")
    @PostMapping("/card")
    public Result<Card> addCard(Card card, String operateUserId){
        try {
            Result<Card> result = cardService.addCard(card, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改卡")
    @PostMapping("/updateCard")
    public Result<Card> updateCard(Card card, String operateUserId){
        try {
            Result<Card> result = cardService.updateCard(card, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除卡")
    @PostMapping("/deleteCard")
    public Result<Card> deleteCard(String cardId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Card> result = cardService.deleteCard(cardId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下卡列表")
    @GetMapping("/getCardList")
    public Result<List<Card>> getCardList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return cardService.getCardList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取卡分页列表")
    @GetMapping("/getCardPageList")
    public Result<PageList<Card>> getCardPageList(String keyword, int page, int size, String customerId,
                                                    @RequestParam(required = false,defaultValue = "-1") int status,
                                                    @RequestParam(required = false,defaultValue = "-1")int cardType,
                                                    String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return cardService.getCardPageList(keyword, page, size, cardType,status,customerId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取未绑定用户卡列表")
    @GetMapping("/getUnbindStaffCardList")
    public Result<List<Card>> getUnbindStaffCardList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return cardService.getUnbindStaffCardList(keyword,customerId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
