package com.wk.platform.fileupload;

import com.wk.bean.Card;
import com.wk.bean.Department;
import com.wk.bean.Staff;
import com.wk.common.constant.Const;
import com.wk.common.util.RegUtil;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.card.CardRepo;
import com.wk.platform.department.DepartmentRepo;
import com.wk.platform.staff.StaffRepo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    private final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private SeqService seqService;
    @Autowired
    private CardRepo cardRepo;

    private Map<String,Integer> sexMap = new HashMap<String,Integer>(){
        {
            this.put("男", Const.STAFF_SEX_NAN);
            this.put("女",Const.STAFF_SEX_NV);
        }
    };
    private Map<String,Integer> staffTypeMap = new HashMap<String,Integer>(){
        {
            this.put("正式工", Const.STAFF_TYPE_NORMAL);
            this.put("临时工",Const.STAFF_TYPE_TEMP);
        }
    };
    private Map<String,Integer> cardTypeMap = new HashMap<String,Integer>(){
        {
            this.put("员工卡", Const.CARD_TYPE_STAFF);
            this.put("发料卡",Const.CARD_TYPE_PRODUCT);
        }
    };
    @Transactional
    @Override
    public Result uploadFile(MultipartFile file, String customerId, int type, String operateUserId) {
        Workbook hssfWorkbook = null;
        List<Staff> staffList = null;
        List<Card> cardList = null;
        try (InputStream inputStream = file.getInputStream()){
            String fileName = file.getOriginalFilename();
            if (fileName.endsWith("xlsx")){
                hssfWorkbook = new XSSFWorkbook(inputStream);//Excel 2007
            }else if (fileName.endsWith("xls")){
                hssfWorkbook = new HSSFWorkbook(inputStream);//Excel 2003
            }else{
                return Result.error("文件格式错误");
            }
            Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if(Const.IMPORT_STAFF == type){
                staffList = readStaff(hssfSheet, customerId, operateUserId);
            }else if(Const.IMPORT_CARD == type){
                cardList = readCard(hssfSheet, customerId, operateUserId);
            }else{

            }

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
        if(Const.IMPORT_STAFF == type){
            staffRepo.saveAll(staffList);
        }else if(Const.IMPORT_CARD == type){
            cardRepo.saveAll(cardList);
        }
        return Result.success();
    }
    @Transactional
    public List<Staff> readStaff(Sheet sheet, String targetCustomerId, String operateUserId) throws Exception {
        List<Staff> staffList = new ArrayList<>();
        Map<String ,String> staffNoMap = new HashMap<>();
        int second = TimeUtil.getCurrentInSecond();
        for (int rowNum = 1,rowCount=sheet.getPhysicalNumberOfRows(); rowNum < rowCount; rowNum++) {
            Row hssfRow = sheet.getRow(rowNum);
            //员工编号
            Cell c1 = hssfRow.getCell(0);
            String staffNo = getValueOfString(c1,rowNum,1);
            int len = staffNo.length();
            if(len<1 || len > 32){
                throw new Exception("第"+rowNum+"行，员工编号长度1-32字符");
            }
            if(!RegUtil.checkStaffNo(staffNo)){
                throw new Exception("第"+rowNum+"行，员工编号格式错误");
            }
            if(staffNoMap.containsKey(staffNo)){
                throw new Exception("第"+rowNum+"行，员工编号重复");
            }
            staffNoMap.put(staffNo,staffNo);
            Staff check = staffRepo.findFirstByStaffNoAndCustomerId(staffNo, targetCustomerId);
            if(check != null){
                throw new Exception("第"+rowNum+"行，员工编号已存在");
            }

            //员工姓名
            Cell c2 = hssfRow.getCell(1);
            String staffName = getValueOfString(c2,rowNum,2);
            len = staffName.length();
            if(len<1 || len > 32){
                throw new Exception("第"+rowNum+"行，员工姓名长度1-32字符");
            }
            //员工性别
            Cell c3 = hssfRow.getCell(2);
            String sex = getValueOfString(c3,rowNum,3);
            if(!sexMap.containsKey(sex)){
                throw new Exception("第"+rowNum+"行，员工性别错误");
            }
            //所属班组
            Cell c4 = hssfRow.getCell(3);
            String departId = getValueOfString(c4,rowNum,43);
            if(StringUtils.isNotBlank(departId)){
                Department department = departmentRepo.findFirstByDepartmentIdAndStatusAndCustomerId(departId
                        , Const.DEPART_STATUS_NORMAL, targetCustomerId);
                if(department == null){
                    throw new Exception("第"+rowNum+"行，班组信息不存在");
                }
            }
            //员工类别
            Cell c5 = hssfRow.getCell(4);
            String staffType = getValueOfString(c5,rowNum,5);
            if(!staffTypeMap.containsKey(staffType)){
                throw new Exception("第"+rowNum+"行，员工类型错误");
            }
            //员工类别
            Cell c6 = hssfRow.getCell(5);
            String phone = getValueOfString(c6,rowNum,6);
            if(StringUtils.isNotBlank(phone) && !RegUtil.checkPhone(phone)){
                throw new Exception("第"+rowNum+"行，联系方式格式错误");
            }
            //员工住址
            Cell c7 = hssfRow.getCell(6);
            String address = getValueOfString(c7,rowNum,7);
            if(StringUtils.isNotBlank(phone)){
                len = address.length();
                if(len<2 || len > 100){
                    throw new Exception("第"+rowNum+"行，员工姓名长度2-100字符");
                }
            }
            //入职时间
            Cell c8 = hssfRow.getCell(7);
            int entryTime = getDateValue(c8,rowNum,8);
            if(entryTime == -1){
                entryTime = second;
            }

            Staff staff = new Staff();
            String staffId = seqService.getNextBusinessId(Const.BZ_STAFF, targetCustomerId, 8);
            staff.setStaffId(staffId);
            staff.setStaffNo(staffNo);
            staff.setCustomerId(targetCustomerId);
            staff.setStaffName(staffName);
            staff.setSex(sexMap.get(sex));
            staff.setDepartmentId(departId);
            staff.setStaffType(staffTypeMap.get(staffType));
            staff.setPhone(phone);
            staff.setEntryTime(entryTime);
            staff.setLeaveTime(0);
            staff.setAddress(address);
            staff.setStatus(Const.STAFF_STATUS_NORMAL);
            staff.setCreateTime(second);
            staff.setUpdateTime(second);
            staff.setAppend("自动导入");
            staffList.add(staff);
        }

        return staffList;
    }
    @Transactional
    public List<Card> readCard(Sheet sheet, String targetCustomerId, String operateUserId) throws Exception {
        List<Card> cardList = new ArrayList<>();
        Map<String ,String> cardNoMap = new HashMap<>();
        Map<String ,String> cardOutNoMap = new HashMap<>();
        int second = TimeUtil.getCurrentInSecond();
        for (int rowNum = 1,rowCount=sheet.getPhysicalNumberOfRows(); rowNum < rowCount; rowNum++) {
            Row hssfRow = sheet.getRow(rowNum);
            //卡内号
            Cell c1 = hssfRow.getCell(0);
            String cardNo = getValueOfString(c1,rowNum,1);
            int len = cardNo.length();
            if(len<1 || len > 32){
                throw new Exception("第"+rowNum+"行，IC卡内号长度1-32字符");
            }
            if(cardNoMap.containsKey(cardNo)){
                throw new Exception("第"+rowNum+"行，IC卡内号重复");
            }
            cardNoMap.put(cardNo,cardNo);
            Card check = cardRepo.findFirstByCardNo(cardNo);
            if(check != null){
                throw new Exception("第"+rowNum+"行，IC卡内号已存在");
            }


            //卡面号
            Cell c2 = hssfRow.getCell(1);
            String cardOutNo = getValueOfString(c2,rowNum,2);
            int len1 = cardOutNo.length();
            if(len1<1 || len1 > 32){
                throw new Exception("第"+rowNum+"行，IC卡面号长度1-32字符");
            }
            if(cardOutNoMap.containsKey(cardOutNo)){
                throw new Exception("第"+rowNum+"行，IC卡面号重复");
            }
            cardOutNoMap.put(cardNo,cardNo);
            Card check1 = cardRepo.findFirstByCardOutNo(cardOutNo);
            if(check1 != null){
                throw new Exception("第"+rowNum+"行，IC卡面号已存在");
            }


            //卡类型
            Cell c3 = hssfRow.getCell(2);
            String cardType = getValueOfString(c3,rowNum,3);
            if(!cardTypeMap.containsKey(cardType)){
                throw new Exception("第"+rowNum+"行，IC卡类型错误");
            }


            Card card = new Card();
            card.setAppend("自动导入");
            card.setCardNo(cardNo);
            card.setCardOutNo(cardOutNo);
            card.setStatus(0);
            String cardId = seqService.getNextBusinessId(Const.BZ_CARD, targetCustomerId, 4);
            card.setCardId(cardId);
            int currentInSecond = TimeUtil.getCurrentInSecond();
            card.setCreateTime(currentInSecond);
            card.setUpdateTime(currentInSecond);
            card.setCustomerId(targetCustomerId);
            card.setCardType(cardTypeMap.get(cardType));
            cardList.add(card);
        }

        return cardList;
    }
    private String getValueOfString(Cell cell, int rowNum, int columnNum) throws Exception{
        String res = "";
        if(cell == null){
            return res;
        }
        CellType cellType = cell.getCellType();
        if(cellType == CellType._NONE || cellType == CellType.BLANK){
            res = "";
        }else if(cellType == CellType.NUMERIC){
            if(HSSFDateUtil.isCellDateFormatted(cell)){
                Date date = cell.getDateCellValue();
                res = String.valueOf(date.getTime()/1000);
            }else{
                res =  String.valueOf(cell.getNumericCellValue());
            }
        }else if(cellType == CellType.STRING){
            res =cell.getStringCellValue().trim();
        }else{
            throw new Exception("第"+rowNum+"行，第"+columnNum+"列数据异常");
        }
        return res;
    }

    public int getDateValue(Cell cell, int rowNum, int columnNum) throws Exception{
        int res = -1;
        if(cell == null){
            return -1;
        }
        CellType cellType = cell.getCellType();
        if(cellType != CellType.NUMERIC || !HSSFDateUtil.isCellDateFormatted(cell)) {
            throw new Exception("第"+rowNum+"行，第"+columnNum+"列数据格式错误");
        }
        Date date = cell.getDateCellValue();
        res = (int)(date.getTime() / 1000);
        if(res < -1){
            res = -1;
        }
        return res;
    }
}
