<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/css/product/product_insert_style.css'/>">
</head>
<body>
<div class="wrap">
    <div class="content">
        <h1>관리자 페이지</h1>
        <div class="nav">
            <div class="menu">
                <ul>
                    <li class="prd_tlt">상품 등록 관리</li>
                    <a href="<c:url value='/product/insert'/>"><li class="menu_list">상품 등록</li></a>
                    <a href="<c:url value='/product/detail/insert'/>"><li class="menu_list">상품 상세 등록</li></a>
                    <a href="<c:url value='/product/insert/image'/>"><li class="menu_list">상품 이미지 등록</li></a>
                    <a href="<c:url value='/product/insert/schedule'/>"><li class="menu_list">상품 일정 등록</li></a>
                    <a href="<c:url value='/product/insert/price'/>"><li class="menu_list">상품 가격 등록</li></a>
                    <a href="<c:url value='/product/schedule/image/insert'/>"><li class="menu_list">상품 일정 사진 등록</li></a>
                </ul>
                <ul>
                    <li class="prd_tlt">상품 등록 현황 관리</li>
                    <a href="<c:url value='/product/management'/>"><li class="menu_list">상품 관리</li></a>
                    <a href="<c:url value='/product/management/detail'/>"><li class="menu_list">상품 상세 관리</li></a>
                    <a href="<c:url value='/product/management/image'/>"><li class="menu_list">상품 이미지 관리</li></a>
                    <a href="<c:url value='/product/management/schedule'/>"><li class="menu_list">상품 일정 관리</li></a>
                    <a href="<c:url value='/product/management/price'/>"><li class="menu_list">상품 가격 관리</li></a>
                    <a href="<c:url value='/product/management/schedule/image'/>"><li class="menu_list">상품 일정 사진 관리</li></a>
                </ul>
                <ul>
                    <li class="prd_tlt">상품 승인 관리</li>
                    <a href="<c:url value='/product/recognize'/>"><li class="menu_list">상품 승인</li></a>
                    <a href="<c:url value='/reserv/admin'/>"><li class="menu_list">예약 승인</li></a>
                </ul>
                <ul>
                    <li class="prd_tlt">고객 관리</li>
                    <li class="menu_list">고객 서비스 제안 관리</li>
                    <li class="menu_list">1:1 문의 관리</li>
                </ul>
                <ul>
                    <li class="prd_tlt">통계</li>
                    <a href="<c:url value='/product/stats'/>"><li class="menu_list">예약 및 구매 통계</li></a>
                </ul>
            </div>
            <div class="board">
                    <h1>상품 등록</h1>
                        <div class="prd_input_form">
                            <form:form action="/product/insert" method="post" modelAttribute="trvPrdWriteDto">
                                <input type="hidden" name="frs_rgs_no" value="${sessionScope.usr_id}"/>
                                <input type="hidden" value="${list.prd_prc_no}" name="prd_prc_no" readonly="readonly"/>

                                <form:label path="prd_cd">상품코드</form:label><br>
                                <form:input  cssClass="input_prd" path="prd_cd" placeholder="상품코드"/><br>
                                <form:errors path="prd_cd" cssClass="error_msg"/><br><br>

                                <form:label path="cntn_cd">대륙코드</form:label><br>
                                <select name="cntn_cd" class="input_prd" id="cntn_select">
                                    <option value="" selected>대륙코드</option>
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                    <option value="C">C</option>
                                    <option value="D">D</option>
                                    <option value="E">E</option>
                                </select><br>
                                <form:errors path="cntn_cd" cssClass="error_msg"/><br><br>

                                <form:label path="nt_cd">국가코드</form:label><br>
                                <select name="nt_cd" class="input_prd" id="nt_cd_select">

                                </select><br>



                                <form:label path="dstn_cd">여행지 코드</form:label><br>
                                <form:input cssClass="input_prd" path="dstn_cd" placeholder="여행지 코드"/><br>
                                <form:errors path="dstn_cd" cssClass="error_msg"/><br><br>

                                <form:label path="cmn_cd_thm">테마코드</form:label><br>
                                <form:input cssClass="input_prd" path="cmn_cd_thm" placeholder="테마코드"/><br>
                                <form:errors path="cmn_cd_thm" cssClass="error_msg"/><br><br>

                                <form:label path="prd_nm">상품명</form:label><br>
                                <form:input cssClass="input_prd" path="prd_nm" placeholder="상품명"/><br>
                                <form:errors path="prd_nm" cssClass="error_msg"/><br><br>

                                <form:label path="prd_dtl_desc">상품 상세 설명</form:label><br>
                                <form:textarea id="desc_area" path="prd_dtl_desc" placeholder="상품 상세 설명" cols="24" rows="10"/><br>
                                <form:errors path="prd_dtl_desc" cssClass="error_msg"/><br><br>

                                <form:label path="trv_per">여행기간</form:label><br>
                                <form:input cssClass="input_prd" path="trv_per" placeholder="여행기간"/><br>
                                <form:errors path="trv_per" cssClass="error_msg"/><br><br>

                                <form:label path="prd_str_prc">상품시작가격</form:label><br>
                                <form:input cssClass="input_prd" path="prd_str_prc" placeholder="상품시작가격"/><br>
                                <form:errors path="prd_str_prc" cssClass="error_msg"/><br><br>

                                <form:label path="dpr_day">출발 요일</form:label><br>
                                <form:input cssClass="input_prd" path="dpr_day" placeholder="출발 요일"/><br>
                                <form:errors path="dpr_day" cssClass="error_msg"/><br><br>

                                <form:label path="dpr_str_date">출발 시작일</form:label><br>
                                <input type="date" class="input_prd" name="dpr_str_date" placeholder="출발 시작일"><br>
                                <form:errors path="dpr_str_date" cssClass="error_msg"/><br><br>

                                <form:label path="dpr_fin_date">출발 마감일</form:label><br>
                                <input type="date" class="input_prd" name="dpr_fin_date" placeholder="출발 마감"><br>
                                <form:errors path="dpr_fin_date" cssClass="error_msg"/><br><br>

                            </form:form>
                            <button id="submit_btn">상품 등록</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<script>

    function checkForm(){
        let prd_cd = $('input[name=prd_cd]').val();
        let dstn_cd = $('input[name=dstn_cd]').val();
        let cmn_cd_thm = $('input[name=cmn_cd_thm]').val();
        let prd_nm = $('input[name=prd_nm]').val();
        let prd_dtl_desc = $('textarea[name=prd_dtl_desc]').val();
        let trv_per = $('input[name=trv_per]').val();
        let prd_str_prc = $('input[name=prd_str_prc]').val();
        let dpr_day = $('input[name=dpr_day]').val();
        let dpr_str_date = $('input[name=dpr_str_date]').val();
        let dpr_fin_date = $('input[name=dpr_fin_date]').val();

        if(prd_cd == null || prd_cd == ""){
            alert('상품코드는 필수 입력 항목입니다.');
            return;
        }


        if(dstn_cd == null || dstn_cd == ""){
            alert('여행지코드는 필수 입력 항목입니다.');
            return;
        }

        if(cmn_cd_thm == null || cmn_cd_thm == ""){
            alert('테마코드는 필수 입력 항목입니다.');
            return;
        }

        if(prd_nm == null || prd_nm == ""){
            alert('상품이름은 필수 입력 항목입니다.');
            return;
        }

        if(prd_dtl_desc == null || prd_dtl_desc == ""){
            alert('상품 상세설명은 필수 입력 항목입니다.');
            return;
        }

        if(trv_per == null || trv_per == ""){
            alert('여행기간은 필수 입력 항목입니다.');
            return;
        }

        if(prd_str_prc == null || prd_str_prc == ""){
            alert('상품시작가격은 필수 입력 항목입니다.');
            return;
        }

        if(dpr_day == null || dpr_day == ""){
            alert('출발요일은 필수 입력 항목입니다.');
            return;
        }

        if(dpr_str_date == null || dpr_str_date == ""){
            alert('출발시작일은 필수 입력 항목입니다.');
            return;
        }

        if(dpr_fin_date == null || dpr_fin_date == ""){
            alert('출발마감일은 필수 입력 항목입니다.');
            return;
        }

        $('form').submit();

    }



    $(document).ready(function (){

        $('#submit_btn').on("click",function (){
           checkForm();
        });

        $('#cntn_select').change(function (){
            let value = $(this).val();
            $.ajax({
                type: "POST",
                url : "<c:url value='/product/option'/>",
                data : {option:value},
                success : function (data){
                    $('#nt_cd_select').empty();
                    $(data).each(function (){
                        $('#nt_cd_select').append("<option value="+this.nt_cd+">"+this.nt_cd_nm+"</option>");
                    });
                },
                error : function (){
                    alert("국가코드를 선택해주세요");
                }

            });
        });
    });
</script>
    </body>
</html>
