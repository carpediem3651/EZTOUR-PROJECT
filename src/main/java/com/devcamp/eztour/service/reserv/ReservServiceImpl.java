package com.devcamp.eztour.service.reserv;

import com.devcamp.eztour.dao.guest.GuestDao;
import com.devcamp.eztour.dao.pay.PayDao;
import com.devcamp.eztour.dao.product.ProductDao;
import com.devcamp.eztour.dao.reserv.ReservDao;
import com.devcamp.eztour.dao.reserv.TravelerInfoDao;
import com.devcamp.eztour.domain.product.TrvPrdPrcDto;
import com.devcamp.eztour.domain.reserv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservServiceImpl implements ReservService {
    @Autowired
    ReservDao reservDao;
    @Autowired
    TravelerInfoDao travelerInfoDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    PayDao payDao;
    @Autowired
    GuestDao guestDao;
    @Autowired
    DataSource ds;

    @Override
    public ReservInfoDto readPrdInfo(String prd_dtl_cd) throws Exception{
        return reservDao.selectPrdInfo(prd_dtl_cd);
    }

    @Override
    public List<AirlineReqDto> readAirLineInfo(String prd_dtl_cd) throws Exception {
        return reservDao.selectArlReqInfo(prd_dtl_cd);
    }

    @Override
    public int reserv(ReservDto reservDto) throws Exception {
        return reservDao.insertReserv(reservDto);
    }

    @Override
    public int saveTrvlrInfo(List<TravelerInfoDto> list) throws Exception{
        return travelerInfoDao.insertTrvlrInfo(list);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean saveReservInfo(ReservDto reservDto, List<TravelerInfoDto> list) throws Exception {
        int rowCntForReserv = reservDao.insertReserv(reservDto); //1
        int rowCntForTrvlrInfo = travelerInfoDao.insertTrvlrInfo(list); //최소 1

        if(rowCntForReserv+rowCntForTrvlrInfo < 2){
            throw new Exception("여행예약정보를 저장하는데 실패했습니다.");
        }

        return true;
    }

    @Override
    public ReservInfoDto getReservInfo(String prd_dtl_cd) throws Exception{
        ReservInfoDto reservInfoDto = reservDao.selectPrdInfo(prd_dtl_cd);

        if (reservInfoDto == null) {

            throw new Exception("wrong prd_dtl_cd value");
        }
        return reservInfoDto;
    }

    @Override
    public List getReservConfInfo(String rsvt_no, String prd_dtl_cd) throws Exception {
        List<Object> list = new ArrayList<>();

        list.add(reservDao.selectReservConfInfo(rsvt_no));
        list.addAll(travelerInfoDao.selectTrvlrInfoList(rsvt_no));

        if(list.size() < 2){
            throw new Exception();
        }

        return list;
    }

    @Override
    public List getReservList(String usr_id) throws Exception{
        return reservDao.selectReservList(usr_id);
    }

    @Override
    public List getReservView(String rsvt_no) throws Exception{
        List<Object> list = new ArrayList<>();

        ReservConfInfoDto rcid = reservDao.selectReservConfInfo(rsvt_no);
        list.add(rcid);
        list.addAll(travelerInfoDao.selectTrvlrInfoList(rsvt_no));
        list.add(payDao.selectPay(rsvt_no));

        if(list.size()==0){
            throw new Exception();
        }

        return list;
    }

    @Override
    public List getReservListPage(Map<String, Object> map) throws Exception{
        return reservDao.selectReservListPage(map);
    }

    @Override
    public int getUserMlg(String usr_id) {
        int usr_mlg = 0;
        try {
            usr_mlg = reservDao.selectUserMlg(usr_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr_mlg;
    }

    @Override
    public int updateUserMlg(String option, Integer mlg, String usr_id){
        Map map = new HashMap();
        map.put("option", option);
        map.put("mlg", mlg);
        map.put("usr_id", usr_id);
        int rowCnt = 0;
        try {
            rowCnt = reservDao.updateUserMlg(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt;
    }

    @Override
    public int updateRsvtStt(String cmn_cd_rsvt_stt, String cmn_cd_pay_stt, String rsvt_no){
        Map map = new HashMap();
        map.put("cmn_cd_rsvt_stt", cmn_cd_rsvt_stt);
        map.put("cmn_cd_pay_stt", cmn_cd_pay_stt);
        map.put("rsvt_no", rsvt_no);
        int rowCnt = 0;
        try {
            rowCnt = reservDao.updateRsvtStt(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCnt;
    }

    @Override
    public long getPayFtrPrc(String rsvt_no) throws Exception {
        return reservDao.selectPayFtrPrc(rsvt_no);
    }

    @Override
    public Map<String, Object> getTheUnAppredList(Integer page, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();

        try {
            int theUnAppredCnt = reservDao.selectTheUnAppredListCnt();

            PageHandler ph = new PageHandler(page, theUnAppredCnt);
            result.put("pageHandler", ph);

            Map<String, Integer> map = new HashMap<>();
            map.put("offset", (page-1) * pageSize);
            map.put("pageSize", pageSize);

            List<ReservDto> list = reservDao.selectTheUnAppredListPage(map);
            result.put("unAppredList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getReservCnt(String usr_id) {
        int rowCnt = 0;
        try {
            rowCnt = reservDao.selectReservCnt(usr_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCnt;
    }

    @Transactional(rollbackFor = Exception.class)
    public String guestReservCheck(String rsvt_no, String mn_rsvt_nm, String phn) throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("rsvt_no", rsvt_no);
        map.put("mn_rsvt_nm", mn_rsvt_nm);
        map.put("phn", phn);

        return reservDao.selectGuestReserv(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelReserv(ReservDto reservDto) throws Exception{
        int updateReservresult = reservDao.updateReservCancel(reservDto);
        int deleteTrvlrInfoResult = travelerInfoDao.deleteTrvlrInfoList(reservDto.getRsvt_no());

        if(updateReservresult == 0 || deleteTrvlrInfoResult == 0){
            throw new Exception();
        }
    }

    @Override
    public int changeReservCount(String prd_dtl_cd, String rsvt_no, String option){
        Map<String, Object> map = new HashMap<>();
        map.put("prd_dtl_cd", prd_dtl_cd);
        map.put("rsvt_no", rsvt_no);
        map.put("option", option);
        int rowCnt = 0;
        try {
            rowCnt = reservDao.updateReservCnt(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCnt;
    }

    @Override
    public ReservDto checkReservInfo(Map<String, String> map) throws Exception {
        return reservDao.selectFtrPrcAndStt(map);
    }

    @Override
    public List<StatsGndrAndAgePerHourDto> getGndrAndAgePerHourStats(){
        List<StatsGndrAndAgePerHourDto> list = null;
        try{
            list = reservDao.selectGndrAndAgePerHour();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<StatsTopListDto> getTopNList(int limitNum){
        List<StatsTopListDto> list = null;
        try{
            list = reservDao.selectTopNList(limitNum);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Map<String, Integer> getTrvlrCntStats() {
        List<ReservDto> list = null;
        Map<String, Integer> map = null;
        try{
            list = reservDao.selectTrvlrCnt();
            map = setupTrvlrCntMap();
            devideTrvlrCnt(map, list);

        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public TrvPrdPrcDto getOneProductPriceByPrdDtlCd(String prd_dtl_cd) throws Exception{
        return productDao.selectOneProductPriceByPrdDtlCd(prd_dtl_cd);
    }

    private void devideTrvlrCnt(Map<String, Integer> map, List<ReservDto> list){
        for(ReservDto reserv : list){
            int totalTrvlrCnt = reserv.getAdt_cnt() + reserv.getChd_cnt() + reserv.getBb_cnt();
            if(totalTrvlrCnt == 1){
                map.replace("1명", map.get("1명") + 1);
            } else if (totalTrvlrCnt == 2) {
                map.replace("2명", map.get("2명") + 1);
            } else if (totalTrvlrCnt == 3) {
                map.replace("3명", map.get("3명") + 1);
            } else if (totalTrvlrCnt == 4) {
                map.replace("4명", map.get("4명") + 1);
            } else if (5 <= totalTrvlrCnt && totalTrvlrCnt < 10) {
                map.replace("5-9명", map.get("5-9명") + 1);
            } else if (10 <= totalTrvlrCnt && totalTrvlrCnt < 20) {
                map.replace("10-19명", map.get("10-19명") + 1);
            } else if (20 <= totalTrvlrCnt && totalTrvlrCnt < 50) {
                map.replace("20-49명", map.get("20-49명") + 1);
            } else {
                map.replace("50명 이상", map.get("50명 이상") + 1);
            }
        }
    }

    private Map<String, Integer> setupTrvlrCntMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("1명", 0);
        map.put("2명", 0);
        map.put("3명", 0);
        map.put("4명", 0);
        map.put("5-9명", 0);
        map.put("10-19명", 0);
        map.put("20-49명", 0);
        map.put("50명 이상", 0);

        return map;
    }
}
