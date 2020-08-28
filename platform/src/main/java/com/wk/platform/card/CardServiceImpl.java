package com.wk.platform.card;

import com.wk.bean.Card;
import com.wk.bean.StaffCard;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.repo.StaffCardRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private StaffCardRepo staffCardRepo;

    @Transactional
    @Override
    public Result<Card> addCard(Card card, String operateUserId) {
        Card card1 = cardRepo.findFirstByCardNo(card.getCardNo());
        if(card1 != null){
            return Result.error("卡内号已存在");
        }
        card1 = cardRepo.findFirstByCardNameAndCustomerIdEquals(card.getCardName(), card.getCustomerId());
        if(card1 != null){
            return Result.error("卡名称重复");
        }

        String cardId = seqService.getNextBusinessId(Const.BZ_CARD, card.getCustomerId(), 4);
        card.setCardId(cardId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        card.setCreateTime(currentInSecond);
        card.setUpdateTime(currentInSecond);
        Card newCard = cardRepo.saveAndFlush(card);
        //添加关联
        if(StringUtils.isNotBlank(card.getStaffId())){
            saveStaffCard(cardId,card.getStaffId(),currentInSecond);
        }

        return Result.success(newCard);
    }
    @Transactional
    @Override
    public Result<Card> updateCard(Card card, String operateUserId) {
        String cardId = card.getCardId();

        String sql = "SELECT c.*,sc.staff_id FROM card c LEFT JOIN staff_card sc ON c.card_id=sc.card_id AND sc.end_time=0 WHERE c.card_id=:cardId";
        Map<String,Object> param = new HashMap<>();
        param.put("cardId", cardId);

        Card card1 = commonService.nativeQuery4FirstObject(sql,param,Card.class);
        if(card1 == null){
            return Result.error("电卡不存在");
        }
        Card card2 = cardRepo.findFirstByCardNoAndCardIdNot(card.getCardNo(),cardId);
        if(card2 != null){
            return Result.error("卡内号已存在");
        }
        card2 = cardRepo.findFirstByCardNameAndCustomerIdEqualsAndCardIdNot(card.getCardName(), card.getCustomerId(),cardId);
        if(card2 != null){
            return Result.error("卡名称重复");
        }
        int second = TimeUtil.getCurrentInSecond();
        card.setUpdateTime(second);
        Card oldCard = cardRepo.findFirstByCardId(cardId);
        card.setStatus(oldCard.getStatus());
        card.setCreateTime(oldCard.getCreateTime());
        card.setCardType(oldCard.getCardType());

        String oldStaffId = oldCard.getStaffId();
        String newStaffId = card.getStaffId();
        if(StringUtils.isNotBlank(oldStaffId) && !oldStaffId.equals(newStaffId)){
            staffCardRepo.updateEndtimeByCardId(cardId,second);
        }
        if(StringUtils.isNotBlank(newStaffId)){
            saveStaffCard(cardId,newStaffId,second);
        }
        return Result.success();
    }
    @Transactional
    public void saveStaffCard(String cardId,String staffId,int second){
        StaffCard staffCard = new StaffCard();
        staffCard.setStaffId(staffId);
        staffCard.setCardId(cardId);
        staffCard.setBeginTime(second);
        staffCard.setEndTime(0);
        staffCardRepo.saveAndFlush(staffCard);
    }
    @Override
    public Result deleteCard(String cardId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Card>> getCardList(String keyword, String customerId, String operateUserId) {
        return null;
    }

    @Override
    public Result<PageList<Card>> getCardPageList(String keyword, int page, int size,int cardType,int status,String customerId,
                                                  String operateUserId) {
        String sql = "SELECT c.*,s.staff_id,s.staff_name FROM card c LEFT JOIN staff_card sc ON c.card_id=sc.card_id" +
                " AND sc.end_time=0 LEFT JOIN staff s ON sc.staff_id=s.staff_id WHERE c.customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);

        if(cardType>-1){
            sql += " AND c.card_type=:cardType ";
            param.put("cardType", cardType);
        }

        if(status>-1){
            sql += " AND c.status=:status ";
            param.put("status", status);
        }

        if(StringUtils.isNotBlank(keyword)) {
            sql += " AND (s.staff_id LIKE :keyword OR s.staff_name like :keyword OR c.card_id like :keyword OR" +
                    " c.card_no like :keyword OR c.card_name like :keyword)";
            param.put("keyword", "%" + keyword + "%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "cardId");
        Page<Card> list = commonService.pageBySql(sql,param,pageable,Card.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }

    @Override
    public Result<List<Card>> getUnbindStaffCardList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT * FROM card WHERE customer_id=:customerId AND card_id NOT IN(SELECT c.card_id FROM card c LEFT JOIN" +
                " staff_card sc ON c.card_id=sc.card_id WHERE sc.end_time=0 AND c.customer_id=:customerId)";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId", customerId);

        if(StringUtils.isNotBlank(keyword)) {
            sql += " AND (card_id like :keyword OR card_no like :keyword OR card_name like :keyword)";
            param.put("keyword", "%" + keyword + "%");
        }
        List<Card> cards = commonService.listBySql(sql, param, Card.class);
        return Result.success(cards);
    }
}
