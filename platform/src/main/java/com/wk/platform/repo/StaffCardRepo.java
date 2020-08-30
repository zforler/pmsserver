package com.wk.platform.repo;

import com.wk.bean.StaffCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StaffCardRepo extends JpaRepository<StaffCard,Integer> {

    @Modifying
    @Query(value = "update staff_card set end_time=?2 where staff_id=?1 AND end_time=0",nativeQuery = true)
    int updateEndtimeByStaffId(String staffId, int endTime);

    @Modifying
    @Query(value = "update staff_card set end_time=?3 where card_id in ?2 AND staff_id=?1 AND end_time=0",nativeQuery = true)
    int updateEndtimeByCardId(String staffId,String[] cardId, int endTime);


    @Modifying
    @Query(value = "update staff_card set end_time=?2 where card_id=?1",nativeQuery = true)
    int updateEndtimeByCardId(String cardId, int endTime);

    StaffCard findFirstByStaffIdAndCardIdAndEndTime(String staffId, String cardI,int endTime);
}
