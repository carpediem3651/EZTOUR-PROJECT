package com.devcamp.eztour.dao.faq;

import com.devcamp.eztour.domain.faq.FaqDto;

import java.util.List;
import java.util.Map;

public interface FaqDao {

    List<FaqDto> selectAllFaq() throws Exception;

    int countFaq() throws Exception;

    List<FaqDto> selectFaqPage(Map map) throws Exception;

    int insertFaq(FaqDto faqDto) throws Exception;

    FaqDto selectFaq(Integer faq_no) throws Exception;

    int deleteFaq(Integer faq_no) throws Exception;

    int updateFaq(FaqDto faqDto) throws Exception;

}
