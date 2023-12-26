package com.devcamp.eztour.dao.reserv;

import com.devcamp.eztour.domain.reserv.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReservDaoImpl implements ReservDao {
    @Autowired
    SqlSession session;

    String namespace = "com.devcamp.eztour.rsvtMapper.";

    @Override
    public int insertReserv(ReservDto reservDto) throws Exception {
        return session.insert(namespace+"insertReserv", reservDto);
    }

    @Override
    public ReservDto selectReserv(String rsvt_no) throws Exception {
        return session.selectOne(namespace+"selectReserv", rsvt_no);
    }

    @Override
    public List<ReservDto> selectReservList(String usr_id) throws Exception {
        return  session.selectList(namespace+"selectReservList", usr_id);
    }

    @Override
    public List<Object> selectReservListPage(Map<String, Object> map) throws Exception{
        return session.selectList(namespace+"selectReservListPage", map);
    }

    @Override
    public ReservDto selectReservByRsvtNo(String rsvt_no) throws Exception {
        return session.selectOne(namespace + "selectReservByrsvtNo", rsvt_no);
    }

    @Override
    public List<ReservDto> selectAllReserv() throws Exception {
        return session.selectList(namespace+"selectAllReserv");
    }

    @Override
    public ReservConfInfoDto selectReservConfInfo(String rsvt_no) throws Exception {
        return session.selectOne(namespace+"selectReservConfInfo", rsvt_no);
    }

    @Override
    public List<ReservDto> selectTheUnAppredListPage(Map<String, Integer> map) throws Exception{
        return session.selectList(namespace+"selectTheUnAppredListPage", map);
    }

    @Override
    public int selectTheUnAppredListCnt() throws Exception{
        return session.selectOne(namespace + "selectTheUnAppredListCnt");
    }
    @Override
    public int updateReservStatus(Map<String, String> map) throws Exception {
        return session.update(namespace+"updateReservStatus", map);
    }

    @Override
    public int deleteAllReserv() throws Exception {
        return session.delete(namespace+"deleteAllReserv");
    }

    @Override
    public ReservInfoDto selectPrdInfo(String prd_dtl_cd) throws Exception{
        return session.selectOne(namespace+"selectPrdInfo", prd_dtl_cd);
    }

    @Override
    public List<AirlineReqDto> selectArlReqInfo(String prd_dtl_cd) throws Exception{
        return session.selectList(namespace+"selectAirInfo", prd_dtl_cd);
    }

    @Override
    public int selectUserMlg(String usr_id) throws Exception {
        return session.selectOne(namespace+"selectUserMlg", usr_id);
    }

    @Override
    public int updateUserMlg(Map map) throws Exception {
        return session.update(namespace+"updateUserMlg", map);
    }

    @Override
    public int updateRsvtStt(Map map) throws Exception {
        return session.update(namespace+"updateRsvtStt", map);
    }

    @Override
    public long selectPayFtrPrc(String rsvt_no) throws Exception {
        return session.selectOne(namespace+"selectPayFtrPrc", rsvt_no);
    }

    @Override
    public int deleteReserv(String rsvt_no) throws Exception {
        return session.delete(namespace+"deleteReserv", rsvt_no);
    }

    @Override
    public int selectReservCnt(String usr_id) throws Exception {
        return session.selectOne(namespace+"selectRsvtCnt", usr_id);
    }

    @Override
    public String selectGuestReserv(Map<String, String> map) throws Exception {
        return session.selectOne(namespace + "checkReservGuest", map);
    }

    @Override
    public int updateReservCancel(ReservDto reservDto) throws Exception {
        return session.update(namespace + "updateReservCnc", reservDto);
    }

    @Override
    public int updateReservCnt(Map<String, Object> map) throws Exception{
        return session.update(namespace + "updateRsvtCnt", map);
    }

    @Override
    public ReservDto selectFtrPrcAndStt(Map<String, String> map) throws Exception {
        return session.selectOne(namespace + "selectFtrPrcAndStt", map);
    }

    @Override
    public List<StatsGndrAndAgePerHourDto> selectGndrAndAgePerHour() throws Exception{
        return session.selectList(namespace + "selectReservGndrAndAgePerHour");
    }

    @Override
    public List<StatsTopListDto> selectTopNList(int limitNum) throws Exception{
        return session.selectList(namespace + "selectTopNList", limitNum);
    }

    @Override
    public List<ReservDto> selectTrvlrCnt() throws Exception {
        return session.selectList(namespace + "selectTrvlrCnt");
    }
}
