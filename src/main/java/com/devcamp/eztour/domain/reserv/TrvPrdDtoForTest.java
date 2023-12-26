package com.devcamp.eztour.domain.reserv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrvPrdDtoForTest {
    private String prd_cd;
    private String dstn_cd;
    private String cmn_cd_thm;
    private String prd_nm;
    private String prd_dtl_desc;
    private String trv_per;
    private Integer prd_str_prc;
    private String dpr_str_date;
    private String dpr_fin_date;
    private int star;
    private boolean evnt_yn;
    private boolean fin_yn;
    private boolean act_yn;
    private boolean dc_yn;
    private int pr_prc;
    private int add_sv_rt;
    private int vcnt;
    private boolean lk_yn;
    private Date frs_reg_date;
    private String frs_rgs_no;
    private Date fnl_mod_date;
    private String fnl_mod_no;

}
